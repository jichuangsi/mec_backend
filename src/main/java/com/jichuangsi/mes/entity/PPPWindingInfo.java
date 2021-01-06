package com.jichuangsi.mes.entity;


import javax.persistence.*;

//待绕线信息
@Entity
@Table(name = "ppp_WindingInfo")
public class PPPWindingInfo {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//产物ID
    private Integer PPPId;//生产id
    private Integer PPPPId;//生产产物id
    private Integer equipmentId;//设备id

    private Integer tension;//张力
    private Integer wasteAge;//废料g
    private Integer cloutG;//余料g
    private Integer lossG;//损耗g
    private Integer flatCable;//排线
    private Integer surface;//表面
    private Integer settingOut;//放线
    private Integer straightLine;//直线

    private Integer deleteNo;//删除否

    public Integer getPPPId() {
        return PPPId;
    }

    public void setPPPId(Integer PPPId) {
        this.PPPId = PPPId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPPPPId() {
        return PPPPId;
    }

    public void setPPPPId(Integer PPPPId) {
        this.PPPPId = PPPPId;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getTension() {
        return tension;
    }

    public void setTension(Integer tension) {
        this.tension = tension;
    }

    public Integer getWasteAge() {
        return wasteAge;
    }

    public void setWasteAge(Integer wasteAge) {
        this.wasteAge = wasteAge;
    }

    public Integer getCloutG() {
        return cloutG;
    }

    public void setCloutG(Integer cloutG) {
        this.cloutG = cloutG;
    }

    public Integer getLossG() {
        return lossG;
    }

    public void setLossG(Integer lossG) {
        this.lossG = lossG;
    }

    public Integer getFlatCable() {
        return flatCable;
    }

    public void setFlatCable(Integer flatCable) {
        this.flatCable = flatCable;
    }

    public Integer getSurface() {
        return surface;
    }

    public void setSurface(Integer surface) {
        this.surface = surface;
    }

    public Integer getSettingOut() {
        return settingOut;
    }

    public void setSettingOut(Integer settingOut) {
        this.settingOut = settingOut;
    }

    public Integer getStraightLine() {
        return straightLine;
    }

    public void setStraightLine(Integer straightLine) {
        this.straightLine = straightLine;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
