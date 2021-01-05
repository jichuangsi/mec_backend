package com.jichuangsi.mes.entity;

public class GXScheduling {


    private Integer id;
    private Integer ppId;//生产计划ID
    private Integer gxId;//
    private String gxName;//工序名称
    private Integer tteamId;//班组ID
    private String tteamName;//班组名称
    private Integer frequency;
    private String frequencystr;// 班次（1白班 2夜班）


    private String staffName;//员工名称
    private String staffNumber;//员工编号
    private String staffId;//员工id

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
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

    public Integer getGxId() {
        return gxId;
    }

    public void setGxId(Integer gxId) {
        this.gxId = gxId;
    }

    public String getGxName() {
        return gxName;
    }

    public void setGxName(String gxName) {
        this.gxName = gxName;
    }

    public Integer getTteamId() {
        return tteamId;
    }

    public void setTteamId(Integer tteamId) {
        this.tteamId = tteamId;
    }

    public String getTteamName() {
        return tteamName;
    }

    public void setTteamName(String tteamName) {
        this.tteamName = tteamName;
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
}
