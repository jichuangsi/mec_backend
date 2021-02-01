package com.jichuangsi.mes.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.jichuangsi.mes.constant.ResultCode;
import com.jichuangsi.mes.entity.*;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.mapper.IMesMapper;
import com.jichuangsi.mes.model.*;
import com.jichuangsi.mes.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class WarehouseService {


    @Resource
    private IMesMapper mesMapper;
    @Resource
    private TPurchaseRepository tpurchaseRepository;
    @Resource
    private TWarehouseRepository tWarehouseRepository;
    @Resource
    private StockRepository stockRepository;
    @Resource
    private TStandardsRepository tStandardsRepository;
    @Resource
    private TBobbinRepository tbobbinRepository;


    @Resource
    private InventoryStatusRepository inventoryStatusRepository;
    @Resource
    private InventoryRecordRepository inventoryRecordRepository;

    /**
     * 仓库管理- 新增/编辑页面获取下拉框数据
     * @param
     * @throws PassportException
     */
    public JSONObject getwarehouseBasicInfo()throws PassportException {
        JSONObject job = new JSONObject();

        long tpNum =tWarehouseRepository.count()+1;
        String strnum = "CK-000"+tpNum;

        job.put("warehouseNum",strnum);//仓库号
        job.put("userXiaLa",mesMapper.findStaffAllXiaLa());//负责人

        return job;
    }

    /**
     * 仓库管理- 新增/编辑
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void saveWarehouse(TWarehouse tWarehouse)throws PassportException {

        tWarehouse.setState(0);
        tWarehouse.setDeleteNo(0);
        tWarehouseRepository.save(tWarehouse);

    }

    /**
     * 仓库管理-查询
     * @param
     * @throws PassportException
     */
    public PageInfo getAllWarehouse(SelectModel smodel)throws PassportException{
        PageInfo page=new PageInfo();

        if(StringUtils.isEmpty(smodel.getPageNum()) || StringUtils.isEmpty(smodel.getPageSize())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        List<WarehouseModel> listSale = mesMapper.findAllWarehouse(smodel.getFindName(),(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());

        page.setList(listSale);
        page.setTotal(mesMapper.countByWarehouse(smodel.getFindName()));

        page.setPageSize(smodel.getPageSize());
        page.setPageNum(smodel.getPageNum());
        return page;
    }

    /**
     * 仓库管理-根据Id查询订单详情
     * @param
     * @throws PassportException
     */
    public JSONObject getWarehourseById(SelectModel smodel)throws PassportException{
        JSONObject jsonObject=new JSONObject();
        if(StringUtils.isEmpty(smodel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        TWarehouse tWarehouse=  tWarehouseRepository.findByid(smodel.getFindById());

        if (StringUtils.isEmpty(tWarehouse)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}
        jsonObject.put("tWarehouse",tWarehouse);
        return jsonObject;
    }

    /**
     * 仓库管理-修改状态(state or  delete_no)
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateWarehouseByid(UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) ||StringUtils.isEmpty(model.getUpdateType())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        TWarehouse tWarehouse=  tWarehouseRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(tWarehouse)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        if(model.getUpdateType().equals("S")){//修改state
            tWarehouse.setState(tWarehouse.getState() == 0 ? 1 :0);
        }else if(model.getUpdateType().equals("D")){//修改deleteno
            tWarehouse.setDeleteNo(tWarehouse.getDeleteNo() == 0 ? 1 :0);
        }
        tWarehouseRepository.save(tWarehouse);
    }


//    -------------------------------------------------以上是仓库管理------------------------------------------------------------------

//            -------------------------------------- 以下是库存管理-出入库管理 -----------------------------------------------------------------------------

    /**
     * 库存管理-出入库管理-页面查询(原材料、半成品、成品、废料、线轴、其他等)
     * @param
     * @throws PassportException
     */
    public PageInfo getAllWarehousing(SelectModel smodel)throws PassportException{
        PageInfo page=new PageInfo();

        if(StringUtils.isEmpty(smodel.getPageNum()) || StringUtils.isEmpty(smodel.getPageSize())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        String strfindName = null;
        if(!StringUtils.isEmpty(smodel.getFindName())){
            strfindName = smodel.getFindName();
        }

        String starttime = null;
        String endtime = null;

        if(!StringUtils.isEmpty(smodel.getFindDate())){
            starttime = smodel.getFindDate() +" 00:00:00";
            endtime = smodel.getFindDate() +" 23:59:59";
        }

        List<InventoryRecordVo> listdata = mesMapper.findAllInventoryRecord(getInventoryType(smodel.getFindModelName()),strfindName,null,0,starttime,endtime,(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());
        page.setList(listdata);
        page.setTotal(mesMapper.countByInventoryRecord(getInventoryType(smodel.getFindModelName()),strfindName,starttime,endtime));

        page.setPageSize(smodel.getPageSize());
        page.setPageNum(smodel.getPageNum());
        return page;
    }

    /**
     * 库存管理-出入库管理-查询下拉框
     * @param
     * @throws PassportException
     */
    public JSONObject getWarehousXiaLa()throws PassportException{
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("warehourseXiaLa",mesMapper.findAllWarehouseByXiaLa());
        return  jsonObject;
    }

    /**
     * 库存管理-出入库管理-入库查询(原材料、成品、废料、线轴、其他等)
     * @param
     * @throws PassportException
     */
    public JSONObject getAllWarehousingProduct(SelectModel smodel)throws PassportException{
        JSONObject jsonObject=new JSONObject();

        String strfindName = null;
        if(!StringUtils.isEmpty(smodel.getFindName())){
            strfindName = smodel.getFindName();
        }

        switch (smodel.getFindModelName()){
            case "stock"://原材料
                jsonObject.put("LData", mesMapper.findAllWareHouseStock(strfindName,1));
                break;
            case "product"://成品。查询库存里面的所有成品
            case "waste"://废料
                jsonObject.put("LData",mesMapper.findAllInventoryByState(getInventoryType(smodel.getFindModelName()),strfindName,smodel.getFindIdOne()));
                break;
            case "bobbin"://线轴
                jsonObject.put("LData",mesMapper.findAllWareHouseBobbin(smodel.getFindName()));

                break;
            case "elseother"://其他
                jsonObject.put("LData",mesMapper.findAllWareHouseStock(strfindName,2));
                break;
            default:
                break;
        }

        return jsonObject;
    }

    /**
     * 库存管理-出入库管理-入库查询(根据Id查询明细)(原材料、成品、废料、线轴、其他等)
     * @param
     * @throws PassportException
     */
    public JSONObject getAllWarehousingProductById(SelectModel smodel)throws PassportException{
        JSONObject jsonObject=new JSONObject();

        switch (smodel.getFindModelName()){
            case "stock"://原材料
                jsonObject.put("RData",mesMapper.findByMaterialIdAndMaterialType(smodel.getFindById(),1));
                break;
            case "product"://成品。查询库存里面的所有成品
            case "waste"://废料
                jsonObject.put("RData",mesMapper.findAllInventoryStateByPPPId(getInventoryType(smodel.getFindModelName()),smodel.getFindById(),smodel.getFindById()%10));
                break;
            case "bobbin"://线轴
                jsonObject.put("RData",mesMapper.findByMaterialIdAndMaterialType(smodel.getFindById(),2));
                break;
            case "elseother"://其他
                jsonObject.put("RData",mesMapper.findByMaterialIdAndMaterialType(smodel.getFindById(),3));
                break;
            default:
                break;
        }

        return jsonObject;
    }

    //库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
    public Integer getInventoryType(String InventoryType){
        Integer returnInt = 0;
        switch (InventoryType){
            case "stock"://原料
                returnInt =1;
                break;
            case "nofinished"://半成品
                returnInt =3;
                break;
            case "product"://成品
                returnInt =2;
                break;
            case "waste"://废料
                returnInt =4;
                break;
            case "bobbin"://线轴
                returnInt =5;
                break;
            case "elseother"://其他
                returnInt =6;
                break;
                default:
                    break;
        }
        return returnInt;
    }

    //出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购 6盘点等)
    public Integer getrecordType(String recordType){
        Integer returnInt = 0;
        switch (recordType){
            case "ck"://出库
                returnInt =1;
                break;
            case "rk"://入库
                returnInt =2;
                break;
            case "db"://调拨
                returnInt =3;
                break;
            case "sale"://销售
                returnInt =4;
                break;
            case "purchase"://采购
                returnInt =5;
                break;
            case "pandian"://盘点
                returnInt =6;
                break;
            case "pCk"://生产出库
                returnInt =7;
                break;
            default:
                break;
        }
        return returnInt;
    }

    /**
     * 库存管理-出入库管理-入库操作(原材料、成品、废料、线轴、其他等)
     *新增库存管理-库存状况数据  新增库存管理-出入库数据
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateWarehouseIn(List<UpdateModel> model)throws PassportException {
        List<InventoryStatus> inventoryStatusList = new ArrayList<>();
        List<InventoryRecord> inventoryRecordList = new ArrayList<>();

        if(model.size() == 0 ){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        //如果是成品或者废料入库的话。另外操作
        if(model.get(0).getFindModelName().equals("product") || model.get(0).getFindModelName().equals("waste")){
            for(UpdateModel updateModel : model){
                if(StringUtils.isEmpty(updateModel.getUpdateID()) || StringUtils.isEmpty(updateModel.getUpdateRemark())|| StringUtils.isEmpty(updateModel.getFindModelName())|| StringUtils.isEmpty(updateModel.getStockModel()) || StringUtils.isEmpty(updateModel.getUnitId())){
                    throw new PassportException(ResultCode.PARAM_MISS_MSG);
                }
                Integer recordType =getrecordType("rk") ;

                InventoryStatus getnventoryStatuss = inventoryStatusRepository.findByid(updateModel.getUpdateID());
                BigDecimal surplusquantity;
                if(!StringUtils.isEmpty(getnventoryStatuss)){//如果不为空就修改 如果为空就报异常。
                    surplusquantity = getnventoryStatuss.getInventorysum().add(updateModel.getUpdateNum()) ;
                    getnventoryStatuss.setInventorysum(surplusquantity);//更改数量
                    inventoryStatusList.add(getnventoryStatuss);

                }else{
                    throw new PassportException(ResultCode.DATA_NOEXIST_MSG);
                }

                //存入记录
                InventoryRecord inventoryRecord = new InventoryRecord();
                inventoryRecord.setProductDetailid(updateModel.getUpdateID());
                inventoryRecord.setRecordType(recordType);//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购等)
                inventoryRecord.setCreateTime(System.currentTimeMillis());
                inventoryRecord.setChangequantity("+"+updateModel.getUpdateNum());
                inventoryRecord.setSurplusquantity(surplusquantity);
                inventoryRecord.setInventoryType(getInventoryType(updateModel.getFindModelName()));//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
                inventoryRecord.setRemark(updateModel.getUpdateRemark());
                inventoryRecord.setWarehouseId(updateModel.getUpdateWarehourseID());

                inventoryRecord.setStockName(updateModel.getStockName());//材料名称
                inventoryRecord.setStockModel(updateModel.getStockModel());//模型
                inventoryRecord.setStockNumber(updateModel.getStockNumber());//编号
                inventoryRecord.setStandards(updateModel.getStandards());//规格
                inventoryRecord.setUnitId(updateModel.getUnitId());//单位id
                inventoryRecordList.add(inventoryRecord);

            }
        }else{

            for(UpdateModel updateModel : model){
                if(StringUtils.isEmpty(updateModel.getUpdateID()) || StringUtils.isEmpty(updateModel.getUpdateRemark())|| StringUtils.isEmpty(updateModel.getFindModelName())|| StringUtils.isEmpty(updateModel.getStockModel()) || StringUtils.isEmpty(updateModel.getUnitId())){
                    throw new PassportException(ResultCode.PARAM_MISS_MSG);
                }
                Integer recordType =getrecordType("rk") ;
                Integer inventoruType = getInventoryType(updateModel.getFindModelName());

                InventoryStatus countInventoryStatus=  inventoryStatusRepository.findByProductIdAndWarehouseIdAndInventoryType(updateModel.getUpdateID(),updateModel.getUpdateWarehourseID(),inventoruType);
                BigDecimal surplusquantity;
                if(StringUtils.isEmpty(countInventoryStatus)){//如果为空就是新增。如果不为空就是修改咯
                    InventoryStatus inventoryStatus = new InventoryStatus();
                    inventoryStatus.setProductId(updateModel.getUpdateID());//产品/原料明细Id

                    inventoryStatus.setStockName(updateModel.getStockName());//材料名称
                    inventoryStatus.setStockModel(updateModel.getStockModel());//模型
                    inventoryStatus.setStockNumber(updateModel.getStockNumber());//编号
                    inventoryStatus.setStandards(updateModel.getStandards());//规格
                    inventoryStatus.setUnitId(updateModel.getUnitId());//单位id

                    inventoryStatus.setWarehouseId(updateModel.getUpdateWarehourseID());//仓库Id
                    inventoryStatus.setInventoryType(inventoruType);//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
                    surplusquantity = updateModel.getUpdateNum();
                    inventoryStatus.setInventorysum(surplusquantity);

                    inventoryStatus.setDeleteNo(0);
                    inventoryStatus.setState(0);
                    inventoryStatusList.add(inventoryStatus);

                }else{
                    surplusquantity = countInventoryStatus.getInventorysum().add(updateModel.getUpdateNum());
                    countInventoryStatus.setInventorysum(surplusquantity);//更改数量
                    inventoryStatusList.add(countInventoryStatus);
                }

                //存入记录
                InventoryRecord inventoryRecord = new InventoryRecord();
                inventoryRecord.setProductDetailid(updateModel.getUpdateID());
                inventoryRecord.setRecordType(recordType);//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购等)
                inventoryRecord.setCreateTime(System.currentTimeMillis());
                inventoryRecord.setChangequantity("+"+updateModel.getUpdateNum());
                inventoryRecord.setSurplusquantity(surplusquantity);
                inventoryRecord.setInventoryType(getInventoryType(updateModel.getFindModelName()));//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
                inventoryRecord.setRemark(updateModel.getUpdateRemark());
                inventoryRecord.setWarehouseId(updateModel.getUpdateWarehourseID());

                inventoryRecord.setStockName(updateModel.getStockName());//材料名称
                inventoryRecord.setStockModel(updateModel.getStockModel());//模型
                inventoryRecord.setStockNumber(updateModel.getStockNumber());//编号
                inventoryRecord.setStandards(updateModel.getStandards());//规格
                inventoryRecord.setUnitId(updateModel.getUnitId());//单位id
                inventoryRecordList.add(inventoryRecord);
            }
        }

        inventoryRecordRepository.saveAll(inventoryRecordList);//批量保存
        inventoryStatusRepository.saveAll(inventoryStatusList);
    }


    /**
     * 库存管理-出入库管理-调拨/出库数据查询 (原材料、半成品、成品、废料、线轴、其他等)
     * @param
     * @throws PassportException
     */
    public JSONObject getAllWarehousingChuKu(SelectModel smodel)throws PassportException{
        JSONObject jsonObject=new JSONObject();

        String strfindName = null;
        if(!StringUtils.isEmpty(smodel.getFindName())){
            strfindName = smodel.getFindName();
        }
        switch (smodel.getFindModelName()){
            case "stock"://原材料
                List<StockModel> listdata = mesMapper.findAllInventoryStateByCDData(strfindName,getInventoryType(smodel.getFindModelName()),smodel.getFindIdOne(),1);
                jsonObject.put("LData",listdata.size() == 0 ? "":listdata);
                break;
            case "nofinished"://半成品。查询库存里面的所有半成品
            case "product"://成品。查询库存里面的所有成品
            case "waste"://废料
                jsonObject.put("LData",mesMapper.findAllInventoryByState(getInventoryType(smodel.getFindModelName()),strfindName,smodel.getFindIdOne()));
                break;
            case "bobbin"://线轴
                List<StockModel> listbobbin = mesMapper.findAllInventoryStateByBobbin(smodel.getFindName(),smodel.getFindIdOne());
                jsonObject.put("LData",listbobbin.size() == 0 ? "" : listbobbin);
                break;
            case "elseother"://其他
                List<StockModel> listto = mesMapper.findAllInventoryStateByCDData(strfindName,getInventoryType(smodel.getFindModelName()),smodel.getFindIdOne(),2);
                jsonObject.put("LData",listto.isEmpty() ? "":listto);
                break;
            default:
                break;
        }

        return jsonObject;
    }

    /**
     * 库存管理-出入库管理-调拨/出库数据根据产品id查询明细
     * @param
     * @throws PassportException
     */
    public JSONObject getAllWarehousingChuKuById(SelectModel smodel)throws PassportException{
        JSONObject jsonObject=new JSONObject();

        if(StringUtils.isEmpty(smodel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        switch (smodel.getFindModelName()){
            case "elseother"://其他
            case "bobbin"://线轴
            case "stock":
                jsonObject.put("RData",mesMapper.findAllInventoryStateByCDDataId(getInventoryType(smodel.getFindModelName()),smodel.getFindById(),smodel.getFindIdOne()));
                break;
            case "nofinished":
            case "product":
            case "waste":
                jsonObject.put("RData",mesMapper.findAllInventoryStateByPPPId(getInventoryType(smodel.getFindModelName()),smodel.getFindById(),smodel.getFindById()%10));
                break;
            default:
                break;
        }
        return jsonObject;
    }

    /**
     * 库存管理-出入库管理-调拨操作
     * @param
     * @param models
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateWarehouseAllocation(List<UpdateModel> models)throws PassportException {

        List<InventoryStatus> inventoryStatusList = new ArrayList<>();
        List<InventoryRecord> inventoryRecordList = new ArrayList<>();

        if(models.size() == 0){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        for (UpdateModel updateModel:models) {
            if(StringUtils.isEmpty(updateModel.getUpdateID()) || StringUtils.isEmpty(updateModel.getUpdateRemark())|| StringUtils.isEmpty(updateModel.getUnitId())){
                throw new PassportException(ResultCode.PARAM_MISS_MSG);
            }

            InventoryStatus findinventory = inventoryStatusRepository.findByid(updateModel.getUpdateID());//根据库存id查找出相对应的信息。

            BigDecimal intsum = findinventory.getInventorysum().subtract(updateModel.getUpdateNum());
            if(intsum.compareTo(BigDecimal.ZERO) == -1){//判断库存数量是否足够
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
                throw new PassportException(ResultCode.NUM_NOENOUGH_MSG);
            }
            findinventory.setInventorysum(intsum);//修改库存数量
            inventoryStatusList.add(findinventory);//修改掉原来仓库的库存

            //获取调取仓库是否有此库存。如果有就修改，没有就新增
            InventoryStatus countInventoryStatus1=  inventoryStatusRepository.findByProductIdAndWarehouseIdAndInventoryType(findinventory.getProductId(),updateModel.getUpdateWarehourseID(),getInventoryType(updateModel.getFindModelName()));
            BigDecimal surplusquantity;//调转仓库修改的数量
            if(StringUtils.isEmpty(countInventoryStatus1)){//如果为空就是新增。如果不为空就是修改咯
                InventoryStatus inventoryStatus = new InventoryStatus();
                inventoryStatus.setProductId(findinventory.getProductId());//产品/原料明细Id
                inventoryStatus.setWarehouseId(updateModel.getUpdateWarehourseID());//仓库Id
                inventoryStatus.setInventoryType(getInventoryType(updateModel.getFindModelName()));//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
                surplusquantity = updateModel.getUpdateNum();
                inventoryStatus.setInventorysum(surplusquantity);

                inventoryStatus.setStockName(findinventory.getStockName());
                inventoryStatus.setStockNumber(findinventory.getStockNumber());
                inventoryStatus.setStockModel(findinventory.getStockModel());
                inventoryStatus.setStandards(findinventory.getStandards());
                inventoryStatus.setUnitId(findinventory.getUnitId());

//                inventoryStatus.setStockName(updateModel.getStockName());
//                inventoryStatus.setStockNumber(updateModel.getStockNumber());
//                inventoryStatus.setStockModel(updateModel.getStockModel());
//                inventoryStatus.setStandards(updateModel.getStandards());
//                inventoryStatus.setUnitId(updateModel.getUnitId());

                inventoryStatus.setPppId(findinventory.getPppId());
                inventoryStatus.setInventorynumbers(findinventory.getInventorynumbers());

                inventoryStatus.setDeleteNo(0);
                inventoryStatus.setState(0);
                inventoryStatusList.add(inventoryStatus);
            }else{
                surplusquantity = countInventoryStatus1.getInventorysum().add(updateModel.getUpdateNum());
                countInventoryStatus1.setInventorysum(surplusquantity);//更改数量
                inventoryStatusList.add(countInventoryStatus1);
            }

            //调拨-取出记录
            InventoryRecord inventoryRecord = new InventoryRecord();
            inventoryRecord.setProductDetailid(findinventory.getProductId());
            inventoryRecord.setRecordType(getrecordType("db"));//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购等)
            inventoryRecord.setCreateTime(System.currentTimeMillis());
            inventoryRecord.setChangequantity("-"+updateModel.getUpdateNum());
            inventoryRecord.setSurplusquantity(intsum);
            inventoryRecord.setInventoryType(getInventoryType(updateModel.getFindModelName()));//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
            inventoryRecord.setRemark(updateModel.getUpdateRemark());
            inventoryRecord.setWarehouseId(findinventory.getWarehouseId());
            inventoryRecord.setPppId(findinventory.getPppId());

            inventoryRecord.setStockName(findinventory.getStockName());
            inventoryRecord.setStockNumber(findinventory.getStockNumber());
            inventoryRecord.setStockModel(findinventory.getStockModel());
            inventoryRecord.setStandards(findinventory.getStandards());
            inventoryRecord.setUnitId(findinventory.getUnitId());
            inventoryRecordList.add(inventoryRecord);

            //调拨-存入记录
            InventoryRecord inventoryRecord1 = new InventoryRecord();
            inventoryRecord1.setProductDetailid(findinventory.getProductId());
            inventoryRecord1.setRecordType(getrecordType("db"));//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购等)
            inventoryRecord1.setCreateTime(System.currentTimeMillis());
            inventoryRecord1.setChangequantity("+"+updateModel.getUpdateNum());
            inventoryRecord1.setSurplusquantity(surplusquantity);
            inventoryRecord1.setInventoryType(getInventoryType(updateModel.getFindModelName()));//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
            inventoryRecord1.setRemark(updateModel.getUpdateRemark());
            inventoryRecord1.setWarehouseId(updateModel.getUpdateWarehourseID());
            inventoryRecord1.setPppId(findinventory.getPppId());

            inventoryRecord1.setStockName(findinventory.getStockName());
            inventoryRecord1.setStockNumber(findinventory.getStockNumber());
            inventoryRecord1.setStockModel(findinventory.getStockModel());
            inventoryRecord1.setStandards(findinventory.getStandards());
            inventoryRecord1.setUnitId(findinventory.getUnitId());

            inventoryRecordList.add(inventoryRecord1);

        }
        inventoryStatusRepository.saveAll(inventoryStatusList);
        inventoryRecordRepository.saveAll(inventoryRecordList);
    }

    /**
     * 库存管理-出入库管理-出库操作
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateWarehouseOut(List<UpdateModel> model)throws PassportException {
        List<InventoryStatus> inventoryStatusList = new ArrayList<>();
        List<InventoryRecord> inventoryRecordList = new ArrayList<>();

        for (UpdateModel updateModel:model) {
            if(StringUtils.isEmpty(updateModel.getUpdateID()) || StringUtils.isEmpty(updateModel.getUpdateRemark())){
                throw new PassportException(ResultCode.PARAM_MISS_MSG);
            }

            InventoryStatus findinventory = inventoryStatusRepository.findByid(updateModel.getUpdateID());//根据库存id查找出相对应的信息。

            BigDecimal intsum = findinventory.getInventorysum().subtract(updateModel.getUpdateNum());
            if(intsum.compareTo(BigDecimal.ZERO) == -1){//判断库存数量是否足够
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
                throw new PassportException(ResultCode.NUM_NOENOUGH_MSG);
            }
            findinventory.setInventorysum(intsum);//修改库存数量
            inventoryStatusList.add(findinventory);//修改掉原来仓库的库存

            //出库-取出记录
            InventoryRecord inventoryRecord = new InventoryRecord();
            inventoryRecord.setProductDetailid(findinventory.getProductId());
            inventoryRecord.setRecordType(getrecordType("ck"));//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购等)
            inventoryRecord.setCreateTime(System.currentTimeMillis());
            inventoryRecord.setChangequantity("-"+updateModel.getUpdateNum());
            inventoryRecord.setSurplusquantity(intsum);
            inventoryRecord.setInventoryType(getInventoryType(updateModel.getFindModelName()));//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
            inventoryRecord.setRemark(updateModel.getUpdateRemark());
            inventoryRecord.setWarehouseId(findinventory.getWarehouseId());

            inventoryRecord.setStockName(findinventory.getStockName());
            inventoryRecord.setStockNumber(findinventory.getStockNumber());
            inventoryRecord.setStockModel(findinventory.getStockModel());
            inventoryRecord.setStandards(findinventory.getStandards());
            inventoryRecord.setUnitId(findinventory.getUnitId());
            inventoryRecordList.add(inventoryRecord);

        }
        inventoryStatusRepository.saveAll(inventoryStatusList);
        inventoryRecordRepository.saveAll(inventoryRecordList);//批量保存
    }

//            -------------------------------------- 以上是库存管理-出入库管理 -----------------------------------------------------------------------------


//            -------------------------------------- 以下是库存管理-库存状况 -----------------------------------------------------------------------------

    /**
     * 库存管理-库存状况-页面查询(原材料、半成品、成品、废料、线轴、其他等)
     * @param
     * @throws PassportException
     */
    public PageInfo getAllInventoryStates(SelectModel smodel)throws PassportException{
        PageInfo page=new PageInfo();

        if(StringUtils.isEmpty(smodel.getPageNum()) || StringUtils.isEmpty(smodel.getPageSize())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        String strfindName = null;
        if(!StringUtils.isEmpty(smodel.getFindName())){
            strfindName = smodel.getFindName();
        }
        List<InventoryStatusVo> listdata = mesMapper.findAllInventoryStates(getInventoryType(smodel.getFindModelName()),strfindName,(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());

        page.setList(listdata);
        page.setTotal(mesMapper.countByInventoryStates(getInventoryType(smodel.getFindModelName()),strfindName));
//        switch (smodel.getFindModelName()){
//            case "stock"://原材料
//            case "elseother"://其他
//                List<InventoryStatusVo> listdata = mesMapper.findAllInventoryStatesByStock(getInventoryType(smodel.getFindModelName()),strfindName,(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());
//
//                page.setList(listdata);
//                page.setTotal(mesMapper.countByInventoryStatesByStock(getInventoryType(smodel.getFindModelName()),strfindName));
//
//                break;
//            case "nofinished"://半成品
//
//                break;
//
//            case "product"://成品
//
//
//                break;
//            case "bobbin"://线轴
//
//
//                break;
//            case "waste"://废料
//
//                break;
//            default:
//                break;
//        }

        page.setPageSize(smodel.getPageSize());
        page.setPageNum(smodel.getPageNum());
        return page;
    }

    /**
     * 库存管理- 库存状况-库存详情获取下拉框数据
     * @param
     * @throws PassportException
     */
    public JSONObject getwarehouseInventoryStatesBasicInfo(SelectModel smodel)throws PassportException {
        JSONObject job = new JSONObject();

        Integer productid = 0;
        if(!StringUtils.isEmpty(smodel.getFindById())){
            InventoryStatus inventoryStatus = inventoryStatusRepository.findByid(smodel.getFindById());//保证有这个规格id
            if(StringUtils.isEmpty(inventoryStatus)){
                throw new PassportException(ResultCode.DATA_NOEXIST_MSG);
            }

            productid = tStandardsRepository.findByid(inventoryStatus.getProductId()).getMaterialId();//规格id
        }

        job.put("warehouseXiaLa",mesMapper.findAllWarehouseByXiaLa());//仓库下拉框
        switch (smodel.getFindModelName()){
            case "stock"://原材料
                job.put("DetailXiaLa",mesMapper.findAllStockDetailByIdXiaLa(productid,1));//原料规格下拉框
                break;

            case "nofinished"://半成品
            case "waste"://废料
            case "product"://成品
                job.put("DetailXiaLa",mesMapper.findAllProductDetailByIdXiaLa(null));//产品规格下拉框
                break;
            case "bobbin"://线轴
                job.put("DetailXiaLa",mesMapper.findAllStockDetailByIdXiaLa(productid,2));//原料规格下拉框
                break;
            case "elseother"://其他
                job.put("DetailXiaLa",mesMapper.findAllStockDetailByIdXiaLa(productid,3));//原料规格下拉框
                break;
            default:
                break;
        }
        return job;
    }


    /**
     * 库存管理-库存状况-页面查询 根据id查询明细(原材料、半成品、成品、废料、线轴、其他等)
     *
     * 规格明细id和仓库id
     * @param
     *
     * @throws PassportException
     */
    public JSONObject getAllInventoryStatesById(SelectModel smodel)throws PassportException{
        JSONObject jsonObject=new JSONObject();

        if(StringUtils.isEmpty(smodel.getFindModelName())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        Integer productDetailId = 0;//规格id
        Integer warehourseId = 0;//仓库id

        if(!StringUtils.isEmpty(smodel.getFindById())){
            InventoryStatus inventoryStatus = inventoryStatusRepository.findByid(smodel.getFindById());//保证有这个规格id
            if(StringUtils.isEmpty(inventoryStatus)){
                throw new PassportException(ResultCode.DATA_NOEXIST_MSG);
            }

            if(StringUtils.isEmpty(smodel.getPageNum()) || StringUtils.isEmpty(smodel.getPageSize())){
                productDetailId = inventoryStatus.getProductId();//规格id
                warehourseId = inventoryStatus.getWarehouseId();//仓库id
            }
        }

        if(!StringUtils.isEmpty(smodel.getPageNum())){//此处充当规格id
            productDetailId = smodel.getPageNum();
        }

        if(!StringUtils.isEmpty(smodel.getPageSize()) ){//此处充当仓库id
            warehourseId = smodel.getPageSize();
        }

        Integer inventoryType = getInventoryType(smodel.getFindModelName());

        switch (smodel.getFindModelName()){
            case "stock"://原材料
            case "elseother"://其他
                jsonObject.put("stockDetail",mesMapper.findstockDetailById(productDetailId));//参数
                jsonObject.put("currentInventory",mesMapper.findByStockInventoryDetailId(productDetailId,warehourseId,inventoryType));//当前库存
                jsonObject.put("InventoryRecord",mesMapper.findAllInventoryRecord(inventoryType,null,productDetailId,warehourseId,null,null,null,null));//库存记录
                jsonObject.put("currentInventoryNum",mesMapper.countByInventoryStatusSum(productDetailId,warehourseId));//当前库存数量
                jsonObject.put("InventorySum",mesMapper.countByInventoryStatusSum(productDetailId,0));//总库存数量

                break;
            case "nofinished"://半成品
                jsonObject.put("stockDetail",mesMapper.findstockDetailById(productDetailId));//参数
                jsonObject.put("currentInventory",mesMapper.findByStockInventoryDetailId(productDetailId,warehourseId,inventoryType));//当前库存
                jsonObject.put("InventoryRecord",mesMapper.findAllInventoryRecord(inventoryType,null,productDetailId,warehourseId,null,null,null,null));//库存记录
                jsonObject.put("currentInventoryNum",mesMapper.countByInventoryStatusSum(productDetailId,warehourseId));//当前库存数量
                jsonObject.put("InventorySum",mesMapper.countByInventoryStatusSum(productDetailId,0));//总库存数量
                break;

            case "product"://成品


                break;
            case "bobbin"://线轴
                jsonObject.put("stockDetail",mesMapper.findByBobbinDetailId(productDetailId));//参数
                jsonObject.put("currentInventory",mesMapper.findByBobbinInventoryDetailId(productDetailId,warehourseId));//当前库存
                jsonObject.put("InventoryRecord",mesMapper.findAllInventoryRecordByBobbin(inventoryType,null,productDetailId,warehourseId,null,null,0,0));//库存记录
                jsonObject.put("currentInventoryNum",mesMapper.countByInventoryStatusSum(productDetailId,warehourseId));//当前库存数量
                jsonObject.put("InventorySum",mesMapper.countByInventoryStatusSum(productDetailId,0));//总库存数量

                break;
            case "waste"://废料

                break;
            default:
                break;
        }

        jsonObject.put("warehoureId",warehourseId);//仓库id
        jsonObject.put("productDetailId",productDetailId);//原材料规格id
        return jsonObject;
    }

    /**
     * 库存管理-库存状况-盘点库存操作
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateInventoryStateSum(UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID())|| StringUtils.isEmpty(model.getUpdateNum())){// || StringUtils.isEmpty(model.getUpdateRemark())
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        InventoryStatus findinventory = inventoryStatusRepository.findByid(model.getUpdateID());//根据库存id查找出相对应的信息。

        BigDecimal intsum =model.getUpdateNum() ;
        findinventory.setInventorysum(intsum);//修改库存数量

        //盘点记录
        InventoryRecord inventoryRecord = new InventoryRecord();
        inventoryRecord.setProductDetailid(findinventory.getProductId());
        inventoryRecord.setRecordType(getrecordType("pandian"));//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购 6盘点等)
        inventoryRecord.setCreateTime(System.currentTimeMillis());
        inventoryRecord.setChangequantity("+"+intsum);
        inventoryRecord.setSurplusquantity(intsum);
        inventoryRecord.setInventoryType(getInventoryType(model.getFindModelName()));//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
        inventoryRecord.setRemark("仓库盘点");
        inventoryRecord.setWarehouseId(findinventory.getWarehouseId());

        inventoryRecord.setStockModel(findinventory.getStockModel());
        inventoryRecord.setStockName(findinventory.getStockName());
        inventoryRecord.setStockNumber(findinventory.getStockNumber());
        inventoryRecord.setStandards(findinventory.getStandards());
        inventoryRecord.setUnitId(findinventory.getUnitId());

        inventoryStatusRepository.save(findinventory);
        inventoryRecordRepository.save(inventoryRecord);//保存
    }



}
