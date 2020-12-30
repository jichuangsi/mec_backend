package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "matters")//办事项
public class Matters {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private long createTime= new Date().getTime();//时间
    private String matterNews;//信息(您有1个生产计划（熔炼）待进行)
    private Integer staffId;//员工Id
    private Integer orderId;//订单Id
    private Integer finishedNo;//完成否
    private Integer deleteNo;//删除否

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getMatterNews() {
        return matterNews;
    }

    public void setMatterNews(String matterNews) {
        this.matterNews = matterNews;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getFinishedNo() {
        return finishedNo;
    }

    public void setFinishedNo(Integer finishedNo) {
        this.finishedNo = finishedNo;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
