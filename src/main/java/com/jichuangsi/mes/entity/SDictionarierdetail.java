package com.jichuangsi.mes.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "s_dictionarierdetail")
public class SDictionarierdetail {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//字典明细ID
    private Integer dictionarierId;//字典ID
    private long createTime= new Date().getTime();//创建时间
    private Integer staffId;//员工ID(创建人)
    private Integer state;//状态
    private Integer deleteNo;//删除否

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDictionarierId() {
        return dictionarierId;
    }

    public void setDictionarierId(Integer dictionarierId) {
        this.dictionarierId = dictionarierId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
