package com.jichuangsi.mes.model;

import com.jichuangsi.mes.entity.*;

import java.util.List;

public class PPProductionModel {

    PPProduction ppProduction;

    List<ProductionStock> OneList;//产品管理-熔炼使用的原料
    List<PPPProducts0> TwoList;//产品管理-本班产物


    List<ELBLData> elblDataList;//产品管理-退火elbl数据
    PPAnnealingInfo ppAnnealingInfo;//产品管理-退火elbl基本数据

    PPPWindingInfo pppWindingInfo;//实体：绕线明细

    public PPPWindingInfo getPppWindingInfo() {
        return pppWindingInfo;
    }

    public void setPppWindingInfo(PPPWindingInfo pppWindingInfo) {
        this.pppWindingInfo = pppWindingInfo;
    }

    public PPAnnealingInfo getPpAnnealingInfo() {
        return ppAnnealingInfo;
    }

    public void setPpAnnealingInfo(PPAnnealingInfo ppAnnealingInfo) {
        this.ppAnnealingInfo = ppAnnealingInfo;
    }

    public List<ELBLData> getElblDataList() {
        return elblDataList;
    }

    public void setElblDataList(List<ELBLData> elblDataList) {
        this.elblDataList = elblDataList;
    }

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
