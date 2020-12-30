package com.jichuangsi.mes.model;

import java.util.Date;

public class SCustomerModel {
    private Integer id;
    private String customerName;//名称
    private String customerNumber;//编号
    private String address;//地址
    private String contactsMan;//联系人
    private String contactsPost;//联系人职称
    private String contactsPhone;//联系手机
    private String landline;//座机
    private String eMails;//电子邮件
    private String Fax;//传真
    private Integer clientNo;//客户否(0 供应商 1客户:客户才有明细)
    private Integer state;//状态
    private long createTime= new Date().getTime();//新增时间
    private String remark;
    private Integer deleteNo;//删除否


    private Integer staffId;//新增的员工Id
    private String staffName;//员工名字

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String geteMails() {
        return eMails;
    }

    public void seteMails(String eMails) {
        this.eMails = eMails;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String fax) {
        Fax = fax;
    }

    public Integer getClientNo() {
        return clientNo;
    }

    public void setClientNo(Integer clientNo) {
        this.clientNo = clientNo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
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
}
