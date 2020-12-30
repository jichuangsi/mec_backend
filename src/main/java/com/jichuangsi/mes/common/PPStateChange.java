package com.jichuangsi.mes.common;

public class PPStateChange {

    //    生产计划单：状态代表
    public static final Integer PP_Audit_NotSubmit = 0;//未提交
    public static final Integer PP_Audit_NotAudit = 1;//已提交,未审核(待审核)
    public static final Integer PP_OrderAudit_AuditING = 2;//审核中
    public static final Integer PP_OrderAudit_Audited = 3;//已通过


    public static String getPPState(Integer orderState){
        String str = "";
        switch (orderState){
            case 1:
                str = "创建计划单";
                break;
            case 2:
                str = "审核中";
                break;
            case 3:
                str = "已通过";
                break;
            default:
                break;
        }
        return str;
    }

}
