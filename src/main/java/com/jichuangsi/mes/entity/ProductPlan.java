package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 生产计划单
 */
@Entity
@Table(name = "product_plan")
public class ProductPlan {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//生产计划ID
    private String ppNumber;//生产计划单号
    private String ppName;//计划单名称
    private Date createTime;//下达时间
    private Date finishedTime;//完工时间
    private Integer SuitId;//套模方案ID
    private Integer SaleId;//关联销售订单ID(允许为空，为空则不关联)
    private Integer relationNo;//关联销售订单否
    private Integer ppPlanState;//生产计划单状态 0（草稿，未提交） 1（提交审核，待审核） 2审核中 3已通过
//    private Integer state;//状态
    private Integer deleteNo;//删除否

    public Integer getPpPlanState() {
        return ppPlanState;
    }

    public void setPpPlanState(Integer ppPlanState) {
        this.ppPlanState = ppPlanState;
    }

    public Integer getRelationNo() {
        return relationNo;
    }

    public void setRelationNo(Integer relationNo) {
        this.relationNo = relationNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPpNumber() {
        return ppNumber;
    }

    public void setPpNumber(String ppNumber) {
        this.ppNumber = ppNumber;
    }

    public String getPpName() {
        return ppName;
    }

    public void setPpName(String ppName) {
        this.ppName = ppName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Date finishedTime) {
        this.finishedTime = finishedTime;
    }

    public Integer getSuitId() {
        return SuitId;
    }

    public void setSuitId(Integer suitId) {
        SuitId = suitId;
    }

    public Integer getSaleId() {
        return SaleId;
    }

    public void setSaleId(Integer saleId) {
        SaleId = saleId;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
