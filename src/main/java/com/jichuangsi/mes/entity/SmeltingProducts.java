package com.jichuangsi.mes.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

//熔炼产物表
@Entity
@Table(name = "smelting_products")
public class SmeltingProducts {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//熔炼产物ID
    private Integer PPPId;//生产id
    private Date createTime;//生产时间

    private BigDecimal grossWeight ;//毛重g
    private BigDecimal netWeightg;//净重g
    private BigDecimal wastageg;//废料g
    private BigDecimal lossg;//损耗g
    private Integer deleteNo;//删除否

    public Integer getPPPId() {
        return PPPId;
    }

    public void setPPPId(Integer PPPId) {
        this.PPPId = PPPId;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getNetWeightg() {
        return netWeightg;
    }

    public void setNetWeightg(BigDecimal netWeightg) {
        this.netWeightg = netWeightg;
    }

    public BigDecimal getWastageg() {
        return wastageg;
    }

    public void setWastageg(BigDecimal wastageg) {
        this.wastageg = wastageg;
    }

    public BigDecimal getLossg() {
        return lossg;
    }

    public void setLossg(BigDecimal lossg) {
        this.lossg = lossg;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
