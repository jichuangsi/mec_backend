package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_purchasedetail")
public class TPurchasedetail {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//采购明细ID
    private Integer purchaseId;//采购开单ID
    private Integer stockId;//原料(规格)ID
    private Integer unitId;//单位ID
    private Integer stockAmount;//数量
    private BigDecimal stockUnitPrice;//单价(元)
//    private BigDecimal stockSum;//总数
    private String remark;
    private Integer deleteNo;

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public BigDecimal getStockUnitPrice() {
        return stockUnitPrice;
    }

    public void setStockUnitPrice(BigDecimal stockUnitPrice) {
        this.stockUnitPrice = stockUnitPrice;
    }

    public Integer getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(Integer stockAmount) {
        this.stockAmount = stockAmount;
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
