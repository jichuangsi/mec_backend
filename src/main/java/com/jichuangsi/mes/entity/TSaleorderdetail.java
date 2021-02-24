package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_saleorderdetail")
public class TSaleorderdetail {

//    合计(数量)：长度*数量
//    合计（元）：长度*单价
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//
    private Integer saleorderId;//销售订单id
    private Integer productId;//产品id
//    private Integer unitId;//单位Id
    private BigDecimal lengthM;//长度/(m/轴)
    private Integer productNum;//数量(轴)
    private BigDecimal productPrice;//单价
    private String remark;//备注
    private Integer finished;//完成否
    private Integer deleteNo;

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

    public BigDecimal getLengthM() {
        return lengthM;
    }

    public void setLengthM(BigDecimal lengthM) {
        this.lengthM = lengthM;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSaleorderId() {
        return saleorderId;
    }

    public void setSaleorderId(Integer saleorderId) {
        this.saleorderId = saleorderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
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
