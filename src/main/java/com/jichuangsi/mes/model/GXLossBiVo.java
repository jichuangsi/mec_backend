package com.jichuangsi.mes.model;

import java.math.BigDecimal;

//存在表GXLossBi 、RawMaterialRatio
public class GXLossBiVo {

    private Integer id;
    private Integer GXid;//工序Id/原料Id
    private String Name;//工序名称/原料名称
    private Integer productId;//产品ID
    private BigDecimal cpstart;//成品率
    private BigDecimal cpend;//成品率
    private BigDecimal fpstart;//废品率
    private BigDecimal fpend;//废品率
    private BigDecimal lossstart;//损耗率
    private BigDecimal lossend;//损耗率
    private Integer deleteNo;


    private BigDecimal ratiostart;//原料配比start
    private BigDecimal ratioend;//原料配比end

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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
