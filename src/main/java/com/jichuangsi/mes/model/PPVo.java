package com.jichuangsi.mes.model;

public class PPVo {
    private Integer id;//生产计划ID
    private String ppNumber;//生产计划单号
    private String ppName;//计划单名称
    private String createTime;//下达时间
    private String finishedTime;//完工时间
    private Integer SuitId;//套模方案ID
    private Integer SaleId;//关联销售订单ID(允许为空，为空则不关联)
    private String SaleOrder;//关联销售订单号
    private Integer relationNo;//关联销售订单否
    private Integer state;//状态
    private String ppstate;//状态
    private Integer deleteNo;//删除否

    public String getPpstate() {
        return ppstate;
    }

    public void setPpstate(String ppstate) {
        this.ppstate = ppstate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPpNumber() {
        return ppNumber;
    }

    public void setPpNumber(String ppNumber) {
        this.ppNumber = ppNumber;
    }

    public String getPpName() {
        return ppName;
    }

    public void setPpName(String ppName) {
        this.ppName = ppName;
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

    public Integer getSuitId() {
        return SuitId;
    }

    public void setSuitId(Integer suitId) {
        SuitId = suitId;
    }

    public Integer getSaleId() {
        return SaleId;
    }

    public void setSaleId(Integer saleId) {
        SaleId = saleId;
    }

    public String getSaleOrder() {
        return SaleOrder;
    }

    public void setSaleOrder(String saleOrder) {
        SaleOrder = saleOrder;
    }

    public Integer getRelationNo() {
        return relationNo;
    }

    public void setRelationNo(Integer relationNo) {
        this.relationNo = relationNo;
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
