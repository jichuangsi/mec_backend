package com.jichuangsi.mes.model;

import com.jichuangsi.mes.entity.*;

import java.util.List;

public class PPProductionModel {

    PPProduction ppProduction;

    List<ProductionStock> OneList;//产品管理-熔炼使用的原料
    List<PPPProducts0> TwoList;//产品管理-本班产物

//    List<SmeltingProducts> smeltingProductsList;//熔炼本班产物
//    List<PPRoughDrawingProducts> roughDrawingProductsListu;//粗拉本班产物
//    List<PPIntermediateDrawingProducts> intermediateDrawingProductsList;//中拉本班产物
//    List<PPSemiFinishedProducts> semiFinishedProductsList;//半成品本班产物
//    List<PPFinishedProducts> finishedProductsList;//成品本班产物
//    List<PPWindingProducts> windingProductsList;//绕线本班产物


    public PPProduction getPpProduction() {
        return ppProduction;
    }

    public void setPpProduction(PPProduction ppProduction) {
        this.ppProduction = ppProduction;
    }

    public List<ProductionStock> getOneList() {
        return OneList;
    }

    public void setOneList(List<ProductionStock> oneList) {
        OneList = oneList;
    }

    public List<PPPProducts0> getTwoList() {
        return TwoList;
    }

    public void setTwoList(List<PPPProducts0> twoList) {
        TwoList = twoList;
    }
}
