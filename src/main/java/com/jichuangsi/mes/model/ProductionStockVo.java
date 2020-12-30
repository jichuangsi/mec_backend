package com.jichuangsi.mes.model;

//生产管理：查询生产所需原料
public class ProductionStockVo {

    private Integer id;//熔炼原料ID
    private Integer PPPId;//生产id
    private Integer inventoryStatusId;//库存原料ID
    private Integer quantityChoose;//选择数量
    private Integer totalNet;//总净数g
    private Integer deleteNo;//删除否



    private String stockNumber;//原料编号
    private String stockName;//名称
    private String stockModel;//型号
    private String standards;//规格(1g2g等)
    private String unitName;//单位

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPPPId() {
        return PPPId;
    }

    public void setPPPId(Integer PPPId) {
        this.PPPId = PPPId;
    }

    public Integer getInventoryStatusId() {
        return inventoryStatusId;
    }

    public void setInventoryStatusId(Integer inventoryStatusId) {
        this.inventoryStatusId = inventoryStatusId;
    }

    public Integer getQuantityChoose() {
        return quantityChoose;
    }

    public void setQuantityChoose(Integer quantityChoose) {
        this.quantityChoose = quantityChoose;
    }

    public Integer getTotalNet() {
        return totalNet;
    }

    public void setTotalNet(Integer totalNet) {
        this.totalNet = totalNet;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
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

    public String getStandards() {
        return standards;
    }

    public void setStandards(String standards) {
        this.standards = standards;
    }
}
