package com.jichuangsi.mes.entity;

import javax.persistence.*;

@Entity
@Table(name = "Workshop")
public class Workshop {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//
    private String workshopImg;//厂房图片logo
    private String workshopName;//厂房信息
    private String workshopAddress;//厂房地址
    private String workshopRemark;//厂房介绍
    private String workshopContact;//联系方式

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkshopImg() {
        return workshopImg;
    }

    public void setWorkshopImg(String workshopImg) {
        this.workshopImg = workshopImg;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }

    public String getWorkshopAddress() {
        return workshopAddress;
    }

    public void setWorkshopAddress(String workshopAddress) {
        this.workshopAddress = workshopAddress;
    }

    public String getWorkshopRemark() {
        return workshopRemark;
    }

    public void setWorkshopRemark(String workshopRemark) {
        this.workshopRemark = workshopRemark;
    }

    public String getWorkshopContact() {
        return workshopContact;
    }

    public void setWorkshopContact(String workshopContact) {
        this.workshopContact = workshopContact;
    }
}
