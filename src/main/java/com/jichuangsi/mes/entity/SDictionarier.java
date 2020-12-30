package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "s_dictionarier")
public class SDictionarier {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private String name;//类别名称
    private Integer dictFID;//类别父ID
    private String dicCode;//字典表代号

    private Date createTime;//创建时间
    private Integer staffId;//创建人id 员工id

    private Integer state;//状态
    private Integer deleteNo;//删除否

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDictFID() {
        return dictFID;
    }

    public void setDictFID(Integer dictFID) {
        this.dictFID = dictFID;
    }

    public String getDicCode() {
        return dicCode;
    }

    public void setDicCode(String dicCode) {
        this.dicCode = dicCode;
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
