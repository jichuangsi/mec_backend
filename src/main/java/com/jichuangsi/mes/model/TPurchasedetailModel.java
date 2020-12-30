package com.jichuangsi.mes.model;

import java.math.BigDecimal;

public class TPurchasedetailModel {

    private Integer id;//采购明细ID
    private Integer purchaseId;//采购开单ID
    private Integer stockId;//原料规格ID
    private Integer stockAmount;//数量
    private BigDecimal stockUnitPrice;//单价(元)
    private BigDecimal stockSum;//总数
    private String remark;
    private Integer deleteNo;


    private String stockNumber;//原料编号
    private String stockName;//名称
    private String stockModel;//型号
    private String standards;//规格(1g2g等)
    private String unitName;//单位名称


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(Integer stockAmount) {
        this.stockAmount = stockAmount;
    }

    public BigDecimal getStockUnitPrice() {
        return stockUnitPrice;
    }

    public void setStockUnitPrice(BigDecimal stockUnitPrice) {
        this.stockUnitPrice = stockUnitPrice;
    }

    public BigDecimal getStockSum() {
        return stockSum;
    }

    public void setStockSum(BigDecimal stockSum) {
        this.stockSum = stockSum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
