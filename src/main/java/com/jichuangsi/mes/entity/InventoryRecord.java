package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 库存记录表
 */
@Entity
@Table(name = "inventory_record")
public class InventoryRecord {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//库存记录Id
    private Integer productDetailid;//产品规格明细Id
    private Integer pppId;//生产id

    private String stockName;//名称
    private String stockModel;//模型
    private String stockNumber;//编号
    private String standards;//规格
    private Integer unitId;//单位

    private Integer warehouseId;//仓库ID
    private Integer recordType;//出入库类型 (1 出库,2 入库，3 调拨，4 销售，5 采购 6盘点 7 生产出库等)
    private long createTime= new Date().getTime();//创建时间
    private String changequantity ;//发生数量
    private Integer surplusquantity;//剩余数量
    private Integer inventoryType;//库存类型(1 原料 2 产品 3半成品 4废料 5线轴  6其他 )
    private String remark;//备注

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductDetailid() {
        return productDetailid;
    }

    public void setProductDetailid(Integer productDetailid) {
        this.productDetailid = productDetailid;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getChangequantity() {
        return changequantity;
    }

    public void setChangequantity(String changequantity) {
        this.changequantity = changequantity;
    }

    public Integer getSurplusquantity() {
        return surplusquantity;
    }

    public void setSurplusquantity(Integer surplusquantity) {
        this.surplusquantity = surplusquantity;
    }

    public Integer getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(Integer inventoryType) {
        this.inventoryType = inventoryType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
