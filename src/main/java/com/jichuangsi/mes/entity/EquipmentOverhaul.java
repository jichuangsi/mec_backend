package com.jichuangsi.mes.entity;

import javax.persistence.*;

//设备检修表
@Entity
@Table(name = "t_equipmentoverhaul")
public class EquipmentOverhaul {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private Integer equipmentItemId;//设备检项id
    private Integer equipmentId;//设备id
    private String equipmentTime;//检修月份(yyyy-dd)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEquipmentItemId() {
        return equipmentItemId;
    }

    public void setEquipmentItemId(Integer equipmentItemId) {
        this.equipmentItemId = equipmentItemId;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentTime() {
        return equipmentTime;
    }

    public void setEquipmentTime(String equipmentTime) {
        this.equipmentTime = equipmentTime;
    }
}
