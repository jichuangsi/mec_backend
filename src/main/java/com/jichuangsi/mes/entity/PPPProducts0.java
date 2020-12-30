package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ppp_Products0")
public class PPPProducts0 {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//熔炼产物ID
    private Integer PPPId;//生产id
    private Integer gxId;//工序id
    private Date createTime;//生产时间

    private Integer bobbinDetailId;//线轴规格id
    private BigDecimal wireDiameterUm;//线径um
    private BigDecimal lengthM;//长度m/轴

    private BigDecimal grossWeight ;//毛重g
    private BigDecimal netWeightg;//净重g
    private BigDecimal wastageg;//废料g
    private BigDecimal lossg;//损耗g

    //    半成品/细拉的时候
    private String Slip;//滑差
    private String tractionSpeed;//牵引速度
    private String takeUpSpeed ;//收线速度
    private String surface;//表面

    //退火
    private String payingOff;//放线
    private String straightLine;//直线

    //绕线
    private Integer totalLength;//总长度
    private BigDecimal netWeightgSum;//总净重g

    private Integer deleteNo;//删除否

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPPPId() {
        return PPPId;
    }

    public void setPPPId(Integer PPPId) {
        this.PPPId = PPPId;
    }

    public Integer getGxId() {
        return gxId;
    }

    public void setGxId(Integer gxId) {
        this.gxId = gxId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getBobbinDetailId() {
        return bobbinDetailId;
    }

    public void setBobbinDetailId(Integer bobbinDetailId) {
        this.bobbinDetailId = bobbinDetailId;
    }

    public BigDecimal getWireDiameterUm() {
        return wireDiameterUm;
    }

    public void setWireDiameterUm(BigDecimal wireDiameterUm) {
        this.wireDiameterUm = wireDiameterUm;
    }

    public BigDecimal getLengthM() {
        return lengthM;
    }

    public void setLengthM(BigDecimal lengthM) {
        this.lengthM = lengthM;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
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

    public String getSlip() {
        return Slip;
    }

    public void setSlip(String slip) {
        Slip = slip;
    }

    public String getTractionSpeed() {
        return tractionSpeed;
    }

    public void setTractionSpeed(String tractionSpeed) {
        this.tractionSpeed = tractionSpeed;
    }

    public String getTakeUpSpeed() {
        return takeUpSpeed;
    }

    public void setTakeUpSpeed(String takeUpSpeed) {
        this.takeUpSpeed = takeUpSpeed;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getPayingOff() {
        return payingOff;
    }

    public void setPayingOff(String payingOff) {
        this.payingOff = payingOff;
    }

    public String getStraightLine() {
        return straightLine;
    }

    public void setStraightLine(String straightLine) {
        this.straightLine = straightLine;
    }

    public Integer getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(Integer totalLength) {
        this.totalLength = totalLength;
    }

    public BigDecimal getNetWeightgSum() {
        return netWeightgSum;
    }

    public void setNetWeightgSum(BigDecimal netWeightgSum) {
        this.netWeightgSum = netWeightgSum;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
