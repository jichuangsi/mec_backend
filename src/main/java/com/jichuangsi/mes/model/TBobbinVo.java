package com.jichuangsi.mes.model;

public class TBobbinVo {

    private Integer id;
    private String bobbinNumber;//线轴编号
    private String bobbinName;// 名称
    private String bobbinModel;//型号
    private Integer procedureId;//工序ID
    private Integer bobbintypeId;//线轴类型ID== 线别类型
    private String remark;//说明
    private Integer dictionarierId;//单位ID
    private Integer state;//状态
    private Integer deleteNo;//删除否

    private String procedureName;//工序
    private String bobbintype;//线轴类型（线别）

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBobbinNumber() {
        return bobbinNumber;
    }

    public void setBobbinNumber(String bobbinNumber) {
        this.bobbinNumber = bobbinNumber;
    }

    public String getBobbinName() {
        return bobbinName;
    }

    public void setBobbinName(String bobbinName) {
        this.bobbinName = bobbinName;
    }

    public String getBobbinModel() {
        return bobbinModel;
    }

    public void setBobbinModel(String bobbinModel) {
        this.bobbinModel = bobbinModel;
    }

    public Integer getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(Integer procedureId) {
        this.procedureId = procedureId;
    }

    public Integer getBobbintypeId() {
        return bobbintypeId;
    }

    public void setBobbintypeId(Integer bobbintypeId) {
        this.bobbintypeId = bobbintypeId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDictionarierId() {
        return dictionarierId;
    }

    public void setDictionarierId(Integer dictionarierId) {
        this.dictionarierId = dictionarierId;
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

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getBobbintype() {
        return bobbintype;
    }

    public void setBobbintype(String bobbintype) {
        this.bobbintype = bobbintype;
    }
}
