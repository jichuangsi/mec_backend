package com.jichuangsi.mes.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_bobbin")
public class TBobbin {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private String bobbinNumber;//线轴编号
    private String bobbinName;// 名称
    private String bobbinModel;//型号
    private String procedureId;//工序IDs (要求线轴也要有多个工序可查)
    private Integer bobbintypeId;//线轴类型ID== 线别类型
    private String remark;//说明
    private Integer dictionarierId;//单位ID
    private Integer state;//状态
    private Integer deleteNo;//删除否

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

    public String getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(String procedureId) {
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
}
