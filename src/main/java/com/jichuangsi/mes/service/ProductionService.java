package com.jichuangsi.mes.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.jichuangsi.mes.common.PPStateChange;
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
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
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
    private ProductionDiaryReportRepository productionDiaryReportRepository;//生产日报汇总表

    /**
     * 生产管理-熔炼- 新增/编辑页面获取生产计划单数据
     * @param
     * @throws PassportException
     */
    public JSONObject getMeltingInfo()throws PassportException {
        JSONObject job = new JSONObject();

        List<ProductPlan> list = productPlanRepository.findAllByDeleteNoAndPpPlanState(0, PPStateChange.PP_OrderAudit_Audited);//审核通过的生产单
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
            job.put("RawMaterialRatio",iProductionMapper.findRawMaterialRatioByNoSaleId(pdetailId));// 原料比例： 根据产品明细id RawMaterialRatio
        }else{
            job.put("BasicInfo",iProductionMapper.findMeltingBasicInfoById(selectModel.getFindById()));//基本信息：关联销售订单 根据生产计划单产物id
            job.put("RawMaterialRatio",iProductionMapper.findRawMaterialRatioBySaleId(pdetailId));// 原料比例： 根据产品明细id RawMaterialRatio
        }

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
            jsonObject.put("RawMaterialRatio",iProductionMapper.findRawMaterialRatioByNoSaleId(pdetailId));// 原料比例： 根据产品明细id RawMaterialRatio
        }else{
            jsonObject.put("BasicInfo",iProductionMapper.findMeltingBasicInfoById(ppProduct.getId()));//基本信息：关联销售订单 根据生产计划单产物id
            jsonObject.put("RawMaterialRatio",iProductionMapper.findRawMaterialRatioBySaleId(pdetailId));// 原料比例： 根据产品明细id RawMaterialRatio
        }

        jsonObject.put("ProcessTechnology",suitRepository.findByid(productPlan.getSuitId()));//工艺参数 根据套模id
        jsonObject.put("equipmentInfo",iProductionMapper.findEquipmentByEquipmentId(ppProduction.getEquipmentId()));//设备信息
        jsonObject.put("OperationInfo",iProductionMapper.findGXSchedulingByPPIdAndGXIdAndSfId(ppProduct.getPpId(),ppProduction.getGXId(),ppProduction.getStaffId()));//操作信息

        jsonObject.put("PPProductionInfo", ppProduction);//熔炼信息

        jsonObject.put("equipmentXiaLa",mesMapper.findAllEquipmentByXiaLa());//下拉框：设备
        jsonObject.put("staffXiaLa",mesMapper.findStaffAllXiaLa());//下拉框：员工
        jsonObject.put("TeamXiaLa",mesMapper.findAllTTeamByXiaLa());//下拉框：班组
        jsonObject.put("BobbinXiaLa",mesMapper.findAllBobbinByXiaLa());//下拉框：线轴


        Integer id = ppProduction.getId()%10;

        if(ppProduction.getGXId() == ProductionStateChange.PSmelting){//熔炼
            jsonObject.put("oneListName","原材料");//原材料
            jsonObject.put("twoListName",ppProduction.getGxName());//本班生产产物

            jsonObject.put("oneList",iProductionMapper.findSmeltingStocksByPPPId(ppProduction.getId()));//原材料
            jsonObject.put("twoList",iProductionMapper.findProductsVoByPPPId(ppProduction.getId(),id));//本班产物
        }else{
            jsonObject.put("oneListName",ppProductionRepository.findByid(ppProduction.getFid()).getGxName());//上班工序名称
            jsonObject.put("twoListName",ppProduction.getGxName());//本班工序名称
            jsonObject.put("oneList",iProductionMapper.findProductsVoByPPPId(ppProduction.getFid(),ppProduction.getFid()%10));//上班产物
            jsonObject.put("twoList",iProductionMapper.findProductsVoByPPPId(ppProduction.getId(),id));//本班产物

            if(ppProduction.getGXId() == ProductionStateChange.PIntermediateAnnealing || ppProduction.getGXId() == ProductionStateChange.PFinishedAnnealing){
                //如果是退火，需要多加两个数据。
                jsonObject.put("elblDataList",elblDataRepository.findByPPPIdAndGxId(ppProduction.getId(), ppProduction.getGXId()));//elbl数据
                jsonObject.put("historyList",iProductionMapper.findAllPPProductionByProductionNumber(ppProduction.getGXId(),ppProduction.getProductionNumber()));//历史退火记录
                jsonObject.put("ppAnnealingInfo",new PPAnnealingInfo());
            }
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

        Integer getNewgxid = 0;
        if(smodel.getFindById() == ProductionStateChange.Production_IntermediateAnnealing){//如果是退火 6
            getNewgxid = ProductionStateChange.PFinishedAnnealing;//加上成品退火工序的数据
        }

        Integer getgxid =ProductionStateChange.getGXIdByGXType(smodel.getFindById());
        List<PPPVo>  ppVoList=iProductionMapper.findAllPPProduction(getgxid,getNewgxid, smodel.getFindName(),smodel.getFindModelName(),beginTime,endTime,(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());

        page.setList(ppVoList);
        page.setTotal(iProductionMapper.countByPPProduction(getgxid,getNewgxid, smodel.getFindName(),smodel.getFindModelName(),beginTime,endTime));

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
    public void savesmeltingProductsList(UserInfoForToken userInfoForToken,PPProductionModel ppProductionModel)throws PassportException {
        PPProduction ppProduction = ppProductionModel.getPpProduction();
        if (StringUtils.isEmpty(ppProduction.getState()) || StringUtils.isEmpty(ppProduction.getPproductId()) ||StringUtils.isEmpty(ppProduction.getEquipmentId())|| StringUtils.isEmpty(ppProduction.getSuitId())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        String productModel = ppProduction.getProductionNumber();//产品模型
        if(ppProduction.getGXId() == ProductionStateChange.Production_Smelting && StringUtils.isEmpty(ppProduction.getId())){//判断是否为熔炼阶段并且是否已经有提交过
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String dateNowStr = sdf.format(d);

            Integer productionSize = ppProductionRepository.findByCreateTimeIsBetweenAndGXId(DateUtil.beginOfDay(d),DateUtil.endOfDay(d),ProductionStateChange.PSmelting).size()+1;
            String strnum =dateNowStr+"00"+productionSize+ppProduction.getProductionNumber();
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

        PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());//根据产物id查询产物基本信息
        ProductPlan productPlan = productPlanRepository.findByid(ppProduct.getPpId());//生产计划单

        UpdateModel upd = new UpdateModel();
        if(productPlan.getRelationNo() == 0){//不关联销售订单
            upd = iProductionMapper.findBasicInfoByNoSaleId(ppProduct.getId());
        }else{
            upd = iProductionMapper.findBasicInfoById(ppProduct.getId());
        }

        savepppproducts(ppProductionModel.getTwoList(),pid,ppProduction.getState(),upd);//保存产物信息

        if(ppProduction.getState() == 1){//转下班操作
            //转下班操作：1、原料出库操作 2、新增粗拉批次 3、新增日报
            updateWarehouseProductOut(productionStockList,upd);//原料出库操作

            GXScheduling  gxScheduling= iProductionMapper.findGXSchedulingByPPIdAndGXIdAndSfId(ppProduct.getPpId(),ProductionStateChange.getGXIdByGXType(ProductionStateChange.Production_PPRoughDrawing),1);//粗拉

            PPProduction ppProductionnew = new PPProduction();
            ppProductionnew.setFid(pid);//粗拉的上级id
            ppProductionnew.setProductionNumber(ppProduction.getProductionNumber());
            ppProductionnew.setPproductId(ppProduction.getPproductId());//生产计划单产物id
            ppProductionnew.setSuitId(ppProduction.getSuitId());//套模id

            ppProductionnew.setFinishNum(0);
            ppProductionnew.setGXId(ProductionStateChange.getGXIdByGXType(ProductionStateChange.Production_PPRoughDrawing));
            ppProductionnew.setGxName(dictionarierRepository.findByid(ProductionStateChange.getGXIdByGXType(ProductionStateChange.Production_PPRoughDrawing)).getName());//工序名称
            ppProductionnew.setStaffId(Integer.valueOf(userInfoForToken.getUserId()));
            ppProductionnew.setTeamId(gxScheduling.getTteamId());//班组id
            ppProductionnew.setFrequency(gxScheduling.getFrequency());//班次id

            ppProductionnew.setState(0);
            ppProductionnew.setCreateTime(new Date());
            ppProductionnew.setDeleteNo(0);
            ppProductionRepository.save(ppProductionnew);

            // 3、新增日报
            saveProductionDiary(ppProductionModel,productModel,productPlan.getPpNumber());
        }
    }

    //新增日报
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public  void saveProductionDiary(PPProductionModel ppProductionModel,String productModel,String ppnumber)throws PassportException {
        ProductionDiaryReport productionDiaryReport = new ProductionDiaryReport();
        productionDiaryReport.setProductDate(DateUtil.today());//当天日期
        productionDiaryReport.setPpNumber(ppnumber);
        productionDiaryReport.setProductionNumber(ppProductionModel.getPpProduction().getProductionNumber());
        productionDiaryReport.setProductModel(productModel);//产品型号
        productionDiaryReport.setIncomeHeavy(ppProductionModel.getOneList().stream().mapToInt(ProductionStock::getTotalNet).sum());//来料重
        productionDiaryReport.setNoFinishEdP(ppProductionModel.getTwoList().stream().map(PPPProducts0::getNetWeightg).reduce(BigDecimal.ZERO, BigDecimal::add));//半成品g
        productionDiaryReport.setFinishEdP(BigDecimal.ZERO);
        productionDiaryReport.setLoss(ppProductionModel.getTwoList().stream().map(PPPProducts0::getLossg).reduce(BigDecimal.ZERO, BigDecimal::add));//损耗
        productionDiaryReport.setWaste(ppProductionModel.getTwoList().stream().map(PPPProducts0::getWastageg).reduce(BigDecimal.ZERO, BigDecimal::add));//废料

        productionDiaryReportRepository.save(productionDiaryReport);
    }

    /**
     * 保存实体-产物信息
     * 此方法作用：1、分表，减少数据库压力。
     * 2、根据pppid分配存进不同的表
     *
     * 除了要保存每一班的产物。也要保存每一班产生的废料。半成品/成品净重等。
     *
     * 废料不会清空。只有半成品/成品才会
     * @param list
     * @param pppid
     * @param state 状态 如果状态== 4.完成生产。就直接保存产物进库存。
     *
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public  void savepppproducts(List<PPPProducts0> list,Integer pppid,Integer state,UpdateModel upd)throws PassportException {
        Integer LId = pppid%10;

        Integer inventoryType = state == 4 ?  2 : 3;

        //1、先把该生产管理该工序所有改变掉状态
        iProductionMapper.UpdatePPPProductsByPPPId(LId,pppid);
//        inventoryRecordRepository.updateByPIdAndInventoryType(pppid,inventoryType);//把上批的产物清零
        inventoryStatusRepository.updateByProductIdAndInventoryType(pppid,3);//把上批的产物清零

        List<InventoryStatus> inventoryStatusList = new ArrayList<>();//成品/半成品
        List<InventoryRecord> inventoryRecordList = new ArrayList<>();//库存记录

        for (int i = 0; i < list.size(); i++) {
            PPPProducts0 pppProducts = list.get(i);
            if(StringUtils.isEmpty(pppProducts.getNetWeightg()) || StringUtils.isEmpty(pppProducts.getLossg()) || StringUtils.isEmpty(pppProducts.getWastageg())){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
                throw new PassportException(ResultCode.PARAM_MISS_MSG);
            }

            pppProducts.setGxId(ProductionStateChange.getGXIdByGXType(pppProducts.getGxId()));
            pppProducts.setPPPId(pppid);
            pppProducts.setNumbers(1);//数量
            pppProducts.setTotalLength(pppProducts.getLengthM());//总长度
            pppProducts.setNetWeightgSum(pppProducts.getNetWeightg());//总净重g
        }

        iProductionMapper.insertPPPProducts(list,LId);//保存本班生产产物

        // 把上批的产物清零。然后新增保存本班的产物
        List<PPPProducts0> findgetId = iProductionMapper.findProductsIdByPPPId(pppid,LId);
        for (int j = 0; j < findgetId.size(); j++) {
            PPPProducts0 pppProducts = findgetId.get(j);

            BigDecimal wastagegs = new BigDecimal(BigDecimal.valueOf(Double.parseDouble(pppProducts.getWastageg().toString())).stripTrailingZeros().toPlainString());
            BigDecimal netWeightgs =new BigDecimal(BigDecimal.valueOf(Double.parseDouble(pppProducts.getNetWeightg().toString())).stripTrailingZeros().toPlainString());
            Integer wastageg =Integer.valueOf(wastagegs.toString()) ;
            Integer netWeightg = Integer.valueOf(netWeightgs.toString());

            InventoryStatus inventoryStatus1 = new InventoryStatus();//废料
            InventoryStatus inventoryStatus2 = new InventoryStatus();//产品/半成品
            InventoryRecord inventoryRecord1 = new InventoryRecord();//废料
            InventoryRecord inventoryRecord2 = new InventoryRecord();//产品/半成品

            inventoryStatus1.setProductId(pppProducts.getId());//产品/原料明细Id/生产id
            inventoryStatus1.setPppId(pppid);
            inventoryStatus1.setWarehouseId(1);//仓库Id
            inventoryStatus1.setInventoryType(4);//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
            inventoryStatus1.setInventorysum(wastageg);//废料数量
            inventoryStatus1.setInventorynumbers(1);//数量

            inventoryStatus1.setStockName(upd.getStockName());
            inventoryStatus1.setStockNumber(upd.getStockNumber());
            inventoryStatus1.setStockModel(upd.getStockModel());
            inventoryStatus1.setStandards(upd.getStandards());
            inventoryStatus1.setUnitId(upd.getUnitId());

            inventoryStatus2.setProductId(pppProducts.getId());//产品/原料明细Id/生产id
            inventoryStatus2.setPppId(pppid);
            inventoryStatus2.setWarehouseId(1);//仓库Id
            inventoryStatus2.setInventoryType(inventoryType);//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
            inventoryStatus2.setInventorysum(netWeightg);//净含量数量
            inventoryStatus2.setInventorynumbers(1);//数量

            inventoryStatus2.setStockName(upd.getStockName());
            inventoryStatus2.setStockNumber(upd.getStockNumber());
            inventoryStatus2.setStockModel(upd.getStockModel());
            inventoryStatus2.setStandards(upd.getStandards());
            inventoryStatus2.setUnitId(upd.getUnitId());

            //存入记录:废料
            inventoryRecord1.setProductDetailid(pppProducts.getId());
            inventoryRecord1.setPppId(pppid);
            inventoryRecord1.setRecordType(2);//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购等)
            inventoryRecord1.setCreateTime(System.currentTimeMillis());
            inventoryRecord1.setChangequantity("+"+wastageg);
            inventoryRecord1.setSurplusquantity(wastageg);
            inventoryRecord1.setInventoryType(4);//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
            inventoryRecord1.setRemark("生产计划单过程产生废料");
            inventoryRecord1.setWarehouseId(1);

            inventoryRecord1.setStockName(upd.getStockName());
            inventoryRecord1.setStockNumber(upd.getStockNumber());
            inventoryRecord1.setStockModel(upd.getStockModel());
            inventoryRecord1.setStandards(upd.getStandards());
            inventoryRecord1.setUnitId(upd.getUnitId());


            //存入记录：产品
            inventoryRecord2.setProductDetailid(pppProducts.getId());
            inventoryRecord2.setPppId(pppid);
            inventoryRecord2.setRecordType(2);//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购等)
            inventoryRecord2.setCreateTime(System.currentTimeMillis());
            inventoryRecord2.setChangequantity("+"+netWeightg);
            inventoryRecord2.setSurplusquantity(netWeightg);
            inventoryRecord2.setInventoryType(inventoryType);//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
            inventoryRecord2.setRemark("生产计划单过程产生数量");
            inventoryRecord2.setWarehouseId(1);

            inventoryRecord2.setStockName(upd.getStockName());
            inventoryRecord2.setStockNumber(upd.getStockNumber());
            inventoryRecord2.setStockModel(upd.getStockModel());
            inventoryRecord2.setStandards(upd.getStandards());
            inventoryRecord2.setUnitId(upd.getUnitId());

            inventoryStatusList.add(inventoryStatus1);
            inventoryStatusList.add(inventoryStatus2);
            inventoryRecordList.add(inventoryRecord1);
            inventoryRecordList.add(inventoryRecord2);
        }

        inventoryRecordRepository.saveAll(inventoryRecordList);//批量保存
        inventoryStatusRepository.saveAll(inventoryStatusList);//保存废料和产品
    }

    /**
     * 生产管理- 转下班/重复当前工序 操作（熔炼、粗拉、中拉、细拉、超细拉、绕线、改绕等）-新增/编辑
     *
     * 0 草稿  1 转下班 2重复当前工序 3 转退火  4 完成生产
     * @param1、保存当前班组操作  2 新增下班操作
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void savePPProduction(UserInfoForToken userInfoForToken,PPProductionModel ppProductionModel)throws PassportException {
        PPProduction ppProduction = ppProductionModel.getPpProduction();
        if (StringUtils.isEmpty(ppProduction.getProductionNumber()) || StringUtils.isEmpty(ppProduction.getState()) || StringUtils.isEmpty(ppProduction.getPproductId()) ||StringUtils.isEmpty(ppProduction.getEquipmentId())|| StringUtils.isEmpty(ppProduction.getSuitId())|| StringUtils.isEmpty(ppProduction.getStaffId())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        PPProduction ppProductions = ppProductionRepository.findByid(ppProduction.getFid());

        if(StringUtils.isEmpty(ppProductions)){ throw new PassportException(ResultCode.DATA_NOEXIST_MSG);}

        ppProductionRepository.save(ppProduction);//保存原来的

        if(ppProduction.getGXId() == ProductionStateChange.PIntermediateAnnealing || ppProduction.getGXId() == ProductionStateChange.PFinishedAnnealing){
                //如果是退火，需要多保存两个数据。
                saveAnnealingBasicInfo(ppProductionModel.getPpAnnealingInfo(),ppProductionModel.getElblDataList());
        }

        Integer pid = ppProduction.getId();

        PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());//根据产物id查询产物基本信息
        ProductPlan productPlan = productPlanRepository.findByid(ppProduct.getPpId());//生产计划单

        UpdateModel upd = new UpdateModel();
        if(productPlan.getRelationNo() == 0){//不关联销售订单
            upd = iProductionMapper.findBasicInfoByNoSaleId(ppProduct.getId());
        }else{
            upd = iProductionMapper.findBasicInfoById(ppProduct.getId());
        }
//        准备转下班操作的工序id
        savepppproducts(ppProductionModel.getTwoList(),pid,ppProduction.getState(),upd);//保存

        if(ppProduction.getState() == 1 || ppProduction.getState() == 2|| ppProduction.getState() == 4){//如果是转下班/重复当前工序/完成生产操作。就新增下班操作
            Integer newGXid =ppProduction.getState() == 1?  ProductionStateChange.getGXIdByGXType(ProductionStateChange.getGXStateChangeone(ProductionStateChange.getGXIdByGXTypeDesc(ppProduction.getGXId()))) : ppProduction.getGXId();

            if(ppProduction.getState() == 1 && ppProduction.getGXId() == ProductionStateChange.PIntermediateAnnealing || ppProduction.getGXId() == ProductionStateChange.PFinishedAnnealing){
//                退火操作的话。转下班需要获取本班的上班工序是什么，再赋值下班工序；
                newGXid =ProductionStateChange.getGXIdByGXType(ProductionStateChange.getGXStateChangeone(ProductionStateChange.getGXIdByGXTypeDesc(ppProductionRepository.findByid(ppProduction.getFid()).getGXId()))) ;
            }

            if(ppProduction.getState() == 4){
                //如果是点击完成生产。首先要保存本班产物。然后新增下一班绕线的工序。然后进行完成生产的入库操作。
                newGXid =ProductionStateChange.PPPWinding;
            }

            String gxName =dictionarierRepository.findByid(newGXid).getName();
            gxName = ppProduction.getState() == 1? gxName :gxName+ppProductionRepository.countByProductionNumberAndGXId(ppProductions.getProductionNumber(),newGXid) ;//如果是重复当前工序。就查询当前生产id的当前工序有多少个

//            PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());
            GXScheduling  gxScheduling= iProductionMapper.findGXSchedulingByPPIdAndGXIdAndSfId(ppProduct.getPpId(),newGXid,1);//粗拉

            PPProduction ppProductionnew = new PPProduction();
            ppProductionnew.setFid(pid);//粗拉的上级id
            ppProductionnew.setGXId(newGXid);//粗拉
            ppProductionnew.setGxName(gxName);//工序名称
            ppProductionnew.setProductionNumber(ppProduction.getProductionNumber());
            ppProductionnew.setPproductId(ppProduction.getPproductId());//生产计划单产物id
            ppProductionnew.setSuitId(ppProductions.getSuitId());//套模id

            ppProductionnew.setFinishNum(0);
            ppProductionnew.setStaffId(Integer.valueOf(userInfoForToken.getUserId()));
            ppProductionnew.setTeamId(gxScheduling.getTteamId());//班组id
            ppProductionnew.setFrequency(gxScheduling.getFrequency());//班次id

            ppProductionnew.setState(0);
            ppProductionnew.setCreateTime(new Date());
            ppProductionnew.setDeleteNo(0);
            ppProductionRepository.save(ppProductionnew);
        }

        if(ppProduction.getState() == 3){//转退火
            annealingPPProduction(Integer.valueOf(userInfoForToken.getUserId()),ppProductionModel);//直接到转退火工序
        }

        //查找生产日报数据。添加数据
        ProductionDiaryReport productionDiaryReport = productionDiaryReportRepository.findByProductionNumberAndProductDate(ppProductions.getProductionNumber(),DateUtil.today());


    }

//    保存退火基本数据
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void saveAnnealingBasicInfo(PPAnnealingInfo ppAnnealingInfo,List<ELBLData> elblDataList)throws PassportException{
        if(StringUtils.isEmpty(ppAnnealingInfo.getPppId())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        for (int i = 0; i < elblDataList.size(); i++){
            if(StringUtils.isEmpty(elblDataList.get(i).getPPPId()) || StringUtils.isEmpty(elblDataList.get(i).getGxId())){
                throw new PassportException(ResultCode.PARAM_MISS_MSG);
            }
        }
        ppAnnealingInfoRepository.save(ppAnnealingInfo);
        elblDataRepository.saveAll(elblDataList);
    }


//    原料出库操作
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateWarehouseProductOut(List<ProductionStock> productionStockList,UpdateModel updateModel)throws PassportException {
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

            inventoryRecord.setStockName(updateModel.getStockName());
            inventoryRecord.setStockNumber(updateModel.getStockNumber());
            inventoryRecord.setStockModel(updateModel.getStockModel());
            inventoryRecord.setStandards(updateModel.getStandards());
            inventoryRecord.setUnitId(updateModel.getUnitId());
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
    public void annealingPPProduction(Integer staffId, PPProductionModel ppProductionModel)throws PassportException {
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

        PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());//根据产物id查询产物基本信息
        ProductPlan productPlan = productPlanRepository.findByid(ppProduct.getPpId());//生产计划单

        UpdateModel upd = new UpdateModel();
        if(productPlan.getRelationNo() == 0){//不关联销售订单
            upd = iProductionMapper.findBasicInfoByNoSaleId(ppProduct.getId());
        }else{
            upd = iProductionMapper.findBasicInfoById(ppProduct.getId());
        }

//        准备转下班操作的工序id
        savepppproducts(ppProductionModel.getTwoList(),pid,ppProduction.getState(),upd);//保存

        if(ppProductions.getGXId() == ProductionStateChange.Production_PPFinished ||ppProductions.getGXId() == ProductionStateChange.PPPFinished){//如果是成品就是成品退火。其他都是中途退火
            newGXid =ProductionStateChange.PFinishedAnnealing;
        }else{//中途退火
            newGXid =ProductionStateChange.PIntermediateAnnealing;
        }

        String gxName =dictionarierRepository.findByid(newGXid).getName();
        Integer repeatCount = ppProductionRepository.countByProductionNumberAndGXId(ppProductions.getProductionNumber(),newGXid);
        gxName = repeatCount > 0? gxName+repeatCount :gxName;//如果是重复当前工序。就查询当前生产id的当前工序有多少个

//        PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());
        GXScheduling  gxScheduling= iProductionMapper.findGXSchedulingByPPIdAndGXIdAndSfId(ppProduct.getPpId(),newGXid,1);//粗拉

        PPProduction ppProductionnew = new PPProduction();
        ppProductionnew.setFid(pid);//上级id
        ppProductionnew.setGXId(newGXid);//工序id
        ppProductionnew.setGxName(gxName);//工序名称
        ppProductionnew.setProductionNumber(ppProduction.getProductionNumber());
        ppProductionnew.setPproductId(ppProduction.getPproductId());//生产计划单产物id
        ppProductionnew.setSuitId(ppProductions.getSuitId());//套模id

        ppProductionnew.setFinishNum(0);
        ppProductionnew.setStaffId(staffId);
        ppProductionnew.setTeamId(gxScheduling.getTteamId());//班组id
        ppProductionnew.setFrequency(gxScheduling.getFrequency());//班次id

        ppProductionnew.setState(0);
        ppProductionnew.setCreateTime(new Date());
        ppProductionnew.setDeleteNo(0);
        ppProductionRepository.save(ppProductionnew);
    }

    /**
     * 生产管理- 退火-导入操作
     * 1、上传excel文件
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public List<ELBLData> importFilePPProduction(SelectModel selectModel,InputStream is)throws PassportException,IOException {

        if(StringUtils.isEmpty(selectModel.getFindById())){ throw new PassportException(ResultCode.DATA_NOEXIST_MSG);}

        // 2.应用HUtool ExcelUtil获取ExcelReader指定输入流和sheet
        ExcelReader excelReader = ExcelUtil.getReader(is);
        // 可以加上表头验证
        // 3.读取第1行到最后一行数据
        List<List<Object>> read = excelReader.read(1, excelReader.getRowCount());
        List<ELBLData> elblDataList = new ArrayList<>();
        for(int i = 0; i < read.size(); i++){
            ELBLData elblData = new ELBLData();
            //el数据
            elblData.setElX1(Integer.parseInt(read.get(i).get(0).toString()));
            elblData.setElX2(Integer.parseInt(read.get(i).get(1).toString()));
            elblData.setElX3(Integer.parseInt(read.get(i).get(2).toString()));
            elblData.setElX4(Integer.parseInt(read.get(i).get(3).toString()));
            elblData.setElX5(Integer.parseInt(read.get(i).get(4).toString()));
            //bl数据
            elblData.setBlX1(Integer.parseInt(read.get(i).get(5).toString()));
            elblData.setBlX2(Integer.parseInt(read.get(i).get(6).toString()));
            elblData.setBlX3(Integer.parseInt(read.get(i).get(7).toString()));
            elblData.setBlX4(Integer.parseInt(read.get(i).get(8).toString()));
            elblData.setBlX5(Integer.parseInt(read.get(i).get(9).toString()));

            elblDataList.add(elblData);
        }
        return  elblDataList;
    }

    /**
     * 生产管理- 退火-转上班 操作-新增/编辑
     * @param1、把本班工序删掉  2 新增上班工序的第二次班
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void transferToPPProduction(UserInfoForToken userInfoForToken,SelectModel selectModel)throws PassportException {
        if (StringUtils.isEmpty(selectModel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        PPProduction ppProduction = ppProductionRepository.findByid(selectModel.getFindById());
        ppProduction.setDeleteNo(1);
        ppProductionRepository.save(ppProduction);//把原来的删掉

        PPProduction ppProductions2 = ppProductionRepository.findByid(ppProduction.getFid());//获取上班的pppid

        if(StringUtils.isEmpty(ppProductions2)){ throw new PassportException(ResultCode.DATA_NOEXIST_MSG);}
            Integer newGXid =ppProductions2.getGXId();

            String gxName =dictionarierRepository.findByid(newGXid).getName()+ppProductionRepository.countByProductionNumberAndGXId(ppProductions2.getProductionNumber(),newGXid);//如果是重复当前工序。就查询当前生产id的当前工序有多少个

            PPProduct ppProduct = ppProductRepository.findByid(ppProductions2.getPproductId());
            GXScheduling  gxScheduling= iProductionMapper.findGXSchedulingByPPIdAndGXIdAndSfId(ppProduct.getPpId(),newGXid,1);//粗拉

            PPProduction ppProductionnew = new PPProduction();
            ppProductionnew.setFid(ppProductions2.getId());//上级id
            ppProductionnew.setGXId(newGXid);//gxid
            ppProductionnew.setGxName(gxName);//工序名称
            ppProductionnew.setProductionNumber(ppProduction.getProductionNumber());
            ppProductionnew.setPproductId(ppProduction.getPproductId());//生产计划单产物id
            ppProductionnew.setSuitId(ppProductions2.getSuitId());//套模id

            ppProductionnew.setFinishNum(0);
            ppProductionnew.setStaffId(Integer.valueOf(userInfoForToken.getUserId()));
            ppProductionnew.setTeamId(gxScheduling.getTteamId());//班组id
            ppProductionnew.setFrequency(gxScheduling.getFrequency());//班次id

            ppProductionnew.setState(0);
            ppProductionnew.setCreateTime(new Date());
            ppProductionnew.setDeleteNo(0);
            ppProductionRepository.save(ppProductionnew);
    }


    /**
     * 生产管理（绕线）- 根据生产管理id查询详情信息
     * 左边的待绕线信息就是上班工序。右边的绕线明细就是本班的信息。
     * @param
     * @throws PassportException
     */
    public JSONObject getPWindingDetailByPPPId(SelectModel selectModel)throws PassportException {
        JSONObject jsonObject = new JSONObject();
        if(StringUtils.isEmpty(selectModel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        PPProduction ppProduction = ppProductionRepository.findByid(selectModel.getFindById());
        if(StringUtils.isEmpty(ppProduction)){
            throw new PassportException(ResultCode.DATA_NOEXIST_MSG);
        }

        PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());//根据产物id查询产物基本信息

        ProductPlan productPlan = productPlanRepository.findByid(ppProduct.getPpId());//生产计划单

        if(productPlan.getRelationNo() == 0){
            jsonObject.put("BasicInfo",iProductionMapper.findMeltingBasicInfoByNoSaleId(ppProduct.getId()));//基本信息：不关联销售订单 根据生产计划单产物id
        }else{
            jsonObject.put("BasicInfo",iProductionMapper.findMeltingBasicInfoById(ppProduct.getId()));//基本信息：关联销售订单 根据生产计划单产物id
        }
        jsonObject.put("OperationInfo",iProductionMapper.findGXSchedulingByPPIdAndGXIdAndSfId(ppProduct.getPpId(),ppProduction.getGXId(),ppProduction.getStaffId()));//操作信息

        jsonObject.put("PPProductionInfo", ppProduction);//熔炼信息

        jsonObject.put("oneListName",ppProductionRepository.findByid(ppProduction.getFid()).getGxName());//上班工序名称
        jsonObject.put("oneList",iProductionMapper.findProductsVoByPPPId(ppProduction.getFid(),ppProduction.getFid()%10));//上班产物/待绕线成品
        jsonObject.put("twoList",iProductionMapper.findProductsVoByPPPId2(ppProduction.getId(),ppProduction.getId()%10));//本班产物/绕线明细
//        jsonObject.put("twoList",iProductionMapper.findPWindingProductsVoByPPPPId(ppProduction.getId(),ppProduction.getId()%10));//本班产物/绕线明细

        jsonObject.put("equipmentXiaLa",mesMapper.findAllEquipmentByXiaLa());//下拉框：设备
        jsonObject.put("staffXiaLa",mesMapper.findStaffAllXiaLa());//下拉框：员工
        jsonObject.put("TeamXiaLa",mesMapper.findAllTTeamByXiaLa());//下拉框：班组
        jsonObject.put("BobbinXiaLa",mesMapper.findAllBobbinByXiaLa());//下拉框：线轴

        return jsonObject;
    }


    /**
     * 生产管理（绕线）-新增绕线页面- 根据上班工序产物id查询详情信息
     *          findById 生产id
     *         findIdOne 生产产物id
     * @throws PassportException
     */
    public JSONObject getPWindingDetailByPPWindingDetailId(SelectModel selectModel)throws PassportException {
        JSONObject jsonObject = new JSONObject();
        if(StringUtils.isEmpty(selectModel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        PPPWindingInfo pppWindingInfo = pppWindingInfoRepository.findByPPPPIdAndPPPId(selectModel.getFindIdOne(),selectModel.getFindById());

        PPProduction ppProduction = ppProductionRepository.findByid(selectModel.getFindById());

        ProductsVo productsVo = iProductionMapper.findBypppProducts(ppProduction.getFid()%10,selectModel.getFindIdOne());
        List<ProductsVo> productsVoList = iProductionMapper.findPWindingProductsVoByPPPPId(selectModel.getFindIdOne(),selectModel.getFindById()%10);

        jsonObject.put("pppProducts",productsVo);//待绕线成品参数
        jsonObject.put("PPPWindingInfo",StringUtils.isEmpty(pppWindingInfo) ? new PPPWindingInfo() :pppWindingInfo);//绕线操作的基本数据
        jsonObject.put("TwoList",productsVoList);//绕线操作的基本数据。根据产物id去查询

        jsonObject.put("oneListName",ppProduction.getGxName());//上班工序名称

        jsonObject.put("equipmentXiaLa",mesMapper.findAllEquipmentByXiaLa());//下拉框：设备
        jsonObject.put("staffXiaLa",mesMapper.findStaffAllXiaLa());//下拉框：员工
        jsonObject.put("TeamXiaLa",mesMapper.findAllTTeamByXiaLa());//下拉框：班组
        jsonObject.put("BobbinXiaLa",mesMapper.findAllBobbinByXiaLa());//下拉框：线轴

        jsonObject.put("beforeLength",productsVo.getLengthM().multiply(new BigDecimal(productsVo.getNumbers())));//绕线前总长度
        jsonObject.put("afterLength",productsVoList.stream().map(ProductsVo::getTotalLength).reduce(BigDecimal.ZERO, BigDecimal::add));//绕线后总长度
        jsonObject.put("beforeWeight",productsVo.getNetWeightg().multiply(new BigDecimal(productsVo.getNumbers())));//绕线前总重量
        jsonObject.put("afterWeight",productsVoList.stream().map(ProductsVo::getNetWeightgSum).reduce(BigDecimal.ZERO, BigDecimal::add));//绕线后总重量

        return jsonObject;
    }

    /**
     * 生产管理(绕线)- 保存明细操作-新增/编辑
     *
     * @param1、保存当前产物明细id 2、增加绕线信息（设备id等）
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void savePWindingDetail(PPProductionModel ppProductionModel)throws PassportException {
        PPProduction ppProduction = ppProductionModel.getPpProduction();
        PPPWindingInfo pppWindingInfo = ppProductionModel.getPppWindingInfo();//绕线基本信息
        if (StringUtils.isEmpty(ppProduction.getId()) ||StringUtils.isEmpty(pppWindingInfo.getEquipmentId()) ||StringUtils.isEmpty(pppWindingInfo.getPPPPId())||StringUtils.isEmpty(pppWindingInfo.getPPPId())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        Integer pppid = ppProduction.getId();
        Integer LId = pppid%10;

        List<PPPProducts0> list = ppProductionModel.getTwoList();

        //1、先把该生产管理该工序所有改变掉状态
        iProductionMapper.UpdatePPPProductsDetailByfid(LId,list.get(0).getFid(),pppid);

        if(list.size() != 0){
            for (int i = 0; i < list.size(); i++) {
                PPPProducts0 pppProducts = list.get(i);
                if(StringUtils.isEmpty(pppProducts.getNetWeightg()) || StringUtils.isEmpty(pppProducts.getLengthM())){
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
                    throw new PassportException(ResultCode.PARAM_MISS_MSG);
                }

//                pppProducts.setGxId(ProductionStateChange.getGXIdByGXType(pppProducts.getGxId()));
                pppProducts.setGxId(0);
                pppProducts.setPPPId(pppid);
                pppProducts.setCreateTime(new Date());
                pppProducts.setTotalLength(pppProducts.getLengthM().multiply(new BigDecimal(pppProducts.getNumbers())));//总长度
                pppProducts.setNetWeightgSum(pppProducts.getNetWeightg().multiply(new BigDecimal(pppProducts.getNumbers())));//总净重g
            }

            iProductionMapper.insertPPPProducts(list,LId);//保存本班生产产物
        }

        pppWindingInfo.setDeleteNo(0);
        pppWindingInfoRepository.save(pppWindingInfo);//保存绕线明细基本信息
    }

    /**
     * 生产管理(绕线)- 保存操作-新增/编辑
     *
     * @param1、把当前产物id的状态改为已绕线/改绕  2 保存当前产物明细id 3 入库
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void savePWinding(PPProductionModel ppProductionModel)throws PassportException {
        PPProduction ppProduction = ppProductionModel.getPpProduction();
        if (StringUtils.isEmpty(ppProduction.getTeamId()) || StringUtils.isEmpty(ppProduction.getState()) || StringUtils.isEmpty(ppProduction.getPproductId()) ||  StringUtils.isEmpty(ppProduction.getStaffId())||  StringUtils.isEmpty(ppProduction.getFrequency())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        ppProductionRepository.save(ppProduction);//保存本信息
        //如果是保存。从数据库中查询出之前的生产产物，然后入库
        if(ppProduction.getState() == 1){
            Integer pppid = ppProduction.getId();
            Integer LId = pppid%10;
            List<ProductsVo> list =iProductionMapper.findProductsVoByPPPId2(pppid,LId);//从数据库中获取提前保存好的生产产物list

            if(list.size() == 0){
                throw new PassportException(ResultCode.DATA_NOEXIST_MSG);
            }

            List<InventoryStatus> inventoryStatusList = new ArrayList<>();//成品
            List<InventoryRecord> inventoryRecordList = new ArrayList<>();//库存记录

            PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());//根据产物id查询产物基本信息
            ProductPlan productPlan = productPlanRepository.findByid(ppProduct.getPpId());//生产计划单

            UpdateModel upd = new UpdateModel();
            if(productPlan.getRelationNo() == 0){//不关联销售订单
                upd = iProductionMapper.findBasicInfoByNoSaleId(ppProduct.getId());
            }else{
                upd = iProductionMapper.findBasicInfoById(ppProduct.getId());
            }

            inventoryStatusRepository.updateByProductIdAndInventoryType(ppProduction.getFid(),2);//把上批的产物清零
            for (int i = 0; i < list.size(); i++) {
                ProductsVo pppProducts = list.get(i);

                InventoryStatus inventoryStatus1 = new InventoryStatus();//成品
                InventoryRecord inventoryRecord1 = new InventoryRecord();//成品

                BigDecimal netWeightgs =new BigDecimal(BigDecimal.valueOf(Double.parseDouble(pppProducts.getNetWeightg().toString())).stripTrailingZeros().toPlainString());//净重
                Integer netWeightg = Integer.valueOf(netWeightgs.toString());
                BigDecimal number =new BigDecimal(BigDecimal.valueOf(Double.parseDouble(pppProducts.getNumbers().toString())).stripTrailingZeros().toPlainString());//净重
                Integer numbers = Integer.valueOf(number.toString());


                inventoryStatus1.setProductId(pppProducts.getId());//产品/原料明细Id/生产id
                inventoryStatus1.setWarehouseId(1);//仓库Id
                inventoryStatus1.setInventoryType(2);//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
                inventoryStatus1.setInventorysum(netWeightg);//废料数量
                inventoryStatus1.setInventorynumbers(numbers);//数量

                inventoryStatus1.setStockName(upd.getStockName());
                inventoryStatus1.setStockNumber(upd.getStockNumber());
                inventoryStatus1.setStockModel(upd.getStockModel());
                inventoryStatus1.setStandards(upd.getStandards());
                inventoryStatus1.setUnitId(upd.getUnitId());
                inventoryStatus1.setPppId(pppid);

                //存入记录:绕线成品
                inventoryRecord1.setProductDetailid(pppProducts.getId());
                inventoryRecord1.setRecordType(2);//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购等)
                inventoryRecord1.setCreateTime(System.currentTimeMillis());
                inventoryRecord1.setChangequantity("+"+netWeightg);
                inventoryRecord1.setSurplusquantity(netWeightg);
                inventoryRecord1.setInventoryType(2);//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
                inventoryRecord1.setRemark("绕线过程产生成品");
                inventoryRecord1.setWarehouseId(1);

                inventoryRecord1.setStockName(upd.getStockName());
                inventoryRecord1.setStockNumber(upd.getStockNumber());
                inventoryRecord1.setStockModel(upd.getStockModel());
                inventoryRecord1.setStandards(upd.getStandards());
                inventoryRecord1.setUnitId(upd.getUnitId());
                inventoryRecord1.setPppId(pppid);

                inventoryStatusList.add(inventoryStatus1);
                inventoryRecordList.add(inventoryRecord1);
            }

            inventoryRecordRepository.saveAll(inventoryRecordList);//批量保存
            inventoryStatusRepository.saveAll(inventoryStatusList);//保存产品
        }
    }


    /**
     * 生产管理（改绕）-查询完成生产的生产信息
     * @throws PassportException
     */
    public JSONObject getAllFinished()throws PassportException {
        JSONObject jsonObject = new JSONObject();

        List<PPProductionVo> list = iProductionMapper.findAllFinished();

        jsonObject.put("oneList",list);//根据生产id查询本班产物list
        jsonObject.put("twoList",list.size() > 0 ? iProductionMapper.findKuCunProductsVoByPPPId(list.get(0).getId(),list.get(0).getId()%10) :"");//根据生产id查询本班产物list

        return jsonObject;
    }

    /**
     * 生产管理（改绕）-根据生产id查询完成生产的生产信息
     * @throws PassportException
     */
    public JSONObject getFinishedByPPPId(SelectModel selectModel)throws PassportException {
        JSONObject jsonObject = new JSONObject();

        if(StringUtils.isEmpty(selectModel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        jsonObject.put("twoList",iProductionMapper.findKuCunProductsVoByPPPId(selectModel.getFindById(),selectModel.getFindById()%10));//根据生产id查询本班产物list

        return jsonObject;
    }

    /**
     * 生产管理（改绕）- 根据选择需要改绕的数据查询详情信息
     * 左边的待绕线信息就是选择需要改绕的数据。右边的绕线明细就是本班的信息。
     * @param
     * @throws PassportException
     */
    public JSONObject getPDetourDetailByChooseIds(UserInfoForToken userInfoForToken,List<SelectModel> selectModel)throws PassportException {
        JSONObject jsonObject = new JSONObject();

        if(selectModel.size() <= 0){
            throw new PassportException(ResultCode.NO_ACCESS);
        }

        PPProduction ppProduction = ppProductionRepository.findByid(selectModel.get(0).getFindById());//这个库存里面找出来的
        if(StringUtils.isEmpty(ppProduction)){
            throw new PassportException(ResultCode.DATA_NOEXIST_MSG);
        }

        List<ProductsVo> list = new ArrayList<>();
        List<ProductsVo> list1 = new ArrayList<>();
        for (SelectModel smodel: selectModel) {
            if(StringUtils.isEmpty(smodel.getFindIdOne()) || StringUtils.isEmpty(smodel.getPageNum())){//需要改绕的产物id跟选择的数量
                throw new PassportException(ResultCode.PARAM_MISS_MSG);
            }
            ProductsVo productsVo = iProductionMapper.findProductsVoById(smodel.getFindIdOne(),smodel.getFindById()%10);
            productsVo.setNumbers(smodel.getPageNum());
            productsVo.setGxId(ProductionStateChange.PPPDetour);//工序id
            productsVo.setTotalLength(productsVo.getLengthM().multiply(new BigDecimal(smodel.getPageNum())) );//总长度
            productsVo.setNetWeightgSum(productsVo.getNetWeightg().multiply(new BigDecimal(smodel.getPageNum())));//总净重
            list.add(productsVo);
        }

        PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());//根据产物id查询产物基本信息
        ProductPlan productPlan = productPlanRepository.findByid(ppProduct.getPpId());//生产计划单

        if(productPlan.getRelationNo() == 0){
            jsonObject.put("BasicInfo",iProductionMapper.findMeltingBasicInfoByNoSaleId(ppProduct.getId()));//基本信息：不关联销售订单 根据生产计划单产物id
        }else{
            jsonObject.put("BasicInfo",iProductionMapper.findMeltingBasicInfoById(ppProduct.getId()));//基本信息：关联销售订单 根据生产计划单产物id
        }

        GXScheduling  gxScheduling= iProductionMapper.findGXSchedulingByPPIdAndGXIdAndSfId(ppProduct.getPpId(),ProductionStateChange.PPPDetour,Integer.valueOf(userInfoForToken.getUserId()));//粗拉

        jsonObject.put("OperationInfo",gxScheduling);//操作信息

        PPProduction ppProductionnew = new PPProduction();
        ppProductionnew.setFid(ppProduction.getId());//粗拉的上级id
        ppProductionnew.setGXId(ProductionStateChange.PPPDetour);//改绕
        ppProductionnew.setGxName("改绕");//工序名称
        ppProductionnew.setProductionNumber(ppProduction.getProductionNumber());
        ppProductionnew.setPproductId(ppProduction.getPproductId());//生产计划单产物id
        ppProductionnew.setSuitId(ppProduction.getSuitId());//套模id

        ppProductionnew.setFinishNum(0);
        ppProductionnew.setStaffId(Integer.valueOf(userInfoForToken.getUserId()));
        ppProductionnew.setTeamId(gxScheduling.getTteamId());//班组id
        ppProductionnew.setFrequency(gxScheduling.getFrequency());//班次id

        ppProductionnew.setState(0);
        ppProductionnew.setCreateTime(new Date());
        ppProductionnew.setDeleteNo(0);

        jsonObject.put("PPProductionInfo", ppProductionnew);//熔炼信息

        jsonObject.put("oneListName",ppProductionRepository.findByid(ppProduction.getId()).getGxName());//上班工序名称
        jsonObject.put("oneList",list);//上班产物/待改绕成品
        jsonObject.put("twoList",list1);//本班产物/改绕明细

        jsonObject.put("equipmentXiaLa",mesMapper.findAllEquipmentByXiaLa());//下拉框：设备
        jsonObject.put("staffXiaLa",mesMapper.findStaffAllXiaLa());//下拉框：员工
        jsonObject.put("TeamXiaLa",mesMapper.findAllTTeamByXiaLa());//下拉框：班组
        jsonObject.put("BobbinXiaLa",mesMapper.findAllBobbinByXiaLa());//下拉框：线轴

        return jsonObject;
    }

    /**
     * 生产管理（改绕）- 根据生产管理id查询详情信息
     * 左边的待绕线信息就是选择需要改绕的数据。右边的绕线明细就是本班的信息。
     * @param
     * @throws PassportException
     */
    public JSONObject getPDetourDetailByPPPId(SelectModel selectModel)throws PassportException {
        JSONObject jsonObject = new JSONObject();

        PPProduction ppProduction = ppProductionRepository.findByid(selectModel.getFindById());
        if(StringUtils.isEmpty(ppProduction)){
            throw new PassportException(ResultCode.DATA_NOEXIST_MSG);
        }

        PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());//根据产物id查询产物基本信息
        ProductPlan productPlan = productPlanRepository.findByid(ppProduct.getPpId());//生产计划单

        if(productPlan.getRelationNo() == 0){
            jsonObject.put("BasicInfo",iProductionMapper.findMeltingBasicInfoByNoSaleId(ppProduct.getId()));//基本信息：不关联销售订单 根据生产计划单产物id
        }else{
            jsonObject.put("BasicInfo",iProductionMapper.findMeltingBasicInfoById(ppProduct.getId()));//基本信息：关联销售订单 根据生产计划单产物id
        }
        jsonObject.put("OperationInfo",iProductionMapper.findGXSchedulingByPPIdAndGXIdAndSfId(ppProduct.getPpId(),ppProduction.getGXId(),ppProduction.getStaffId()));//操作信息

        jsonObject.put("PPProductionInfo", ppProduction);//熔炼信息

        jsonObject.put("oneListName",ppProductionRepository.findByid(ppProduction.getFid()).getGxName());//上班工序名称
        jsonObject.put("oneList",iProductionMapper.findDetourProductsVoByPPPId(ppProduction.getId()));//上班产物/待改绕成品
        jsonObject.put("twoList",iProductionMapper.findProductsVoByPPPId(ppProduction.getId(),ppProduction.getId()%10));//本班产物/改绕明细

        jsonObject.put("equipmentXiaLa",mesMapper.findAllEquipmentByXiaLa());//下拉框：设备
        jsonObject.put("staffXiaLa",mesMapper.findStaffAllXiaLa());//下拉框：员工
        jsonObject.put("TeamXiaLa",mesMapper.findAllTTeamByXiaLa());//下拉框：班组
        jsonObject.put("BobbinXiaLa",mesMapper.findAllBobbinByXiaLa());//下拉框：线轴

        return jsonObject;
    }


    /**
     * 生产管理(改绕)- 保存操作-新增/编辑
     *
     * @param1、保存一个新的改绕信息  2、保存当前改绕的待改绕信息
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void savePDetour(UserInfoForToken userInfoForToken,PPProductionModel ppProductionModel)throws PassportException {
        PPProduction ppProduction = ppProductionModel.getPpProduction();//本班的工序
        if (StringUtils.isEmpty(ppProduction.getState()) || StringUtils.isEmpty(ppProduction.getPproductId()) || StringUtils.isEmpty(ppProduction.getSuitId())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        PPProduction ppProduction1 = ppProductionRepository.save(ppProduction);

        if(ppProductionModel.getTwoList().size() == 0 ){//判断待改绕是否存在
            throw new PassportException(ResultCode.DATA_NOEXIST_MSG);
        }

        List<PPPProducts0> products0List = ppProductionModel.getTwoList();
        for (PPPProducts0 pppProducts: products0List) {
            pppProducts.setPPPId(ppProduction1.getId());
            pppProducts.setFid(pppProducts.getId());
        }
        iProductionMapper.insertPDetourroducts(products0List);

        if(ppProduction.getState() == 1){//转下班操作：判断数量是否足够。记录库存状态
            List<ProductsVo> productsVoList =  iProductionMapper.findKuCunProductsVoByPPPId(ppProduction.getFid(),ppProduction.getFid()%10);

            List<InventoryStatus> inventoryStatusList = new ArrayList<>();//成品
            List<InventoryRecord> inventoryRecordList = new ArrayList<>();//库存记录

            PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());//根据产物id查询产物基本信息
            ProductPlan productPlan = productPlanRepository.findByid(ppProduct.getPpId());//生产计划单

            UpdateModel upd = new UpdateModel();
            if(productPlan.getRelationNo() == 0){//不关联销售订单
                upd = iProductionMapper.findBasicInfoByNoSaleId(ppProduct.getId());
            }else{
                upd = iProductionMapper.findBasicInfoById(ppProduct.getId());
            }

//            for (PPPProducts0 pppProducts: ppProductionModel.getTwoList()) {
//                if(StringUtils.isEmpty(pppProducts.getPPPId()) || StringUtils.isEmpty(pppProducts.getNumbers()) || StringUtils.isEmpty(pppProducts.getLengthM())){//需要改绕的产物id跟选择的数量
//                    throw new PassportException(ResultCode.PARAM_MISS_MSG);
//                }
//
//                InventoryStatus inventoryStatus1 = new InventoryStatus();//成品
//                InventoryRecord inventoryRecord1 = new InventoryRecord();//成品
//
//                BigDecimal netWeightgs =new BigDecimal(BigDecimal.valueOf(Double.parseDouble(pppProducts.getNetWeightg().toString())).stripTrailingZeros().toPlainString());//净重
//                Integer netWeightg = Integer.valueOf(netWeightgs.toString());
//                BigDecimal number =new BigDecimal(BigDecimal.valueOf(Double.parseDouble(pppProducts.getNumbers().toString())).stripTrailingZeros().toPlainString());//净重
//                Integer numbers = Integer.valueOf(number.toString());
//
//                inventoryStatus1.setProductId(pppProducts.getId());//产品/原料明细Id/生产id
//                inventoryStatus1.setWarehouseId(1);//仓库Id
//                inventoryStatus1.setInventoryType(2);//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
//                inventoryStatus1.setInventorysum(netWeightg);//废料数量
//                inventoryStatus1.setInventorynumbers(numbers);//数量
//
//                inventoryStatus1.setStockName(upd.getStockName());
//                inventoryStatus1.setStockNumber(upd.getStockNumber());
//                inventoryStatus1.setStockModel(upd.getStockModel());
//                inventoryStatus1.setStandards(upd.getStandards());
//                inventoryStatus1.setUnitId(upd.getUnitId());
//                inventoryStatus1.setPppId(pppid);
//
//                //存入记录:绕线成品
//                inventoryRecord1.setProductDetailid(pppProducts.getId());
//                inventoryRecord1.setRecordType(2);//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购等)
//                inventoryRecord1.setCreateTime(System.currentTimeMillis());
//                inventoryRecord1.setChangequantity("+"+netWeightg);
//                inventoryRecord1.setSurplusquantity(netWeightg);
//                inventoryRecord1.setInventoryType(2);//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他)
//                inventoryRecord1.setRemark("绕线过程产生成品");
//                inventoryRecord1.setWarehouseId(1);
//
//                inventoryRecord1.setStockName(upd.getStockName());
//                inventoryRecord1.setStockNumber(upd.getStockNumber());
//                inventoryRecord1.setStockModel(upd.getStockModel());
//                inventoryRecord1.setStandards(upd.getStandards());
//                inventoryRecord1.setUnitId(upd.getUnitId());
//                inventoryRecord1.setPppId(pppid);
//
//                inventoryStatusList.add(inventoryStatus1);
//                inventoryRecordList.add(inventoryRecord1);
//
//            }
        }
    }


    /**
     * 生产管理（改绕）-新增改绕页面- 根据待改绕查询详情
     *          findById 生产id
     *         findIdOne 生产产物id
     * @throws PassportException
     */
    public JSONObject getPDetourDetailByPPDetourDetailId(SelectModel selectModel)throws PassportException {
        JSONObject jsonObject = new JSONObject();
        if(StringUtils.isEmpty(selectModel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        PPPWindingInfo pppWindingInfo = pppWindingInfoRepository.findByPPPPIdAndPPPId(selectModel.getFindIdOne(),selectModel.getFindById());//根据产物id查询详情

        PPProduction ppProduction = ppProductionRepository.findByid(selectModel.getFindById());

        ProductsVo productsVo = iProductionMapper.findBypppDetourProducts(selectModel.getFindById(),selectModel.getFindIdOne());
        List<ProductsVo> productsVoList = iProductionMapper.findProductsVoByPPPId2(selectModel.getFindById(),selectModel.getFindById()%10);//查询本班产物

        jsonObject.put("pppProducts",productsVo);//待绕线成品参数
        jsonObject.put("PPPWindingInfo",StringUtils.isEmpty(pppWindingInfo) ? new PPPWindingInfo() :pppWindingInfo);//绕线操作的基本数据
        jsonObject.put("TwoList",productsVoList);//绕线操作的基本数据。根据产物id去查询

        jsonObject.put("oneListName",ppProduction.getGxName());//上班工序名称

        jsonObject.put("equipmentXiaLa",mesMapper.findAllEquipmentByXiaLa());//下拉框：设备
        jsonObject.put("staffXiaLa",mesMapper.findStaffAllXiaLa());//下拉框：员工
        jsonObject.put("TeamXiaLa",mesMapper.findAllTTeamByXiaLa());//下拉框：班组
        jsonObject.put("BobbinXiaLa",mesMapper.findAllBobbinByXiaLa());//下拉框：线轴

        jsonObject.put("beforeLength",productsVo.getLengthM().multiply(new BigDecimal(productsVo.getNumbers())));//绕线前总长度
        jsonObject.put("afterLength",productsVoList.stream().map(ProductsVo::getTotalLength).reduce(BigDecimal.ZERO, BigDecimal::add));//绕线后总长度
        jsonObject.put("beforeWeight",productsVo.getNetWeightg().multiply(new BigDecimal(productsVo.getNumbers())));//绕线前总重量
        jsonObject.put("afterWeight",productsVoList.stream().map(ProductsVo::getNetWeightgSum).reduce(BigDecimal.ZERO, BigDecimal::add));//绕线后总重量

        return jsonObject;
    }
}
