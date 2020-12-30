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

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SaleService {
    @Resource
    private IMesMapper mesMapper;


    @Resource
    private TSaleorderRepository tsaleorderRepository;
    @Resource
    private TSaleorderdetailRepository tSaleorderdetailRepository;
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
     * 销售订单管理- 新增/编辑页面获取下拉框数据
     * @param
     * @throws PassportException
     */
    public JSONObject getSaleBasicInfo()throws PassportException {
        JSONObject job = new JSONObject();

        long tpNum =tsaleorderRepository.count()+1;
        String strnum = "XS-000"+tpNum;

        job.put("pruchaseNum",strnum);//销售订单号
        job.put("kehuXiaLa",mesMapper.findClientAllXiaLa(1));//客户
        job.put("userXiaLa",mesMapper.findStaffAllXiaLa());//负责人
        job.put("purchaseType",sdictionarierRepository.findByDicCode("CGType"));//销售类型
        job.put("warehouse",mesMapper.findAllWarehouseByXiaLa());//仓库
        job.put("payType",sdictionarierRepository.findByDicCode("PT"));//付款方式
        job.put("orderState","待审核");//订单状态
        job.put("checkState","未审核");//审核状态

        return job;
    }


    /**
     * 销售订单管理- 明细页面--新增/编辑页面获取下拉框数据
     * @param
     * @throws PassportException
     */
    public JSONObject getSaleDetailBasicInfo()throws PassportException {
        JSONObject job = new JSONObject();

        job.put("stockXiaLa",mesMapper.findAllProductByXiaLa(null));//产品下拉框

        return job;
    }

    /**
     * 销售订单管理- 明细页面--联动下拉框：根据原材料Id查询规格明细下拉框
     * @param
     * @throws PassportException
     */
    public JSONObject getSaleDetailBasicInfo(SelectModel smodel)throws PassportException {
        JSONObject job = new JSONObject();

        job.put("productDetailXiaLa",mesMapper.findAllProductDetailByIdXiaLa(smodel.getFindById()));//产品下拉框

        return job;
    }

    /**
     * 销售订单管理- 新增/编辑
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void saveSale(SaleModel saleModel)throws PassportException {
        TSaleorder tSaleorder = saleModel.getTsaleorder();
        if (StringUtil.isEmpty(tSaleorder.getSaleOrder()) || StringUtils.isEmpty(tSaleorder.getOrderStateId())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        if(StringUtils.isEmpty(tSaleorder.getId())){//判断是否已经有提交过
            long tpNum =tsaleorderRepository.count()+1;
            String strnum = "XS-000"+tpNum;
            tSaleorder.setSaleOrder(strnum);//避免同时有人在操作。这边直接获取编号。

        }
        tSaleorder.setDeleteNo(0);
        TSaleorder tSaleorder1 =tsaleorderRepository.save(tSaleorder);

        Integer pid = tSaleorder1.getId();

        tSaleorderdetailRepository.updatesaleorderdetailByOrderId(pid);//先把明细删除
        List<TSaleorderdetail> listpur = saleModel.getTsaleorderdetail();
        for (int i = 0; i < listpur.size(); i++) {
            TSaleorderdetail tSaleorderdetail = listpur.get(i);
            if(StringUtils.isEmpty(listpur.get(i).getProductNum()) || StringUtils.isEmpty(listpur.get(i).getProductPrice())){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
                throw new PassportException(ResultCode.PARAM_MISS_MSG);

            }
            tSaleorderdetail.setDeleteNo(0);
            tSaleorderdetail.setSaleorderId(pid);
        }
        tSaleorderdetailRepository.saveAll(saleModel.getTsaleorderdetail());

        if(tSaleorder.getOrderStateId() == 1){//如果是提交的话就要发送一条待办事项

            long t4=System.currentTimeMillis();
            Integer countOrderAudit =  orderAuditPocessRepository.findByAuditTypeTwoAndOrderId("XX","TH",tSaleorder.getId());
            if(StringUtils.isEmpty(countOrderAudit) || countOrderAudit == 0){
                mesMapper.insertOrderPocess(tSaleorder.getId(),t4,"XX","TH");//保存订单的时候就把需要审核的流程保存起来
            }

            Matters matters = new Matters();
            matters.setMatterNews("您有1个销售订单待审核");
            matters.setStaffId(auditSettingRepository.getstaffIdByauditTypeandLevel("XX","1"));
            matters.setOrderId(tSaleorder.getId());
            matters.setDeleteNo(0);
            mattersRepository.save(matters);//新增待办事项

            AuditPocess auditPocess = new AuditPocess();
            auditPocess.setAuditOrderId(tSaleorder.getId());
            auditPocess.setAuditType("XX");
            auditPocess.setAuditSetting("创建销售订单");
            auditPocess.setAuditSettingId(0);
            auditPocess.setRemark(tSaleorder.getRemark());
            auditPocess.setDeleteNo(0);
            auditPocessRepository.save(auditPocess);//新增审核流程
        }
    }

    /**
     * 销售订单管理-查询
     * @param
     * @throws PassportException
     */
    public PageInfo getAllSale(SelectModel smodel)throws PassportException{
        int total=0;
        PageInfo page=new PageInfo();

        String starttime = null;
        String endtime = null;

        if(!StringUtils.isEmpty(smodel.getFindDate())){
            starttime = smodel.getFindDate() +" 00:00:00";
            endtime = smodel.getFindDate() +" 23:59:59";
        }

        List<SaleVo> listSale = mesMapper.findAllSale(smodel.getFindName(),starttime,endtime,(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());
        for (SaleVo modes: listSale) {
            Map<String,String> map =  OrderStateChange.getSaleOrderState(modes.getOrderStateId());
            modes.setCheckStates(map.get("checkState"));
            modes.setOrderStates(map.get("orderstate"));
        }
        page.setList(listSale);
        page.setTotal(mesMapper.countBySale(smodel.getFindName(),starttime,endtime));

        page.setPageSize(smodel.getPageSize());
        page.setPageNum(smodel.getPageNum());
        return page;
    }

    /**
     * 销售订单管理-(销售订单审核)-查询
     * @param
     * @throws PassportException
     */
    public PageInfo getAllSaleOrderAudit(SelectModel smodel)throws PassportException{
        PageInfo page=new PageInfo();

        String starttime = null;
        String endtime = null;

        if(!StringUtils.isEmpty(smodel.getFindDate())){
            starttime = smodel.getFindDate() +" 00:00:00";
            endtime = smodel.getFindDate() +" 23:59:59";
        }

        List<SaleVo> listSale = mesMapper.getAllSaleOrderAudit(smodel.getFindName(),starttime,endtime,(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());
        for (SaleVo modes: listSale) {
//            modes.setStaffName();//当前审核人
            Map<String,String> map =  OrderStateChange.getSaleOrderState(modes.getOrderStateId());
            modes.setCheckStates(map.get("checkState"));
            modes.setOrderStates(map.get("orderstate"));
        }
        page.setList(listSale);
        page.setTotal(mesMapper.countBySale(smodel.getFindName(),starttime,endtime));

        page.setPageSize(smodel.getPageSize());
        page.setPageNum(smodel.getPageNum());
        return page;
    }

    /**
     * 销售订单管理-根据Id查询订单详情
     * @param
     * @throws PassportException
     */
    public JSONObject getSaleById(SelectModel smodel)throws PassportException{
        JSONObject jsonObject=new JSONObject();
        if(StringUtils.isEmpty(smodel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        TSaleorder tSaleorder=  tsaleorderRepository.findByid(smodel.getFindById());

        if (StringUtils.isEmpty(tSaleorder)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        Map<String,String> map =  OrderStateChange.getSaleOrderState(tSaleorder.getOrderStateId());

        List<TSaleorderdetailVo>  listdetail = mesMapper.findSaleDetailById(smodel.getFindById());
        BigDecimal total = listdetail.stream().map(TSaleorderdetailVo->TSaleorderdetailVo.getProductSum()).reduce(BigDecimal.ZERO,BigDecimal::add);//统计list明细里面的金额总数

        jsonObject.put("saleorder",tSaleorder);
        jsonObject.put("checkState",map.get("checkState"));
        jsonObject.put("orderState",map.get("orderstate"));
        jsonObject.put("saleOrderDetail",listdetail);
        jsonObject.put("detailSize",listdetail.size());
        jsonObject.put("sumMoney",total);

        jsonObject.put("auditDetail",mesMapper.findAuditListById(smodel.getFindById(),"XX","TH"));//加上审核详情
        return jsonObject;
    }

    /**
     * 销售订单管理-修改状态 （delete_no状态）
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateSaleByid(UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) ||StringUtils.isEmpty(model.getUpdateType())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        TSaleorder tSaleorder = tsaleorderRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(tSaleorder)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        tSaleorder.setDeleteNo(tSaleorder.getDeleteNo() == 0 ? 1 :0);
        tsaleorderRepository.save(tSaleorder);

    }

    /**
     * 当前订单状态Id
     * @param orderStateId 订单状态Id
     * @return
     */
    public Map<String,String> showSaleOrderState(Integer orderStateId,Integer orderId)throws PassportException{
        Map<String,String> map = new HashMap<>();
        Integer getint = 0;
        String str = "";
        Integer id = 0;
        String strAuditType = "";//审核类型

        switch (orderStateId){
            case 0:
//                str1 = "草稿";
//                str2 = "未审核";
                getint = 1;
                break;
            case 1://"订单审核";   "未审核";
            case 2:
//                str1 = "订单审核";
//                str2 = "审核中";

                getint = 2;
                strAuditType = "XX";
                List<OrderAuditPocess> oldauditCG = orderAuditPocessRepository.findByAuditTypeAndOrderId("XX",orderId);
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
                    orderAuditPocessRepository.updateByAuditTypeAndOrderIdandAndStaffId("XX",orderId,oldstaffid);
                }
                if(oldauditCG.size() >1){
                    Integer countId = oldauditCG.get(1).getStaffId() ;

                    if(!StringUtil.isEmpty(countId.toString()) && countId > 0){//如果有进程。则进入到下一个阶段。并且修改上一个人的完成状态
                        Matters matters = new Matters();
                        matters.setMatterNews("您有1个销售订单待审核");
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
            case 3://"待出库" "待确认"

                getint =4;
                break;
            case 4:
//                str1 = "已出库";
//                str2 = "已确认";

                getint =5;
                break;
            case 5:
//                str1 = "已完成";
//                str2 = "已通过";
                getint = 5;//订单完成
                break;
            case 6:
//                str1 = "退回中";
//                str2 = "待审核";//就是退回审核那里。如果审核通过了，到最后一层就自动入库
            case 7:
//                str1 = "退回中";
//                str2 = "审核中";
                getint = 7;
                strAuditType = "TH";
                List<OrderAuditPocess> oldauditLL = orderAuditPocessRepository.findByAuditTypeAndOrderId("TH",orderId);
                if(oldauditLL.size() != 0){
                    Integer oldLLstaffid = oldauditLL.get(0).getStaffId();
                    str = oldauditLL.get(0).getLevelName();//获取层级名称
                    id = oldauditLL.get(0).getId();//获取处理的单子Id
                    Matters oldLLmatters = new Matters();
                    oldLLmatters.setOrderId(orderId);
                    oldLLmatters.setStaffId(oldLLstaffid);
                    oldLLmatters.setFinishedNo(1);
                    mattersRepository.save(oldLLmatters);

                    //修改订单审核流程完成度
                    orderAuditPocessRepository.updateByAuditTypeAndOrderIdandAndStaffId("TH",orderId,oldLLstaffid);
                }

                if(oldauditLL.size() > 1 && !StringUtils.isEmpty(oldauditLL.get(1).getStaffId()) && oldauditLL.get(1).getStaffId() > 0){//如果有进程。则进入到下一个阶段。并且修改上一个人的完成状态
                    Integer staffId =oldauditLL.get(1).getStaffId();

                    Matters matters = new Matters();
                    matters.setMatterNews("您有1个销售退回订单待审核");
                    matters.setStaffId(staffId);// 获取下一个阶段需要审核的员工Id
                    matters.setOrderId(orderId);
                    matters.setDeleteNo(0);
                    matters.setFinishedNo(0);
                    mattersRepository.save(matters);//新增待办事项
                }else{//1、状态改为8；2、入库操作
                    getint = OrderStateChange.Sale_OrderAudit_Returned_Passed;
                    //入库操作
                    saleInventory(getint,6,2,orderId,"销售订单退货入库");
                }

                break;
            case 8:
//                str1 = "已退回";
//                str2 = "已通过";
                getint = 8;
                break;
            default:
                getint = 0;
                break;
        }
        map.put("getint",getint.toString());
        map.put("levelName",str);
        map.put("id",id.toString());
        map.put("auditType",strAuditType);//获取审核的类型
        return  map;
    }

    /**
     * 销售订单管理-修改订单状态 （订单撤回，结束销售，销售退回等）
     * 结束销售：就是点击后状态变为已完成；
     * 撤回:强行中止订单,返回提交流程（草稿状态）
     * 销售退回:到退回审核流程
     *
     * 销售订单流程图：销售开单-销售 订单审核-审核通过了之后订单状态变为待出库-已出库-订单已完成-（订单退回）-已退回审核后（入库）
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateSaleOrderStateByid(UpdateModel model, HttpSession session)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) || StringUtils.isEmpty(model.getUpdateRemark())|| StringUtils.isEmpty(model.getUpdateType())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        TSaleorder tSaleorder = tsaleorderRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(tSaleorder)){ throw new PassportException(ResultCode.DATA_NOEXIST_MSG);}

        String straudtiSetting = "";
        Integer getinttypeId = tSaleorder.getOrderStateId();
        Integer newstateId = 0;
        switch (model.getUpdateType()){
            case "CH"://撤回
                if(getinttypeId == OrderStateChange.Sale_OrderAudit_NotAudit ||getinttypeId == OrderStateChange.Sale_OrderAudit_AuditING){//如果订单状态在2的时候 1、把之前有审核的订单流程全部清掉。重新开始
                    //修改订单审核流程完成度
                    orderAuditPocessRepository.updateByAuditTypeAndOrderId("XX",model.getUpdateID());
                    newstateId = OrderStateChange.Sale_OrderAudit_draft;//返回到草稿状态

                    straudtiSetting = "订单审核状态-撤回";
                }else{
                    throw new PassportException(ResultCode.PARAM_ERR_MSG);
                }
                break;
            case "CK"://出库
                if(getinttypeId == OrderStateChange.Sale_OrderAudit_NOTDelivered_NotSURE){
                    newstateId = OrderStateChange.Sale_OrderAudit_Delivered_Sured;

                    straudtiSetting = "出库";
                }else{
                    throw new PassportException(ResultCode.PARAM_ERR_MSG);
                }
                break;
            case "JS"://结束销售
                if(getinttypeId == OrderStateChange.Sale_OrderAudit_Delivered_Sured){//如果订单状态在4的时候。才可以进行此操作
                    newstateId = OrderStateChange.Sale_OrderAudit_Finished_Passed;//进入到订单完成状态

                    straudtiSetting = "结束销售";
                }else{
                    throw new PassportException(ResultCode.PARAM_ERR_MSG);
                }
                break;
            case "TH"://销售退回
                if(getinttypeId == OrderStateChange.Sale_OrderAudit_Finished_Passed){
                    newstateId = OrderStateChange.Sale_OrderAudit_Returning_NotAudit;
                    straudtiSetting = "销售退回";
                }else{
                    throw new PassportException(ResultCode.PARAM_ERR_MSG);
                }
                break;
            default:
                throw new PassportException(ResultCode.PARAM_ERR_MSG);
        }

        AuditPocess auditPocess = new AuditPocess();
        auditPocess.setAuditOrderId(model.getUpdateID());//审核单子ID
        auditPocess.setAuditType("XX");
        auditPocess.setAuditSettingId(0);//处理的单子Id
        auditPocess.setAuditSetting(straudtiSetting);
        auditPocess.setRemark(model.getUpdateRemark());
        auditPocess.setDeleteNo(0);
        auditPocessRepository.save(auditPocess);//新增审核流程

        tSaleorder.setOrderStateId(newstateId);
        tsaleorderRepository.save(tSaleorder);
    }

    /**
     * 销售订单管理-审核详情修改订单状态(审核流程点击的通过/驳回)
     *
     * 订单审核：任何一个审核不通过都是返回到未提交状态
     * 退回审核：任何一个审核不通过都是返回到原本的订单完成状态
     *
     * 销售开单-销售 订单审核-审核通过了之后订单状态变为待出库-已出库-订单已完成-（订单退回）-已退回审核后（入库）
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateSaleAuditStateByid(UpdateModel model, HttpSession session)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) || StringUtils.isEmpty(model.getUpdateRemark())|| StringUtils.isEmpty(model.getUpdateType())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        TSaleorder tSaleorder = tsaleorderRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(tSaleorder)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        String levelName = "";
        String strauditType = "";
        Integer newstateId = 0;
        Integer orderAuditPocessId = 0 ;//获取审核流程的单子Id

        Map<String,String> map = showSaleOrderState(tSaleorder.getOrderStateId(),model.getUpdateID());
        levelName =map.get("levelName");

        switch (model.getUpdateType()){
            case "T"://通过审核
                newstateId =Integer.valueOf(map.get("getint"));//获取一个新的订单状态Id
                strauditType =map.get("auditType");
                orderAuditPocessId =Integer.valueOf(map.get("id"));
                newstateId = newstateId> 0 ? newstateId:tSaleorder.getOrderStateId();

                break;
            case "F"://不通过
                if(tSaleorder.getOrderStateId() == OrderStateChange.Sale_OrderAudit_AuditING){//销售订单审核：任何一个审核不通过都是返回到未提交状态
                    //修改订单审核流程完成度
                    orderAuditPocessRepository.updateByAuditTypeAndOrderId("XX",model.getUpdateID());
                    newstateId = OrderStateChange.Sale_OrderAudit_draft;//返回到草稿状态
                    strauditType = "XX";
                }else if(tSaleorder.getOrderStateId() == OrderStateChange.Sale_OrderAudit_Returning_AuditING){
                    newstateId = OrderStateChange.Sale_OrderAudit_Finished_Passed;//返回到订单完成状态
                    strauditType = "TH";
                }

                levelName ="在-----"+levelName+ "------中被驳回";
                break;
            default:
                throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        AuditPocess auditPocess = new AuditPocess();
        auditPocess.setAuditOrderId(model.getUpdateID());//审核单子ID
        auditPocess.setAuditType(strauditType);
        auditPocess.setAuditSettingId(orderAuditPocessId);//处理的单子Id
        auditPocess.setAuditSetting(OrderStateChange.getSaleOrderState(tSaleorder.getOrderStateId()).get("orderstate") +"("+ levelName+")");
        auditPocess.setRemark(model.getUpdateRemark());
        auditPocess.setDeleteNo(0);
        auditPocessRepository.save(auditPocess);//新增审核流程

        tSaleorder.setOrderStateId(newstateId);
        tsaleorderRepository.save(tSaleorder);
    }

    /**
     * 销售订单-新增销售订单出库
     * 此处出库的主要操作有，1、让订单状态显示已出库 2、新增库存管理-库存状况数据 3、新增库存管理-出入库数据
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateMaterialOuter(UpdateModel model, HttpSession session)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) || StringUtils.isEmpty(model.getUpdateRemark())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        saleInventory(OrderStateChange.Sale_OrderAudit_Delivered_Sured,InventoryRecordReturnCode.RecordType_CK,InventoryRecordReturnCode.InventoryType_CP,model.getUpdateID(),model.getUpdateRemark());

        //新增审核流程
        AuditPocess auditPocess = new AuditPocess();
        auditPocess.setAuditOrderId(model.getUpdateID());//审核单子ID
        auditPocess.setAuditSettingId(0);//处理的过程Id
        auditPocess.setAuditSetting("出库");
        auditPocess.setRemark(model.getUpdateRemark());
        auditPocess.setDeleteNo(0);
        auditPocessRepository.save(auditPocess);
    }

    /**
     * 新增库存管理-库存状况数据 3、新增库存管理-出入库数据
     * @return
     */
    public void saleInventory(Integer orderstateId,Integer recordType,Integer inventoryType, Integer updateOrderId,String remarks)throws PassportException{
        TSaleorder tSaleorder = tsaleorderRepository.findByid(updateOrderId);

        if (StringUtils.isEmpty(tSaleorder)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        if((recordType == InventoryRecordReturnCode.RecordType_CK && tSaleorder.getOrderStateId() == OrderStateChange.Sale_OrderAudit_NOTDelivered_NotSURE) || (recordType == InventoryRecordReturnCode.RecordType_TH && tSaleorder.getOrderStateId() == OrderStateChange.Sale_OrderAudit_Returning_AuditING)){//判断是销售退回还是出库
            throw new PassportException(ResultCode.NO_ACCESS);
        }

        List<TSaleorderdetailVo>  listdetail =  mesMapper.findSaleDetailById(updateOrderId);

        List<InventoryStatus> inventoryStatusList = new ArrayList<>();
        List<InventoryRecord> inventoryRecordList = new ArrayList<>();
        for(TSaleorderdetailVo tsaleorderdetailVo : listdetail){
            InventoryStatus countInventoryStatus=  inventoryStatusRepository.findByProductIdAndWarehouseIdAndInventoryType(tsaleorderdetailVo.getProductId(),tSaleorder.getWarehouseId(),inventoryType);
            Integer surplusquantity = 0;
            if(StringUtils.isEmpty(countInventoryStatus)){//如果为空就是新增。如果不为空就是修改咯
                InventoryStatus inventoryStatus = new InventoryStatus();
                inventoryStatus.setProductId(tsaleorderdetailVo.getProductId());//产品/原料明细Id
                inventoryStatus.setWarehouseId(tSaleorder.getWarehouseId());//仓库Id
//                inventoryStatus.setRecordType(recordType);//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购 6销售退回==入库等)
                inventoryStatus.setInventoryType(inventoryType);//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他 )
                surplusquantity = tsaleorderdetailVo.getProductNum();
                inventoryStatus.setInventorysum(surplusquantity);
                inventoryStatusList.add(inventoryStatus);

            }else{
                surplusquantity = recordType == 1 ? countInventoryStatus.getInventorysum() - tsaleorderdetailVo.getProductNum():countInventoryStatus.getInventorysum() + tsaleorderdetailVo.getProductNum();
                countInventoryStatus.setInventorysum(surplusquantity);//更改数量
                inventoryStatusList.add(countInventoryStatus);
            }

            //存入记录
            InventoryRecord inventoryRecord = new InventoryRecord();
            inventoryRecord.setProductDetailid(tsaleorderdetailVo.getProductId());
            inventoryRecord.setRecordType(recordType);//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购 6销售退回等)
            inventoryRecord.setCreateTime(System.currentTimeMillis());
            inventoryRecord.setChangequantity(recordType == 1 ? "-"+tsaleorderdetailVo.getProductNum() : "+"+tsaleorderdetailVo.getProductNum());
            inventoryRecord.setSurplusquantity(surplusquantity);
            inventoryRecord.setInventoryType(inventoryType);//库存类型(1 原料 2 产品 )
            inventoryRecord.setRemark(remarks);
            inventoryRecord.setWarehouseId(tSaleorder.getWarehouseId());
            inventoryRecordList.add(inventoryRecord);
        }

        inventoryRecordRepository.saveAll(inventoryRecordList);//批量保存
        inventoryStatusRepository.saveAll(inventoryStatusList);


        tSaleorder.setOrderStateId(orderstateId);
        tsaleorderRepository.save(tSaleorder);//修改订单状态
    }
}
