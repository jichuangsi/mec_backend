package com.jichuangsi.mes.model;

import java.math.BigDecimal;

public class TSaleorderdetailVo {

    private Integer id;//
    private Integer saleorderId;//销售订单id
    private Integer productId;//产品id
    private Integer productdetailId;//产品规格id

    private String productNumber;//产品编号
    private String productName;//产品名称
    private String productModel;//产品型号
    private String umStart;//产品规格

    private Integer unitId;//单位Id
    private String unitName;//单位
    private Integer productNum;//数量
    private BigDecimal productPrice;//单价
    private BigDecimal productSum;//总价
    private String remark;//备注
    private Integer deleteNo;

    public Integer getProductdetailId() {
        return productdetailId;
    }

    public void setProductdetailId(Integer productdetailId) {
        this.productdetailId = productdetailId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSaleorderId() {
        return saleorderId;
    }

    public void setSaleorderId(Integer saleorderId) {
        this.saleorderId = saleorderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public String getUmStart() {
        return umStart;
    }

    public void setUmStart(String umStart) {
        this.umStart = umStart;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductSum() {
        return productSum;
    }

    public void setProductSum(BigDecimal productSum) {
        this.productSum = productSum;
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
}
