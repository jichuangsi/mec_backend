package com.jichuangsi.mes.model;

public class TSuitVo {

    private Integer id;//套模组合ID
    private String constituteNumber;//组合编号
    private String constituteName;//名称
    private String lineType;//线别类型
    private String staffName;//制定人

    private String scopeApplication;//适用范围描述
    private String scrapNo;//模具组合状态
    private Integer stateNo;//模具组合状态

    public Integer getStateNo() {
        return stateNo;
    }

    public void setStateNo(Integer stateNo) {
        this.stateNo = stateNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConstituteNumber() {
        return constituteNumber;
    }

    public void setConstituteNumber(String constituteNumber) {
        this.constituteNumber = constituteNumber;
    }

    public String getConstituteName() {
        return constituteName;
    }

    public void setConstituteName(String constituteName) {
        this.constituteName = constituteName;
    }

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getScopeApplication() {
        return scopeApplication;
    }

    public void setScopeApplication(String scopeApplication) {
        this.scopeApplication = scopeApplication;
    }

    public String getScrapNo() {
        return scrapNo;
    }

    public void setScrapNo(String scrapNo) {
        this.scrapNo = scrapNo;
    }
}
