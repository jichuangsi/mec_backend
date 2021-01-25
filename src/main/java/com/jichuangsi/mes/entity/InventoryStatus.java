package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 库存状况表
 */
@Entity
@Table(name = "inventory_status")
public class InventoryStatus {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//库存状况Id
    private Integer productId;//产品ID /
    private Integer pppId;//生产id

    private String stockName;//名称
    private String stockModel;//模型
    private String stockNumber;//编号
    private String standards;//规格
    private Integer unitId;//单位

    private Integer warehouseId;//仓库ID
    private Integer inventorysum;//库存总数
    private BigDecimal inventorynumbers;//库存数量
//    private Integer recordType;//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购 6销售退回等)
    private Integer inventoryType;//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他 )


    private Integer state;//状态 （0 最新 1不是最新）
    private Integer deleteNo;//删除否(0 未删除、有用的  1已删除、没有用的)

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }

    public Integer getInventorysum() {
        return inventorysum;
    }

    public void setInventorysum(Integer inventorysum) {
        this.inventorysum = inventorysum;
    }

    public Integer getPppId() {
        return pppId;
    }

    public void setPppId(Integer pppId) {
        this.pppId = pppId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
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

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(Integer inventoryType) {
        this.inventoryType = inventoryType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }



    public BigDecimal getInventorynumbers() {
        return inventorynumbers;
    }

    public void setInventorynumbers(BigDecimal inventorynumbers) {
        this.inventorynumbers = inventorynumbers;
    }
}
