package com.jichuangsi.mes.entity;


import javax.persistence.*;
import java.util.Date;

//包装
@Entity
@Table(name = "t_packing")
public class TPacking {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//包装id
    private String packingName;//包装编号
    private Date createTime;//生产日期
    private Date qualityTime;//保质期
    private String stock;//原材料
    private String cartonsNumber;//装盒数量


    private String productids;//关联的库存产品

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPackingName() {
        return packingName;
    }

    public void setPackingName(String packingName) {
        this.packingName = packingName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getQualityTime() {
        return qualityTime;
    }

    public void setQualityTime(Date qualityTime) {
        this.qualityTime = qualityTime;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getCartonsNumber() {
        return cartonsNumber;
    }

    public void setCartonsNumber(String cartonsNumber) {
        this.cartonsNumber = cartonsNumber;
    }

    public String getProductids() {
        return productids;
    }

    public void setProductids(String productids) {
        this.productids = productids;
    }
}
