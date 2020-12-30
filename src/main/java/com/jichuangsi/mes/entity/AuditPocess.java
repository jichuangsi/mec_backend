package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 审核流程表
 */
@Entity
@Table(name = "audit_pocess")
public class AuditPocess {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private Integer auditSettingId;//审核设置ID
    private String auditSetting;//审核设置(审核节点备注)
    private Integer auditOrderId;//审核单子ID
    private String auditType;//审核类型("CG","LL","XX","TH")
    private String remark;//审核过程备注
    private long createTime= new Date().getTime();//创建时间
    private Integer deleteNo;

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
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

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
