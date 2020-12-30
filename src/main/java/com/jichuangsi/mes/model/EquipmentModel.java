package com.jichuangsi.mes.model;

import com.jichuangsi.mes.entity.*;

import java.util.List;

//检修model表
public class EquipmentModel {

    Equipment equipment;

    List<EquipmentItems> equipmentItemsList;

    EquipmentCheckRecord equipmentCheckRecord;

    List<EquipmentCheckDetailRecord> equipmentCheckDetailRecordList;

    RepairReport repairReport;//报修表


    public RepairReport getRepairReport() {
        return repairReport;
    }

    public void setRepairReport(RepairReport repairReport) {
        this.repairReport = repairReport;
    }

    public EquipmentCheckRecord getEquipmentCheckRecord() {
        return equipmentCheckRecord;
    }

    public void setEquipmentCheckRecord(EquipmentCheckRecord equipmentCheckRecord) {
        this.equipmentCheckRecord = equipmentCheckRecord;
    }

    public List<EquipmentCheckDetailRecord> getEquipmentCheckDetailRecordList() {
        return equipmentCheckDetailRecordList;
    }

    public void setEquipmentCheckDetailRecordList(List<EquipmentCheckDetailRecord> equipmentCheckDetailRecordList) {
        this.equipmentCheckDetailRecordList = equipmentCheckDetailRecordList;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public List<EquipmentItems> getEquipmentItemsList() {
        return equipmentItemsList;
    }

    public void setEquipmentItemsList(List<EquipmentItems> equipmentItemsList) {
        this.equipmentItemsList = equipmentItemsList;
    }
}
