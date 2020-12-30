package com.jichuangsi.mes.model;

//产品的model
public class TProductModel {
    private Integer id;//
    private String productNumber;//产品编号
    private String productName;//产品名称
    private String productModel;//产品型号
    private Integer productLineId;//产品线别ID
    private String productLine;//产品线别ID
    private String productRemark;//产品说明
    private Integer productUnitId;//单位
    private String productUnit;//单位
    private Integer bobbinId;//线轴
    private Integer beginId;//始端
    private Integer endId;//末端
    private Integer state;
    private Integer deleteNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(Integer productLineId) {
        this.productLineId = productLineId;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getProductRemark() {
        return productRemark;
    }

    public void setProductRemark(String productRemark) {
        this.productRemark = productRemark;
    }

    public Integer getProductUnitId() {
        return productUnitId;
    }

    public void setProductUnitId(Integer productUnitId) {
        this.productUnitId = productUnitId;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public Integer getBobbinId() {
        return bobbinId;
    }

    public void setBobbinId(Integer bobbinId) {
        this.bobbinId = bobbinId;
    }

    public Integer getBeginId() {
        return beginId;
    }

    public void setBeginId(Integer beginId) {
        this.beginId = beginId;
    }

    public Integer getEndId() {
        return endId;
    }

    public void setEndId(Integer endId) {
        this.endId = endId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
