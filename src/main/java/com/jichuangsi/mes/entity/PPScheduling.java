package com.jichuangsi.mes.entity;

import javax.persistence.*;

/**
 * 生产计划单-排班表
 */
@Entity
@Table(name = "pp_scheduling")
public class PPScheduling {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//排班id
    private Integer ppId;//生产计划ID
    private Integer gxId;//工序ID
    private Integer tteamId;//班组ID
    private Integer frequency;// 班次（1白班 2夜班）

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    public Integer getGxId() {
        return gxId;
    }

    public void setGxId(Integer gxId) {
        this.gxId = gxId;
    }

    public Integer getTteamId() {
        return tteamId;
    }

    public void setTteamId(Integer tteamId) {
        this.tteamId = tteamId;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}
