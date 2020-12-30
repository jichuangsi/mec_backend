package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_repairreport")
public class RepairReport {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//历史报修单ID
    private Integer equipmentId;//设备id
    private String repairReportNumber;//报修单号
    private Date createTime;//报修时间
    private Integer state;//状态 0待处理 1待维修 2待检验 3已完成
    private Integer deleteNo;//删除否

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getRepairReportNumber() {
        return repairReportNumber;
    }

    public void setRepairReportNumber(String repairReportNumber) {
        this.repairReportNumber = repairReportNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
