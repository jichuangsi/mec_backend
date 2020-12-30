package com.jichuangsi.mes.model;

import com.jichuangsi.mes.entity.TPurchase;
import com.jichuangsi.mes.entity.TPurchasedetail;

import java.util.List;

public class OrderModel {

    //    新增采购订单
    private TPurchase tPurchase;

//    新增采购订单明细
    private List<TPurchasedetail> tPurchaseDetails;

    public TPurchase gettPurchase() {
        return tPurchase;
    }

    public void settPurchase(TPurchase tPurchase) {
        this.tPurchase = tPurchase;
    }

    public List<TPurchasedetail> gettPurchaseDetails() {
        return tPurchaseDetails;
    }

    public void settPurchaseDetails(List<TPurchasedetail> tPurchaseDetails) {
        this.tPurchaseDetails = tPurchaseDetails;
    }
}
