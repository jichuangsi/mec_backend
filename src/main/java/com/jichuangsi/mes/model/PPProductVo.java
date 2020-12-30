package com.jichuangsi.mes.model;

public class PPProductVo {

    private Integer id;//计划产物id
    private Integer ppId;//生产计划ID
    private Integer productDetailId;//产品规格ID
    private Double length;//长度
    private Integer quantum;//数量
    private String sumMI;//合计
    private Integer deleteNo;//删除否


    private String productNumber;//产品编号
    private String productName;//产品名称
    private String productModel;//产品型号
    private String standards;//规格(1g2g等)

    private String ppUnit;//产品单位
    private String customerName;//客户名称

    public String getPpUnit() {
        return ppUnit;
    }

    public void setPpUnit(String ppUnit) {
        this.ppUnit = ppUnit;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSumMI() {
        return sumMI;
    }

    public void setSumMI(String sumMI) {
        this.sumMI = sumMI;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    public Integer getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(Integer productDetailId) {
        this.productDetailId = productDetailId;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Integer getQuantum() {
        return quantum;
    }

    public void setQuantum(Integer quantum) {
        this.quantum = quantum;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
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

    public String getStandards() {
        return standards;
    }

    public void setStandards(String standards) {
        this.standards = standards;
    }
}
