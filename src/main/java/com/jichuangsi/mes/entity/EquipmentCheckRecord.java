package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.util.Date;

//设备检修记录表
@Entity
@Table(name = "t_equipmentcheckrecord")
public class EquipmentCheckRecord {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;

    private Integer equipmentId;//设备ID
    private String equipmentTime;//检修日期(年月日)

    private Integer checkYear;//检修日期(年)
    private Integer checkMonth;//检修日期(月)
    private Integer checkDay;//检修日期(日)
    private Integer userTime;//使用时间h
    private Integer frequency;// 班次（1白班 2夜班）
    private Integer staffId;//负责人ID

    private Date createTime;//新增时间(具体的时间)

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

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
}
