package com.jichuangsi.mes.constant;

public class InventoryRecordReturnCode {

//    出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购 6 销售退回 == 入库等)
    public static final Integer RecordType_CK = 1;
    public static final Integer RecordType_RK = 2;
    public static final Integer RecordType_DB = 3;
    public static final Integer RecordType_XX = 4;
    public static final Integer RecordType_CG = 5;
    public static final Integer RecordType_TH = 6;


//    库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他 )
    public static final Integer InventoryType_YL = 1;
    public static final Integer InventoryType_CP = 2;
    public static final Integer InventoryType_BCP = 3;
    public static final Integer InventoryType_FL = 4;
    public static final Integer InventoryType_XZ = 5;
    public static final Integer InventoryType_QT = 6;
}
