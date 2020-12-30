package com.jichuangsi.mes.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_suitdetail")
public class TSuitdetail {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//组合明细ID
    private Integer suitId;//套模组合ID
    private Integer mouldId;//模具ID
    private String mouldDetailId;//模具明细ID
    private Integer compositeTypeId;//组合类型(1粗拉，2中拉，3半成品，4成品等)
    private Integer mouldType;//模具类别(1成品模具/2成套模具/0不使用模具)
    private String remark;
    private Integer deleteNo;


    public String getMouldDetailId() {
        return mouldDetailId;
    }

    public void setMouldDetailId(String mouldDetailId) {
        this.mouldDetailId = mouldDetailId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSuitId() {
        return suitId;
    }

    public void setSuitId(Integer suitId) {
        this.suitId = suitId;
    }

    public Integer getMouldId() {
        return mouldId;
    }

    public void setMouldId(Integer mouldId) {
        this.mouldId = mouldId;
    }

    public Integer getCompositeTypeId() {
        return compositeTypeId;
    }

    public void setCompositeTypeId(Integer compositeTypeId) {
        this.compositeTypeId = compositeTypeId;
    }

    public Integer getMouldType() {
        return mouldType;
    }

    public void setMouldType(Integer mouldType) {
        this.mouldType = mouldType;
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
