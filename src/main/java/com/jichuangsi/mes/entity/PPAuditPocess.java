package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 生产计划单-审核流程表
 */
@Entity
@Table(name = "pp_audit_pocess")
public class PPAuditPocess {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private Integer auditSettingId;//审核设置ID
    private String auditSetting;//审核设置(审核节点备注)
    private Integer auditOrderId;//审核单子ID
    private String remark;//审核过程备注
    private Integer staffId;//审核员工id
    private Date createTime;//创建时间
    private Integer deleteNo;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

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

    public Integer getAuditOrderId() {
        return auditOrderId;
    }

    public void setAuditOrderId(Integer auditOrderId) {
        this.auditOrderId = auditOrderId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
