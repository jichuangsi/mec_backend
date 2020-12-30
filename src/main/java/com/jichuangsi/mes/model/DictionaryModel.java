package com.jichuangsi.mes.model;

public class DictionaryModel {

    private Integer id;//子类别ID
    private Integer dictFID;//大类别ID
    private String dictFname;//大类别名称
    private String dictname;//类别名称

    private String dicCode;//字典表代号
    private String createTime;//创建时间
    private Integer staffId;//员工ID(创建人)
    private String staffName;//创建人

    private Integer state;//备注
    private Integer deleteNo;//删除否

    public String getDictFname() {
        return dictFname;
    }

    public void setDictFname(String dictFname) {
        this.dictFname = dictFname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDictFID() {
        return dictFID;
    }

    public void setDictFID(Integer dictFID) {
        this.dictFID = dictFID;
    }

    public String getDictname() {
        return dictname;
    }

    public void setDictname(String dictname) {
        this.dictname = dictname;
    }

    public String getDicCode() {
        return dicCode;
    }

    public void setDicCode(String dicCode) {
        this.dicCode = dicCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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
