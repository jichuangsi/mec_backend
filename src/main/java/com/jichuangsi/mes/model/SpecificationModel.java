package com.jichuangsi.mes.model;

//基础设置-规格型号model
public class SpecificationModel {

    private Integer id;//
    private String sNumber;//编号
    private String sName;//名称
    private String sModel;//型号
    private Integer sLineId;//线别ID
    private String sRemark;//备注/说明
    private Integer sUnitId;//单位
    private String sUnitName;//单位名称
    private Integer bobbinId;//线轴
    private Integer beginId;//始端
    private Integer endId;//末端


    private Integer stockTypeId;//原料类型
    private String stockTypeName;//原料类型名称


    private Integer procedureId;//工序ID
    private String procedureName;//工序名称
    private Integer bobbintypeId;//线轴类型ID
    private String bobbintypeName;//线轴类型名称
    private Integer state;
    private Integer deleteNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getsNumber() {
        return sNumber;
    }

    public void setsNumber(String sNumber) {
        this.sNumber = sNumber;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsModel() {
        return sModel;
    }

    public void setsModel(String sModel) {
        this.sModel = sModel;
    }

    public Integer getsLineId() {
        return sLineId;
    }

    public void setsLineId(Integer sLineId) {
        this.sLineId = sLineId;
    }

    public String getsRemark() {
        return sRemark;
    }

    public void setsRemark(String sRemark) {
        this.sRemark = sRemark;
    }

    public Integer getsUnitId() {
        return sUnitId;
    }

    public void setsUnitId(Integer sUnitId) {
        this.sUnitId = sUnitId;
    }

    public String getsUnitName() {
        return sUnitName;
    }

    public void setsUnitName(String sUnitName) {
        this.sUnitName = sUnitName;
    }

    public Integer getBobbinId() {
        return bobbinId;
    }

    public void setBobbinId(Integer bobbinId) {
        this.bobbinId = bobbinId;
    }

    public Integer getBeginId() {
        return beginId;
    }

    public void setBeginId(Integer beginId) {
        this.beginId = beginId;
    }

    public Integer getEndId() {
        return endId;
    }

    public void setEndId(Integer endId) {
        this.endId = endId;
    }

    public Integer getStockTypeId() {
        return stockTypeId;
    }

    public void setStockTypeId(Integer stockTypeId) {
        this.stockTypeId = stockTypeId;
    }

    public String getStockTypeName() {
        return stockTypeName;
    }

    public void setStockTypeName(String stockTypeName) {
        this.stockTypeName = stockTypeName;
    }

    public Integer getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(Integer procedureId) {
        this.procedureId = procedureId;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public Integer getBobbintypeId() {
        return bobbintypeId;
    }

    public void setBobbintypeId(Integer bobbintypeId) {
        this.bobbintypeId = bobbintypeId;
    }

    public String getBobbintypeName() {
        return bobbintypeName;
    }

    public void setBobbintypeName(String bobbintypeName) {
        this.bobbintypeName = bobbintypeName;
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
