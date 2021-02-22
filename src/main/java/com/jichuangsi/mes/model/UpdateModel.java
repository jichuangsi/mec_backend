package com.jichuangsi.mes.model;

import java.math.BigDecimal;

public class UpdateModel {
    private String findModelName;//需要查询的模块名字


    private Integer updateID;//需要修改的ID
    private Integer updateWarehourseID;//需要修改的仓库ID（调拨：转出）
    private BigDecimal updateNum;//需要修改的数量
    private String updateType;//修改的类型    是Delete_no “D”还是state "S"

    private String updateRemark;//需要添加的备注

    private String bobbinColor;//线轴颜色
    private String axleNumber;//轴号
    private String stockName;//名称
    private String stockModel;//模型
    private String stockNumber;//编号
    private String standards;//规格
    private Integer unitId;//单位id

    public String getBobbinColor() {
        return bobbinColor;
    }

    public void setBobbinColor(String bobbinColor) {
        this.bobbinColor = bobbinColor;
    }

    public String getAxleNumber() {
        return axleNumber;
    }

    public void setAxleNumber(String axleNumber) {
        this.axleNumber = axleNumber;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockModel() {
        return stockModel;
    }

    public void setStockModel(String stockModel) {
        this.stockModel = stockModel;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public String getStandards() {
        return standards;
    }

    public void setStandards(String standards) {
        this.standards = standards;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public BigDecimal getUpdateNum() {
        return updateNum;
    }

    public void setUpdateNum(BigDecimal updateNum) {
        this.updateNum = updateNum;
    }

    public Integer getUpdateWarehourseID() {
        return updateWarehourseID;
    }

    public void setUpdateWarehourseID(Integer updateWarehourseID) {
        this.updateWarehourseID = updateWarehourseID;
    }

    public String getUpdateRemark() {
        return updateRemark;
    }

    public void setUpdateRemark(String updateRemark) {
        this.updateRemark = updateRemark;
    }

    public String getFindModelName() {
        return findModelName;
    }

    public void setFindModelName(String findModelName) {
        this.findModelName = findModelName;
    }

    public Integer getUpdateID() {
        return updateID;
    }

    public void setUpdateID(Integer updateID) {
        this.updateID = updateID;
    }

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }
}
