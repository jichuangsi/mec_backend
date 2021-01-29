package com.jichuangsi.mes.service;


import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.jichuangsi.mes.common.ProductionStateChange;
import com.jichuangsi.mes.constant.ResultCode;
import com.jichuangsi.mes.entity.*;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.mapper.IMesMapper;
import com.jichuangsi.mes.mapper.INewProductionMapper;
import com.jichuangsi.mes.mapper.IProductionMapper;
import com.jichuangsi.mes.model.*;
import com.jichuangsi.mes.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductionInventoryService {

    @Resource
    private WarehouseService warehouseService;
    @Resource
    private IMesMapper mesMapper;

    @Resource
    private SDictionarierRepository dictionarierRepository;

    @Resource
    private IProductionMapper iProductionMapper;
    @Resource
    private INewProductionMapper iNewProductionMapper;
    @Resource
    private ProductPlanRepository productPlanRepository;
    @Resource
    private PPProductRepository ppProductRepository;
    @Resource
    private TSuitRepository suitRepository;
    @Resource
    private PPProductionRepository ppProductionRepository;
    @Resource
    private ProductionStockRepository productionStockRepository;
    @Resource
    private PickingStockRepository pickingStockRepository;

    @Resource
    private TStandardsRepository tStandardsRepository;

    @Resource
    private InventoryStatusRepository inventoryStatusRepository;
    @Resource
    private InventoryRecordRepository inventoryRecordRepository;

    @Resource
    private ELBLDataRepository elblDataRepository;
    @Resource
    private PPAnnealingInfoRepository ppAnnealingInfoRepository;
    @Resource
    private PPPWindingInfoRepository pppWindingInfoRepository;


    @Resource
    private ProductionPickingRepository productionPickingRepository;


    /**
     * 生产库存管理-生产领料-查询当前生产计划单
     * @param
     * @throws PassportException
     */
    public JSONObject getPPPlanInfo()throws PassportException {
        JSONObject job = new JSONObject();


        List<PPVo> ppVoList = iNewProductionMapper.findProductPlanInfo();

        job.put("productPlan",ppVoList);

        return job;
    }

    /**
     * 生产库存管理-生产领料-根据生产计划单id查询生产计划单详情
     * @param
     * @throws PassportException
     */
    public JSONObject getPPPlanInfoById(SelectModel selectModel)throws PassportException {
        JSONObject jsonObject = new JSONObject();

        if(StringUtils.isEmpty(selectModel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        Integer ppid = selectModel.getFindById();

        ProductPlan productPlan = productPlanRepository.findByid(ppid);

        jsonObject.put("ppproduct",mesMapper.findNOSalePProductByPPId(ppid));//计划产物-产品

        if(productPlan.getRelationNo() == 1 && !StringUtils.isEmpty(productPlan.getSaleId())){//如果关联了销售订单
            jsonObject.put("ppproduct",mesMapper.findSalePProductByPPId(ppid));//计划产物-销售订单的产品
        }

        return jsonObject;
    }

    /**
     * 生产库存管理- 生产领料-新增/(没有编辑)
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void saveProductionPicking(ProductionPickingModel productionPickingModel)throws PassportException {
        ProductionPicking productionPicking = productionPickingModel.getProductionPicking();

        List<PickingStock> pickingStockList = productionPickingModel.getPickingStockList();
        if(!StringUtils.isEmpty(productionPicking.getId())){//不能修改
            throw new PassportException(ResultCode.NO_OPE);
        }

        if (StringUtils.isEmpty(productionPicking.getPPIName()) || StringUtils.isEmpty(productionPicking.getPPId()) || productionPickingModel.getPickingStockList().isEmpty()){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        productionPicking.setCreateTime(new Date());
        productionPicking.setDeleteNo(0);
        productionPicking.setWarehouseId(9);//默认仓库id为9
        productionPicking.setTotalNet(pickingStockList.stream().map(PickingStock::getTotalNet).reduce(BigDecimal.ZERO, BigDecimal::add));//总净重g

        ProductionPicking productionPicking1 =productionPickingRepository.save(productionPicking);
        Integer pid = productionPicking1.getId();

        pickingStockRepository.updateByPPIId(pid);//先清空数据

        List<InventoryStatus> inventoryStatusList = new ArrayList<>();
        List<InventoryRecord> inventoryRecordList = new ArrayList<>();
        for (int i = 0; i < pickingStockList.size(); i++) {
            PickingStock pickingStock = pickingStockList.get(i);
            if(StringUtils.isEmpty(pickingStock.getInventoryStatusId()) || StringUtils.isEmpty(pickingStock.getQuantityChoose())){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
                throw new PassportException(ResultCode.PARAM_MISS_MSG);

            }

            InventoryStatus findinventory = inventoryStatusRepository.findByid(pickingStock.getInventoryStatusId());//根据库存id查找出相对应的信息。

            pickingStock.setPPIId(pid);
            pickingStock.setDeleteNo(0);
            pickingStock.setState(0);
            pickingStock.setWarehourseId(findinventory.getWarehouseId());//出库仓库id


            Integer intsum = findinventory.getInventorysum() - pickingStock.getQuantityChoose().intValue();
            if(intsum<0){//判断库存数量是否足够
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
                throw new PassportException(ResultCode.NUM_NOENOUGH_MSG);
            }
            findinventory.setInventorysum(intsum);//修改库存数量
            inventoryStatusList.add(findinventory);//修改掉原来仓库的库存

            //获取调取仓库是否有此库存。如果有就修改，没有就新增
            InventoryStatus countInventoryStatus1=  inventoryStatusRepository.findByProductIdAndWarehouseIdAndInventoryType(findinventory.getProductId(),productionPicking1.getWarehouseId(),warehouseService.getInventoryType("stock"));
            Integer surplusquantity =  0;//调转仓库修改的数量
            if(StringUtils.isEmpty(countInventoryStatus1)){//如果为空就是新增。如果不为空就是修改咯
                InventoryStatus inventoryStatus = new InventoryStatus();
                inventoryStatus.setProductId(findinventory.getProductId());//产品/原料明细Id
                inventoryStatus.setWarehouseId(productionPicking1.getWarehouseId());//存入的仓库Id
                inventoryStatus.setInventoryType(warehouseService.getInventoryType("stock"));//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
                surplusquantity = pickingStock.getQuantityChoose().intValue();
                inventoryStatus.setInventorysum(surplusquantity);

                inventoryStatus.setStockName(findinventory.getStockName());
                inventoryStatus.setStockNumber(findinventory.getStockNumber());
                inventoryStatus.setStockModel(findinventory.getStockModel());
                inventoryStatus.setStandards(findinventory.getStandards());
                inventoryStatus.setUnitId(findinventory.getUnitId());

                inventoryStatus.setPppId(findinventory.getPppId());
                inventoryStatus.setInventorynumbers(findinventory.getInventorynumbers());

                inventoryStatus.setDeleteNo(0);
                inventoryStatus.setState(0);
                inventoryStatusList.add(inventoryStatus);
            }else{
                surplusquantity = countInventoryStatus1.getInventorysum() + pickingStock.getQuantityChoose().intValue();
                countInventoryStatus1.setInventorysum(surplusquantity);//更改数量
                inventoryStatusList.add(countInventoryStatus1);
            }

            //调拨-取出记录
            InventoryRecord inventoryRecord = new InventoryRecord();
            inventoryRecord.setProductDetailid(findinventory.getProductId());
            inventoryRecord.setRecordType(warehouseService.getrecordType("db"));//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购等)
            inventoryRecord.setCreateTime(System.currentTimeMillis());
            inventoryRecord.setChangequantity("-"+pickingStock.getQuantityChoose());
            inventoryRecord.setSurplusquantity(intsum);
            inventoryRecord.setInventoryType(warehouseService.getInventoryType("stock"));//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
            inventoryRecord.setRemark("生产领料");
            inventoryRecord.setWarehouseId(findinventory.getWarehouseId());

            inventoryRecord.setStockName(findinventory.getStockName());
            inventoryRecord.setStockNumber(findinventory.getStockNumber());
            inventoryRecord.setStockModel(findinventory.getStockModel());
            inventoryRecord.setStandards(findinventory.getStandards());
            inventoryRecord.setUnitId(findinventory.getUnitId());
            inventoryRecordList.add(inventoryRecord);

            //调拨-存入记录
            InventoryRecord inventoryRecord1 = new InventoryRecord();
            inventoryRecord1.setProductDetailid(findinventory.getProductId());
            inventoryRecord1.setRecordType(warehouseService.getrecordType("db"));//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购等)
            inventoryRecord1.setCreateTime(System.currentTimeMillis());
            inventoryRecord1.setChangequantity("+"+pickingStock.getQuantityChoose());
            inventoryRecord1.setSurplusquantity(surplusquantity);
            inventoryRecord1.setInventoryType(warehouseService.getInventoryType("stock"));//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
            inventoryRecord1.setRemark("生产领料调拨");
            inventoryRecord1.setWarehouseId(productionPicking1.getWarehouseId());

            inventoryRecord1.setStockName(findinventory.getStockName());
            inventoryRecord1.setStockNumber(findinventory.getStockNumber());
            inventoryRecord1.setStockModel(findinventory.getStockModel());
            inventoryRecord1.setStandards(findinventory.getStandards());
            inventoryRecord1.setUnitId(findinventory.getUnitId());

            inventoryRecordList.add(inventoryRecord1);
        }
        pickingStockRepository.saveAll(pickingStockList);

        inventoryStatusRepository.saveAll(inventoryStatusList);
        inventoryRecordRepository.saveAll(inventoryRecordList);

//        updateWarehouseProductDB(pickingStockList);//原料调拨操作
    }


    //    原料出库操作
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateWarehouseProductDB(List<PickingStock> pickingStockList)throws PassportException {

//        List<InventoryStatus> inventoryStatusList = new ArrayList<>();
//        List<InventoryRecord> inventoryRecordList = new ArrayList<>();
//
//        if(pickingStockList.size() == 0){
//            throw new PassportException(ResultCode.PARAM_MISS_MSG);
//        }
//
//        for (PickingStock pickingStock:pickingStockList) {
//            if(StringUtils.isEmpty(pickingStock.getInventoryStatusId()) || StringUtils.isEmpty(pickingStock.getQuantityChoose())){
//                throw new PassportException(ResultCode.PARAM_MISS_MSG);
//            }
//
//            InventoryStatus findinventory = inventoryStatusRepository.findByid(pickingStock.getInventoryStatusId());//根据库存id查找出相对应的信息。
//
//            Integer intsum = findinventory.getInventorysum() -pickingStock.getQuantityChoose();
//            if(intsum<0){//判断库存数量是否足够
//                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
//                throw new PassportException(ResultCode.NUM_NOENOUGH_MSG);
//            }
//            findinventory.setInventorysum(intsum);//修改库存数量
//            inventoryStatusList.add(findinventory);//修改掉原来仓库的库存
//
//            //获取调取仓库是否有此库存。如果有就修改，没有就新增
//            InventoryStatus countInventoryStatus1=  inventoryStatusRepository.findByProductIdAndWarehouseIdAndInventoryType(findinventory.getProductId(),pickingStock.getWarehourseId(),warehouseService.getInventoryType("stock"));
//            Integer surplusquantity =  0;//调转仓库修改的数量
//            if(StringUtils.isEmpty(countInventoryStatus1)){//如果为空就是新增。如果不为空就是修改咯
//                InventoryStatus inventoryStatus = new InventoryStatus();
//                inventoryStatus.setProductId(findinventory.getProductId());//产品/原料明细Id
//                inventoryStatus.setWarehouseId(pickingStock.getWarehourseId());//仓库Id
//                inventoryStatus.setInventoryType(warehouseService.getInventoryType("stock"));//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
//                surplusquantity = pickingStock.getQuantityChoose();
//                inventoryStatus.setInventorysum(surplusquantity);
//
//                inventoryStatus.setStockName(findinventory.getStockName());
//                inventoryStatus.setStockNumber(findinventory.getStockNumber());
//                inventoryStatus.setStockModel(findinventory.getStockModel());
//                inventoryStatus.setStandards(findinventory.getStandards());
//                inventoryStatus.setUnitId(findinventory.getUnitId());
//
//                inventoryStatus.setPppId(findinventory.getPppId());
//                inventoryStatus.setInventorynumbers(findinventory.getInventorynumbers());
//
//                inventoryStatus.setDeleteNo(0);
//                inventoryStatus.setState(0);
//                inventoryStatusList.add(inventoryStatus);
//            }else{
//                surplusquantity = countInventoryStatus1.getInventorysum() + pickingStock.getQuantityChoose();
//                countInventoryStatus1.setInventorysum(surplusquantity);//更改数量
//                inventoryStatusList.add(countInventoryStatus1);
//            }
//
//            //调拨-取出记录
//            InventoryRecord inventoryRecord = new InventoryRecord();
//            inventoryRecord.setProductDetailid(findinventory.getProductId());
//            inventoryRecord.setRecordType(warehouseService.getrecordType("db"));//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购等)
//            inventoryRecord.setCreateTime(System.currentTimeMillis());
//            inventoryRecord.setChangequantity("-"+pickingStock.getQuantityChoose());
//            inventoryRecord.setSurplusquantity(intsum);
//            inventoryRecord.setInventoryType(warehouseService.getInventoryType("stock"));//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
//            inventoryRecord.setRemark("生产领料");
//            inventoryRecord.setWarehouseId(findinventory.getWarehouseId());
//
//            inventoryRecord.setStockName(findinventory.getStockName());
//            inventoryRecord.setStockNumber(findinventory.getStockNumber());
//            inventoryRecord.setStockModel(findinventory.getStockModel());
//            inventoryRecord.setStandards(findinventory.getStandards());
//            inventoryRecord.setUnitId(findinventory.getUnitId());
//            inventoryRecordList.add(inventoryRecord);
//
//            //调拨-存入记录
//            InventoryRecord inventoryRecord1 = new InventoryRecord();
//            inventoryRecord1.setProductDetailid(findinventory.getProductId());
//            inventoryRecord1.setRecordType(warehouseService.getrecordType("db"));//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购等)
//            inventoryRecord1.setCreateTime(System.currentTimeMillis());
//            inventoryRecord1.setChangequantity("+"+pickingStock.getQuantityChoose());
//            inventoryRecord1.setSurplusquantity(surplusquantity);
//            inventoryRecord1.setInventoryType(warehouseService.getInventoryType("stock"));//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
//            inventoryRecord1.setRemark("生产领料调拨");
//            inventoryRecord1.setWarehouseId(pickingStock.getWarehourseId());
//
//            inventoryRecord1.setStockName(findinventory.getStockName());
//            inventoryRecord1.setStockNumber(findinventory.getStockNumber());
//            inventoryRecord1.setStockModel(findinventory.getStockModel());
//            inventoryRecord1.setStandards(findinventory.getStandards());
//            inventoryRecord1.setUnitId(findinventory.getUnitId());
//
//            inventoryRecordList.add(inventoryRecord1);
//
//        }
//        inventoryStatusRepository.saveAll(inventoryStatusList);
//        inventoryRecordRepository.saveAll(inventoryRecordList);

    }


    /**
     * 生产库存管理-生产领料- 查询
     * @param
     * @throws PassportException
     */
    public PageInfo getAllPPPicking(SelectModel smodel)throws PassportException{
        PageInfo page=new PageInfo();

        List<PPPickingVo>  ppVoList=iNewProductionMapper.findAllPPPicking(smodel.getFindName(),(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());

        page.setList(ppVoList);
        page.setTotal(iNewProductionMapper.countAllPPPicking(smodel.getFindName()));

        page.setPageSize(smodel.getPageSize());
        page.setPageNum(smodel.getPageNum());
        return page;
    }


    /**
     * 生产库存管理-生产领料- 根据id查询详情
     * @param
     * @throws PassportException
     */
    public JSONObject getPPPickingById(SelectModel smodel)throws PassportException{
        JSONObject jsonObject=new JSONObject();

        ProductionPicking productionPicking = productionPickingRepository.findByid(smodel.getFindById());
        jsonObject.put("productionPicking",productionPicking);//生产领料信息

        Integer ppid = productionPicking.getPPId();
        jsonObject.put("productPlan",iNewProductionMapper.findProductPlanInfoById(ppid));//生产计划单数据

        ProductPlan productPlan = productPlanRepository.findByid(ppid);

        jsonObject.put("ppproduct",mesMapper.findNOSalePProductByPPId(ppid));//计划产物-产品

        if(productPlan.getRelationNo() == 1 && !StringUtils.isEmpty(productPlan.getSaleId())){//如果关联了销售订单
            jsonObject.put("ppproduct",mesMapper.findSalePProductByPPId(ppid));//计划产物-销售订单的产品
        }

        jsonObject.put("pickingStockList",iNewProductionMapper.findPickingStocksByPPIId(smodel.getFindById()));//领料信息
        return jsonObject;
    }


    /**
     * 生产管理-修改状态(delete_no)
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updatePPIByPPIId(UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        ProductionPicking productionPicking=  productionPickingRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(productionPicking)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        productionPicking.setDeleteNo(productionPicking.getDeleteNo() == 0 ? 1 :0);
        productionPickingRepository.save(productionPicking);
    }
}
