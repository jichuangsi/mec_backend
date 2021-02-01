package com.jichuangsi.mes.model;

import java.math.BigDecimal;

public class TBobbinDetailVo {

    private Integer id;
    private Integer standardId;//线轴id
    private String axisNumber;//轴号
    private BigDecimal newBobbinWeight;// 最新轴重


    private BigDecimal BobbinWeight1;// 近1次
    private BigDecimal BobbinWeight2;// 近2次
    private BigDecimal BobbinWeight3;// 近3次
    private BigDecimal BobbinWeight4;// 近4次
    private BigDecimal BobbinWeight5;// 近5次

    private Integer state;//状态
    private Integer deleteNo;//删除否

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStandardId() {
        return standardId;
    }

    public void setStandardId(Integer standardId) {
        this.standardId = standardId;
    }

    public String getAxisNumber() {
        return axisNumber;
    }

    public void setAxisNumber(String axisNumber) {
        this.axisNumber = axisNumber;
    }

    public BigDecimal getNewBobbinWeight() {
        return newBobbinWeight;
    }

    public void setNewBobbinWeight(BigDecimal newBobbinWeight) {
        this.newBobbinWeight = newBobbinWeight;
    }

    public BigDecimal getBobbinWeight1() {
        return BobbinWeight1;
    }

    public void setBobbinWeight1(BigDecimal bobbinWeight1) {
        BobbinWeight1 = bobbinWeight1;
    }

    public BigDecimal getBobbinWeight2() {
        return BobbinWeight2;
    }

    public void setBobbinWeight2(BigDecimal bobbinWeight2) {
        BobbinWeight2 = bobbinWeight2;
    }

    public BigDecimal getBobbinWeight3() {
        return BobbinWeight3;
    }

    public void setBobbinWeight3(BigDecimal bobbinWeight3) {
        BobbinWeight3 = bobbinWeight3;
    }

    public BigDecimal getBobbinWeight4() {
        return BobbinWeight4;
    }

    public void setBobbinWeight4(BigDecimal bobbinWeight4) {
        BobbinWeight4 = bobbinWeight4;
    }

    public BigDecimal getBobbinWeight5() {
        return BobbinWeight5;
    }

    public void setBobbinWeight5(BigDecimal bobbinWeight5) {
        BobbinWeight5 = bobbinWeight5;
    }

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
}
