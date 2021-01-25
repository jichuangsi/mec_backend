package com.jichuangsi.mes.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_moulddetailReplaceHistory")
public class TMouldDetailReplaceHistory {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//模具替换历史id
    private Integer sonmouldId;//
    private Date createTime;//替换时间
    private String sonmouldModel;//子模具型号
    private String sonmouldNumberBrfore;//子模具编号（更换前）
    private String sonmouldNumberAfter;//子模具编号（更换后）

    private String sonmouldwiredrawSumBefore;//累计拉丝量 (更换前)
    private String sonmouldwiredrawSumAfter;//累计拉丝量（更换后）


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSonmouldId() {
        return sonmouldId;
    }

    public void setSonmouldId(Integer sonmouldId) {
        this.sonmouldId = sonmouldId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSonmouldModel() {
        return sonmouldModel;
    }

    public void setSonmouldModel(String sonmouldModel) {
        this.sonmouldModel = sonmouldModel;
    }

    public String getSonmouldNumberBrfore() {
        return sonmouldNumberBrfore;
    }

    public void setSonmouldNumberBrfore(String sonmouldNumberBrfore) {
        this.sonmouldNumberBrfore = sonmouldNumberBrfore;
    }

    public String getSonmouldNumberAfter() {
        return sonmouldNumberAfter;
    }

    public void setSonmouldNumberAfter(String sonmouldNumberAfter) {
        this.sonmouldNumberAfter = sonmouldNumberAfter;
    }

    public String getSonmouldwiredrawSumBefore() {
        return sonmouldwiredrawSumBefore;
    }

    public void setSonmouldwiredrawSumBefore(String sonmouldwiredrawSumBefore) {
        this.sonmouldwiredrawSumBefore = sonmouldwiredrawSumBefore;
    }

    public String getSonmouldwiredrawSumAfter() {
        return sonmouldwiredrawSumAfter;
    }

    public void setSonmouldwiredrawSumAfter(String sonmouldwiredrawSumAfter) {
        this.sonmouldwiredrawSumAfter = sonmouldwiredrawSumAfter;
    }
}
