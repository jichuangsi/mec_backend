package com.jichuangsi.mes.entity;


import javax.persistence.*;

//设备检修记录明细表
@Entity
@Table(name = "t_equipmentcheckdetailrecord")
public class EquipmentCheckDetailRecord {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private Integer equipmentCheckRecordId;//设备检修记录ID
    private Integer equipmentOverhaulId;//设备检修项ID
    private Integer overhaulState;//检修状态(1正常 2不正常 3休班 4停用)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEquipmentCheckRecordId() {
        return equipmentCheckRecordId;
    }

    public void setEquipmentCheckRecordId(Integer equipmentCheckRecordId) {
        this.equipmentCheckRecordId = equipmentCheckRecordId;
    }

    public Integer getEquipmentOverhaulId() {
        return equipmentOverhaulId;
    }

    public void setEquipmentOverhaulId(Integer equipmentOverhaulId) {
        this.equipmentOverhaulId = equipmentOverhaulId;
    }

    public Integer getOverhaulState() {
        return overhaulState;
    }

    public void setOverhaulState(Integer overhaulState) {
        this.overhaulState = overhaulState;
    }


}
