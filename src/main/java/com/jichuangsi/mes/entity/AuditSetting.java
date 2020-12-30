package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.util.Date;
//审核层级表
@Entity
@Table(name = "audit_setting")
public class AuditSetting {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private String levelName;//层级名称
    private Integer auditLevel;//审核层级
    private Integer staffId;//员工ID(审核人+审核人职称)
    private String auditType;//审核类型(采购订单审核"CG"，来料检验审核"LL"，销售订单审核"XX"，出入库审核等"CRK"......)
    private long createTime= new Date().getTime();//新增审核设置时间
    private String remark;
    private Integer deleteNo;//删除否

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getAuditLevel() {
        return auditLevel;
    }

    public void setAuditLevel(Integer auditLevel) {
        this.auditLevel = auditLevel;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
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
