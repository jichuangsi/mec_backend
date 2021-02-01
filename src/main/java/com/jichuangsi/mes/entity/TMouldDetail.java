package com.jichuangsi.mes.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_moulddetail")
public class TMouldDetail {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//模具套装ID
    private Integer mouldId;//模具ID
    private Integer fsonId;//父 子模具ID （默认0）
    private String sonmouldNumber;//子模具编号（唯一编号）
    private String sonmouldModel;//子模具型号
    private String sonmouldSpaNum;//子模具孔径um

    private String sonmouldwiredrawSum;//累计拉丝量（换成只有子模具编号才有累计拉丝量了）



//
//    private Long packageNumber;//套号
//    private Long initialspaNum;//初始孔径um
//    private Long currentspaNum;//当前孔径um
//    private Long warnspaNum;//预警孔径um
//    private Long scrapspaNum;//报废孔径um
    private String remark;
    private Integer scrapNo;//报废否 （0正常 1报废）
    private Integer deleteNo;

    public Integer getFsonId() {
        return fsonId;
    }

    public void setFsonId(Integer fsonId) {
        this.fsonId = fsonId;
    }

    public String getSonmouldNumber() {
        return sonmouldNumber;
    }

    public void setSonmouldNumber(String sonmouldNumber) {
        this.sonmouldNumber = sonmouldNumber;
    }

    public String getSonmouldwiredrawSum() {
        return sonmouldwiredrawSum;
    }

    public void setSonmouldwiredrawSum(String sonmouldwiredrawSum) {
        this.sonmouldwiredrawSum = sonmouldwiredrawSum;
    }

    public Integer getScrapNo() {
        return scrapNo;
    }

    public void setScrapNo(Integer scrapNo) {
        this.scrapNo = scrapNo;
    }

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
