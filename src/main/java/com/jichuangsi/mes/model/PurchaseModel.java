package com.jichuangsi.mes.model;

import java.math.BigDecimal;
import java.util.Date;

public class PurchaseModel {

    private Integer id;//
    private Integer customerId;//供应商ID

    private String customerName;//供应商
    private Integer staffId;//员工ID
    private String staffName;//员工
    private Integer purchasetypeId;//采购类型ID
    private Integer warehouseiId;//仓库ID
    private Date createTime;//开单日期
    private Date finishedTime;//交货日期
    private String purchaseOrder;//采购单号
    private Integer orderStateId;//订单状态(草稿：0,  订单审核(待审核):1,  订单审核(审核中):2 订单审核(未通过)    来料检验(待检验):2,已完成:3,退回中:4,已退回:5)    待检验，待入库，待确认，退回中，已退回等)
    //  草稿：0   订单审核(待审核):1   订单审核(审核中):2
    //  订单审核(已通过) == 来料检验(待检验) ：3
    //  来料检验(检验中) :4
    //  来料检验(已通过) == 待入库 :5
    //  来料检验(未通过)  == 退回:7
    //  来料检验(未通过)  == 退回中:8
    //  订单结束(已完成):9

    private String orderState;//订单状态(草稿：0,订单审核:1,来料检验:2,已完成:3,退回中:4,已退回:5)    待检验，待入库，待确认，退回中，已退回等)
    private String checkState;//检验结果(未检验，检验中，未通过，已通过等)
    private Integer paytypeId;//付款方式(现金微信支付宝等)
    private String remark;
    private Integer deleteNo;

    private BigDecimal orderSum;//订单总金额

    public BigDecimal getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(BigDecimal orderSum) {
        this.orderSum = orderSum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Integer getPurchasetypeId() {
        return purchasetypeId;
    }

    public void setPurchasetypeId(Integer purchasetypeId) {
        this.purchasetypeId = purchasetypeId;
    }

    public Integer getWarehouseiId() {
        return warehouseiId;
    }

    public void setWarehouseiId(Integer warehouseiId) {
        this.warehouseiId = warehouseiId;
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

    public String getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(String purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public Integer getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(Integer orderStateId) {
        this.orderStateId = orderStateId;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState;
    }

    public Integer getPaytypeId() {
        return paytypeId;
    }

    public void setPaytypeId(Integer paytypeId) {
        this.paytypeId = paytypeId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
