package com.jichuangsi.mes.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private String equipmentName;//设备名称
    private String equipmentModel;//设备型号
    private String equipmentNumber;//设备编号
    private String equipmentTypeId;//设备类型Ids（熔炼设备，粗拉设备，中拉设备，细拉设备等） 注意：这个设备类型可以多选
    private Integer state;//状态 0 开启 1关闭 2停用
    private Integer deleteNo;//删除否

    private Integer checkNo;//是否检修(当天) 定时任务：到12点自动变成 0   0 未检验 1 已检验


    private Integer mouldId;//模具id（跟模具管理那边绑定的设备id相对应）

    public Integer getMouldId() {
        return mouldId;
    }

    public void setMouldId(Integer mouldId) {
        this.mouldId = mouldId;
    }

    public Integer getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(Integer checkNo) {
        this.checkNo = checkNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(String equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public String getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(String equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
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
