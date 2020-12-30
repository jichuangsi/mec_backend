package com.jichuangsi.mes.entity;

import javax.persistence.*;
//设备明细表
@Entity
@Table(name = "t_equipmentitems")
public class EquipmentItems {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private Integer equipmentId;//设备ID
    private String equipmentItems;//检项名称
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

    public String getEquipmentItems() {
        return equipmentItems;
    }

    public void setEquipmentItems(String equipmentItems) {
        this.equipmentItems = equipmentItems;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
