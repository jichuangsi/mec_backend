package com.jichuangsi.mes.entity;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_saleDelivery_record")
public class SaleDeliveryRecord {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private Integer saleOrderId;//销售id
    private Integer inventoryStautsId;//库存id
    private String stockModel;//模型
    private String stockNumber;//编号
    private String updateRemark;//线轴
    private String standards;//长度m
    private BigDecimal pageNum;//改变数量

    public String getUpdateRemark() {
        return updateRemark;
    }

    public void setUpdateRemark(String updateRemark) {
        this.updateRemark = updateRemark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(Integer saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    public Integer getInventoryStautsId() {
        return inventoryStautsId;
    }

    public void setInventoryStautsId(Integer inventoryStautsId) {
        this.inventoryStautsId = inventoryStautsId;
    }

    public String getStockModel() {
        return stockModel;
    }

    public void setStockModel(String stockModel) {
        this.stockModel = stockModel;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public String getStandards() {
        return standards;
    }

    public void setStandards(String standards) {
        this.standards = standards;
    }

    public BigDecimal getPageNum() {
        return pageNum;
    }

    public void setPageNum(BigDecimal pageNum) {
        this.pageNum = pageNum;
    }
}
