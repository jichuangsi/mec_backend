package com.jichuangsi.mes.model;

public class TFinishedproducecheckVo {

    private Integer id;//成品模具检查ID
    private Integer mouldId;//模具ID
    private Double measureddiamUm;//实测直径um    //有公式计算的，属于自动生成
    private String createTime;//检查日期
    private Integer staffId;//员工id
    private String staffName;//员工
    private String remark;
    private Integer deleteNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMouldId() {
        return mouldId;
    }

    public void setMouldId(Integer mouldId) {
        this.mouldId = mouldId;
    }

    public Double getMeasureddiamUm() {
        return measureddiamUm;
    }

    public void setMeasureddiamUm(Double measureddiamUm) {
        this.measureddiamUm = measureddiamUm;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
