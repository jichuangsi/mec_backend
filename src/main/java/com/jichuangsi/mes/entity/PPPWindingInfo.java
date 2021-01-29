package com.jichuangsi.mes.entity;


import javax.persistence.*;
import java.math.BigDecimal;

//待绕线信息
@Entity
@Table(name = "ppp_WindingInfo")
public class PPPWindingInfo {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//产物ID
    private Integer PPPId;//生产id
    private Integer PPPPId;//生产产物id
    private Integer equipmentId;//设备id


    private String windingProcedure ;//绕线程序
    private String tensionProgram ;//张力程序
    private BigDecimal elongation;//延伸率%
    private String breakingForce ;//拉断力cN
    private String bobbinType;//线轴类型
    private BigDecimal bobbindiameter;//线轴直径
    private String bobbinColor;//线轴颜色
    private String identification;//首尾标识

//
//    private Integer tension;//张力
//    private Integer wasteAge;//废料g
//    private Integer cloutG;//余料g
//    private Integer lossG;//损耗g
//    private Integer flatCable;//排线
//    private Integer surface;//表面
//    private Integer settingOut;//放线
//    private Integer straightLine;//直线

    private Integer deleteNo;//删除否

    public Integer getPPPId() {
        return PPPId;
    }

    public void setPPPId(Integer PPPId) {
        this.PPPId = PPPId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPPPPId() {
        return PPPPId;
    }

    public void setPPPPId(Integer PPPPId) {
        this.PPPPId = PPPPId;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

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

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
