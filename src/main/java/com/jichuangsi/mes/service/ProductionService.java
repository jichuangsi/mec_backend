package com.jichuangsi.mes.service;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.jichuangsi.mes.common.ProductionStateChange;
import com.jichuangsi.mes.constant.ResultCode;
import com.jichuangsi.mes.entity.*;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.mapper.IMesMapper;
import com.jichuangsi.mes.mapper.IProductionMapper;
import com.jichuangsi.mes.model.*;
import com.jichuangsi.mes.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductionService {

    @Resource
    private IMesMapper mesMapper;
    @Resource
    private WarehouseService warehouseService;


    @Resource
    private SDictionarierRepository dictionarierRepository;

    @Resource
    private IProductionMapper iProductionMapper;
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
    private TStandardsRepository tStandardsRepository;
    @Resource
    private SmeltingProductsRepository smeltingProductsRepositorye;//熔炼本班产物
    @Resource
    private PPRoughDrawingProductsRepository ppRoughDrawingProductsRepository;//粗拉本班产物
    @Resource
    private PPIntermediateDrawingProductsRepository ppIntermediateDrawingProductsRepository;//中拉本班产物
    @Resource
    private PPSemiFinishedProductsRepository ppSemiFinishedProductsRepository;//半成品本班产物
    @Resource
    private PPFinishedProductsRepository ppFinishedProductsRepository;//成品本班产物
    @Resource
    private PPWindingProductsRepository ppWindingProductsRepository;//绕线本班产物


    @Resource
    private InventoryStatusRepository inventoryStatusRepository;
    @Resource
    private InventoryRecordRepository inventoryRecordRepository;

    /**
     * 生产管理-熔炼- 新增/编辑页面获取生产计划单数据
     * @param
     * @throws PassportException
     */
    public JSONObject getMeltingInfo()throws PassportException {
        JSONObject job = new JSONObject();

        List<ProductPlan> list = productPlanRepository.findAllByDeleteNo(0);
        job.put("LData",list.size() == 0 ? "": list);

        if(list.size() != 0){
            if(list.get(0).getRelationNo() == 0){//有数据且不关联销售订单的话
                job.put("RData",iProductionMapper.findNoSaleMeltingInfoById(list.get(0).getId()));
            }else{
                job.put("RData",iProductionMapper.findSaleMeltingInfoById(list.get(0).getId()));
            }
        }

        return job;
    }

    /**
     * 生产管理-熔炼- 新增/编辑页面根据生产计划单id获取生产计划单数据
     * @param
     * @throws PassportException
     */
    public JSONObject getMeltingInfoById(SelectModel selectModel)throws PassportException {
        JSONObject job = new JSONObject();

        if(StringUtils.isEmpty(selectModel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        ProductPlan productPlan = productPlanRepository.findByid(selectModel.getFindById());
        if(!StringUtils.isEmpty(productPlan)){
            if(productPlan.getRelationNo() == 0){//有数据且不关联销售订单的话
                job.put("RData",iProductionMapper.findNoSaleMeltingInfoById(selectModel.getFindById()));
            }else{
                job.put("RData",iProductionMapper.findSaleMeltingInfoById(selectModel.getFindById()));
            }
        }

        return job;
    }

    /** 新增的时候保存的是生产计划单里面的产物id
     * 生产管理-熔炼- 新增/编辑页面根据生产计划单产物id获取(基本信息、原料比例、工艺参数、设备信息、操作信息)信息
     * @param
     * @throws PassportException
     */
    public JSONObject getMeltingBasicInfoById(SelectModel selectModel)throws PassportException {
        JSONObject job = new JSONObject();

        if(StringUtils.isEmpty(selectModel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        PPProduct ppProduct = ppProductRepository.findByid(selectModel.getFindById());//根据产物id查询产物基本信息

        Integer pdetailId = ppProduct.getProductDetailId();//得出 产品明细id

        ProductPlan productPlan = productPlanRepository.findByid(ppProduct.getPpId());//生产计划单

        if(productPlan.getRelationNo() == 0){
            job.put("BasicInfo",iProductionMapper.findMeltingBasicInfoByNoSaleId(selectModel.getFindById()));//基本信息：不关联销售订单 根据生产计划单产物id
        }else{
            job.put("BasicInfo",iProductionMapper.findMeltingBasicInfoById(selectModel.getFindById()));//基本信息：关联销售订单 根据生产计划单产物id
        }

        job.put("RawMaterialRatio",iProductionMapper.findRawMaterialRatioById(pdetailId));// 原料比例： 根据产品明细id RawMaterialRatio

        job.put("ProcessTechnology",suitRepository.findByid(productPlan.getSuitId()));//工艺参数 根据套模id
        job.put("equipmentInfo",new EquipmentVo());//设备信息(初始都为null)
        job.put("OperationInfo",iProductionMapper.findGXSchedulingByPPIdAndGXIdAndSfId(ppProduct.getPpId(),38,1));//操作信息

        job.put("PPProductionInfo", new PPProduction());//熔炼信息（初始化都为null）

        job.put("equipmentXiaLa",mesMapper.findAllEquipmentByXiaLa());//下拉框：设备
        job.put("staffXiaLa",mesMapper.findStaffAllXiaLa());//下拉框：员工
        job.put("TeamXiaLa",mesMapper.findAllTTeamByXiaLa());//下拉框：班组
        return job;
    }

    /**
     * 生产管理-熔炼- 新增本班产物-根据设备id查询设备信息
     * @param
     * @throws PassportException
     */
    public EquipmentVo getEquipmentXiaLaInfoById(SelectModel selectModel)throws PassportException {
        if(StringUtils.isEmpty(selectModel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        return iProductionMapper.findEquipmentByEquipmentId(selectModel.getFindById());
    }

    /**
     * 生产管理-下拉框-根据线轴id查询线轴信息
     * @param
     * @throws PassportException
     */
    public List<TStandards> getBobbinXiaLaInfoByBId(SelectModel selectModel)throws PassportException {
        if(StringUtils.isEmpty(selectModel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        return tStandardsRepository.findByMaterialIdAndMaterialTypeAndDeleteNo(selectModel.getFindById(),2,0);
    }

    /**
     * 生产管理- 根据生产管理id查询详情信息
     * @param
     * @throws PassportException
     */
    public JSONObject getProductionDetailByPPPId(SelectModel selectModel)throws PassportException {
        JSONObject jsonObject = new JSONObject();
        if(StringUtils.isEmpty(selectModel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        PPProduction ppProduction = ppProductionRepository.findByid(selectModel.getFindById());
        if(StringUtils.isEmpty(ppProduction)){
            throw new PassportException(ResultCode.DATA_NOEXIST_MSG);
        }

        PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());//根据产物id查询产物基本信息

        Integer pdetailId = ppProduct.getProductDetailId();//得出 产品明细id

        ProductPlan productPlan = productPlanRepository.findByid(ppProduct.getPpId());//生产计划单

        if(productPlan.getRelationNo() == 0){
            jsonObject.put("BasicInfo",iProductionMapper.findMeltingBasicInfoByNoSaleId(ppProduct.getId()));//基本信息：不关联销售订单 根据生产计划单产物id
        }else{
            jsonObject.put("BasicInfo",iProductionMapper.findMeltingBasicInfoById(ppProduct.getId()));//基本信息：关联销售订单 根据生产计划单产物id
        }

        jsonObject.put("RawMaterialRatio",iProductionMapper.findRawMaterialRatioById(pdetailId));// 原料比例： 根据产品明细id RawMaterialRatio

        jsonObject.put("ProcessTechnology",suitRepository.findByid(productPlan.getSuitId()));//工艺参数 根据套模id
        jsonObject.put("equipmentInfo",iProductionMapper.findEquipmentByEquipmentId(ppProduction.getEquipmentId()));//设备信息
        jsonObject.put("OperationInfo",iProductionMapper.findGXSchedulingByPPIdAndGXIdAndSfId(ppProduct.getPpId(),ppProduction.getGXId(),ppProduction.getStaffId()));//操作信息

        jsonObject.put("PPProductionInfo", ppProduction);//熔炼信息

        jsonObject.put("equipmentXiaLa",mesMapper.findAllEquipmentByXiaLa());//下拉框：设备
        jsonObject.put("staffXiaLa",mesMapper.findStaffAllXiaLa());//下拉框：员工
        jsonObject.put("TeamXiaLa",mesMapper.findAllTTeamByXiaLa());//下拉框：班组
        jsonObject.put("BobbinXiaLa",mesMapper.findAllBobbinByXiaLa());//下拉框：线轴

        JSONObject jsonObject1 =  getProductionDetailListByPPPId(ppProduction);
        jsonObject.put("oneList",jsonObject1.get("oneList"));
        jsonObject.put("twoList",jsonObject1.get("twoList"));
        return jsonObject;
    }

//    查询上班/下班生产产物
    public JSONObject getProductionDetailListByPPPId(PPProduction ppProduction)throws PassportException {
        JSONObject jsonObject = new JSONObject();

        Integer id = ppProduction.getId()%10;

        if(ppProduction.getGXId() == ProductionStateChange.PSmelting){//熔炼
            jsonObject.put("oneList",iProductionMapper.findSmeltingStocksByPPPId(ppProduction.getId()));//原材料
            jsonObject.put("twoList",iProductionMapper.findProductsVoByPPPId(ppProduction.getId(),id));//本班产物
        }else if(ppProduction.getGXId() == ProductionStateChange.PIntermediateAnnealing || ppProduction.getGXId() == ProductionStateChange.PFinishedAnnealing){
            //elbl数据
            //历史退火记录
            List<PPPVo>  ppVoList=iProductionMapper.findAllPPProduction(ppProduction.getGXId(),null,null,null,null,0,1000);

            jsonObject.put("ppVoList",iProductionMapper.findProductsVoByPPPId(ppProduction.getId(),id));//本班产物
        }else{
            jsonObject.put("oneList",iProductionMapper.findProductsVoByPPPId(ppProduction.getFid(),ppProduction.getFid()%10));//上班产物
            jsonObject.put("twoList",iProductionMapper.findProductsVoByPPPId(ppProduction.getId(),id));//本班产物
        }
        return jsonObject;
    }

    /**
     * 生产计划单-查询 (熔炼粗拉中拉细拉超细拉等)
     * @param
     * @throws PassportException
     */
    public PageInfo getAllPPProduction(SelectModel smodel)throws PassportException{
        PageInfo page=new PageInfo();

        if(StringUtils.isEmpty(smodel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        String beginTime = null;
        String endTime = null;
        if(!StringUtils.isEmpty(smodel.getFindDate())){
            beginTime = smodel.getFindDate() +"00:00:00";
            endTime = smodel.getFindDate() +"23:59:59";
        }

        Integer getgxid =ProductionStateChange.getGXIdByGXType(smodel.getFindById());
        List<PPPVo>  ppVoList=iProductionMapper.findAllPPProduction(getgxid, smodel.getFindName(),smodel.getFindModelName(),beginTime,endTime,(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());

        page.setList(ppVoList);
        page.setTotal(iProductionMapper.countByPPProduction(getgxid, smodel.getFindName(),smodel.getFindModelName(),beginTime,endTime));

        page.setPageSize(smodel.getPageSize());
        page.setPageNum(smodel.getPageNum());
        return page;
    }

    /**
     * 生产管理- 转下班操作(-熔炼)-新增/编辑
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void savesmeltingProductsList(PPProductionModel ppProductionModel)throws PassportException {
        PPProduction ppProduction = ppProductionModel.getPpProduction();
        if (StringUtils.isEmpty(ppProduction.getState()) || StringUtils.isEmpty(ppProduction.getPproductId()) ||StringUtils.isEmpty(ppProduction.getEquipmentId())|| StringUtils.isEmpty(ppProduction.getSuitId())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        if(ppProduction.getGXId() == ProductionStateChange.Production_Smelting && StringUtils.isEmpty(ppProduction.getId())){//判断是否为熔炼阶段并且是否已经有提交过
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String dateNowStr = sdf.format(d);
            String strnum =dateNowStr+"00"+ppProductionRepository.countByCreateTimeIsBetween(DateUtil.beginOfDay(d),DateUtil.endOfDay(d))+ppProduction.getProductionNumber();
            ppProduction.setProductionNumber(strnum);//避免同时有人在操作。这边直接获取编号。
        }
        Integer inggxid = StringUtils.isEmpty(ppProduction.getId()) ? ProductionStateChange.getGXIdByGXType(ppProduction.getGXId()) :ppProduction.getGXId();//工序id
        ppProduction.setFid(0);
        ppProduction.setDeleteNo(0);
        ppProduction.setCreateTime(new Date());

        ppProduction.setGxName(dictionarierRepository.findByid(inggxid).getName());//工序名称

        ppProduction.setGXId(inggxid);
        PPProduction ppProduction1 =ppProductionRepository.save(ppProduction);

        Integer pid = ppProduction1.getId();

        productionStockRepository.updateByPPPId(pid);
        smeltingProductsRepositorye.updateByPPPId(pid);
        List<ProductionStock> productionStockList = ppProductionModel.getOneList();
        for (int i = 0; i < productionStockList.size(); i++) {
            ProductionStock productionStock = productionStockList.get(i);
            if(StringUtils.isEmpty(productionStock.getInventoryStatusId()) || StringUtils.isEmpty(productionStock.getQuantityChoose())){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
                throw new PassportException(ResultCode.PARAM_MISS_MSG);

            }
            productionStock.setPPPId(pid);
            productionStock.setDeleteNo(0);
        }
        productionStockRepository.saveAll(productionStockList);

        savepppproducts(ppProductionModel.getTwoList(),pid);//保存产物信息

        if(ppProduction.getState() == 1){//转下班操作
            //转下班操作：1、原料出库操作 2、新增粗拉批次
            updateWarehouseProductOut(productionStockList);//原料出库操作

            PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());
            GXScheduling  gxScheduling= iProductionMapper.findGXSchedulingByPPIdAndGXIdAndSfId(ppProduct.getPpId(),ProductionStateChange.getGXIdByGXType(ProductionStateChange.Production_PPRoughDrawing),1);//粗拉

            PPProduction ppProductionnew = new PPProduction();
            ppProductionnew.setFid(pid);//粗拉的上级id
            ppProductionnew.setProductionNumber(ppProduction.getProductionNumber());
            ppProductionnew.setPproductId(ppProduction.getPproductId());//生产计划单产物id
            ppProductionnew.setSuitId(ppProduction.getSuitId());//套模id

            ppProductionnew.setFinishNum(0);
            ppProductionnew.setGXId(ProductionStateChange.getGXIdByGXType(ProductionStateChange.Production_PPRoughDrawing));
            ppProduction.setGxName(dictionarierRepository.findByid(ProductionStateChange.getGXIdByGXType(ProductionStateChange.Production_PPRoughDrawing)).getName());//工序名称
            ppProductionnew.setStaffId(1);//暂时
            ppProductionnew.setTeamId(gxScheduling.getTteamId());//班组id
            ppProductionnew.setFrequency(gxScheduling.getFrequency());//班次id

            ppProductionnew.setState(0);
            ppProductionnew.setCreateTime(new Date());
            ppProductionnew.setDeleteNo(0);
            ppProductionRepository.save(ppProductionnew);

        }
    }

    /**
     * 保存实体-产物信息
     * 此方法作用：1、分表，减少数据库压力。
     * 2、根据pppid分配存进不同的表
     * @param list
     * @param pppid
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public  void savepppproducts(List<PPPProducts0> list,Integer pppid)throws PassportException {
        Integer LId = pppid%10;

        //        先把该生产管理该工序所有改变掉状态
        iProductionMapper.UpdatePPPProductsByPPPId(LId,pppid);

        List<UpdateModel> updateModels = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            PPPProducts0 pppProducts = list.get(i);
            if(StringUtils.isEmpty(pppProducts.getNetWeightg()) || StringUtils.isEmpty(pppProducts.getLossg()) || StringUtils.isEmpty(pppProducts.getWastageg())){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
                throw new PassportException(ResultCode.PARAM_MISS_MSG);
            }

            pppProducts.setGxId(ProductionStateChange.getGXIdByGXType(pppProducts.getGxId()));
            pppProducts.setPPPId(pppid);
        }

        iProductionMapper.insertPPPProducts(list,LId);//保存


        warehouseService.updateWarehouseIn(updateModels);//保存废料
    }

    /**
     * 生产管理- 转下班/重复当前工序 操作（熔炼、粗拉、中拉、细拉、超细拉、绕线、改绕等）-新增/编辑
     * @param1、保存当前班组操作  2 新增下班操作
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void savePPProduction(PPProductionModel ppProductionModel)throws PassportException {
        PPProduction ppProduction = ppProductionModel.getPpProduction();
        if (StringUtils.isEmpty(ppProduction.getProductionNumber()) || StringUtils.isEmpty(ppProduction.getState()) || StringUtils.isEmpty(ppProduction.getPproductId()) ||StringUtils.isEmpty(ppProduction.getEquipmentId())|| StringUtils.isEmpty(ppProduction.getSuitId())|| StringUtils.isEmpty(ppProduction.getStaffId())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        PPProduction ppProductions = ppProductionRepository.findByid(ppProduction.getFid());

        if(StringUtils.isEmpty(ppProductions)){ throw new PassportException(ResultCode.DATA_NOEXIST_MSG);}

        ppProductionRepository.save(ppProduction);//保存原来的

        Integer pid = ppProduction.getId();

//        准备转下班操作的工序id
        savepppproducts(ppProductionModel.getTwoList(),pid);//保存

        if(ppProduction.getState() == 1 || ppProduction.getState() == 2){//如果是转下班/重复当前工序操作。就新增下班操作
            ;
            Integer newGXid =ppProduction.getState() == 1?  ProductionStateChange.getGXIdByGXType(ProductionStateChange.getGXStateChangeone(ProductionStateChange.getGXIdByGXTypeDesc(ppProduction.getGXId()))) : ppProduction.getGXId();

            String gxName =dictionarierRepository.findByid(newGXid).getName();
            gxName = ppProduction.getState() == 1? gxName :gxName+ppProductionRepository.countByProductionNumberAndGXId(ppProductions.getProductionNumber(),newGXid) ;//如果是重复当前工序。就查询当前生产id的当前工序有多少个

            PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());
            GXScheduling  gxScheduling= iProductionMapper.findGXSchedulingByPPIdAndGXIdAndSfId(ppProduct.getPpId(),newGXid,1);//粗拉

            PPProduction ppProductionnew = new PPProduction();
            ppProductionnew.setFid(pid);//粗拉的上级id
            ppProductionnew.setGXId(newGXid);//粗拉
            ppProductionnew.setGxName(gxName);//工序名称
            ppProductionnew.setProductionNumber(ppProduction.getProductionNumber());
            ppProductionnew.setPproductId(ppProduction.getPproductId());//生产计划单产物id
            ppProductionnew.setSuitId(ppProductions.getSuitId());//套模id

            ppProductionnew.setFinishNum(0);
            ppProductionnew.setStaffId(1);//暂时
            ppProductionnew.setTeamId(gxScheduling.getTteamId());//班组id
            ppProductionnew.setFrequency(gxScheduling.getFrequency());//班次id

            ppProductionnew.setState(0);
            ppProductionnew.setCreateTime(new Date());
            ppProductionnew.setDeleteNo(0);
            ppProductionRepository.save(ppProductionnew);
        }

        if(ppProduction.getState() == 3){//转退火
            annealingPPProduction(ppProductionModel);//直接到转退火工序
        }
    }


//    原料出库操作
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateWarehouseProductOut(List<ProductionStock> productionStockList)throws PassportException {
        List<InventoryStatus> inventoryStatusList = new ArrayList<>();
        List<InventoryRecord> inventoryRecordList = new ArrayList<>();

        for (ProductionStock productionStock:productionStockList) {
            if(StringUtils.isEmpty(productionStock.getInventoryStatusId()) || StringUtils.isEmpty(productionStock.getQuantityChoose())){
                throw new PassportException(ResultCode.PARAM_MISS_MSG);
            }

            InventoryStatus findinventory = inventoryStatusRepository.findByid(productionStock.getInventoryStatusId());//根据库存id查找出相对应的信息。

            Integer intsum = findinventory.getInventorysum() -productionStock.getQuantityChoose();
            if(intsum<0){//判断库存数量是否足够
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
                throw new PassportException(ResultCode.NUM_NOENOUGH_MSG);
            }
            findinventory.setInventorysum(intsum);//修改库存数量
            inventoryStatusList.add(findinventory);//修改掉原来仓库的库存

            //调拨-取出记录
            InventoryRecord inventoryRecord = new InventoryRecord();
            inventoryRecord.setProductDetailid(findinventory.getProductId());
            inventoryRecord.setRecordType(7);//生产出库 7
            inventoryRecord.setCreateTime(System.currentTimeMillis());
            inventoryRecord.setChangequantity("-"+productionStock.getQuantityChoose());
            inventoryRecord.setSurplusquantity(intsum);
            inventoryRecord.setInventoryType(1);//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
            inventoryRecord.setRemark("生产出库");
            inventoryRecord.setWarehouseId(findinventory.getWarehouseId());
            inventoryRecordList.add(inventoryRecord);

        }
        inventoryStatusRepository.saveAll(inventoryStatusList);
        inventoryRecordRepository.saveAll(inventoryRecordList);//批量保存
    }

    /**
     * 生产管理-修改状态(delete_no)
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updatePPPByPPPId(UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) ||StringUtils.isEmpty(model.getUpdateType())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        PPProduction ppProduction=  ppProductionRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(ppProduction)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        ppProduction.setDeleteNo(ppProduction.getDeleteNo() == 0 ? 1 :0);
        ppProductionRepository.save(ppProduction);
    }

    /**
     * 生产管理- 撤回上班工序==修改上班工序的数据（熔炼、粗拉、中拉、细拉、超细拉、绕线、改绕等）
     * 1、把当前状态的数据物理删掉
     * 2、上班工序状态改为待重复
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void backToPPProduction(SelectModel selectModel)throws PassportException {
        if (StringUtils.isEmpty(selectModel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        Integer pppid = selectModel.getFindById();
        PPProduction ppProductions = ppProductionRepository.findByid(selectModel.getFindById());
        PPProduction ppProductionsF = ppProductionRepository.findByid(ppProductions.getFid());//上班工序
        if(StringUtils.isEmpty(ppProductions)){ throw new PassportException(ResultCode.DATA_NOEXIST_MSG);}

        // 先把该生产管理该工序所有改变掉状态
        iProductionMapper.UpdatePPPProductsByPPPId(pppid%10,pppid);

        ppProductions.setDeleteNo(1);//删掉当前工序

        ppProductionsF.setState(0);//上班工序状态改为待编辑
        ppProductionRepository.save(ppProductions);//保存原来的
        ppProductionRepository.save(ppProductionsF);//保存上班工序

    }


    /**
     * 生产管理- 转退火（粗拉、中拉、细拉、超细拉、绕线、改绕等）
     * 1、只有成品(超细拉)的时候才是成品退火。其他都是中间退火
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void annealingPPProduction(PPProductionModel ppProductionModel)throws PassportException {
        PPProduction ppProduction = ppProductionModel.getPpProduction();
        if (StringUtils.isEmpty(ppProduction.getProductionNumber()) || StringUtils.isEmpty(ppProduction.getState()) || StringUtils.isEmpty(ppProduction.getPproductId()) ||StringUtils.isEmpty(ppProduction.getEquipmentId())|| StringUtils.isEmpty(ppProduction.getSuitId())|| StringUtils.isEmpty(ppProduction.getStaffId())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        PPProduction ppProductions = ppProductionRepository.findByid(ppProduction.getFid());

        if (ppProductions.getGXId() == ProductionStateChange.Production_Smelting){throw new PassportException(ResultCode.PARAM_MISS_MSG);}//熔炼状态下不能退火

        if(StringUtils.isEmpty(ppProductions)){ throw new PassportException(ResultCode.DATA_NOEXIST_MSG);}

        ppProductionRepository.save(ppProduction);//保存原来的

        Integer pid = ppProduction.getId();
        Integer newGXid = 0 ;//新的工序id

//        准备转下班操作的工序id
        savepppproducts(ppProductionModel.getTwoList(),pid);//保存

        if(ppProductions.getGXId() == ProductionStateChange.Production_PPFinished){//如果是成品就是成品退火。其他都是中途退火
            newGXid =ProductionStateChange.PFinishedAnnealing;
        }else{//中途退火
            newGXid =ProductionStateChange.PIntermediateAnnealing;
        }

        String gxName =dictionarierRepository.findByid(newGXid).getName();
        Integer repeatCount = ppProductionRepository.countByProductionNumberAndGXId(ppProductions.getProductionNumber(),newGXid);
        gxName = repeatCount > 0? gxName+repeatCount :gxName;//如果是重复当前工序。就查询当前生产id的当前工序有多少个

        PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());
//        GXScheduling  gxScheduling= iProductionMapper.findGXSchedulingByPPIdAndGXIdAndSfId(ppProduct.getPpId(),newGXid,1);//粗拉

        PPProduction ppProductionnew = new PPProduction();
        ppProductionnew.setFid(pid);//上级id
        ppProductionnew.setGXId(newGXid);//工序id
        ppProductionnew.setGxName(gxName);//工序名称
        ppProductionnew.setProductionNumber(ppProduction.getProductionNumber());
        ppProductionnew.setPproductId(ppProduction.getPproductId());//生产计划单产物id
        ppProductionnew.setSuitId(ppProductions.getSuitId());//套模id

        ppProductionnew.setFinishNum(0);
        ppProductionnew.setStaffId(1);//暂时
        ppProductionnew.setTeamId(0);//班组id
        ppProductionnew.setFrequency(0);//班次id

        ppProductionnew.setState(0);
        ppProductionnew.setCreateTime(new Date());
        ppProductionnew.setDeleteNo(0);
        ppProductionRepository.save(ppProductionnew);
    }


    /**
     * 生产管理(退火)- 根据生产管理id查询详情信息
     * @param
     * @throws PassportException
     */
    public JSONObject getProductionAnnealingByPPPId(SelectModel selectModel)throws PassportException {
        JSONObject jsonObject = new JSONObject();
        if(StringUtils.isEmpty(selectModel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        PPProduction ppProduction = ppProductionRepository.findByid(selectModel.getFindById());
        if(StringUtils.isEmpty(ppProduction)){
            throw new PassportException(ResultCode.DATA_NOEXIST_MSG);
        }

        PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());//根据产物id查询产物基本信息

        Integer pdetailId = ppProduct.getProductDetailId();//得出 产品明细id

        ProductPlan productPlan = productPlanRepository.findByid(ppProduct.getPpId());//生产计划单

        if(productPlan.getRelationNo() == 0){
            jsonObject.put("BasicInfo",iProductionMapper.findMeltingBasicInfoByNoSaleId(ppProduct.getId()));//基本信息：不关联销售订单 根据生产计划单产物id
        }else{
            jsonObject.put("BasicInfo",iProductionMapper.findMeltingBasicInfoById(ppProduct.getId()));//基本信息：关联销售订单 根据生产计划单产物id
        }

        jsonObject.put("RawMaterialRatio",iProductionMapper.findRawMaterialRatioById(pdetailId));// 原料比例： 根据产品明细id RawMaterialRatio

        jsonObject.put("ProcessTechnology",suitRepository.findByid(productPlan.getSuitId()));//工艺参数 根据套模id
        jsonObject.put("equipmentInfo",iProductionMapper.findEquipmentByEquipmentId(ppProduction.getEquipmentId()));//设备信息
        jsonObject.put("OperationInfo",iProductionMapper.findGXSchedulingByPPIdAndGXIdAndSfId(ppProduct.getPpId(),ppProduction.getGXId(),ppProduction.getStaffId()));//操作信息

        jsonObject.put("PPProductionInfo", ppProduction);//熔炼信息

        jsonObject.put("equipmentXiaLa",mesMapper.findAllEquipmentByXiaLa());//下拉框：设备
        jsonObject.put("staffXiaLa",mesMapper.findStaffAllXiaLa());//下拉框：员工
        jsonObject.put("TeamXiaLa",mesMapper.findAllTTeamByXiaLa());//下拉框：班组
        jsonObject.put("BobbinXiaLa",mesMapper.findAllBobbinByXiaLa());//下拉框：线轴

        JSONObject jsonObject1 =  getProductionDetailListByPPPId(ppProduction);
        jsonObject.put("oneList",jsonObject1.get("oneList"));
        jsonObject.put("twoList",jsonObject1.get("twoList"));
        return jsonObject;
    }


    /**
     * 生产管理- 完成生产（粗拉、中拉、细拉、超细拉、绕线、改绕等）
     * 1、进库存啦 入库操作
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void finishedPPProduction(PPProductionModel ppProductionModel)throws PassportException {
        PPProduction ppProduction = ppProductionModel.getPpProduction();
        if (StringUtils.isEmpty(ppProduction.getProductionNumber()) || StringUtils.isEmpty(ppProduction.getState()) || StringUtils.isEmpty(ppProduction.getPproductId()) ||StringUtils.isEmpty(ppProduction.getEquipmentId())|| StringUtils.isEmpty(ppProduction.getSuitId())|| StringUtils.isEmpty(ppProduction.getStaffId())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        PPProduction ppProductions = ppProductionRepository.findByid(ppProduction.getId());

        if (ppProductions.getGXId() == ProductionStateChange.Production_Smelting){throw new PassportException(ResultCode.PARAM_MISS_MSG);}//熔炼状态下不能退火

        if(StringUtils.isEmpty(ppProductions)){ throw new PassportException(ResultCode.DATA_NOEXIST_MSG);}

        ppProductionRepository.save(ppProduction);//保存原来的

        Integer pid = ppProduction.getId();

        //准备入库的数据
        savepppproducts(ppProductionModel.getTwoList(),pid);//保存




    }
}
