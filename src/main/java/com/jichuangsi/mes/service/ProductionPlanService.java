package com.jichuangsi.mes.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.jichuangsi.mes.common.OrderStateChange;
import com.jichuangsi.mes.common.PPStateChange;
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
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductionPlanService {

    @Resource
    private IMesMapper mesMapper;

    @Resource
    private SDictionarierRepository sdRepository;
    @Resource
    private ProductPlanRepository productPlanRepository;
    @Resource
    private PPOutputStatisticsRepository ppOutputStatisticsRepository;
    @Resource
    private PPSchedulingRepository ppSchedulingRepository;
    @Resource
    private PPProductRepository ppProductRepository;
    @Resource
    private CustomerDetailRepository customerDetailRepository;
    @Resource
    private PPAuditPocessRepository ppAuditPocessRepository;
    @Resource
    private PPOrderAuditPocessRepository ppOrderAuditPocessRepository;
    @Resource
    private AuditSettingRepository auditSettingRepository;
    @Resource
    private MattersRepository mattersRepository;


    /**
     * 生产计划单- 新增/编辑页面获取下拉框数据
     * @param
     * @throws PassportException
     */
    public JSONObject getPPBasicInfo(SelectModel selectModel)throws PassportException {
        JSONObject job = new JSONObject();

        String strnum ="100000000"+productPlanRepository.count()+1;
        job.put("productPlanNum",strnum);//生产计划单编号

        job.put("SuitXiaLa",mesMapper.findAllSuitByXiaLa());//查询套模下拉框
        job.put("GX",sdRepository.findByDicCode("GX"));//查询工序
        job.put("TeamXiaLa",mesMapper.findAllTTeamByXiaLa());//查询班组下拉框

        if(!StringUtils.isEmpty(selectModel.getFindById())){
            SaleVo saleVo = mesMapper.findSaleDetailByPPId(selectModel.getFindById());//销售订单id
            //绑定状态
            Map<String,String> map =  OrderStateChange.getSaleOrderState(saleVo.getOrderStateId());
            saleVo.setOrderStates(map.get("orderstate"));

            job.put("saleorder",saleVo);//关联销售订单信息
            job.put("customerDetail",StringUtils.isEmpty(saleVo)? "":  customerDetailRepository.findAllByCustomerId(saleVo.getCustomerId()));//客户信息
        }
        return job;
    }

    /**
     * 生产计划单- 新增/编辑页面-设置产物-获取生产数据
     * @param
     * @throws PassportException
     */
    public JSONObject getPPProductInfo(SelectModel selectModel)throws PassportException {
        JSONObject job = new JSONObject();

        if(StringUtils.isEmpty(selectModel.getIswhether())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        if(selectModel.getIswhether() == 1){
            List<MapVo> listvo = mesMapper.findAllSaleByPP(selectModel.getFindName());
            job.put("LData",listvo.size() == 0 ? "":listvo);//左边的销售订单list
            job.put("RData",listvo.size() == 0 ? "": mesMapper.findSaleDetailById(listvo.get(0).getMapKey()));//右边的销售订单明细

        }else{
            List<MapVo> listvo = mesMapper.findAllProductByXiaLa(selectModel.getFindName());
            job.put("LData",listvo.size() == 0 ? "":listvo);//左边的产品list
            job.put("RData",listvo.size() == 0 ? "":mesMapper.findAllProductDetailByIdXiaLa(listvo.get(0).getMapKey()));//右边的产品明细
        }

        return job;
    }

    /**
     * 生产计划单- 新增/编辑页面-设置产物-根据销售订单id/产品id查询明细
     * @param
     * @throws PassportException
     */
    public JSONObject getPPProductInfoById(SelectModel selectModel)throws PassportException {
        JSONObject job = new JSONObject();

        if(StringUtils.isEmpty(selectModel.getIswhether()) || StringUtils.isEmpty(selectModel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        if (selectModel.getIswhether() == 1){
            job.put("RData",mesMapper.findSaleDetailById(selectModel.getFindById()));//右边的销售订单明细
        }else{
            job.put("RData",mesMapper.findAllProductDetailByIdXiaLa(selectModel.getFindById()));//右边的产品明细
        }

        return job;
    }



    /**
     * 生产计划单- 新增/编辑
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void saveProductPlan(UserInfoForToken userInfoForToken,ProductPlanModel productPlanModel)throws PassportException {
        ProductPlan productPlan = productPlanModel.getProductPlan();
        if (StringUtil.isEmpty(productPlan.getPpName()) || StringUtils.isEmpty(productPlan.getRelationNo())|| StringUtils.isEmpty(productPlan.getPpPlanState())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        if(StringUtils.isEmpty(productPlan.getId())){//判断是否已经有提交过
            String strnum ="100000000"+productPlanRepository.count()+1;
            productPlan.setPpNumber(strnum);//避免同时有人在操作。这边直接获取编号。

        }
        productPlan.setDeleteNo(0);
        ProductPlan productPlan1 =productPlanRepository.save(productPlan);

        Integer pid = productPlan1.getId();

        List<PPScheduling> ppSchedulingList = productPlanModel.getPpSchedulingList();
        for (int i = 0; i < ppSchedulingList.size(); i++) {
            PPScheduling ppScheduling = ppSchedulingList.get(i);
            if(StringUtils.isEmpty(ppScheduling.getGxId()) || StringUtils.isEmpty(ppScheduling.getTteamId())){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
                throw new PassportException(ResultCode.PARAM_MISS_MSG);

            }
            ppScheduling.setPpId(pid);
        }
        ppSchedulingRepository.saveAll(ppSchedulingList);

        List<PPProduct> ppProductList = productPlanModel.getPpProductList();
        for (int i = 0; i < ppProductList.size(); i++) {
            PPProduct ppProduct = ppProductList.get(i);
            if(StringUtils.isEmpty(ppProduct.getProductDetailId()) || StringUtils.isEmpty(ppProduct.getLength()) || StringUtils.isEmpty(ppProduct.getQuantum())){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
                throw new PassportException(ResultCode.PARAM_MISS_MSG);

            }
            ppProduct.setPpId(pid);
            ppProduct.setDeleteNo(0);
        }
        ppProductRepository.saveAll(ppProductList);

        PPOutputStatistics outputStatistics =  ppOutputStatisticsRepository.findByPpId(pid);
        if(StringUtils.isEmpty(outputStatistics)){
            //新增产量统计
            PPOutputStatistics ppOutputStatistics = new PPOutputStatistics();
            ppOutputStatistics.setPpId(pid);
            ppOutputStatistics.setWireCompleteNum(0);
            ppOutputStatistics.setWireNoCompleteNum(0);
            ppOutputStatistics.setAnnealingCompleteNum(0);
            ppOutputStatistics.setAnnealingNoCompleteNum(0);
            ppOutputStatistics.setWindingCompleteNum(0);
            ppOutputStatistics.setWindingNoCompleteNum(0);
            ppOutputStatistics.setCheckNum(0);
            ppOutputStatistics.setCheckQualifiedNum(0);
            ppOutputStatistics.setCheckNoQualifiedNum(0);
            ppOutputStatisticsRepository.save(ppOutputStatistics);


            mesMapper.insertPPOrderPocess(pid,"PP");//保存订单的时候就把需要审核的流程保存起来

            Matters matters = new Matters();
            matters.setMatterNews("您有1个报修单待处理");
            matters.setStaffId(auditSettingRepository.getstaffIdByauditTypeandLevel("PP","1"));
            matters.setOrderId(pid);
            matters.setDeleteNo(0);
            mattersRepository.save(matters);//新增待办事项

            PPAuditPocess auditPocess = new PPAuditPocess();
            auditPocess.setAuditOrderId(pid);
            auditPocess.setAuditSetting(PPStateChange.getPPState(productPlan.getPpPlanState()));
            auditPocess.setAuditSettingId(0);
            auditPocess.setRemark("创建计划单");
            auditPocess.setStaffId(Integer.valueOf(userInfoForToken.getUserId()));
            auditPocess.setDeleteNo(0);
            auditPocess.setCreateTime(new Date());
            ppAuditPocessRepository.save(auditPocess);//新增生产计划单-审核流程
        }
    }

    /**
     * 生产计划单-查询
     * @param
     * @throws PassportException
     */
    public PageInfo getAllProductPlan(SelectModel smodel)throws PassportException{
        PageInfo page=new PageInfo();

        String beginTime = null;
        String endTime = null;
        if(!StringUtils.isEmpty(smodel.getFindDate())){
            beginTime = smodel.getFindDate() +"00:00:00";
            endTime = smodel.getFindDate() +"23:59:59";
        }

       List<PPVo>  ppVoList=mesMapper.findAllProductPlan(smodel.getFindName(),beginTime,endTime,(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());

        page.setList(ppVoList);
        page.setTotal(mesMapper.countByAllProductPlan(smodel.getFindName(),beginTime,endTime));

        page.setPageSize(smodel.getPageSize());
        page.setPageNum(smodel.getPageNum());
        return page;
    }

    /**
     * 生产计划单-修改状态(state or  delete_no)
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateProductPlanByid(UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) ||StringUtils.isEmpty(model.getUpdateType())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        ProductPlan productPlan=  productPlanRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(productPlan)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}


        productPlan.setDeleteNo(productPlan.getDeleteNo() == 0 ? 1 :0);
        productPlanRepository.save(productPlan);
    }

    /**
     * 生产计划单-根据生产计划单id查询详情
     * @param
     * @throws PassportException
     */
    public JSONObject getProductPlanById(SelectModel smodel)throws PassportException{
        JSONObject jsonObject=new JSONObject();

        if(StringUtils.isEmpty(smodel.getFindById()) || StringUtils.isEmpty(smodel.getFindModelName())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        Integer ppid = smodel.getFindById();

        ProductPlan productPlan = productPlanRepository.findByid(ppid);
        jsonObject.put("pp",productPlan);//基本信息
        jsonObject.put("pp_scheduling",mesMapper.findPPGXSchedulingByPPId(ppid));//班组和班次信息
        jsonObject.put("ppproduct",mesMapper.findNOSalePProductByPPId(ppid));//计划产物-产品

        if(productPlan.getRelationNo() == 1 && !StringUtils.isEmpty(productPlan.getSaleId())){//如果关联了销售订单

            SaleVo saleVo = mesMapper.findSaleDetailByPPId(productPlan.getSaleId());
            jsonObject.put("saleorder",saleVo);//关联销售订单信息
            jsonObject.put("customerDetail",customerDetailRepository.findAllByCustomerId(saleVo.getCustomerId()));//客户信息

            jsonObject.put("ppproduct",mesMapper.findSalePProductByPPId(ppid));//计划产物-销售订单的产品
        }
        jsonObject.put("auditDetail",mesMapper.findPPAuditListById(smodel.getFindById()));//加上审核详情

        if(smodel.getFindModelName().equals("S")){
            jsonObject.put("OutputStatistics",ppOutputStatisticsRepository.findByPpId(smodel.getFindById()));//产量统计

            List<TSuitdetailVo> tSuitdetailVoList = mesMapper.findTSuitDetailById(productPlan.getSuitId());
            for (TSuitdetailVo tSuitdetailVo:  tSuitdetailVoList) {
                tSuitdetailVo.setSonmouldModel(StringUtils.isEmpty(tSuitdetailVo.getMouldDetailId()) ? "" :mesMapper.findTmodelDetailByIds(tSuitdetailVo.getMouldDetailId()));
            }
            jsonObject.put("suitDetail",tSuitdetailVoList);//套模方案
        }
        return jsonObject;
    }


    /**
     * 当前订单状态Id
     * @param orderStateId 订单状态Id
     * @return
     */
    public Map<String,String> showPPOrderState(Integer orderStateId,Integer orderId)throws PassportException{
        Map<String,String> map = new HashMap<>();
        Integer getint = 0;
        String str = "";
        Integer id = 0;

        switch (orderStateId){
            case 1:
            case 2://审核中
                getint = 2;

                List<PPOrderAuditPocess> oldauditCG = ppOrderAuditPocessRepository.findByOrderId(orderId);
                if(!StringUtils.isEmpty(oldauditCG)){
                    Integer oldstaffid = oldauditCG.get(0).getStaffId();
                    str = oldauditCG.get(0).getLevelName();//获取层级名称
                    id = oldauditCG.get(0).getId();//获取审核流程的单子Id
                    Matters oldmatters = new Matters();
                    oldmatters.setOrderId(orderId);
                    oldmatters.setStaffId(oldstaffid);
                    oldmatters.setFinishedNo(1);
                    mattersRepository.save(oldmatters);

                    //修改订单审核流程完成度
                    ppOrderAuditPocessRepository.updateByOrderIdAndStaffId(orderId,oldstaffid);
                }
                if(oldauditCG.size() >1){
                    Integer countId = oldauditCG.get(1).getStaffId() ;

                    if(!StringUtil.isEmpty(countId.toString()) && countId > 0){//如果有进程。则进入到下一个阶段。并且修改上一个人的完成状态
                        Matters matters = new Matters();
                        matters.setMatterNews("您有1个生产计划单待审核");
                        matters.setStaffId(countId);// 获取下一个阶段需要审核的员工Id
                        matters.setOrderId(orderId);
                        matters.setDeleteNo(0);
                        matters.setFinishedNo(0);
                        mattersRepository.save(matters);//新增待办事项
                    }else{
                        getint = 3;
                    }
                }else{
                    getint = 3;
                }
                break;
            case 3:

                break;
            default:
                getint = 0;
                break;
        }
        map.put("getint",getint.toString());
        map.put("levelName",str);
        map.put("id",id.toString());
        return  map;
    }


    /**
     * 生产计划单-审核详情修改订单状态(审核流程点击的通过/驳回)
     * 任何一个审核不通过都是返回到未提交状态   0未提交 1待审核 2审核中 3已通过
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updatePPStateByid(UserInfoForToken userInfoForToken, UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) || StringUtils.isEmpty(model.getUpdateRemark())|| StringUtils.isEmpty(model.getUpdateType())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        ProductPlan productPlan = productPlanRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(productPlan)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        if(productPlan.getPpPlanState() == PPStateChange.PP_OrderAudit_Audited){
            throw new PassportException(ResultCode.NO_ACCESS);
        }

        String levelName = "";
        Integer newstateId = 0;
        Integer orderAuditPocessId = 0 ;//获取审核流程的单子Id

        Map<String,String> map = showPPOrderState(productPlan.getPpPlanState(),model.getUpdateID());
        levelName =map.get("levelName");

        switch (model.getUpdateType()){
            case "T"://通过审核
                newstateId =Integer.valueOf(map.get("getint"));//获取一个新的订单状态Id
                orderAuditPocessId =Integer.valueOf(map.get("id"));
                newstateId = newstateId> 0 ? newstateId:productPlan.getPpPlanState();
                break;
            case "F"://不通过
                //修改订单审核流程完成度
                ppOrderAuditPocessRepository.updateByOrderId(model.getUpdateID());
                newstateId = PPStateChange.PP_Audit_NotAudit;//返回到未审核状态

                levelName ="在-----"+levelName+ "------中被驳回";
                break;
            default:
                throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        PPAuditPocess auditPocess = new PPAuditPocess();
        auditPocess.setAuditOrderId(model.getUpdateID());//审核单子ID
        auditPocess.setAuditSettingId(orderAuditPocessId);//处理的单子Id
        auditPocess.setAuditSetting(levelName);
        auditPocess.setRemark(model.getUpdateRemark());
        auditPocess.setStaffId(Integer.valueOf(userInfoForToken.getUserId()));
        auditPocess.setDeleteNo(0);
        auditPocess.setCreateTime(new Date());
        ppAuditPocessRepository.save(auditPocess);//新增审核流程

        productPlan.setPpPlanState(newstateId);
        productPlanRepository.save(productPlan);
    }
}
