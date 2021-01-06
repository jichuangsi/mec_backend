package com.jichuangsi.mes.entity;

import javax.persistence.*;

//退火-基本信息
@Entity
@Table(name = "pp_annealingInfo")
public class PPAnnealingInfo {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;

    private Integer pppId;//生产id
    private String temperature;//温度
    private Integer speed;//速度
    private Integer tension;//张力
    private Integer gasFlow ;//气体流量
    private String furnaceNumber ;//炉管号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPppId() {
        return pppId;
    }

    public void setPppId(Integer pppId) {
        this.pppId = pppId;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getTension() {
        return tension;
    }

    public void setTension(Integer tension) {
        this.tension = tension;
    }

    public Integer getGasFlow() {
        return gasFlow;
    }

    public void setGasFlow(Integer gasFlow) {
        this.gasFlow = gasFlow;
    }

    public String getFurnaceNumber() {
        return furnaceNumber;
    }

    public void setFurnaceNumber(String furnaceNumber) {
        this.furnaceNumber = furnaceNumber;
    }
}
