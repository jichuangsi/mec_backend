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
import com.jichuangsi.mes.model.PPProductionModel;
import com.jichuangsi.mes.model.SelectModel;
import com.jichuangsi.mes.model.UpdateModel;
import com.jichuangsi.mes.model.UserInfoForToken;
import com.jichuangsi.mes.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class NewProductionService {
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

        // 根据生产计划单id查询领料数据
        job.put("OneList",iNewProductionMapper.findPickingStocksByPPIId(selectModel.getFindById()));//领料信息

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

        // 根据生产计划单id查询领料数据
        job.put("LData",iNewProductionMapper.findAllPPProduction( ProductionStateChange.getGXIdByGXType(selectModel.getFindById()),selectModel.getFindName()));//领料信息

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
    public void saveProcuction(UserInfoForToken userInfoForToken, PPProductionModel ppProductionModel)throws PassportException {
        PPProduction ppProduction = ppProductionModel.getPpProduction();
        if (StringUtils.isEmpty(ppProduction.getPproductId()) ||StringUtils.isEmpty(ppProduction.getProductionNumber())||StringUtils.isEmpty(ppProduction.getGXId())){//此时的ProductionNumber 代表产品型号
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        //获取生产批号
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateNowStr = sdf.format(d);

        Integer productionSize = ppProductionRepository.findByCreateTimeIsBetweenAndGXId(DateUtil.beginOfDay(d),DateUtil.endOfDay(d),ProductionStateChange.PSmelting).size()+1;
        String strnum =dateNowStr+"00"+productionSize+ppProduction.getProductionNumber();
        ppProduction.setProductionNumber(strnum);//避免同时有人在操作。这边直接获取编号。

        Integer inggxid = StringUtils.isEmpty(ppProduction.getId()) ? ProductionStateChange.getGXIdByGXType(ppProduction.getGXId()) :ppProduction.getGXId();//工序id
        ppProduction.setFid(0);
        ppProduction.setDeleteNo(0);
        ppProduction.setStaffId(Integer.valueOf(userInfoForToken.getUserId()));
        ppProduction.setCreateTime(new Date());
        ppProduction.setGxName(dictionarierRepository.findByid(inggxid).getName());//工序名称
        ppProduction.setGXId(inggxid);
        PPProduction ppProduction1 =ppProductionRepository.save(ppProduction);

        Integer pid = ppProduction1.getId();

        productionStockRepository.updateByPPPId(pid);
        List<ProductionStock> productionStockList = ppProductionModel.getOneList();
        for (int i = 0; i < productionStockList.size(); i++) {
            ProductionStock productionStock = productionStockList.get(i);
            if(StringUtils.isEmpty(productionStock.getQuantityChoose()) || StringUtils.isEmpty(productionStock.getInventoryStatusId())){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
                throw new PassportException(ResultCode.PARAM_MISS_MSG);

            }
            productionStock.setPPPId(pid);
            productionStock.setDeleteNo(0);
        }
        productionStockRepository.saveAll(productionStockList);


    }

    /**
     * 【新】-生产管理- 转下班操作(-熔炼)-新增/编辑
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void savesmeltingProductsList(UserInfoForToken userInfoForToken, PPProductionModel ppProductionModel)throws PassportException {


    }
}
