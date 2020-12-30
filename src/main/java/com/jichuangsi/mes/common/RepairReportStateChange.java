package com.jichuangsi.mes.common;

public class RepairReportStateChange {

    //    报修订单：状态代表
    public static final Integer RepairReport_Audit_NotAudit = 0;//未处理(待处理)
    public static final Integer Purchase_OrderAudit_NotRepaire = 1;//待维修
    public static final Integer Purchase_OrderAudit_AuditING = 2;//待检验
    public static final Integer Purchase_OrderAudit_Finished_Sured = 3;//已完成-已通过

    public static String getRepairReportState(Integer orderState){
        String str = "";
        switch (orderState){
            case 0:
                str = "故障名称现象简述";
                break;
            case 1:
                str = "处理意见";
                break;
            case 2:
                str = "检修记录";
                break;
            case 3:
                str = "验收情况";
                break;
            default:
                    break;
        }
        return str;
    }
}
