package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_finishedproducecheck")
public class TFinishedproducecheck {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//成品模具检查ID
    private Integer mouldId;//模具ID
    private Double lengthM;//长度m
    private Double density;//密度
    private Double weightMg1;//重量mg(1~10)
    private Double weightMg2;//重量mg(1~10)
    private Double weightMg3;//重量mg(1~10)
    private Double weightMg4;//重量mg(1~10)
    private Double weightMg5;//重量mg(1~10)
    private Double weightMg6;//重量mg(1~10)
    private Double weightMg7;//重量mg(1~10)
    private Double weightMg8;//重量mg(1~10)
    private Double weightMg9;//重量mg(1~10)
    private Double weightMg0;// 重量mg(1~10)
    private Double weightavageMg;//重量平均值mg   //由上面的1~10的重量的平均值
    private Double measureddiamUm;//实测直径um    //有公式计算的，属于自动生成
    private Date createTime;//检查日期
    private Integer staffId;//员工id
    private String remark;
    private Integer deleteNo;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMouldId() {
        return mouldId;
    }

    public void setMouldId(Integer mouldId) {
        this.mouldId = mouldId;
    }

    public Double getLengthM() {
        return lengthM;
    }

    public void setLengthM(Double lengthM) {
        this.lengthM = lengthM;
    }

    public Double getDensity() {
        return density;
    }

    public void setDensity(Double density) {
        this.density = density;
    }

    public Double getWeightMg1() {
        return weightMg1;
    }

    public void setWeightMg1(Double weightMg1) {
        this.weightMg1 = weightMg1;
    }

    public Double getWeightMg2() {
        return weightMg2;
    }

    public void setWeightMg2(Double weightMg2) {
        this.weightMg2 = weightMg2;
    }

    public Double getWeightMg3() {
        return weightMg3;
    }

    public void setWeightMg3(Double weightMg3) {
        this.weightMg3 = weightMg3;
    }

    public Double getWeightMg4() {
        return weightMg4;
    }

    public void setWeightMg4(Double weightMg4) {
        this.weightMg4 = weightMg4;
    }

    public Double getWeightMg5() {
        return weightMg5;
    }

    public void setWeightMg5(Double weightMg5) {
        this.weightMg5 = weightMg5;
    }

    public Double getWeightMg6() {
        return weightMg6;
    }

    public void setWeightMg6(Double weightMg6) {
        this.weightMg6 = weightMg6;
    }

    public Double getWeightMg7() {
        return weightMg7;
    }

    public void setWeightMg7(Double weightMg7) {
        this.weightMg7 = weightMg7;
    }

    public Double getWeightMg8() {
        return weightMg8;
    }

    public void setWeightMg8(Double weightMg8) {
        this.weightMg8 = weightMg8;
    }

    public Double getWeightMg9() {
        return weightMg9;
    }

    public void setWeightMg9(Double weightMg9) {
        this.weightMg9 = weightMg9;
    }

    public Double getWeightMg0() {
        return weightMg0;
    }

    public void setWeightMg0(Double weightMg0) {
        this.weightMg0 = weightMg0;
    }

    public Double getWeightavageMg() {
        return weightavageMg;
    }

    public void setWeightavageMg(Double weightavageMg) {
        this.weightavageMg = weightavageMg;
    }

    public Double getMeasureddiamUm() {
        return measureddiamUm;
    }

    public void setMeasureddiamUm(Double measureddiamUm) {
        this.measureddiamUm = measureddiamUm;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
