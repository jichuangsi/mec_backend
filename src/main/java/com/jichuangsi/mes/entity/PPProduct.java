package com.jichuangsi.mes.entity;

import javax.persistence.*;

/**
 * 生产计划单-计划产物表
 */
@Entity
@Table(name = "pp_product")
public class PPProduct {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//计划产物id
    private Integer ppId;//生产计划ID
    private Integer productDetailId;//产品规格ID
    private Double length;//长度
    private Integer quantum;//数量
    private Integer deleteNo;//删除否

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    public Integer getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(Integer productDetailId) {
        this.productDetailId = productDetailId;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Integer getQuantum() {
        return quantum;
    }

    public void setQuantum(Integer quantum) {
        this.quantum = quantum;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
