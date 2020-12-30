package com.jichuangsi.mes.model;

public class CuffingcheckVo {

    private Integer id;//成套模具明细检查ID
    private Integer cuffingCheckId;//套模检查ID
    private Integer mouldDetailId;//模套ID(小模具)

    private String sonmouldModel;//子模具型号
    private String sonmouldSpaNum;//子模具孔径um

    private String remark;//备注
    private Integer entranceNo;//入口区正常否
    private Integer deformationNo;//变形区正常否
    private Integer rsmNo;//定径区正常否
    private Integer exportNo;//出口区正常否

    private String entranceNos;//入口区正常否
    private String deformationNos;//变形区正常否
    private String rsmNos;//定径区正常否
    private String exportNos;//出口区正常否

    private Integer deleteNo;

//历史数据
    private Integer mouldid;//模具ID
    private String mouldName;//名称
    private String mouldModel;//型号
    private String judgeresult;//综合判定(0合格/1不合格)
    private String staffName;//员工
    private String createTime;//日期
    private Integer deleteno;//删除否


    public String getEntranceNos() {
        return entranceNos;
    }

    public void setEntranceNos(String entranceNos) {
        this.entranceNos = entranceNos;
    }

    public String getDeformationNos() {
        return deformationNos;
    }

    public void setDeformationNos(String deformationNos) {
        this.deformationNos = deformationNos;
    }

    public String getRsmNos() {
        return rsmNos;
    }

    public void setRsmNos(String rsmNos) {
        this.rsmNos = rsmNos;
    }

    public String getExportNos() {
        return exportNos;
    }

    public void setExportNos(String exportNos) {
        this.exportNos = exportNos;
    }

    public String getMouldName() {
        return mouldName;
    }

    public void setMouldName(String mouldName) {
        this.mouldName = mouldName;
    }

    public String getMouldModel() {
        return mouldModel;
    }

    public void setMouldModel(String mouldModel) {
        this.mouldModel = mouldModel;
    }

    public Integer getMouldid() {
        return mouldid;
    }

    public void setMouldid(Integer mouldid) {
        this.mouldid = mouldid;
    }

    public String getJudgeresult() {
        return judgeresult;
    }

    public void setJudgeresult(String judgeresult) {
        this.judgeresult = judgeresult;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getDeleteno() {
        return deleteno;
    }

    public void setDeleteno(Integer deleteno) {
        this.deleteno = deleteno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCuffingCheckId() {
        return cuffingCheckId;
    }

    public void setCuffingCheckId(Integer cuffingCheckId) {
        this.cuffingCheckId = cuffingCheckId;
    }

    public Integer getMouldDetailId() {
        return mouldDetailId;
    }

    public void setMouldDetailId(Integer mouldDetailId) {
        this.mouldDetailId = mouldDetailId;
    }

    public String getSonmouldModel() {
        return sonmouldModel;
    }

    public void setSonmouldModel(String sonmouldModel) {
        this.sonmouldModel = sonmouldModel;
    }

    public String getSonmouldSpaNum() {
        return sonmouldSpaNum;
    }

    public void setSonmouldSpaNum(String sonmouldSpaNum) {
        this.sonmouldSpaNum = sonmouldSpaNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getEntranceNo() {
        return entranceNo;
    }

    public void setEntranceNo(Integer entranceNo) {
        this.entranceNo = entranceNo;
    }

    public Integer getDeformationNo() {
        return deformationNo;
    }

    public void setDeformationNo(Integer deformationNo) {
        this.deformationNo = deformationNo;
    }

    public Integer getRsmNo() {
        return rsmNo;
    }

    public void setRsmNo(Integer rsmNo) {
        this.rsmNo = rsmNo;
    }

    public Integer getExportNo() {
        return exportNo;
    }

    public void setExportNo(Integer exportNo) {
        this.exportNo = exportNo;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
