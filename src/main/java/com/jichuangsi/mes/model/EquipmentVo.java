package com.jichuangsi.mes.model;

public class EquipmentVo {

    private Integer id;
    private String equipmentName;//设备名称
    private String equipmentModel;//设备型号
    private String equipmentNumber;//设备编号
    private Integer equipmentTypeId;//设备类型Id（熔炼设备，粗拉设备，中拉设备，细拉设备等）
    private String equipmentType;//设备类型（熔炼设备，粗拉设备，中拉设备，细拉设备等）
    private Integer state;//状态
    private String stateName;//状态释义
    private Integer deleteNo;//删除否

    private Integer checkNo;//是否检修(当天检修状态)
    private String checkNoName;//检修状态
    private String checkStaffName;//检修员
    private String checkTime;//检修时间
    private String runNumber;//运行次数

//    设备检修

    private Integer userTime;//使用时间

    private Integer currentNormalMonth;//本月正常运行时间
    private Integer currentNONormalMonth;//本月不正常运行时间
    private Integer currentRestMonth;//本月休息运行时间
    private Integer currentOutMonth;//本月停用运行时间

    private Integer SumNormalMonth;//累计正常运行时间
    private Integer SumNONormalMonth;//累计不正常运行时间
    private Integer SumRestMonth;//累计休息运行时间
    private Integer SumOutMonth;//累计停用运行时间



    //报修历史单
    private String repairReportNumber;//报修单号
    private String createTime;//报修时间

    public Integer getUserTime() {
        return userTime;
    }

    public void setUserTime(Integer userTime) {
        this.userTime = userTime;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getCheckStaffName() {
        return checkStaffName;
    }

    public void setCheckStaffName(String checkStaffName) {
        this.checkStaffName = checkStaffName;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getRunNumber() {
        return runNumber;
    }

    public void setRunNumber(String runNumber) {
        this.runNumber = runNumber;
    }

    public String getCheckNoName() {
        return checkNoName;
    }

    public void setCheckNoName(String checkNoName) {
        this.checkNoName = checkNoName;
    }

    public Integer getCurrentNormalMonth() {
        return currentNormalMonth;
    }

    public void setCurrentNormalMonth(Integer currentNormalMonth) {
        this.currentNormalMonth = currentNormalMonth;
    }

    public Integer getCurrentNONormalMonth() {
        return currentNONormalMonth;
    }

    public void setCurrentNONormalMonth(Integer currentNONormalMonth) {
        this.currentNONormalMonth = currentNONormalMonth;
    }

    public Integer getCurrentRestMonth() {
        return currentRestMonth;
    }

    public void setCurrentRestMonth(Integer currentRestMonth) {
        this.currentRestMonth = currentRestMonth;
    }

    public Integer getCurrentOutMonth() {
        return currentOutMonth;
    }

    public void setCurrentOutMonth(Integer currentOutMonth) {
        this.currentOutMonth = currentOutMonth;
    }

    public Integer getSumNormalMonth() {
        return SumNormalMonth;
    }

    public void setSumNormalMonth(Integer sumNormalMonth) {
        SumNormalMonth = sumNormalMonth;
    }

    public Integer getSumNONormalMonth() {
        return SumNONormalMonth;
    }

    public void setSumNONormalMonth(Integer sumNONormalMonth) {
        SumNONormalMonth = sumNONormalMonth;
    }

    public Integer getSumRestMonth() {
        return SumRestMonth;
    }

    public void setSumRestMonth(Integer sumRestMonth) {
        SumRestMonth = sumRestMonth;
    }

    public Integer getSumOutMonth() {
        return SumOutMonth;
    }

    public void setSumOutMonth(Integer sumOutMonth) {
        SumOutMonth = sumOutMonth;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getRepairReportNumber() {
        return repairReportNumber;
    }

    public void setRepairReportNumber(String repairReportNumber) {
        this.repairReportNumber = repairReportNumber;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(String equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public Integer getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(Integer equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
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

    public Integer getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(Integer checkNo) {
        this.checkNo = checkNo;
    }
}
