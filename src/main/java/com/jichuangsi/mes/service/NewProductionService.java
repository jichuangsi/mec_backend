package com.jichuangsi.mes.service;


import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.jichuangsi.mes.common.PPStateChange;
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

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NewProductionService {
    @Resource
    private ProductionService productionService;
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
    private ProductionDiaryReportRepository productionDiaryReportRepository;//生产日报汇总表

    /**
     * 【新】-生产管理-熔炼- 新增/编辑页面根据生产计划单id获取生产计划单数据and原材料数据
     * @param
     * @throws PassportException
     */
    public JSONObject getMeltingInfoById(SelectModel selectModel)throws PassportException {
        JSONObject job = new JSONObject();

        if(StringUtils.isEmpty(selectModel.getFindById()) || StringUtils.isEmpty(selectModel.getFindIdOne())|| StringUtils.isEmpty(selectModel.getPageNum())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        PPProduct ppProduct = ppProductRepository.findByid(selectModel.getFindById());//根据产物id查询产物基本信息

        Integer ppid = ppProduct.getPpId();
        ProductPlan productPlan = productPlanRepository.findByid(ppid);//生产计划单

        //基本信息
        if(productPlan.getRelationNo() == 0){//有数据且不关联销售订单的话
            job.put("BasicInfo",iProductionMapper.findMeltingBasicInfoByNoSaleId(selectModel.getFindById()));//基本信息：不关联销售订单 根据生产计划单产物id
        }else{
            job.put("BasicInfo",iProductionMapper.findMeltingBasicInfoById(selectModel.getFindById()));//基本信息：关联销售订单 根据生产计划单产物id
        }

        job.put("ppProduction",new PPProduction());//生产信息

        if(selectModel.getFindIdOne() == ProductionStateChange.Production_Smelting || selectModel.getFindIdOne() == ProductionStateChange.PSmelting){
//            job.put("oneList",iNewProductionMapper.findPickingStocksByPPId(ppid));//熔炼： 领料信息:根据生产计划单id查询领料数据
        }else{
            job.put("oneListName",ppProductionRepository.findByid(selectModel.getPageNum()).getGxName());//上班工序名称
            job.put("oneList",iProductionMapper.findProductsVoByPPPId(selectModel.getPageNum(),selectModel.getPageNum()%10,1));//查询还没有被关联的上班产物
        }

        return job;
    }


    /**
     * 【新】-生产管理-(粗拉、中拉、细拉、超细拉、退火、绕线、改绕等)- 查询生产批号
     * @param
     * @throws PassportException
     */
    public JSONObject getProductionList(SelectModel selectModel)throws PassportException {
        JSONObject job = new JSONObject();

        if(StringUtils.isEmpty(selectModel.getFindById())){//工序id
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        //如果是退火/中间退火
        if(selectModel.getFindById() == ProductionStateChange.Production_IntermediateAnnealing || selectModel.getFindById() == ProductionStateChange.Production_FinishedAnnealing){
            // 根据生产计划单id查询领料数据
            job.put("LData",iNewProductionMapper.findAllPPProductionAnnealing(ProductionStateChange.getGXIdByGXType(selectModel.getFindById()),   selectModel.getFindName(),3));//领料信息
        }else if(selectModel.getFindById() == ProductionStateChange.Production_PPWinding){
            // 根据生产计划单id查询领料数据
            job.put("LData",iNewProductionMapper.findAllPPProductionAnnealing(ProductionStateChange.getGXIdByGXType(selectModel.getFindById()),selectModel.getFindName(),4));//领料信息
        }else{
            // 根据生产计划单id查询领料数据
            job.put("LData",iNewProductionMapper.findAllPPProduction( ProductionStateChange.getGXIdByGXType2(selectModel.getFindById()),ProductionStateChange.getGXIdByGXType(selectModel.getFindById()),   selectModel.getFindName()));//领料信息
        }

        return job;
    }


    /**
     * 【新】-生产管理-熔炼[开始生产]操作-新增/编辑
     *点击【开始生产的时候是0，或者在【草稿】的时候状态也是0】
     * 1、新增一个熔炼信息
     * 2、保存生产原材料信息
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void saveStartProduction(UserInfoForToken userInfoForToken,PPProductionModel ppProductionModel)throws PassportException {
        PPProduction ppProduction =ppProductionModel.getPpProduction();
        if (StringUtils.isEmpty(ppProduction.getPproductId()) || ppProductionModel.getOneList().isEmpty()){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date d = new Date();
        String dateNowStr = sdf.format(d);

        Integer productionSize = ppProductionRepository.findByCreateTimeIsBetweenAndGXId(DateUtil.beginOfDay(d),DateUtil.endOfDay(d),ProductionStateChange.PSmelting).size()+1;
        String strnum = dateNowStr+"00"+productionSize+ppProduction.getProductionNumber();
        ppProduction.setProductionNumber(strnum);//避免同时有人在操作。这边直接获取编号。


        PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());//根据产物id查询产物基本信息

        ProductPlan productPlan = productPlanRepository.findByid(ppProduct.getPpId());//生产计划单
        GXScheduling  gxScheduling= iProductionMapper.findGXSchedulingByPPIdAndGXIdAndSfId(ppProduct.getPpId(),ProductionStateChange.getGXIdByGXType(ProductionStateChange.Production_Smelting),Integer.valueOf(userInfoForToken.getUserId()));//粗拉

        Integer inggxid = ProductionStateChange.PSmelting;//工序id
        ppProduction.setFid(0);
        ppProduction.setDeleteNo(0);
        ppProduction.setState(0);
        ppProduction.setCreateTime(new Date());
        ppProduction.setGxName(dictionarierRepository.findByid(inggxid).getName());//工序名称
        ppProduction.setGXId(inggxid);
        ppProduction.setStaffId(Integer.valueOf(userInfoForToken.getUserId()));//员工id
        ppProduction.setTeamId(gxScheduling.getTteamId());//班组id
        ppProduction.setFrequency(gxScheduling.getFrequency());//班次id
        ppProduction.setSuitId(productPlan.getSuitId());//套模id
        PPProduction ppProduction1 =ppProductionRepository.save(ppProduction);

        Integer pid = ppProduction1.getId();

        List<ProductionStock> productionStockList = ppProductionModel.getOneList();
        for (int i = 0; i < productionStockList.size(); i++) {
            ProductionStock productionStock = productionStockList.get(i);
            if(StringUtils.isEmpty(productionStock.getQuantityChoose()) || StringUtils.isEmpty(productionStock.getInventoryStatusId()) ){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
                throw new PassportException(ResultCode.PARAM_MISS_MSG);

            }
            productionStock.setPPPId(pid);
            productionStock.setDeleteNo(0);
        }
        productionStockRepository.saveAll(productionStockList);

//        iNewProductionMapper.updatePickingStockstateByIds(ppProductionModel.getProductionStockVoList());//根据id把领料的数据状态改为已使用
//
//        List<ProductionStockVo> productionStockVos = ppProductionModel.getProductionStockVoList();
//
//        List<ProductionStock> productionStockList = new ArrayList<>();
//        for (int i = 0; i < productionStockVos.size(); i++) {//新增生产需要的原材料数据
//            ProductionStockVo productionStockVo = productionStockVos.get(i);
//            ProductionStock productionStock = new ProductionStock();
//
//            productionStock.setInventoryStatusId(productionStockVo.getInventoryStatusId());
//            productionStock.setQuantityChoose(productionStockVo.getQuantityChoose());
//            productionStock.setTotalNet(productionStockVo.getTotalNet());
//            productionStock.setDeleteNo(0);
//            productionStock.setPPPId(pid);
//
//            productionStockList.add(productionStock);
//        }
//        productionStockRepository.saveAll(productionStockList);
    }

    /**
     * 【新】-生产管理-粗拉、中拉、细拉、超细拉、退火、绕线、改绕等[开始生产]操作-新增/编辑
     *点击【开始生产的时候是0】
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void saveStartProduction2(UserInfoForToken userInfoForToken,PPProductionModel ppProductionModel)throws PassportException {
        PPProduction ppProduction =ppProductionModel.getPpProduction();
        if (StringUtils.isEmpty(ppProduction.getPproductId()) || StringUtils.isEmpty(ppProduction.getFid()) || StringUtils.isEmpty(ppProduction.getGXId()) || ppProductionModel.getTwoList().isEmpty()){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        PPProduction Fppproduction = ppProductionRepository.findByid(ppProduction.getFid());//查询出上班的信息
        if (StringUtils.isEmpty(Fppproduction) ){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());//根据产物id查询产物基本信息

        Integer newGXid =  ProductionStateChange.getGXIdByGXType(ppProduction.getGXId());
        if(Fppproduction.getState() == 3 && (Fppproduction.getGXId() == ProductionStateChange.Production_PPFinished || Fppproduction.getGXId() == ProductionStateChange.PPPFinished)){//如果是成品阶段，那就是成品退火
            newGXid = ProductionStateChange.PFinishedAnnealing;
        }

        String gxName =dictionarierRepository.findByid(newGXid).getName();
        String countint = ppProductionRepository.countByProductionNumberAndGXIdAndDeleteNo(Fppproduction.getProductionNumber(),newGXid,0).toString();
        countint =countint.equals("0") ? "" :countint;
        gxName = gxName+ countint;//如果是重复当前工序。就查询当前生产id的当前工序有多少个

        GXScheduling  gxScheduling= iProductionMapper.findGXSchedulingByPPIdAndGXIdAndSfId(ppProduct.getPpId(),newGXid,Integer.valueOf(userInfoForToken.getUserId()));//粗拉

        ppProduction.setGXId(newGXid);//粗拉
        ppProduction.setGxName(gxName);//工序名称
        ppProduction.setProductionNumber(Fppproduction.getProductionNumber());
        ppProduction.setSuitId(Fppproduction.getSuitId());//套模id

        ppProduction.setFinishNum(0);
        ppProduction.setStaffId(Integer.valueOf(userInfoForToken.getUserId()));
        ppProduction.setTeamId(gxScheduling.getTteamId());//班组id
        ppProduction.setFrequency(gxScheduling.getFrequency());//班次id

        ppProduction.setState(0);
        ppProduction.setCreateTime(new Date());
        ppProduction.setDeleteNo(0);

        PPProduction ppProduction1 =   ppProductionRepository.save(ppProduction);

        Integer pid = ppProduction1.getId();

        iProductionMapper.UpdatePPPProductsLPPPIdByPPPId(ppProduction1.getFid()%10,pid,ppProductionModel.getTwoList());//绑定本次生产的上班产物

    }

}
