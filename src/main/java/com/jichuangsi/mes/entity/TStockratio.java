package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_stockratio")
public class TStockratio {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//
    private Integer stockNumber;//原料配比序号
    private Integer stockId;//原料ID
    private BigDecimal stockRatioStart;//原料比例start
    private BigDecimal stockRatioEnd;//原料比例end
    private String remark;
    private Integer deleteNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public BigDecimal getStockRatioStart() {
        return stockRatioStart;
    }

    public void setStockRatioStart(BigDecimal stockRatioStart) {
        this.stockRatioStart = stockRatioStart;
    }

    public BigDecimal getStockRatioEnd() {
        return stockRatioEnd;
    }

    public void setStockRatioEnd(BigDecimal stockRatioEnd) {
        this.stockRatioEnd = stockRatioEnd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
