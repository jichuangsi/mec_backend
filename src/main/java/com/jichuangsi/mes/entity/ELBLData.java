package com.jichuangsi.mes.entity;


import javax.persistence.*;

@Entity
@Table(name = "t_elblData")
//本次退火的EL/BL数据
public class ELBLData {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private Integer PPPId;//生产id
    private Integer gxId;//工序id

    private Integer elX1;//el数据
    private Integer elX2;//el数据
    private Integer elX3;//el数据
    private Integer elX4;//el数据
    private Integer elX5;//el数据

    private Integer blX1;//bl数据
    private Integer blX2;//bl数据
    private Integer blX3;//bl数据
    private Integer blX4;//bl数据
    private Integer blX5;//bl数据

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPPPId() {
        return PPPId;
    }

    public void setPPPId(Integer PPPId) {
        this.PPPId = PPPId;
    }

    public Integer getGxId() {
        return gxId;
    }

    public void setGxId(Integer gxId) {
        this.gxId = gxId;
    }

    public Integer getElX1() {
        return elX1;
    }

    public void setElX1(Integer elX1) {
        this.elX1 = elX1;
    }

    public Integer getElX2() {
        return elX2;
    }

    public void setElX2(Integer elX2) {
        this.elX2 = elX2;
    }

    public Integer getElX3() {
        return elX3;
    }

    public void setElX3(Integer elX3) {
        this.elX3 = elX3;
    }

    public Integer getElX4() {
        return elX4;
    }

    public void setElX4(Integer elX4) {
        this.elX4 = elX4;
    }

    public Integer getElX5() {
        return elX5;
    }

    public void setElX5(Integer elX5) {
        this.elX5 = elX5;
    }

    public Integer getBlX1() {
        return blX1;
    }

    public void setBlX1(Integer blX1) {
        this.blX1 = blX1;
    }

    public Integer getBlX2() {
        return blX2;
    }

    public void setBlX2(Integer blX2) {
        this.blX2 = blX2;
    }

    public Integer getBlX3() {
        return blX3;
    }

    public void setBlX3(Integer blX3) {
        this.blX3 = blX3;
    }

    public Integer getBlX4() {
        return blX4;
    }

    public void setBlX4(Integer blX4) {
        this.blX4 = blX4;
    }

    public Integer getBlX5() {
        return blX5;
    }

    public void setBlX5(Integer blX5) {
        this.blX5 = blX5;
    }
}
