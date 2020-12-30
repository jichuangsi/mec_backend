package com.jichuangsi.mes.model;

import com.jichuangsi.mes.entity.*;

import java.util.List;

public class ClientModel {

    private String updateids;//获取修改的明细id（记录id，用','隔开）

//    新增客户/供应商
    private SCustomer sclient;

    private List<CustomerDetail> customerDetails;

    //新增产品and 产品详情
    private TProduct tProduct;

    private List<TProstandard> tProstandards;
    private List<GXLossBi> gxLossBislist;
    private List<RawMaterialRatio> rawMaterialRatios;

    //新增原材料
    private Stock stock;

    //规格型号表
    private List<TStandards> tstandards;

    //新增线轴型号规格
    private TBobbin tBobbin;

    public String getUpdateids() {
        return updateids;
    }

    public void setUpdateids(String updateids) {
        this.updateids = updateids;
    }

    public List<GXLossBi> getGxLossBislist() {
        return gxLossBislist;
    }

    public void setGxLossBislist(List<GXLossBi> gxLossBislist) {
        this.gxLossBislist = gxLossBislist;
    }

    public List<RawMaterialRatio> getRawMaterialRatios() {
        return rawMaterialRatios;
    }

    public void setRawMaterialRatios(List<RawMaterialRatio> rawMaterialRatios) {
        this.rawMaterialRatios = rawMaterialRatios;
    }

    public TBobbin gettBobbin() {
        return tBobbin;
    }

    public void settBobbin(TBobbin tBobbin) {
        this.tBobbin = tBobbin;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public List<TStandards> getTstandards() {
        return tstandards;
    }

    public void setTstandards(List<TStandards> tstandards) {
        this.tstandards = tstandards;
    }

    public TProduct gettProduct() {
        return tProduct;
    }

    public void settProduct(TProduct tProduct) {
        this.tProduct = tProduct;
    }

    public List<TProstandard> gettProstandards() {
        return tProstandards;
    }

    public void settProstandards(List<TProstandard> tProstandards) {
        this.tProstandards = tProstandards;
    }

    public SCustomer getSclient() {
        return sclient;
    }

    public void setSclient(SCustomer sclient) {
        this.sclient = sclient;
    }

    public List<CustomerDetail> getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(List<CustomerDetail> customerDetails) {
        this.customerDetails = customerDetails;
    }
}
