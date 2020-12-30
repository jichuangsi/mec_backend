package com.jichuangsi.mes.entity;


import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 原料配比表
 */
@Entity
@Table(name = "rawmaterial_ratio")
public class RawMaterialRatio {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private Integer stock_id;//原料Id
    private Integer productId;//产品ID
    private BigDecimal ratiostart;//原料配比start
    private BigDecimal ratioend;//原料配比end
    private Integer deleteNo;

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStock_id() {
        return stock_id;
    }

    public void setStock_id(Integer stock_id) {
        this.stock_id = stock_id;
    }

    public BigDecimal getRatiostart() {
        return ratiostart;
    }

    public void setRatiostart(BigDecimal ratiostart) {
        this.ratiostart = ratiostart;
    }

    public BigDecimal getRatioend() {
        return ratioend;
    }

    public void setRatioend(BigDecimal ratioend) {
        this.ratioend = ratioend;
    }
}
