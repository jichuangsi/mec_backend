package com.jichuangsi.mes.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_standards")
public class TStandards {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//材料规格ID
    private Integer materialId;//材料ID
    private String standards;//规格(1g2g等)
//    private Integer bobbinWeight;//轴重。只有线轴有
    private Integer materialType;//材料类型(1 原料/ 2 线轴/3 其他)
    private String remark;
    private Integer deleteNo;

//    public Integer getBobbinWeight() {
//        return bobbinWeight;
//    }
//
//    public void setBobbinWeight(Integer bobbinWeight) {
//        this.bobbinWeight = bobbinWeight;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getStandards() {
        return standards;
    }

    public void setStandards(String standards) {
        this.standards = standards;
    }

    public Integer getMaterialType() {
        return materialType;
    }

    public void setMaterialType(Integer materialType) {
        this.materialType = materialType;
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
