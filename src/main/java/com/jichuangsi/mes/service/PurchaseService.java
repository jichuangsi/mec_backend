package com.jichuangsi.mes.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.jichuangsi.mes.common.OrderStateChange;
import com.jichuangsi.mes.constant.InventoryRecordReturnCode;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PurchaseService {


    @Resource
    private IMesMapper mesMapper;


    @Resource
    private TPurchaseRepository tpurchaseRepository;
    @Resource
    private TPurchasedetailRepository tpurchasedetailRepository;
    @Resource
    private SCustomerRepository scustomerRepository;
    @Resource
    private UserRepository userRepository;
    @Resource
    private SDictionarierRepository sdictionarierRepository;
    @Resource
    private TWarehouseRepository twarehouseRepository;
    @Resource
    private SDictionarierRepository sdRepository;
    @Resource
    private AuditSettingRepository auditSettingRepository;
    @Resource
    private MattersRepository mattersRepository;
    @Resource
    private AuditPocessRepository auditPocessRepository;
    @Resource
    private OrderAuditPocessRepository orderAuditPocessRepository;

    @Resource
    private InventoryStatusRepository inventoryStatusRepository;
    @Resource
    private InventoryRecordRepository inventoryRecordRepository;

    /**
     * 采购订单管理- 新增/编辑页面获取下拉框数据
     * @param
     * @throws PassportException
     */
    public JSONObject getPurchaseBasicInfo()throws PassportException {
        JSONObject job = new JSONObject();

        long tpNum =tpurchaseRepository.count()+1;
        String strnum = "CG-000"+tpNum;

        job.put("pruchaseNum",strnum);//采购订单
        job.put("customerXiaLa",mesMapper.findClientAllXiaLa(0));//供应商
        job.put("userXiaLa",mesMapper.findStaffAllXiaLa());//负责人
        job.put("purchaseType",sdictionarierRepository.findByDicCode("CGType"));//采购类型
        job.put("warehouse",mesMapper.findAllWarehouseByXiaLa());//仓库
        job.put("payType",sdictionarierRepository.findByDicCode("PT"));//付款方式
        job.put("orderState","待审核");//订单状态
        job.put("checkState","未检验");//检验状态

        return job;
    }

    /**
     * 采购订单管理- 明细页面--新增/编辑页面获取下拉框数据
     * @param
     * @throws PassportException
     */
    public JSONObject getPurchaseDetailBasicInfo()throws PassportException {
        JSONObject job = new JSONObject();

        job.put("stockXiaLa",mesMapper.findAllStockByXiaLa());//原材料下拉框
        job.put("DW",sdictionarierRepository.findByDicCode("DW"));//单位

        return job;
    }

    /**
     * 采购订单管理- 明细页面--联动下拉框：根据原材料Id查询规格明细下拉框
     * @param
     * @throws PassportException
     */
    public JSONObject getPurchaseDetailById(SelectModel smodel)throws PassportException {
        JSONObject job = new JSONObject();

        job.put("stockDetailXiaLa",mesMapper.findAllStockDetailByIdXiaLa(smodel.getFindById(),null));//原材料下拉框

        return job;
    }

    /**
     * 采购订单管理- 新增/编辑
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void savePurchase(UserInfoForToken userInfoForToken,OrderModel orderModel)throws PassportException {
        TPurchase tPurchase = orderModel.gettPurchase();
        if (StringUtil.isEmpty(tPurchase.getPurchaseOrder())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        if(StringUtils.isEmpty(tPurchase.getOrderState()) || tPurchase.getOrderState() > 1){
            throw new PassportException(ResultCode.PARAM_ERR_MSG);
        }

        long t4=System.currentTimeMillis();

        if(StringUtils.isEmpty(tPurchase.getId())){
            long tpNum =tpurchaseRepository.count()+1;
            String strnum = "CG-000"+tpNum;
            tPurchase.setPurchaseOrder(strnum);//防止有多人在提交订单
        }

        TPurchase tPurchase1 = tpurchaseRepository.save(tPurchase);
        Integer pid = tPurchase1.getId();

        tpurchasedetailRepository.updatepurchasedetailByOrderId(pid);
        List<TPurchasedetail> listpur = orderModel.gettPurchaseDetails();
        for (int i = 0; i < listpur.size(); i++) {
            TPurchasedetail tPurchaseDetails = listpur.get(i);
            if(StringUtils.isEmpty(listpur.get(i).getStockAmount()) || StringUtils.isEmpty(listpur.get(i).getStockUnitPrice())){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
                throw new PassportException(ResultCode.PARAM_MISS_MSG);
            }
            tPurchaseDetails.setDeleteNo(0);
            tPurchaseDetails.setPurchaseId(pid);
        }
        tpurchasedetailRepository.saveAll(orderModel.gettPurchaseDetails());

        if(tPurchase.getOrderState() == 1){//如果是提交的话就要发送一条待办事项
           Integer countOrderAudit =  orderAuditPocessRepository.findByAuditTypeTwoAndOrderId("CG","LL",tPurchase.getId());
           if (StringUtils.isEmpty(countOrderAudit) || countOrderAudit == 0){
               mesMapper.insertOrderPocess(tPurchase.getId(),t4,"CG","LL");//保存订单的时候就把需要审核的流程保存起来
           }

            Matters matters = new Matters();
            matters.setMatterNews("您有1个采购订单待审核");
            matters.setStaffId(auditSettingRepository.getstaffIdByauditTypeandLevel("CG","1"));
            matters.setOrderId(tPurchase.getId());
            matters.setType(1);//进程类型（1 采购-订单审核  2 采购-来料检验）
            matters.setFinishedNo(0);//完成否
            matters.setReadNo(0);//阅读否
            matters.setDeleteNo(0);
            mattersRepository.save(matters);//新增待办事项

            AuditPocess auditPocess = new AuditPocess();
            auditPocess.setAuditOrderId(tPurchase.getId());
            auditPocess.setAuditType("CG");
            auditPocess.setAuditSetting("创建采购订单");
            auditPocess.setAuditSettingId(0);
            auditPocess.setRemark(tPurchase.getRemark());
            auditPocess.setAuditStaffId(Integer.valueOf(userInfoForToken.getUserId()));//员工id
            auditPocess.setDeleteNo(0);
            auditPocessRepository.save(auditPocess);//新增审核流程
        }
    }


    /**
     * 采购订单管理-查询
     * @param
     * @throws PassportException
     */
    public PageInfo getAllPurchase(SelectModel smodel)throws PassportException{
        PageInfo page=new PageInfo();

        List<PurchaseModel> listPurchase = mesMapper.findAllPurchase(smodel.getFindName(),(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());
        for (PurchaseModel modes: listPurchase) {
            Map<String,String> map =  OrderStateChange.getOrderState(modes.getOrderStateId());
            modes.setCheckState(map.get("checkState"));
            modes.setOrderState(map.get("orderstate"));
        }
        page.setList(listPurchase);
        page.setTotal(mesMapper.countByPurchase(smodel.getFindName()));

        page.setPageSize(smodel.getPageSize());
        page.setPageNum(smodel.getPageNum());
        return page;
    }

    /**
     * 采购订单管理-根据Id查询订单详情
     * 判断该采购单的审核阶段是否跟该员工符合，如果符合修改状态显示已读
     * @param
     * @throws PassportException
     */
    public JSONObject getPurchaseById(UserInfoForToken userInfoForToken,SelectModel smodel)throws PassportException{
        JSONObject jsonObject=new JSONObject();
        if(StringUtils.isEmpty(smodel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        TPurchase purchase=  tpurchaseRepository.findByid(smodel.getFindById());

        if (StringUtils.isEmpty(purchase)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        updateMatterReadNo(Integer.valueOf(userInfoForToken.getUserId()),purchase.getOrderState(),purchase.getId());//修改状态

        Map<String,String> map =  OrderStateChange.getOrderState(purchase.getOrderState());

        List<TPurchasedetailModel> listdetail = mesMapper.findAllPurchaseById(smodel.getFindById());//用list把查询的明细装起来
        BigDecimal total = listdetail.stream().map(TPurchasedetailModel->TPurchasedetailModel.getStockSum()).reduce(BigDecimal.ZERO,BigDecimal::add);//统计list明细里面的金额总数

        jsonObject.put("purchase",purchase);
        jsonObject.put("purchase_checkState",map.get("checkState"));
        jsonObject.put("purchase_orderstate",map.get("orderstate"));
        jsonObject.put("purchaseDetail",listdetail);
        jsonObject.put("detailSize",listdetail.size());
        jsonObject.put("sumMoney",total);

        jsonObject.put("auditDetail",mesMapper.findAuditListById(smodel.getFindById(),"CG","LL"));//加上审核详情 auditPocessRepository.findByAuditOrderId(smodel.getFindById())
        return jsonObject;
    }

    /**
     * 待办事项-修改状态（已读否）
     * @throws PassportException
     */
    public void updateMatterReadNo(Integer staffId,Integer orderState, Integer orderId)throws PassportException {

        String str = "";
        Integer type = 0;
        if(orderState ==  OrderStateChange.Purchase_OrderAudit_NotAudit ||orderState ==  OrderStateChange.Purchase_OrderAudit_AuditING){
            str ="CG";
            type = 1;

        }else if(orderState ==  OrderStateChange.Purchase_OrderCheckout_Checking ||orderState ==  OrderStateChange.Purchase_OrderCheckout_NotCheck){
            str ="LL";
            type = 2;
        }

        List<OrderAuditPocess> oldaudit = orderAuditPocessRepository.findByAuditTypeAndOrderId(str,orderId);

        if(oldaudit.size() != 0 &&  staffId == oldaudit.get(0).getStaffId()){//对比两个操作的员工是否相同
            mattersRepository.updateReadNoByStaffIdAndTypeAndOrderId(staffId,type,orderId);
        }

    }

    /**
     * 采购订单管理-修改状态 （delete_no状态）
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updatePurchaseByid(UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) ||StringUtils.isEmpty(model.getUpdateType())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        TPurchase purchase = tpurchaseRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(purchase)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        purchase.setDeleteNo(purchase.getDeleteNo() == 0 ? 1 :0);
        tpurchaseRepository.save(purchase);

    }

    /**
     * 当前订单状态Id
     * @param orderStateId 订单状态Id
     * @return
     */
    public Map<String,String> showOrderState(Integer orderStateId,Integer orderId,Integer currentStaffId)throws PassportException {
        Map<String,String> map = new HashMap<>();
        Integer getint = 0;
        String str = "";
        String strAuditType = "";//审核类型
        Integer id = 0;

        String matterNew = "";//待办事项文字
        Integer newStaffId = 0;//待办事项下个staffId
        Integer mattertype = 0;//待办事项类型
        switch (orderStateId){
            case 0://草稿-未审核
                getint = 1;
                break;
            case 1://订单审核-未审核
            case 2://订单审核-审核中
                getint = 2;
                strAuditType = "CG";

                mattertype = 1;
                List<OrderAuditPocess> oldauditCG = orderAuditPocessRepository.findByAuditTypeAndOrderId("CG",orderId);

                if(oldauditCG.size() != 0){
                    Integer oldstaffid = oldauditCG.get(0).getStaffId();

                    if(currentStaffId != oldstaffid){//对比两个操作的员工是否相同
                        throw new PassportException(ResultCode.NO_ACCESS);
                    }

                    str = oldauditCG.get(0).getLevelName();//获取层级名称
                    id = oldauditCG.get(0).getId();//获取处理的单子Id

                    //修改待办事项
                    mattersRepository.updateByStaffIdAndTypeAndOrderId(oldstaffid,1,orderId);

                    //修改订单审核流程完成度
                    orderAuditPocessRepository.updateByAuditTypeAndOrderIdandAndStaffId("CG",orderId,oldstaffid);
                }

                if(oldauditCG.size() >1){
                    Integer countId = oldauditCG.get(1).getStaffId() ;

                    if(!StringUtil.isEmpty(countId.toString()) && countId > 0){//如果有进程。则进入到下一个阶段。并且修改上一个人的完成状态
                        newStaffId = countId;
                        matterNew = "您有1个采购订单待审核";
                    }else{
                        newStaffId = orderAuditPocessRepository.findByAuditTypeAndOrderId("LL",orderId).get(0).getStaffId();
                        matterNew = "您有1个采购来料订单待审核";
                        mattertype = 2;//待办事项类型来料检验

                        getint = 3;
                    }
                }else{
                    newStaffId = orderAuditPocessRepository.findByAuditTypeAndOrderId("LL",orderId).get(0).getStaffId();
                    matterNew = "您有1个采购来料订单待审核";
                    mattertype = 2;//待办事项类型来料检验类型2

                    getint = 3;
                }
                break;
            case 3://来料检验-待检验
            case 4://来料检验-检验中
                getint = 4;
                strAuditType = "LL";

                mattertype = 2;//待办事项类型
                List<OrderAuditPocess> oldauditLL = orderAuditPocessRepository.findByAuditTypeAndOrderId("LL",orderId);
                if(oldauditLL.size() != 0){
                    Integer oldLLstaffid = oldauditLL.get(0).getStaffId();

                    if(currentStaffId != oldLLstaffid){//对比两个操作的员工是否相同
                        throw new PassportException(ResultCode.NO_ACCESS);
                    }

                    str = oldauditLL.get(0).getLevelName();//获取层级名称
                    id = oldauditLL.get(0).getId();//获取处理的单子Id

                    //修改待办事项
                    mattersRepository.updateByStaffIdAndTypeAndOrderId(oldLLstaffid,2,orderId);

                    //修改订单审核流程完成度
                    orderAuditPocessRepository.updateByAuditTypeAndOrderIdandAndStaffId("LL",orderId,oldLLstaffid);
                }


                if(oldauditLL.size() > 1){
                    Integer staffId =oldauditLL.get(1).getStaffId();
                    if(!StringUtils.isEmpty(staffId) && staffId > 0){//如果有进程。则进入到下一个阶段。并且修改上一个人的完成状态
                        newStaffId = staffId;
                        matterNew = "您有1个采购来料订单待审核";
                    }else{
                        newStaffId = currentStaffId;
                        matterNew = "您有1个采购检验已通过-请前往确认";

                        getint =5;//检验已通过——待确认
                    }
                }else{
                    newStaffId = currentStaffId;
                    matterNew = "您有1个采购检验已通过-请前往确认";

                    getint =5;//检验已通过——待确认
                }

                break;
            default:
                throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        map.put("getint",getint.toString());//订单类型Id
        map.put("levelName",str);//获取层级名称
        map.put("id",id.toString());//获取处理的单子Id
        map.put("auditType",strAuditType);//获取审核的类型

        if(!StringUtils.isEmpty(matterNew)){
            Matters matters = new Matters();
            matters.setMatterNews(matterNew);
            matters.setStaffId(newStaffId);// 获取下一个阶段需要审核的员工Id
            matters.setOrderId(orderId);
            matters.setDeleteNo(0);
            matters.setFinishedNo(0);
            matters.setReadNo(0);
            matters.setType(mattertype);
            mattersRepository.save(matters);//新增待办事项
        }

        return  map;

    }

    /**
     * 采购订单管理-修改订单状态(审核流程点击的通过/驳回)
     * //先判断当前操作人员是否有权利操作该审核
     * 订单审核：任何一个审核不通过都是返回到未提交状态
     * 来料审核：任何一个审核不通过都是退回状态
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updatePurchaseOrderAuditByid(UserInfoForToken userInfoForToken, UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) || StringUtils.isEmpty(model.getUpdateRemark())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        TPurchase purchase = tpurchaseRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(purchase)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        String levelName = "";
        String strauditType = "";
        Integer newstateId = 0;
        Integer orderAuditPocessId = 0 ;//获取审核流程的单子Id


        Map<String,String> map = showOrderState(purchase.getOrderState(),model.getUpdateID(),Integer.valueOf(userInfoForToken.getUserId()));
        levelName =map.get("levelName");
        switch (model.getUpdateType()){
            case "T"://通过审核
                newstateId =Integer.valueOf(map.get("getint"));//获取一个新的订单状态Id
                strauditType =map.get("auditType");
                orderAuditPocessId =Integer.valueOf(map.get("id"));
                newstateId = newstateId> 0 ? newstateId:purchase.getOrderState();
                break;
            case "F"://不通过
                if(purchase.getOrderState() == OrderStateChange.Purchase_OrderAudit_AuditING){//订单审核-审核中
                    //修改订单审核流程完成度
                    orderAuditPocessRepository.updateByAuditTypeAndOrderId("CG",model.getUpdateID());
                    newstateId =OrderStateChange.Purchase_OrderAudit_draft;//返回到草稿状态
                    strauditType = "CG";
                }else if(purchase.getOrderState() == OrderStateChange.Purchase_OrderCheckout_Checking){//来料检验-检验中
                    newstateId = OrderStateChange.Purchase_OrderAudit_Returning_AuditIng;
                    strauditType="LL";
                }

                levelName ="在-----"+levelName+ "------中被驳回";
                break;
            default:
                throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        AuditPocess auditPocess = new AuditPocess();
        auditPocess.setAuditOrderId(model.getUpdateID());//审核单子ID
        auditPocess.setAuditSettingId(orderAuditPocessId);//处理的单子Id
        auditPocess.setAuditType(strauditType);
        auditPocess.setAuditSetting(OrderStateChange.getOrderState(purchase.getOrderState()).get("orderstate") +"("+ levelName+")");
        auditPocess.setRemark(model.getUpdateRemark());
        auditPocess.setDeleteNo(0);
        auditPocess.setAuditStaffId(Integer.valueOf(userInfoForToken.getUserId()));//员工id
        auditPocessRepository.save(auditPocess);//新增审核流程

        purchase.setOrderState(newstateId);
        tpurchaseRepository.save(purchase);
    }

    /**
     * 采购订单管理-修改订单状态 （订单撤回，结束采购，采购退回，结束退回等）
     * 撤回:强行中止订单,返回提交流程（草稿状态）
     * 结束采购：就是点击后状态变为已完成；
     * 采购退回:到退回审核流程
     * 结束退回：
     *
     * 采购订单流程图：采购开单-采购订单审核-订单审核通过了之后订单状态变为待检验-订单检验通过之后订单状态再变成-待入库-已入库-订单已完成-（采购退回）-已退回（入库）
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateOrderStateByid(UserInfoForToken userInfoForToken,UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) || StringUtils.isEmpty(model.getUpdateRemark())|| StringUtils.isEmpty(model.getUpdateType())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        TPurchase tPurchase = tpurchaseRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(tPurchase)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        Integer getinttypeId = tPurchase.getOrderState();
        Integer newstateId = 0;

        String straudtiSetting = "";
        switch (model.getUpdateType()){
            case "CH"://撤回
                if(getinttypeId == OrderStateChange.Purchase_OrderAudit_NotAudit ||getinttypeId == OrderStateChange.Purchase_OrderAudit_AuditING){//如果订单状态在2的时候 1、把之前有审核的订单流程全部清掉。重新开始
                    //修改订单审核流程完成度
                    orderAuditPocessRepository.updateByAuditTypeAndOrderId("CG",model.getUpdateID());
                    newstateId = OrderStateChange.Purchase_OrderAudit_draft;//返回到草稿状态
                    straudtiSetting="采购订单--撤回";
                }else{
                    throw new PassportException(ResultCode.PARAM_ERR_MSG);
                }
                break;
            case "JSCG"://结束采购
                if(getinttypeId == OrderStateChange.Purchase_OrderCheckout_Checked){
                    newstateId = OrderStateChange.Purchase_OrderAudit_NOTDelivered_SureIng;
                    straudtiSetting="采购订单--结束采购";
                }else{
                    throw new PassportException(ResultCode.PARAM_ERR_MSG);
                }
                break;
            case "TH"://采购退回
                if(getinttypeId == OrderStateChange.Purchase_OrderCheckout_Checked || getinttypeId == OrderStateChange.Purchase_OrderAudit_NOTDelivered_SureIng){
                    newstateId = OrderStateChange.Purchase_OrderAudit_Returning_AuditIng;
                    straudtiSetting="采购订单--采购退回";
                }else{
                    throw new PassportException(ResultCode.PARAM_ERR_MSG);
                }
                break;
            case "JS"://结束退回
                if(getinttypeId == OrderStateChange.Purchase_OrderAudit_Returning_AuditIng){//如果订单状态在4的时候。才可以进行此操作
                    newstateId = OrderStateChange.Purchase_OrderAudit_Finished_Passed;
                    straudtiSetting="采购订单--结束退回";
                }else{
                    throw new PassportException(ResultCode.PARAM_ERR_MSG);
                }
                break;
            default:
                throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        AuditPocess auditPocess = new AuditPocess();
        auditPocess.setAuditOrderId(model.getUpdateID());//审核单子ID
        auditPocess.setAuditType("CG");
        auditPocess.setAuditSettingId(0);//处理的单子Id
        auditPocess.setAuditSetting(straudtiSetting);
        auditPocess.setRemark(model.getUpdateRemark());
        auditPocess.setDeleteNo(0);
        auditPocess.setAuditStaffId(Integer.valueOf(userInfoForToken.getUserId()));//员工id
        auditPocessRepository.save(auditPocess);//新增审核流程

        tPurchase.setOrderState(newstateId);
        tpurchaseRepository.save(tPurchase);
    }

    /**
     * 订单审核(采购管理)-查询
     * @param
     * @throws PassportException
     */
    public PageInfo getAllPurchaseOrderAudit(SelectModel smodel)throws PassportException{
        PageInfo page=new PageInfo();

        List<PurchaseModel> listPurchase = mesMapper.findAllPurchaseOrderAudit(smodel.getFindName(),(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());
        for (PurchaseModel modes: listPurchase) {
            Map<String,String> map =  OrderStateChange.getOrderState(modes.getOrderStateId());
            modes.setCheckState(map.get("checkState"));
            modes.setOrderState(map.get("orderstate"));
        }
        page.setList(listPurchase);
        page.setTotal(mesMapper.countByPurchaseOrderAudit(smodel.getFindName()));

        page.setPageSize(smodel.getPageSize());
        page.setPageNum(smodel.getPageNum());
        return page;
    }

    /**
     * 来料检验(采购管理)-查询
     * @param
     * @throws PassportException
     */
    public PageInfo getAllPurchaseLLAudit(SelectModel smodel)throws PassportException{
        PageInfo page=new PageInfo();

        List<PurchaseModel> listPurchase = mesMapper.findAllPurchaseLLAudit(smodel.getFindName(),(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());
        for (PurchaseModel modes: listPurchase) {
            Map<String,String> map =  OrderStateChange.getOrderState(modes.getOrderStateId());
            modes.setCheckState(map.get("checkState"));
            modes.setOrderState(map.get("orderstate"));
        }
        page.setList(listPurchase);
        page.setTotal(mesMapper.countByPurchaseLLAudit(smodel.getFindName()));

        page.setPageSize(smodel.getPageSize());
        page.setPageNum(smodel.getPageNum());
        return page;
    }


    /**
     * 采购入库-新增采购入库
     * 采购订单管理- 入库
     * 此处入库的主要操作有：1、让订单状态显示已入库。2、新增库存管理-库存状况数据 3、新增库存管理-出入库数据
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateMaterialEnter(UserInfoForToken userInfoForToken,UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) || StringUtils.isEmpty(model.getUpdateRemark())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        TPurchase purchase = tpurchaseRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(purchase)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        List<TPurchasedetailModel>  listdetail =  mesMapper.findAllPurchaseById(model.getUpdateID());

        List<InventoryStatus> inventoryStatusList = new ArrayList<>();
        List<InventoryRecord> inventoryRecordList = new ArrayList<>();
        for(TPurchasedetailModel tPurchasedetailModel : listdetail){
            InventoryStatus countInventoryStatus=  inventoryStatusRepository.findByProductIdAndWarehouseIdAndInventoryType(tPurchasedetailModel.getStockId(),purchase.getWarehouseiId(),InventoryRecordReturnCode.InventoryType_YL);
            Integer surplusquantity = 0;
            if(StringUtils.isEmpty(countInventoryStatus)){//如果为空就是新增。如果不为空就是修改咯
                InventoryStatus inventoryStatus = new InventoryStatus();
                inventoryStatus.setProductId(tPurchasedetailModel.getStockId());//产品/原料明细Id
                inventoryStatus.setWarehouseId(purchase.getWarehouseiId());//仓库Id
//                inventoryStatus.setRecordType(InventoryRecordReturnCode.RecordType_CG);//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购等)
                inventoryStatus.setInventoryType(InventoryRecordReturnCode.InventoryType_YL);//库存类型(1 原料 2 产品 )
                surplusquantity = tPurchasedetailModel.getStockAmount();
                inventoryStatus.setInventorysum(surplusquantity);

                inventoryStatus.setStockName(tPurchasedetailModel.getStockName());
                inventoryStatus.setStockModel(tPurchasedetailModel.getStockModel());
                inventoryStatus.setStockNumber(tPurchasedetailModel.getStockNumber());
                inventoryStatus.setStandards(tPurchasedetailModel.getStandards());
                inventoryStatus.setUnitId(tPurchasedetailModel.getUnitId());
                inventoryStatusList.add(inventoryStatus);

            }else{
                surplusquantity = countInventoryStatus.getInventorysum() + tPurchasedetailModel.getStockAmount();
                countInventoryStatus.setInventorysum(surplusquantity);//更改数量
                inventoryStatusList.add(countInventoryStatus);
            }


            //存入记录
            InventoryRecord inventoryRecord = new InventoryRecord();
            inventoryRecord.setProductDetailid(tPurchasedetailModel.getStockId());
            inventoryRecord.setRecordType(InventoryRecordReturnCode.RecordType_CG);//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购等)
            inventoryRecord.setCreateTime(System.currentTimeMillis());
            inventoryRecord.setChangequantity("+"+tPurchasedetailModel.getStockAmount());
            inventoryRecord.setSurplusquantity(surplusquantity);
            inventoryRecord.setInventoryType(InventoryRecordReturnCode.InventoryType_YL);//库存类型(1 原料 2 产品 )
            inventoryRecord.setRemark(model.getUpdateRemark());
            inventoryRecord.setWarehouseId(purchase.getWarehouseiId());

            inventoryRecord.setStockName(tPurchasedetailModel.getStockName());
            inventoryRecord.setStockNumber(tPurchasedetailModel.getStockNumber());
            inventoryRecord.setStockModel(tPurchasedetailModel.getStockModel());
            inventoryRecord.setStandards(tPurchasedetailModel.getStandards());
            inventoryRecord.setUnitId(tPurchasedetailModel.getUnitId());
            inventoryRecordList.add(inventoryRecord);
        }

        inventoryRecordRepository.saveAll(inventoryRecordList);//批量保存
        inventoryStatusRepository.saveAll(inventoryStatusList);

        //新增审核流程
        AuditPocess auditPocess = new AuditPocess();
        auditPocess.setAuditOrderId(model.getUpdateID());//审核单子ID
        auditPocess.setAuditSettingId(0);//处理的过程Id
        auditPocess.setAuditSetting("入库");
        auditPocess.setRemark(model.getUpdateRemark());
        auditPocess.setAuditStaffId(Integer.valueOf(userInfoForToken.getUserId()));//员工id
        auditPocess.setAuditType("CG");
        auditPocess.setDeleteNo(0);
        auditPocessRepository.save(auditPocess);

        purchase.setOrderState(OrderStateChange.Purchase_OrderAudit_Delivered_Sured);
        tpurchaseRepository.save(purchase);//修改订单状态
    }

}
