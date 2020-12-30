package com.jichuangsi.mes.entity;

import javax.persistence.*;

//熔炼原料表
@Entity
@Table(name = "production_stock")
public class ProductionStock {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//熔炼原料ID
    private Integer PPPId;//生产id
    private Integer inventoryStatusId;//库存原料ID
    private Integer quantityChoose;//选择数量
    private Integer totalNet;//总净数g
    private Integer deleteNo;//删除否

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPPPId() {
        return PPPId;
    }

    public void setPPPId(Integer PPPId) {
        this.PPPId = PPPId;
    }

    public Integer getInventoryStatusId() {
        return inventoryStatusId;
    }

    public void setInventoryStatusId(Integer inventoryStatusId) {
        this.inventoryStatusId = inventoryStatusId;
    }

    public Integer getQuantityChoose() {
        return quantityChoose;
    }

    public void setQuantityChoose(Integer quantityChoose) {
        this.quantityChoose = quantityChoose;
    }

    public Integer getTotalNet() {
        return totalNet;
    }

    public void setTotalNet(Integer totalNet) {
        this.totalNet = totalNet;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
