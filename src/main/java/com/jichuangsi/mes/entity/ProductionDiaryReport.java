package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 生产日报汇总表
 */
@Entity
@Table(name = "pp_productionDiary_report")
public class ProductionDiaryReport {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private String productDate;//生产日期
    private String ppNumber;//生产计划单号
    private String productionNumber;//生产批号（年+月+日+当天第几个+产品型号）


    private String productModel;//产品型号
    private Integer incomeHeavy;//来料重g （在新增熔炼的时候产生）
    private Integer numbers;//数量

    private BigDecimal noFinishEdP;//半成品g
    private BigDecimal finishEdP;//成品g
    private BigDecimal loss;//损耗g
    private BigDecimal waste;//废料g


    private BigDecimal totalNet;//线上合计g

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public String getPpNumber() {
        return ppNumber;
    }

    public void setPpNumber(String ppNumber) {
        this.ppNumber = ppNumber;
    }

    public String getProductionNumber() {
        return productionNumber;
    }

    public void setProductionNumber(String productionNumber) {
        this.productionNumber = productionNumber;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public Integer getIncomeHeavy() {
        return incomeHeavy;
    }

    public void setIncomeHeavy(Integer incomeHeavy) {
        this.incomeHeavy = incomeHeavy;
    }

    public BigDecimal getNoFinishEdP() {
        return noFinishEdP;
    }

    public void setNoFinishEdP(BigDecimal noFinishEdP) {
        this.noFinishEdP = noFinishEdP;
    }

    public BigDecimal getFinishEdP() {
        return finishEdP;
    }

    public void setFinishEdP(BigDecimal finishEdP) {
        this.finishEdP = finishEdP;
    }

    public BigDecimal getLoss() {
        return loss;
    }

    public void setLoss(BigDecimal loss) {
        this.loss = loss;
    }

    public BigDecimal getWaste() {
        return waste;
    }

    public void setWaste(BigDecimal waste) {
        this.waste = waste;
    }

    public BigDecimal getTotalNet() {
        return totalNet;
    }

    public void setTotalNet(BigDecimal totalNet) {
        this.totalNet = totalNet;
    }
}
