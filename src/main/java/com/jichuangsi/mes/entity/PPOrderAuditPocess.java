package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.util.Date;

//生产计划单-订单审核审核层级表
@Entity
@Table(name = "pp_order_auditpocess")
public class PPOrderAuditPocess {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private Integer orderId;//计划单id
    private Integer auditLevel;//审核层级
    private String levelName;//层级名称
    private Integer staffId;//员工ID
    private Date createTime;//创建时间
    private Integer finished;//完成否

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getAuditLevel() {
        return auditLevel;
    }

    public void setAuditLevel(Integer auditLevel) {
        this.auditLevel = auditLevel;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }
}
