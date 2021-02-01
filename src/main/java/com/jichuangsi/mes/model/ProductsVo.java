package com.jichuangsi.mes.model;

import java.math.BigDecimal;
import java.util.Date;

public class ProductsVo {

    private Integer id;//熔炼产物ID
    private Integer PPPId;//生产id
    private Integer LPPId;//领料的生产id
    private Integer gxId;//工序id
    private Integer Fid;//上级id（默认0）
    private String gxName;//工序名称
    private Date createTime;//生产时间

    private Integer bobbinDetailId;//线轴规格id
    private String bobbinName;//线轴名称
    private String standards;//规格(1g2g等)
    private BigDecimal wireDiameterUm;//线径um
    private BigDecimal lengthM;//长度m/轴

    private String axleNumber ;//轴号
    private BigDecimal axleloadWeight ;//轴重g
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
    private Integer numbers;//数量
    private Integer flatCable;//排线
    private Integer tension;//张力
    private BigDecimal oddmentsG;//余料g
    private BigDecimal totalLength;//总长度（长度*数量）
    private BigDecimal netWeightgSum;//总净重g(净重*数量)


    private String windingProcedure ;//绕线程序
    private String tensionProgram ;//张力程序
    private BigDecimal elongation;//延伸率%
    private String breakingForce ;//拉断力cN
    private String bobbinType;//线轴类型
    private BigDecimal bobbindiameter;//线轴直径
    private String bobbinColor;//线轴颜色
    private String identification;//首尾标识


    private Integer state;//使用否 0否 1是（默认0）

    private Integer deleteNo;//删除否

    public String getWindingProcedure() {
        return windingProcedure;
    }

    public void setWindingProcedure(String windingProcedure) {
        this.windingProcedure = windingProcedure;
    }

    public String getTensionProgram() {
        return tensionProgram;
    }

    public void setTensionProgram(String tensionProgram) {
        this.tensionProgram = tensionProgram;
    }

    public BigDecimal getElongation() {
        return elongation;
    }

    public void setElongation(BigDecimal elongation) {
        this.elongation = elongation;
    }

    public String getBreakingForce() {
        return breakingForce;
    }

    public void setBreakingForce(String breakingForce) {
        this.breakingForce = breakingForce;
    }

    public String getBobbinType() {
        return bobbinType;
    }

    public void setBobbinType(String bobbinType) {
        this.bobbinType = bobbinType;
    }

    public BigDecimal getBobbindiameter() {
        return bobbindiameter;
    }

    public void setBobbindiameter(BigDecimal bobbindiameter) {
        this.bobbindiameter = bobbindiameter;
    }

    public String getBobbinColor() {
        return bobbinColor;
    }

    public void setBobbinColor(String bobbinColor) {
        this.bobbinColor = bobbinColor;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public Integer getLPPId() {
        return LPPId;
    }

    public void setLPPId(Integer LPPId) {
        this.LPPId = LPPId;
    }

    public String getAxleNumber() {
        return axleNumber;
    }

    public void setAxleNumber(String axleNumber) {
        this.axleNumber = axleNumber;
    }

    public BigDecimal getAxleloadWeight() {
        return axleloadWeight;
    }

    public void setAxleloadWeight(BigDecimal axleloadWeight) {
        this.axleloadWeight = axleloadWeight;
    }

    public Integer getFid() {
        return Fid;
    }

    public void setFid(Integer fid) {
        Fid = fid;
    }

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

    public String getGxName() {
        return gxName;
    }

    public void setGxName(String gxName) {
        this.gxName = gxName;
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

    public String getBobbinName() {
        return bobbinName;
    }

    public void setBobbinName(String bobbinName) {
        this.bobbinName = bobbinName;
    }

    public String getStandards() {
        return standards;
    }

    public void setStandards(String standards) {
        this.standards = standards;
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

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }

    public Integer getFlatCable() {
        return flatCable;
    }

    public void setFlatCable(Integer flatCable) {
        this.flatCable = flatCable;
    }

    public Integer getTension() {
        return tension;
    }

    public void setTension(Integer tension) {
        this.tension = tension;
    }

    public BigDecimal getOddmentsG() {
        return oddmentsG;
    }

    public void setOddmentsG(BigDecimal oddmentsG) {
        this.oddmentsG = oddmentsG;
    }

    public BigDecimal getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(BigDecimal totalLength) {
        this.totalLength = totalLength;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
