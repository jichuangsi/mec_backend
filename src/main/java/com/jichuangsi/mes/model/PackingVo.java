package com.jichuangsi.mes.model;

import com.jichuangsi.mes.entity.TPacking;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PackingVo {


    private Integer id;//包装id
    private String packingName;//包装编号
    private Integer PPPId;//生产id
    private Date productTime;//生产日期
    private Date qualityTime;//保质期
    private String stock;//原材料
    private String cartonsNumber;//装盒数量


    private Date createTime;//包装日期
    private String productionNumber;//生产批号（年+月+日+当天第几个+产品型号）
    private String productModel;//产品型号
    private BigDecimal lengthM;//长度m


    private String productids;//关联的库存产品


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPackingName() {
        return packingName;
    }

    public void setPackingName(String packingName) {
        this.packingName = packingName;
    }

    public Integer getPPPId() {
        return PPPId;
    }

    public void setPPPId(Integer PPPId) {
        this.PPPId = PPPId;
    }

    public Date getProductTime() {
        return productTime;
    }

    public void setProductTime(Date productTime) {
        this.productTime = productTime;
    }

    public Date getQualityTime() {
        return qualityTime;
    }

    public void setQualityTime(Date qualityTime) {
        this.qualityTime = qualityTime;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getCartonsNumber() {
        return cartonsNumber;
    }

    public void setCartonsNumber(String cartonsNumber) {
        this.cartonsNumber = cartonsNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProductionNumber() {
        return productionNumber;
    }

    public void setProductionNumber(String productionNumber) {
        this.productionNumber = productionNumber;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public BigDecimal getLengthM() {
        return lengthM;
    }

    public void setLengthM(BigDecimal lengthM) {
        this.lengthM = lengthM;
    }

    public String getProductids() {
        return productids;
    }

    public void setProductids(String productids) {
        this.productids = productids;
    }
}
