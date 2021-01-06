package com.jichuangsi.mes.entity;


import javax.persistence.*;

//抽样检验报告明细
@Entity
@Table(name = "t_samplingReportDetail")
public class TSamplingReportDetail {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//id

    private Integer samplingRId;//抽样检验id

    private String wireUm;//线径um
    private String lengthM;//长度m
    private String samplingUm;//检验直径um
    private String surface;//表面
    private String settingOut;//放线
    private String straightLine;//直线


    private Integer qualifiedNo;//合格否

    public String getWireUm() {
        return wireUm;
    }

    public void setWireUm(String wireUm) {
        this.wireUm = wireUm;
    }

    public String getLengthM() {
        return lengthM;
    }

    public void setLengthM(String lengthM) {
        this.lengthM = lengthM;
    }

    public String getSamplingUm() {
        return samplingUm;
    }

    public void setSamplingUm(String samplingUm) {
        this.samplingUm = samplingUm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSamplingRId() {
        return samplingRId;
    }

    public void setSamplingRId(Integer samplingRId) {
        this.samplingRId = samplingRId;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getSettingOut() {
        return settingOut;
    }

    public void setSettingOut(String settingOut) {
        this.settingOut = settingOut;
    }

    public String getStraightLine() {
        return straightLine;
    }

    public void setStraightLine(String straightLine) {
        this.straightLine = straightLine;
    }

    public Integer getQualifiedNo() {
        return qualifiedNo;
    }

    public void setQualifiedNo(Integer qualifiedNo) {
        this.qualifiedNo = qualifiedNo;
    }
}
