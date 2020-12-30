package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_prostandard")
public class TProstandard {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//产品规格型号ID
    private Integer productId;//产品ID
    private BigDecimal umStart;//成品直径um
    private BigDecimal milStart;//成品直径mil(此字段为自动换算而成。1mil=25.4um)
    private BigDecimal elStart;//延伸率EL
    private BigDecimal elEnd;//延伸率EL
    private BigDecimal blStart;//拉断力BL(CN)
    private BigDecimal blEend;//拉断力BL(CN)
    private BigDecimal coarseStart;//粗拉直径um
    private BigDecimal coarseEnd;//粗拉直径um
    private BigDecimal diamStart;//中拉直径um
    private BigDecimal diamEnd;//中拉直径um
    private BigDecimal semiStart;//半成品直径um
    private BigDecimal semiEnd;//半成品直径um
    private Integer deleteNo;

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

    public BigDecimal getUmStart() {
        return umStart;
    }

    public void setUmStart(BigDecimal umStart) {
        this.umStart = umStart;
    }

    public BigDecimal getMilStart() {
        return milStart;
    }

    public void setMilStart(BigDecimal milStart) {
        this.milStart = milStart;
    }

    public BigDecimal getElStart() {
        return elStart;
    }

    public void setElStart(BigDecimal elStart) {
        this.elStart = elStart;
    }

    public BigDecimal getElEnd() {
        return elEnd;
    }

    public void setElEnd(BigDecimal elEnd) {
        this.elEnd = elEnd;
    }

    public BigDecimal getBlStart() {
        return blStart;
    }

    public void setBlStart(BigDecimal blStart) {
        this.blStart = blStart;
    }

    public BigDecimal getBlEend() {
        return blEend;
    }

    public void setBlEend(BigDecimal blEend) {
        this.blEend = blEend;
    }

    public BigDecimal getCoarseStart() {
        return coarseStart;
    }

    public void setCoarseStart(BigDecimal coarseStart) {
        this.coarseStart = coarseStart;
    }

    public BigDecimal getCoarseEnd() {
        return coarseEnd;
    }

    public void setCoarseEnd(BigDecimal coarseEnd) {
        this.coarseEnd = coarseEnd;
    }

    public BigDecimal getDiamStart() {
        return diamStart;
    }

    public void setDiamStart(BigDecimal diamStart) {
        this.diamStart = diamStart;
    }

    public BigDecimal getDiamEnd() {
        return diamEnd;
    }

    public void setDiamEnd(BigDecimal diamEnd) {
        this.diamEnd = diamEnd;
    }

    public BigDecimal getSemiStart() {
        return semiStart;
    }

    public void setSemiStart(BigDecimal semiStart) {
        this.semiStart = semiStart;
    }

    public BigDecimal getSemiEnd() {
        return semiEnd;
    }

    public void setSemiEnd(BigDecimal semiEnd) {
        this.semiEnd = semiEnd;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
