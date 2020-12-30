package com.jichuangsi.mes.model;

public class WarehouseModel {

    private Integer id;
    private String warehouseNumber;//仓库编号
    private String warehousenName;//仓库名称
    private Integer staffId;//员工ID(负责人)
    private String staffName;//负责人
    private String remark;//备注
    private Integer state;//仓库状态
    private Integer deleteNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWarehouseNumber() {
        return warehouseNumber;
    }

    public void setWarehouseNumber(String warehouseNumber) {
        this.warehouseNumber = warehouseNumber;
    }

    public String getWarehousenName() {
        return warehousenName;
    }

    public void setWarehousenName(String warehousenName) {
        this.warehousenName = warehousenName;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
