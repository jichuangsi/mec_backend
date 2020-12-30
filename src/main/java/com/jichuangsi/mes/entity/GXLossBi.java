package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 各工序环节损耗比率
 */
@Entity
@Table(name = "gx_lossbi")
public class GXLossBi {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private Integer GXid;//工序Id
    private Integer productId;//产品ID
    private BigDecimal cpstart;//成品率
    private BigDecimal cpend;//成品率
    private BigDecimal fpstart;//废品率
    private BigDecimal fpend;//废品率
    private BigDecimal lossstart;//损耗率
    private BigDecimal lossend;//损耗率
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

    public Integer getGXid() {
        return GXid;
    }

    public void setGXid(Integer GXid) {
        this.GXid = GXid;
    }

    public BigDecimal getCpstart() {
        return cpstart;
    }

    public void setCpstart(BigDecimal cpstart) {
        this.cpstart = cpstart;
    }

    public BigDecimal getCpend() {
        return cpend;
    }

    public void setCpend(BigDecimal cpend) {
        this.cpend = cpend;
    }

    public BigDecimal getFpstart() {
        return fpstart;
    }

    public void setFpstart(BigDecimal fpstart) {
        this.fpstart = fpstart;
    }

    public BigDecimal getFpend() {
        return fpend;
    }

    public void setFpend(BigDecimal fpend) {
        this.fpend = fpend;
    }

    public BigDecimal getLossstart() {
        return lossstart;
    }

    public void setLossstart(BigDecimal lossstart) {
        this.lossstart = lossstart;
    }

    public BigDecimal getLossend() {
        return lossend;
    }

    public void setLossend(BigDecimal lossend) {
        this.lossend = lossend;
    }
}
