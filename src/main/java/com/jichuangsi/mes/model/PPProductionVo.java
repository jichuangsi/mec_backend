package com.jichuangsi.mes.model;

import java.math.BigDecimal;

public class PPProductionVo {

    private Integer id;//计划产物id
    private Integer ppId;//生产计划ID
    private Integer productDetailId;//产品规格ID

    private Double length;//成品长度
    private Integer quantum;//计划轴数

    private String ppNumber;//生产计划单号
    private String createTime;//下达时间
    private String finishedTime;//完工时间
    private String customerName;//客户名称
    private Integer planNum;//预计生产数量(米)
    private Integer finishNum;//实际生产数量(米)

    private String productNumber;//产品编号
    private String productName;//产品名称
    private String productModel;//产品型号

    private BigDecimal umStart;//成品直径um
    private BigDecimal milStart;//成品直径mil

    private String beginName;//始端
    private String endName;//末端
    private String bobbinName;//成品线轴
    private String productUnit;//产品单位

    private BigDecimal elStart;//延伸率EL
    private BigDecimal elEnd;//延伸率EL
    private BigDecimal blStart;//拉断力BL(CN)
    private BigDecimal blEend;//拉断力BL(CN)

//    private Integer suitId;//套模id
//    private BigDecimal moldTemp;//铸造温度℃
//    private Integer towTime;//牵引时间min
//    private Integer towParameters;//牵引参数
//    private Integer stopTime;//停止时间 min
//    private BigDecimal waterTemp;//水温℃


    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
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

    public String getPpNumber() {
        return ppNumber;
    }

    public void setPpNumber(String ppNumber) {
        this.ppNumber = ppNumber;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(String finishedTime) {
        this.finishedTime = finishedTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getPlanNum() {
        return planNum;
    }

    public void setPlanNum(Integer planNum) {
        this.planNum = planNum;
    }

    public Integer getFinishNum() {
        return finishNum;
    }

    public void setFinishNum(Integer finishNum) {
        this.finishNum = finishNum;
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

    public BigDecimal getUmStart() {
        return umStart;
    }

    public void setUmStart(BigDecimal umStart) {
        this.umStart = umStart;
    }

    public BigDecimal getMilStart() {
        return milStart;
    }

    public void setMilStart(BigDecimal milStart) {
        this.milStart = milStart;
    }

    public String getBeginName() {
        return beginName;
    }

    public void setBeginName(String beginName) {
        this.beginName = beginName;
    }

    public String getEndName() {
        return endName;
    }

    public void setEndName(String endName) {
        this.endName = endName;
    }

    public String getBobbinName() {
        return bobbinName;
    }

    public void setBobbinName(String bobbinName) {
        this.bobbinName = bobbinName;
    }

    public BigDecimal getElStart() {
        return elStart;
    }

    public void setElStart(BigDecimal elStart) {
        this.elStart = elStart;
    }

    public BigDecimal getElEnd() {
        return elEnd;
    }

    public void setElEnd(BigDecimal elEnd) {
        this.elEnd = elEnd;
    }

    public BigDecimal getBlStart() {
        return blStart;
    }

    public void setBlStart(BigDecimal blStart) {
        this.blStart = blStart;
    }

    public BigDecimal getBlEend() {
        return blEend;
    }

    public void setBlEend(BigDecimal blEend) {
        this.blEend = blEend;
    }
}
