package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.util.Date;

//日汇总表
@Entity
@Table(name = "t_summaryRecord")
public class SummaryRecord {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private Integer orderId;//采购订单id/销售订单id
    private Integer orderType;//1 采购订单/2 销售订单
    private Date createTime;// 结算时间
    private String settlementAccount ;//结算账户（现金、第三方支付）
    private String amountIncurred;//发生金额

    public String getAmountIncurred() {
        return amountIncurred;
    }

    public void setAmountIncurred(String amountIncurred) {
        this.amountIncurred = amountIncurred;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSettlementAccount() {
        return settlementAccount;
    }

    public void setSettlementAccount(String settlementAccount) {
        this.settlementAccount = settlementAccount;
    }
}
