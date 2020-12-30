package com.jichuangsi.mes.model;

//原材料model
public class StockModel {

    private Integer id;
    private String stockNumber;//原料编号
    private String stockName;//名称
    private String stockModel;//型号
    private Integer stockTypeId;//原料类型id
    private String stockType;//原料类型
    private String stockRemarks;//原料说明
    private Integer dictionarierId;//单位ID(米，克，线)
    private String dictionarier;//单位ID(米，克，线)
    private Integer state;//启用否
    private Integer deleteNo;//删除否

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
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

    public Integer getStockTypeId() {
        return stockTypeId;
    }

    public void setStockTypeId(Integer stockTypeId) {
        this.stockTypeId = stockTypeId;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public String getStockRemarks() {
        return stockRemarks;
    }

    public void setStockRemarks(String stockRemarks) {
        this.stockRemarks = stockRemarks;
    }

    public Integer getDictionarierId() {
        return dictionarierId;
    }

    public void setDictionarierId(Integer dictionarierId) {
        this.dictionarierId = dictionarierId;
    }

    public String getDictionarier() {
        return dictionarier;
    }

    public void setDictionarier(String dictionarier) {
        this.dictionarier = dictionarier;
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
