package com.jichuangsi.mes.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_cuffingcheckdetail")
public class TCuffingcheckdetail {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//成套模具明细检查ID
    private Integer cuffingCheckId;//套模检查ID
    private Integer mouldDetailId;//模套ID(小模具)
    private String remark;//备注
    private Integer entranceNo;//入口区正常否
    private Integer deformationNo;//变形区正常否
    private Integer rsmNo;//定径区正常否
    private Integer exportNo;//出口区正常否
    private Integer deleteNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCuffingCheckId() {
        return cuffingCheckId;
    }

    public void setCuffingCheckId(Integer cuffingCheckId) {
        this.cuffingCheckId = cuffingCheckId;
    }

    public Integer getMouldDetailId() {
        return mouldDetailId;
    }

    public void setMouldDetailId(Integer mouldDetailId) {
        this.mouldDetailId = mouldDetailId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getEntranceNo() {
        return entranceNo;
    }

    public void setEntranceNo(Integer entranceNo) {
        this.entranceNo = entranceNo;
    }

    public Integer getDeformationNo() {
        return deformationNo;
    }

    public void setDeformationNo(Integer deformationNo) {
        this.deformationNo = deformationNo;
    }

    public Integer getRsmNo() {
        return rsmNo;
    }

    public void setRsmNo(Integer rsmNo) {
        this.rsmNo = rsmNo;
    }

    public Integer getExportNo() {
        return exportNo;
    }

    public void setExportNo(Integer exportNo) {
        this.exportNo = exportNo;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
