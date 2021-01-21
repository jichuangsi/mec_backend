package com.jichuangsi.mes.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

//库存线轴-历史轴重数据
@Entity
@Table(name = "t_bobbinHistory")
public class TBobbinHistory {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private Integer bobbinDetailId;//线轴明细id
    private Date createTime;//更新时间
    private BigDecimal historyBobbinWeight;// 最新轴重


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBobbinDetailId() {
        return bobbinDetailId;
    }

    public void setBobbinDetailId(Integer bobbinDetailId) {
        this.bobbinDetailId = bobbinDetailId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getHistoryBobbinWeight() {
        return historyBobbinWeight;
    }

    public void setHistoryBobbinWeight(BigDecimal historyBobbinWeight) {
        this.historyBobbinWeight = historyBobbinWeight;
    }
}
