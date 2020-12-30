package com.jichuangsi.mes.common;

import com.jichuangsi.mes.repository.AuditSettingRepository;
import com.jichuangsi.mes.repository.MattersRepository;
import com.jichuangsi.mes.repository.OrderAuditPocessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
@Component
public class OrderStateChange {

    @Autowired
    private static OrderAuditPocessRepository orderAuditPocessRepository;
    private static OrderStateChange  orderStateChange ;
    @Resource
    private AuditSettingRepository auditSettingRepository;
    @Resource
    private MattersRepository mattersRepository;



    @PostConstruct
    public void init() {
        orderStateChange = this;
        orderStateChange.orderAuditPocessRepository = this.orderAuditPocessRepository;
        orderStateChange.auditSettingRepository = this.auditSettingRepository;
        orderStateChange.mattersRepository = this.mattersRepository;
    }

    //    public void setTestService(TestService  testService) {
//        this.testService = testService;
//    }

    /**
     * 当前订单状态Id
     * @param orderStateId 订单状态Id
     * @return
     */
//    public static Integer showOrderState(Integer orderStateId,Integer orderId){
//        Integer getint = 0;
//        switch (orderStateId){
//            case 0:
//                getint = 1;
//                break;
//            case 1:
//                getint = 2;
//                break;
//            case 2:
//               Integer countId =  orderStateChange.orderAuditPocessRepository.findByAuditTypeAndOrderId("CG",orderId);
//
//                if(!StringUtils.isEmpty(countId) && countId > 0){//如果有进程。则进入到下一个阶段
//                    Matters matters = new Matters();
//                    matters.setMatterNews("您有1个采购订单待审核");
//                    matters.setStaffId(countId);// 获取下一个阶段需要审核的员工Id
//                    matters.setOrderId(orderId);
//                    matters.setDeleteNo(0);
//                    orderStateChange.mattersRepository.save(matters);//新增待办事项
//                }else{
//                    getint = 3;
//                }
////                str1 = "订单审核";
////                str2 = "审核中";
//                break;
//            case 3:
//                getint = 4;
//                break;
//            case 4:
//                Integer staffId =  orderStateChange.orderAuditPocessRepository.findByAuditTypeAndOrderId("LL",orderId);
//
//                if(!StringUtils.isEmpty(staffId) && staffId > 0){    //如果有进程。则进入到下一个阶段
//                    Matters matters = new Matters();
//                    matters.setMatterNews("您有1个采购来料订单待审核");
//                    matters.setStaffId(staffId);// 获取下一个阶段需要审核的员工Id
//                    matters.setOrderId(orderId);
//                    matters.setDeleteNo(0);
//                    orderStateChange.mattersRepository.save(matters);//新增待办事项
//                }else{
//                    getint = 4;
//                }
//
////                str1 = "来料检验";
////                str2 = "检验中";
//                break;
//            case 5:
//                getint = 7;
//                break;
//            case 6:
////                str1 = "退回";
////                str2 = "检验中";
//                break;
//            default:
//                getint = 0;
//                break;
//
//        }
//        return  getint;
//
//    }

    //    采购订单：状态代表
    public static final Integer Purchase_OrderAudit_draft = 0;//草稿-未审核
    public static final Integer Purchase_OrderAudit_NotAudit = 1;//订单审核-未审核
    public static final Integer Purchase_OrderAudit_AuditING = 2;//订单审核-审核中
    public static final Integer Purchase_OrderCheckout_NotCheck = 3;//来料检验-待检验
    public static final Integer Purchase_OrderCheckout_Checking = 4;//来料检验-检验中
    public static final Integer Purchase_OrderCheckout_Checked = 5;//检验已通过——待确认
    public static final Integer Purchase_OrderAudit_NOTDelivered_SureIng = 6;//待入库-检验中
    public static final Integer Purchase_OrderAudit_Returning_AuditIng = 7;//退回-检验中
    public static final Integer Purchase_OrderAudit_Finished_Passed = 8;//结束退回-已退回
    public static final Integer Purchase_OrderAudit_Delivered_Sured = 9;//已入库-已通过
    public static final Integer Purchase_OrderAudit_Finished_Sured = 10;//已完成-已通过

//采购订单：状态
    public static Map<String,String> getOrderState(Integer orderStateId){
        String str1 = "";
        String str2 = "";
        Map<String,String> myMap = new HashMap<String,String>();
        switch (orderStateId){
            case 0:
                str1 = "草稿";
                str2 = "未检验";
                break;
            case 1:
                str1 = "订单审核";
                str2 = "未审核";
                break;
            case 2:
                str1 = "订单审核";
                str2 = "审核中";
                break;
            case 3:
                str1 = "来料检验";
                str2 = "待检验";
                break;
            case 4:
                str1 = "来料检验";
                str2 = "检验中";
                break;
            case 5:
                str1 = "来料检验";
                str2 = "检验已通过——待确认";
                break;
            case 6:
                str1 = "待入库";
                str2 = "检验中";
                break;
            case 7:
                str1 = "退回";
                str2 = "检验中";
                break;
            case 8:
                str1 = "结束退回";
                str2 = "已退回";
                break;

            case 9:
                str1 = "已入库";
                str2 = "已通过";
                break;
            case 10:
                str1 = "已完成";
                str2 = "已通过";
                break;
            default:
                str1 = "--";
                str2 = "--";
                break;

        }
        myMap.put("orderstate",str1);
        myMap.put("checkState",str2);
        return  myMap;
    }



    //    销售订单：状态代表
    public static final Integer Sale_OrderAudit_draft = 0;//草稿-未审核
    public static final Integer Sale_OrderAudit_NotAudit = 1;//订单审核-未审核
    public static final Integer Sale_OrderAudit_AuditING = 2;//订单审核-审核中
    public static final Integer Sale_OrderAudit_NOTDelivered_NotSURE = 3;//待出库-待确认
    public static final Integer Sale_OrderAudit_Delivered_Sured = 4;//已出库-已确认
    public static final Integer Sale_OrderAudit_Finished_Passed = 5;//已完成-已通过
    public static final Integer Sale_OrderAudit_Returning_NotAudit = 6;//退回中-待审核
    public static final Integer Sale_OrderAudit_Returning_AuditING = 7;//退回中-审核中
    public static final Integer Sale_OrderAudit_Returned_Passed = 8;//已退回-已通过

//    销售订单：状态
    public static Map<String,String> getSaleOrderState(Integer saleorderStateId){
        String str1 = "";
        String str2 = "";
        Map<String,String> myMap = new HashMap<String,String>();
        switch (saleorderStateId){
            case 0:
                str1 = "草稿";
                str2 = "未审核";

                break;
            case 1:
                str1 = "订单审核";
                str2 = "未审核";
                break;
            case 2:
                str1 = "订单审核";
                str2 = "审核中";
                break;
            case 3:
                str1 = "待出库";
                str2 = "待确认";
                break;
            case 4:
                str1 = "已出库";
                str2 = "已确认";
                break;
            case 5:
                str1 = "已完成";
                str2 = "已通过";
                break;
            case 6:
                str1 = "退回中";
                str2 = "待审核";//就是退回审核那里。如果审核通过了，到最后一层就自动入库
                break;
            case 7:
                str1 = "退回中";
                str2 = "审核中";//就是退回审核那里。如果审核通过了，到最后一层就自动入库
                break;
            case 8:
                str1 = "已退回";
                str2 = "已通过";
                break;

            default:
                str1 = "--";
                str2 = "--";
                break;

        }
        myMap.put("orderstate",str1);
        myMap.put("checkState",str2);
        return  myMap;
    }


}
