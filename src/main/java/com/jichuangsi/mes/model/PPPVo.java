package com.jichuangsi.mes.model;

public class PPPVo {

    private Integer id;//生产管理
    private String productionNumber;//生产批号（年+月+日+当天第几个+产品型号）
    private String ppNumber;//生产计划单号


    private Integer teamId;//班组id
    private String teamName;//班组
    private Integer frequency;//班次id （1 白班 2夜班）
    private String frequencystr;//班次（1 白班 2夜班）
    private Integer GXId;//工序类型(1熔炼 2粗拉 3中拉 4半成品(细拉) 5成品(超细拉) 6 中间退火 7成品退火 8绕线 9成品改绕)
    private String GXName;//工序类型(1熔炼 2粗拉 3中拉 4半成品(细拉) 5成品(超细拉) 6 中间退火 7成品退火 8绕线 9成品改绕)
    private Integer state;//完成情况 (0未完成 1已完成)
    private String statestr;//完成情况 (0未完成 1已完成)
    private String createTime;//创建时间


    private String finishedTime;//完工时间(生产计划单)

    private Integer deleteNo;//删除否

    public String getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(String finishedTime) {
        this.finishedTime = finishedTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductionNumber() {
        return productionNumber;
    }

    public void setProductionNumber(String productionNumber) {
        this.productionNumber = productionNumber;
    }

    public String getPpNumber() {
        return ppNumber;
    }

    public void setPpNumber(String ppNumber) {
        this.ppNumber = ppNumber;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public String getFrequencystr() {
        return frequencystr;
    }

    public void setFrequencystr(String frequencystr) {
        this.frequencystr = frequencystr;
    }

    public Integer getGXId() {
        return GXId;
    }

    public void setGXId(Integer GXId) {
        this.GXId = GXId;
    }

    public String getGXName() {
        return GXName;
    }

    public void setGXName(String GXName) {
        this.GXName = GXName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStatestr() {
        return statestr;
    }

    public void setStatestr(String statestr) {
        this.statestr = statestr;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
