package com.jichuangsi.mes.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_moulddetail")
public class TMouldDetail {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//模具套装ID
    private Integer mouldId;//模具ID
    private String sonmouldModel;//子模具型号
    private String sonmouldSpaNum;//子模具孔径um

//
//    private Long packageNumber;//套号
//    private Long initialspaNum;//初始孔径um
//    private Long currentspaNum;//当前孔径um
//    private Long warnspaNum;//预警孔径um
//    private Long scrapspaNum;//报废孔径um
    private String remark;
    private Integer deleteNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMouldId() {
        return mouldId;
    }

    public void setMouldId(Integer mouldId) {
        this.mouldId = mouldId;
    }

    public String getSonmouldModel() {
        return sonmouldModel;
    }

    public void setSonmouldModel(String sonmouldModel) {
        this.sonmouldModel = sonmouldModel;
    }

    public String getSonmouldSpaNum() {
        return sonmouldSpaNum;
    }

    public void setSonmouldSpaNum(String sonmouldSpaNum) {
        this.sonmouldSpaNum = sonmouldSpaNum;
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
