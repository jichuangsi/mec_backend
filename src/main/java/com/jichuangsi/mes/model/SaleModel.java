package com.jichuangsi.mes.model;

import com.jichuangsi.mes.entity.TSaleorder;
import com.jichuangsi.mes.entity.TSaleorderdetail;

import java.util.List;

public class SaleModel {


    //    新增销售订单
    private TSaleorder tsaleorder;

//    新增销售订单明细
    private List<TSaleorderdetailVo> tsaleorderdetail;

    public TSaleorder getTsaleorder() {
        return tsaleorder;
    }

    public void setTsaleorder(TSaleorder tsaleorder) {
        this.tsaleorder = tsaleorder;
    }

    public List<TSaleorderdetailVo> getTsaleorderdetail() {
        return tsaleorderdetail;
    }

    public void setTsaleorderdetail(List<TSaleorderdetailVo> tsaleorderdetail) {
        this.tsaleorderdetail = tsaleorderdetail;
    }
}
