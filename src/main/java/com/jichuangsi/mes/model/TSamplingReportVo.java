package com.jichuangsi.mes.model;

import java.util.Date;

public class TSamplingReportVo {


    private Integer id;//id
    private Integer ppppId;//生产产物id
    private Integer pppId;//生产id
    private String pppNumbers;//抽检批号
    private String reportName;//名称
    private Date createTime;//检验日期
    private Integer inspectionSum;//进检轴数
    private Integer samplesNums;//抽检轴数

    private Integer qualifiedNum;//合格轴数
    private Integer unqualifiedNum;//不合格轴数

    private Integer state;//状态
    private Integer deleteNo;//删除否


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPpppId() {
        return ppppId;
    }

    public void setPpppId(Integer ppppId) {
        this.ppppId = ppppId;
    }

    public Integer getPppId() {
        return pppId;
    }

    public void setPppId(Integer pppId) {
        this.pppId = pppId;
    }

    public String getPppNumbers() {
        return pppNumbers;
    }

    public void setPppNumbers(String pppNumbers) {
        this.pppNumbers = pppNumbers;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getInspectionSum() {
        return inspectionSum;
    }

    public void setInspectionSum(Integer inspectionSum) {
        this.inspectionSum = inspectionSum;
    }

    public Integer getSamplesNums() {
        return samplesNums;
    }

    public void setSamplesNums(Integer samplesNums) {
        this.samplesNums = samplesNums;
    }

    public Integer getQualifiedNum() {
        return qualifiedNum;
    }

    public void setQualifiedNum(Integer qualifiedNum) {
        this.qualifiedNum = qualifiedNum;
    }

    public Integer getUnqualifiedNum() {
        return unqualifiedNum;
    }

    public void setUnqualifiedNum(Integer unqualifiedNum) {
        this.unqualifiedNum = unqualifiedNum;
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
