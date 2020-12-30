package com.jichuangsi.mes.model;

//产品管理-原料配比
public class RawMaterialRatioVo {


    private String ratiostart;//原料配比start
    private String ratioend;//原料配比end
    private String stockName;//原料名称

    public String getRatiostart() {
        return ratiostart;
    }

    public void setRatiostart(String ratiostart) {
        this.ratiostart = ratiostart;
    }

    public String getRatioend() {
        return ratioend;
    }

    public void setRatioend(String ratioend) {
        this.ratioend = ratioend;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
}
