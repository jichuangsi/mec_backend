package com.jichuangsi.mes.model;

public class AuditPocessVo {

    private Integer id;
    private Integer auditSettingId;//审核设置ID
    private String auditSetting;//审核设置(审核类型)
    private Integer auditListId;//审核单子ID
    private String remark;//审核过程备注
    private String createTime;//创建时间
    private Integer deleteNo;

    private String staffName;//员工名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuditSettingId() {
        return auditSettingId;
    }

    public void setAuditSettingId(Integer auditSettingId) {
        this.auditSettingId = auditSettingId;
    }

    public String getAuditSetting() {
        return auditSetting;
    }

    public void setAuditSetting(String auditSetting) {
        this.auditSetting = auditSetting;
    }

    public Integer getAuditListId() {
        return auditListId;
    }

    public void setAuditListId(Integer auditListId) {
        this.auditListId = auditListId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}
