package com.jichuangsi.mes.entity;

import javax.persistence.*;

/**
 * 生产计划单-产量统计
 */
@Entity
@Table(name = "pp_outputstatistics")
public class PPOutputStatistics {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//产量统计id
    private Integer ppId;//生产计划ID
    private String ppNumber;//生产批号
    private Integer wireCompleteNum;//拉丝完成轴数
    private Integer wireNoCompleteNum;//拉丝未完成轴数

    private Integer AnnealingCompleteNum;//退火完成轴数
    private Integer AnnealingNoCompleteNum;//退火未完成轴数
    private Integer WindingCompleteNum;//绕线完成轴数
    private Integer WindingNoCompleteNum;//绕线未完成轴数

    private Integer CheckNum;//检验轴数
    private Integer CheckQualifiedNum;//检验合格轴数
    private Integer CheckNoQualifiedNum;//检验不合格轴数

    public String getPpNumber() {
        return ppNumber;
    }

    public void setPpNumber(String ppNumber) {
        this.ppNumber = ppNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    public Integer getWireCompleteNum() {
        return wireCompleteNum;
    }

    public void setWireCompleteNum(Integer wireCompleteNum) {
        this.wireCompleteNum = wireCompleteNum;
    }

    public Integer getWireNoCompleteNum() {
        return wireNoCompleteNum;
    }

    public void setWireNoCompleteNum(Integer wireNoCompleteNum) {
        this.wireNoCompleteNum = wireNoCompleteNum;
    }

    public Integer getAnnealingCompleteNum() {
        return AnnealingCompleteNum;
    }

    public void setAnnealingCompleteNum(Integer annealingCompleteNum) {
        AnnealingCompleteNum = annealingCompleteNum;
    }

    public Integer getAnnealingNoCompleteNum() {
        return AnnealingNoCompleteNum;
    }

    public void setAnnealingNoCompleteNum(Integer annealingNoCompleteNum) {
        AnnealingNoCompleteNum = annealingNoCompleteNum;
    }

    public Integer getWindingCompleteNum() {
        return WindingCompleteNum;
    }

    public void setWindingCompleteNum(Integer windingCompleteNum) {
        WindingCompleteNum = windingCompleteNum;
    }

    public Integer getWindingNoCompleteNum() {
        return WindingNoCompleteNum;
    }

    public void setWindingNoCompleteNum(Integer windingNoCompleteNum) {
        WindingNoCompleteNum = windingNoCompleteNum;
    }

    public Integer getCheckNum() {
        return CheckNum;
    }

    public void setCheckNum(Integer checkNum) {
        CheckNum = checkNum;
    }

    public Integer getCheckQualifiedNum() {
        return CheckQualifiedNum;
    }

    public void setCheckQualifiedNum(Integer checkQualifiedNum) {
        CheckQualifiedNum = checkQualifiedNum;
    }

    public Integer getCheckNoQualifiedNum() {
        return CheckNoQualifiedNum;
    }

    public void setCheckNoQualifiedNum(Integer checkNoQualifiedNum) {
        CheckNoQualifiedNum = checkNoQualifiedNum;
    }
}
