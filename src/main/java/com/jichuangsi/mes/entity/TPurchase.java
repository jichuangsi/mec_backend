package com.jichuangsi.mes.entity;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "t_purchase")
public class TPurchase {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//
    private Integer customerId;//供应商ID
    private Integer staffId;//员工ID
    private Integer purchasetypeId;//采购类型ID
    private Integer warehouseiId;//仓库ID
    private Date createTime;//开单日期
    private Date finishedTime;//交货日期
    private String purchaseOrder;//采购单号
    private Integer orderState;//订单状态(草稿：0,  订单审核(待审核):1,  订单审核(审核中):2 订单审核(未通过)    来料检验(待检验):2,已完成:3,退回中:4,已退回:5)    待检验，待入库，待确认，退回中，已退回等)
                                //  草稿：0   订单审核(待审核):1   订单审核(审核中):2  订单审核(未通过):3
                                //  订单审核(已通过) == 来料检验(待检验) ：4
                                //  来料检验(检验中) :5
                                //  来料检验(已通过) == 待入库 :6
                                //  来料检验(未通过)  == 退回:7
                                //  来料检验(未通过)  == 退回中:8
                                //  订单结束(已完成):9


    //    private Integer orderState;//订单状态(草稿：0,订单审核:1,来料检验:2,已完成:3,退回中:4,已退回:5)    待检验，待入库，待确认，退回中，已退回等)
//    private String checkState;//检验结果(未检验，检验中，未通过，已通过等)
    private Integer paytypeId;//付款方式(现金微信支付宝等)
    private String remark;
    private Integer deleteNo;

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

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
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

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
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
