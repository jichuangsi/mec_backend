package com.jichuangsi.mes.model;

import java.math.BigDecimal;

public class PackingDetailVo {

    private Integer id;//包装明细id
    private String productionNumber;//生产批号
    private String productModel;//模型
    private String standards;//规格
    private String bobbinName;//线轴名称
    private String axleNumber;//编号
    private BigDecimal lengthm;//长度m
    private BigDecimal inventorysum;//库存总数

    public String getProductionNumber() {
        return productionNumber;
    }

    public void setProductionNumber(String productionNumber) {
        this.productionNumber = productionNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public String getStandards() {
        return standards;
    }

    public void setStandards(String standards) {
        this.standards = standards;
    }

    public String getBobbinName() {
        return bobbinName;
    }

    public void setBobbinName(String bobbinName) {
        this.bobbinName = bobbinName;
    }

    public String getAxleNumber() {
        return axleNumber;
    }

    public void setAxleNumber(String axleNumber) {
        this.axleNumber = axleNumber;
    }

    public BigDecimal getLengthm() {
        return lengthm;
    }

    public void setLengthm(BigDecimal lengthm) {
        this.lengthm = lengthm;
    }

    public BigDecimal getInventorysum() {
        return inventorysum;
    }

    public void setInventorysum(BigDecimal inventorysum) {
        this.inventorysum = inventorysum;
    }
}
