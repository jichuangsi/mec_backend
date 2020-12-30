package com.jichuangsi.mes.model;

public class InventoryRecordVo {
    private Integer id;//库存记录Id
    private Integer productDetailid;//产品规格明细Id
    private Integer warehouseId;//仓库ID
    private Integer recordTypeId;//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购等)
    private String recordType;//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购等)
    private String createTime;//创建时间
    private String changequantity ;//发生数量
    private Integer surplusquantity;//剩余数量
    private Integer inventoryType;//库存类型(1 原料 2 产品 )
    private String remark;//备注


    private String warehousenName;//备注
    private String stockName;//名称
    private String stockModel;//模型
    private String stockNumber;//编号
    private String standards;//规格
    private String unitName;//单位

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductDetailid() {
        return productDetailid;
    }

    public void setProductDetailid(Integer productDetailid) {
        this.productDetailid = productDetailid;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getRecordTypeId() {
        return recordTypeId;
    }

    public void setRecordTypeId(Integer recordTypeId) {
        this.recordTypeId = recordTypeId;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getChangequantity() {
        return changequantity;
    }

    public void setChangequantity(String changequantity) {
        this.changequantity = changequantity;
    }

    public Integer getSurplusquantity() {
        return surplusquantity;
    }

    public void setSurplusquantity(Integer surplusquantity) {
        this.surplusquantity = surplusquantity;
    }

    public Integer getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(Integer inventoryType) {
        this.inventoryType = inventoryType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWarehousenName() {
        return warehousenName;
    }

    public void setWarehousenName(String warehousenName) {
        this.warehousenName = warehousenName;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockModel() {
        return stockModel;
    }

    public void setStockModel(String stockModel) {
        this.stockModel = stockModel;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public String getStandards() {
        return standards;
    }

    public void setStandards(String standards) {
        this.standards = standards;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
