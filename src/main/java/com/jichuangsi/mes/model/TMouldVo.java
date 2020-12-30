package com.jichuangsi.mes.model;

public class TMouldVo {

    private Integer id;//模具ID
    private String mouldName;//名称
    private String mouldModel;//型号
    private String mouldNumber;//编号
    private Integer linetypeId;//线别类型ID(金线银线等)
    private String linetypeName;//线别类型
    private String wiredrawRemark;//拉丝范围描述
    private String wiredrawUp;//拉丝范围nm上限
    private String wiredrawDown;//拉丝范围nm下限
    private String wiredrawgUp;//拉丝量参考范围g上限
    private String wiredrawgPip;//拉丝量参考范围g标准
    private String wiredrawgDown;//拉丝量参考范围g下限
    private String warnRacc;//预警参考量
    private String wiredrawSum;//累计拉丝量
    private Integer modelusedId;//适用机型ID
    private String modelusedName;//适用机型
    private String remark;//备注
    private Integer cuffingmouldNno;//成品模具否(有成套模具就有模具套装)
    private Integer scrapNo;//报废否
    private String stateName;//模具状态
    private Integer deleteNo;//删除否


    private Double measureddiamUm;//实测直径um    //有公式计算的，属于自动生成

    public Double getMeasureddiamUm() {
        return measureddiamUm;
    }

    public void setMeasureddiamUm(Double measureddiamUm) {
        this.measureddiamUm = measureddiamUm;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getMouldNumber() {
        return mouldNumber;
    }

    public void setMouldNumber(String mouldNumber) {
        this.mouldNumber = mouldNumber;
    }

    public Integer getLinetypeId() {
        return linetypeId;
    }

    public void setLinetypeId(Integer linetypeId) {
        this.linetypeId = linetypeId;
    }

    public String getLinetypeName() {
        return linetypeName;
    }

    public void setLinetypeName(String linetypeName) {
        this.linetypeName = linetypeName;
    }

    public String getWiredrawRemark() {
        return wiredrawRemark;
    }

    public void setWiredrawRemark(String wiredrawRemark) {
        this.wiredrawRemark = wiredrawRemark;
    }

    public String getWiredrawUp() {
        return wiredrawUp;
    }

    public void setWiredrawUp(String wiredrawUp) {
        this.wiredrawUp = wiredrawUp;
    }

    public String getWiredrawDown() {
        return wiredrawDown;
    }

    public void setWiredrawDown(String wiredrawDown) {
        this.wiredrawDown = wiredrawDown;
    }

    public String getWiredrawgUp() {
        return wiredrawgUp;
    }

    public void setWiredrawgUp(String wiredrawgUp) {
        this.wiredrawgUp = wiredrawgUp;
    }

    public String getWiredrawgPip() {
        return wiredrawgPip;
    }

    public void setWiredrawgPip(String wiredrawgPip) {
        this.wiredrawgPip = wiredrawgPip;
    }

    public String getWiredrawgDown() {
        return wiredrawgDown;
    }

    public void setWiredrawgDown(String wiredrawgDown) {
        this.wiredrawgDown = wiredrawgDown;
    }

    public String getWarnRacc() {
        return warnRacc;
    }

    public void setWarnRacc(String warnRacc) {
        this.warnRacc = warnRacc;
    }

    public String getWiredrawSum() {
        return wiredrawSum;
    }

    public void setWiredrawSum(String wiredrawSum) {
        this.wiredrawSum = wiredrawSum;
    }

    public Integer getModelusedId() {
        return modelusedId;
    }

    public void setModelusedId(Integer modelusedId) {
        this.modelusedId = modelusedId;
    }

    public String getModelusedName() {
        return modelusedName;
    }

    public void setModelusedName(String modelusedName) {
        this.modelusedName = modelusedName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCuffingmouldNno() {
        return cuffingmouldNno;
    }

    public void setCuffingmouldNno(Integer cuffingmouldNno) {
        this.cuffingmouldNno = cuffingmouldNno;
    }

    public Integer getScrapNo() {
        return scrapNo;
    }

    public void setScrapNo(Integer scrapNo) {
        this.scrapNo = scrapNo;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
