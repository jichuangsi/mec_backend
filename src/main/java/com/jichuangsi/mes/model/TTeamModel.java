package com.jichuangsi.mes.model;

public class TTeamModel {

    private Integer id;//
    private String teamName;//班组名称
    private String remark;//备注
    private Integer staffId;//员工ID(班组负责人)
    private String staffName;//班组负责人

    private String frequency;// 班次（1白班 2夜班）
    private String teamStaffList;//班组成员列表 (把员工ID存进去，用,号隔开)
    private Integer state;//状态
    private Integer deleteNo;//删除否

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getTeamStaffList() {
        return teamStaffList;
    }

    public void setTeamStaffList(String teamStaffList) {
        this.teamStaffList = teamStaffList;
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
