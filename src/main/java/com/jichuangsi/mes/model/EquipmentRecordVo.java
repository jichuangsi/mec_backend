package com.jichuangsi.mes.model;

public class EquipmentRecordVo {


    private Integer equipmentCheckRecordId;//设备检修记录ID

    private Integer equipmentId;//设备ID
    private Integer equipmentOverhaulId;//设备检修项ID
    private String equipmentItems;//检项名称
    private String equipmentTime;//检修日期(年月日)
    private Integer userTime;//使用时间h
    private Integer frequency;// 班次（1白班 2夜班）
    private String frequencystr;// 班次（1白班 2夜班）
    private Integer staffId;//负责人ID
    private String staffName;//负责人名称


    private Integer checkYear;//检修日期(年)
    private Integer checkMonth;//检修日期(月)
    private Integer checkDay;//检修日期(日)

    private String overhaulState;//检修状态(1正常 2不正常 3休班 4停用)


    public Integer getCheckYear() {
        return checkYear;
    }

    public void setCheckYear(Integer checkYear) {
        this.checkYear = checkYear;
    }

    public Integer getCheckMonth() {
        return checkMonth;
    }

    public void setCheckMonth(Integer checkMonth) {
        this.checkMonth = checkMonth;
    }

    public Integer getCheckDay() {
        return checkDay;
    }

    public void setCheckDay(Integer checkDay) {
        this.checkDay = checkDay;
    }

    public String getFrequencystr() {
        return frequencystr;
    }

    public void setFrequencystr(String frequencystr) {
        this.frequencystr = frequencystr;
    }


    public Integer getEquipmentCheckRecordId() {
        return equipmentCheckRecordId;
    }

    public void setEquipmentCheckRecordId(Integer equipmentCheckRecordId) {
        this.equipmentCheckRecordId = equipmentCheckRecordId;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getEquipmentOverhaulId() {
        return equipmentOverhaulId;
    }

    public void setEquipmentOverhaulId(Integer equipmentOverhaulId) {
        this.equipmentOverhaulId = equipmentOverhaulId;
    }

    public String getEquipmentItems() {
        return equipmentItems;
    }

    public void setEquipmentItems(String equipmentItems) {
        this.equipmentItems = equipmentItems;
    }

    public String getEquipmentTime() {
        return equipmentTime;
    }

    public void setEquipmentTime(String equipmentTime) {
        this.equipmentTime = equipmentTime;
    }

    public Integer getUserTime() {
        return userTime;
    }

    public void setUserTime(Integer userTime) {
        this.userTime = userTime;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
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

    public String getOverhaulState() {
        return overhaulState;
    }

    public void setOverhaulState(String overhaulState) {
        this.overhaulState = overhaulState;
    }
}
