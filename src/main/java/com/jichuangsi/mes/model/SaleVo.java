package com.jichuangsi.mes.model;

import java.math.BigDecimal;

public class SaleVo {

    private Integer id;//开单ID
    private String createTime;//开单时间
    private String saleOrder;//销售单号
    private Integer customerId;//客户ID
    private String customer;//客户名称
    private BigDecimal orderSum;//订单总金额
    private Integer staffId;//员工ID
    private String staffName;//员工
    private String remark;
    private Integer deleteNo;

    private Integer saleTypeId;//销售类型ID
    private Integer warehouseId;//仓库ID
    private String finishedTime;//交货时间
    private Integer orderStateId;//订单状态(草稿，待检验，待入库，待确认，退回中，已退回等)
    private String payType;//付款方式(现金微信支付宝等)
    private String transportType;//运输方式
    private String receiveAddress;//收货地址

    private String orderStates;//订单状态
    private String checkStates;//审核状态


    private String customerNumber;//编号
    private String contactsMan;//联系人
    private String contactsPost;//联系人职称
    private String contactsPhone;//联系手机

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getContactsMan() {
        return contactsMan;
    }

    public void setContactsMan(String contactsMan) {
        this.contactsMan = contactsMan;
    }

    public String getContactsPost() {
        return contactsPost;
    }

    public void setContactsPost(String contactsPost) {
        this.contactsPost = contactsPost;
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

    public String getOrderStates() {
        return orderStates;
    }

    public void setOrderStates(String orderStates) {
        this.orderStates = orderStates;
    }

    public String getCheckStates() {
        return checkStates;
    }

    public void setCheckStates(String checkStates) {
        this.checkStates = checkStates;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSaleOrder() {
        return saleOrder;
    }

    public void setSaleOrder(String saleOrder) {
        this.saleOrder = saleOrder;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public BigDecimal getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(BigDecimal orderSum) {
        this.orderSum = orderSum;
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

    public Integer getSaleTypeId() {
        return saleTypeId;
    }

    public void setSaleTypeId(Integer saleTypeId) {
        this.saleTypeId = saleTypeId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }


    public String getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(String finishedTime) {
        this.finishedTime = finishedTime;
    }

    public Integer getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(Integer orderStateId) {
        this.orderStateId = orderStateId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }
}
