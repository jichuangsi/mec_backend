package com.jichuangsi.mes.entity;


import javax.persistence.*;
import java.util.Date;

//质量证书报告
@Entity
@Table(name = "t_certificateReport")
public class TCertificateReport {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//id
    private Integer pppId;//生产id
    private String reportName;//名称
    private Integer tempId;//模板id
    private Date createTime;//证书日期
    private String remarks;//备注

    private String checkEquipment;//检测设备
    private String checkLength;//检测长度
    private String drawingSpeed ;//拉伸速度

    private Integer elongation1;//延伸率1~5
    private Integer elongation2;//延伸率1~5
    private Integer elongation3;//延伸率1~5
    private Integer elongation4;//延伸率1~5
    private Integer elongation5;//延伸率1~5

    private Integer crack1;//断裂符合1~5
    private Integer crack2;//断裂符合1~5
    private Integer crack3;//断裂符合1~5
    private Integer crack4;//断裂符合1~5
    private Integer crack5;//断裂符合1~5

    private Integer staffId;//员工id

    private Integer state;//状态
    private Integer deleteNo;//删除否

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

    public Integer getPppId() {
        return pppId;
    }

    public void setPppId(Integer pppId) {
        this.pppId = pppId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCheckEquipment() {
        return checkEquipment;
    }

    public void setCheckEquipment(String checkEquipment) {
        this.checkEquipment = checkEquipment;
    }

    public String getCheckLength() {
        return checkLength;
    }

    public void setCheckLength(String checkLength) {
        this.checkLength = checkLength;
    }

    public String getDrawingSpeed() {
        return drawingSpeed;
    }

    public void setDrawingSpeed(String drawingSpeed) {
        this.drawingSpeed = drawingSpeed;
    }

    public Integer getElongation1() {
        return elongation1;
    }

    public void setElongation1(Integer elongation1) {
        this.elongation1 = elongation1;
    }

    public Integer getElongation2() {
        return elongation2;
    }

    public void setElongation2(Integer elongation2) {
        this.elongation2 = elongation2;
    }

    public Integer getElongation3() {
        return elongation3;
    }

    public void setElongation3(Integer elongation3) {
        this.elongation3 = elongation3;
    }

    public Integer getElongation4() {
        return elongation4;
    }

    public void setElongation4(Integer elongation4) {
        this.elongation4 = elongation4;
    }

    public Integer getElongation5() {
        return elongation5;
    }

    public void setElongation5(Integer elongation5) {
        this.elongation5 = elongation5;
    }

    public Integer getCrack1() {
        return crack1;
    }

    public void setCrack1(Integer crack1) {
        this.crack1 = crack1;
    }

    public Integer getCrack2() {
        return crack2;
    }

    public void setCrack2(Integer crack2) {
        this.crack2 = crack2;
    }

    public Integer getCrack3() {
        return crack3;
    }

    public void setCrack3(Integer crack3) {
        this.crack3 = crack3;
    }

    public Integer getCrack4() {
        return crack4;
    }

    public void setCrack4(Integer crack4) {
        this.crack4 = crack4;
    }

    public Integer getCrack5() {
        return crack5;
    }

    public void setCrack5(Integer crack5) {
        this.crack5 = crack5;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
