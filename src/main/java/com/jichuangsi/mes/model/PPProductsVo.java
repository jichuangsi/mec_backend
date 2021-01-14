package com.jichuangsi.mes.model;

import java.math.BigDecimal;
import java.sql.Date;

//查询统计需要
public class PPProductsVo {

    private Integer id;//产物id
    private Integer pppId;//生产ID
    private Integer teamId;//班组id
    private Date createTime;//创建时间
    private String productionNumber;//生产批号（年+月+日+当天第几个+产品型号）
    private String ppNumber;//生产计划单号
    private String xbName;//线别名称
    private String teamName;//班组名称
    private String productModel;//产品型号


    private String productDate;//时间
    private BigDecimal incomeHeavy;//来料重
    private BigDecimal finishEdP;//成品g
    private BigDecimal wastageg;//废料g
    private BigDecimal lossg;//损耗g
    private BigDecimal netWeightgRate;//成品率
    private BigDecimal wastagegRate;//废料率
    private BigDecimal lossgRate;//损耗率

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPppId() {
        return pppId;
    }

    public void setPppId(Integer pppId) {
        this.pppId = pppId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProductionNumber() {
        return productionNumber;
    }

    public void setProductionNumber(String productionNumber) {
        this.productionNumber = productionNumber;
    }

    public String getPpNumber() {
        return ppNumber;
    }

    public void setPpNumber(String ppNumber) {
        this.ppNumber = ppNumber;
    }

    public String getXbName() {
        return xbName;
    }

    public void setXbName(String xbName) {
        this.xbName = xbName;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public BigDecimal getIncomeHeavy() {
        return incomeHeavy;
    }

    public void setIncomeHeavy(BigDecimal incomeHeavy) {
        this.incomeHeavy = incomeHeavy;
    }

    public BigDecimal getFinishEdP() {
        return finishEdP;
    }

    public void setFinishEdP(BigDecimal finishEdP) {
        this.finishEdP = finishEdP;
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

    public BigDecimal getNetWeightgRate() {
        return netWeightgRate;
    }

    public void setNetWeightgRate(BigDecimal netWeightgRate) {
        this.netWeightgRate = netWeightgRate;
    }

    public BigDecimal getWastagegRate() {
        return wastagegRate;
    }

    public void setWastagegRate(BigDecimal wastagegRate) {
        this.wastagegRate = wastagegRate;
    }

    public BigDecimal getLossgRate() {
        return lossgRate;
    }

    public void setLossgRate(BigDecimal lossgRate) {
        this.lossgRate = lossgRate;
    }
}
