package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 生产管理
 */
@Entity
@Table(name = "pp_production")
public class PPProduction {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//生产管理
    private Integer Fid;//生产管理上班id
    private Integer NGXId;//转下班的工序
    private String productionNumber;//生产批号（年+月+日+当天第几个+产品型号）

    private Integer finishNum;//实际生产数量(米)
    private Integer pproductId;//生产计划单-产物id

    private Integer suitId;//套模id

//    熔炼的时候的数据
    private BigDecimal moldTemp;//铸造温度℃
    private Integer towTime;//牵引时间min
    private Integer towParameters;//牵引参数
    private Integer stopTime;//停止时间 min
    private BigDecimal waterTemp;//水温℃

    //    中拉的时候的数据
    private BigDecimal compressionRate12 ;//1~2轴压缩率%
    private BigDecimal compressionRate34 ;//3~4轴压缩率%
    private BigDecimal elongationRate;//延伸率
    private BigDecimal lineSpacing;//排线间距mm
    private BigDecimal drawingSpeed;//拉丝速度

//    成品时候的数据
    private BigDecimal slipRate;//滑动率%(中拉的时候也有)
    private BigDecimal speedM;//速度m/s
    private BigDecimal payTension;//放线张力
    private BigDecimal PV;//PV

    private Integer equipmentId;//设备id
    private Integer staffId;//员工id
    private Integer teamId;//班组id
    private Integer frequency;//班次id （1 白班 2夜班）

    private Integer GXId;//工序类型(1熔炼 2粗拉 3中拉 4半成品(细拉) 5成品(超细拉) 6 中间退火 7成品退火 8绕线 9成品改绕)
    private String gxName;//工序类型名称
    private Integer state;//完成情况 (0 草稿 未完成 1 转下班 已完成 2 重复当前工序)
    private Date createTime;//创建时间
    private Integer deleteNo;//删除否


    public Integer getNGXId() {
        return NGXId;
    }

    public void setNGXId(Integer NGXId) {
        this.NGXId = NGXId;
    }

    public BigDecimal getCompressionRate12() {
        return compressionRate12;
    }

    public void setCompressionRate12(BigDecimal compressionRate12) {
        this.compressionRate12 = compressionRate12;
    }

    public BigDecimal getCompressionRate34() {
        return compressionRate34;
    }

    public void setCompressionRate34(BigDecimal compressionRate34) {
        this.compressionRate34 = compressionRate34;
    }

    public BigDecimal getElongationRate() {
        return elongationRate;
    }

    public void setElongationRate(BigDecimal elongationRate) {
        this.elongationRate = elongationRate;
    }

    public BigDecimal getLineSpacing() {
        return lineSpacing;
    }

    public void setLineSpacing(BigDecimal lineSpacing) {
        this.lineSpacing = lineSpacing;
    }

    public BigDecimal getDrawingSpeed() {
        return drawingSpeed;
    }

    public void setDrawingSpeed(BigDecimal drawingSpeed) {
        this.drawingSpeed = drawingSpeed;
    }

    public String getGxName() {
        return gxName;
    }

    public void setGxName(String gxName) {
        this.gxName = gxName;
    }

    public Integer getFid() {
        return Fid;
    }

    public void setFid(Integer fid) {
        Fid = fid;
    }

    public BigDecimal getSlipRate() {
        return slipRate;
    }

    public void setSlipRate(BigDecimal slipRate) {
        this.slipRate = slipRate;
    }

    public BigDecimal getSpeedM() {
        return speedM;
    }

    public void setSpeedM(BigDecimal speedM) {
        this.speedM = speedM;
    }

    public BigDecimal getPayTension() {
        return payTension;
    }

    public void setPayTension(BigDecimal payTension) {
        this.payTension = payTension;
    }

    public BigDecimal getPV() {
        return PV;
    }

    public void setPV(BigDecimal PV) {
        this.PV = PV;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductionNumber() {
        return productionNumber;
    }

    public void setProductionNumber(String productionNumber) {
        this.productionNumber = productionNumber;
    }

    public Integer getFinishNum() {
        return finishNum;
    }

    public void setFinishNum(Integer finishNum) {
        this.finishNum = finishNum;
    }

    public Integer getPproductId() {
        return pproductId;
    }

    public void setPproductId(Integer pproductId) {
        this.pproductId = pproductId;
    }

    public Integer getSuitId() {
        return suitId;
    }

    public void setSuitId(Integer suitId) {
        this.suitId = suitId;
    }

    public BigDecimal getMoldTemp() {
        return moldTemp;
    }

    public void setMoldTemp(BigDecimal moldTemp) {
        this.moldTemp = moldTemp;
    }

    public Integer getTowTime() {
        return towTime;
    }

    public void setTowTime(Integer towTime) {
        this.towTime = towTime;
    }

    public Integer getTowParameters() {
        return towParameters;
    }

    public void setTowParameters(Integer towParameters) {
        this.towParameters = towParameters;
    }

    public Integer getStopTime() {
        return stopTime;
    }

    public void setStopTime(Integer stopTime) {
        this.stopTime = stopTime;
    }

    public BigDecimal getWaterTemp() {
        return waterTemp;
    }

    public void setWaterTemp(BigDecimal waterTemp) {
        this.waterTemp = waterTemp;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Integer getGXId() {
        return GXId;
    }

    public void setGXId(Integer GXId) {
        this.GXId = GXId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
