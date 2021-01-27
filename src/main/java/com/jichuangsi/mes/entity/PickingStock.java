package com.jichuangsi.mes.entity;


import javax.persistence.*;

//生产领料原料表
@Entity
@Table(name = "picking_stock")
public class PickingStock {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//生产领料原料ID
    private Integer PPIId;//生产领料id
    private Integer inventoryStatusId;//库存原料ID
    private Integer warehourseId;//仓库ID
    private Integer quantityChoose;//选择数量
    private Integer totalNet;//净数g = 选择的数量
    private Integer deleteNo;//删除否


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPPIId() {
        return PPIId;
    }

    public void setPPIId(Integer PPIId) {
        this.PPIId = PPIId;
    }

    public Integer getInventoryStatusId() {
        return inventoryStatusId;
    }

    public void setInventoryStatusId(Integer inventoryStatusId) {
        this.inventoryStatusId = inventoryStatusId;
    }

    public Integer getWarehourseId() {
        return warehourseId;
    }

    public void setWarehourseId(Integer warehourseId) {
        this.warehourseId = warehourseId;
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
