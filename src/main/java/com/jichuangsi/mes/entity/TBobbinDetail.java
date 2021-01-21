package com.jichuangsi.mes.entity;


import javax.persistence.*;
import java.math.BigDecimal;

//库存线轴明细
@Entity
@Table(name = "t_bobbinDetail")
public class TBobbinDetail {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private Integer standardId;//线轴id
    private String axisNumber;//轴号
    private BigDecimal newBobbinWeight;// 最新轴重
    private Integer state;//状态
    private Integer deleteNo;//删除否

    public Integer getStandardId() {
        return standardId;
    }

    public void setStandardId(Integer standardId) {
        this.standardId = standardId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
