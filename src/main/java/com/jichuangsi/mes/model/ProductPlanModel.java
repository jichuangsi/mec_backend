package com.jichuangsi.mes.model;

import com.jichuangsi.mes.entity.PPProduct;
import com.jichuangsi.mes.entity.PPScheduling;
import com.jichuangsi.mes.entity.ProductPlan;

import java.util.List;

public class ProductPlanModel {

    //   新增生产计划单
    private ProductPlan productPlan;
    //   新增生产计划单-班组和班次
    private List<PPScheduling> ppSchedulingList;
    //   新增生产计划单-计划产物
    private List<PPProduct> ppProductList;


    public ProductPlan getProductPlan() {
        return productPlan;
    }

    public void setProductPlan(ProductPlan productPlan) {
        this.productPlan = productPlan;
    }

    public List<PPScheduling> getPpSchedulingList() {
        return ppSchedulingList;
    }

    public void setPpSchedulingList(List<PPScheduling> ppSchedulingList) {
        this.ppSchedulingList = ppSchedulingList;
    }

    public List<PPProduct> getPpProductList() {
        return ppProductList;
    }

    public void setPpProductList(List<PPProduct> ppProductList) {
        this.ppProductList = ppProductList;
    }
}
