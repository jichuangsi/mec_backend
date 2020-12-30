package com.jichuangsi.mes.model;

import com.jichuangsi.mes.entity.*;

import java.util.List;

public class TMouldModel {
    TMould tMould;//模具表

    List<TMouldDetail> tMouldDetailList;//子模具表

    TCuffingcheck tCuffingcheck; //模具检查表

    List<TCuffingcheckdetail> cuffingcheckdetails;//子模具检查表

    TSuit tSuit;//模具组合表
    List<TSuitdetail> tSuitdetailList;//模具组合id

    public TSuit gettSuit() {
        return tSuit;
    }

    public void settSuit(TSuit tSuit) {
        this.tSuit = tSuit;
    }

    public List<TSuitdetail> gettSuitdetailList() {
        return tSuitdetailList;
    }

    public void settSuitdetailList(List<TSuitdetail> tSuitdetailList) {
        this.tSuitdetailList = tSuitdetailList;
    }

    public TCuffingcheck gettCuffingcheck() {
        return tCuffingcheck;
    }

    public void settCuffingcheck(TCuffingcheck tCuffingcheck) {
        this.tCuffingcheck = tCuffingcheck;
    }

    public List<TCuffingcheckdetail> getCuffingcheckdetails() {
        return cuffingcheckdetails;
    }

    public void setCuffingcheckdetails(List<TCuffingcheckdetail> cuffingcheckdetails) {
        this.cuffingcheckdetails = cuffingcheckdetails;
    }

    public TMould gettMould() {
        return tMould;
    }

    public void settMould(TMould tMould) {
        this.tMould = tMould;
    }

    public List<TMouldDetail> gettMouldDetailList() {
        return tMouldDetailList;
    }

    public void settMouldDetailList(List<TMouldDetail> tMouldDetailList) {
        this.tMouldDetailList = tMouldDetailList;
    }
}
