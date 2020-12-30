package com.jichuangsi.mes.common;

public class ProductionStateChange {

    //    生产管理：状态代表
    public static final Integer Production_Smelting = 1;//熔炼
    public static final Integer Production_PPRoughDrawing = 2;//粗拉
    public static final Integer Production_PPIntermediateDrawing = 3;//中拉
    public static final Integer Production_PPSemiFinished = 4;//细拉(半成品)
    public static final Integer Production_PPFinished = 5;//超细拉(成品)
    public static final Integer Production_IntermediateAnnealing = 6;//中间退火
    public static final Integer Production_FinishedAnnealing = 7;//成品退火
    public static final Integer Production_PPWinding = 8;//绕线
    public static final Integer Production_PPDetour = 9;//改绕


    public static final Integer PSmelting = 38;//熔炼
    public static final Integer PPPRoughDrawing = 39;//粗拉
    public static final Integer PPPIntermediateDrawing = 40;//中拉
    public static final Integer PPPSemiFinished = 41;//细拉(半成品)
    public static final Integer PPPFinished = 42;//超细拉(成品)
    public static final Integer PIntermediateAnnealing = 43;//中间退火
    public static final Integer PFinishedAnnealing = 90;//成品退火
    public static final Integer PPPWinding = 68;//绕线
    public static final Integer PPPDetour = 70;//改绕


    //1熔炼 2粗拉 3中拉 4半成品(细拉) 5成品(超细拉) 6中间退火 7成品退火 8绕线 9成品改绕
    public static Integer getGXIdByGXType(Integer state){
        Integer intid = 0;
        switch (state){
            case 1:
                intid = 38;
                break;
            case 2:
                intid = 39;
                break;
            case 3:
                intid = 40;
                break;
            case 4:
                intid = 41;
                break;
            case 5:
                intid = 42;
                break;
            case 6:
                intid = 43;
                break;
            case 7:
                intid = 90;
                break;
            case 8:
                intid = 68;
                break;
            case 9:
                intid = 70;
                break;

            default:
                break;
        }

        return intid;
    }

    //1熔炼 2粗拉 3中拉 4半成品(细拉) 5成品(超细拉) 6中间退火 7成品退火 8绕线 9成品改绕
    public static Integer getGXIdByGXTypeDesc(Integer state){
        Integer intid = 0;
        switch (state){
            case 38:
                intid = 1;
                break;
            case 39:
                intid = 2;
                break;
            case 40:
                intid = 3;
                break;
            case 41:
                intid = 4;
                break;
            case 42:
                intid = 5;
                break;
            case 43:
                intid = 6;
                break;
            case 90:
                intid = 7;
                break;
            case 68:
                intid = 8;
                break;
            case 70:
                intid = 9;
                break;

            default:
                break;
        }

        return intid;
    }



    //1熔炼 2粗拉 3中拉 4半成品(细拉) 5成品(超细拉) 6中间退火 7成品退火 8绕线 9成品改绕
    public static Integer getGXStateChangeone(Integer state){
        Integer intid = 0;
        switch (state){
            case 1:
                intid = 2;
                break;
            case 2:
                intid = 3;
                break;
            case 3:
                intid = 4;
                break;
            case 4:
                intid = 5;
                break;
            default:
                break;
        }

        return intid;
    }



}
