package com.jichuangsi.mes.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer_detail")
public class CustomerDetail {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private Integer customerId;//客户ID
    private String customerDetailName;//明细名称
    private String remark;
    private Integer deleteNo;//删除否

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

    public String getCustomerDetailName() {
        return customerDetailName;
    }

    public void setCustomerDetailName(String customerDetailName) {
        this.customerDetailName = customerDetailName;
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
