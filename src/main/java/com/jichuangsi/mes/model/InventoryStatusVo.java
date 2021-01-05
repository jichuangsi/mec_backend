package com.jichuangsi.mes.model;

public class InventoryStatusVo {

    private Integer id;//库存状况Id
    private Integer productId;//产品规格ID
    private Integer warehouseId;//仓库ID
    private Integer inventorysum;//库存总数
    private Integer inventoryType;//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他 )
    private String inventoryTypestr;//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他 )

    private String warehousenName;//仓库名称
    private String stockName;//名称
    private String stockModel;//模型
    private String stockNumber;//编号
    private String standards;//规格
    private String unitName;//单位

    public String getInventoryTypestr() {
        return inventoryTypestr;
    }

    public void setInventoryTypestr(String inventoryTypestr) {
        this.inventoryTypestr = inventoryTypestr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getInventorysum() {
        return inventorysum;
    }

    public void setInventorysum(Integer inventorysum) {
        this.inventorysum = inventorysum;
    }

    public Integer getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(Integer inventoryType) {
        this.inventoryType = inventoryType;
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
