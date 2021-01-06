package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.util.Date;

//抽样检验报告
@Entity
@Table(name = "t_samplingReport")
public class TSamplingReport {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//id
    private Integer ppppId;//生产产物id
    private Integer pppId;//生产id
    private String reportName;//名称
    private Integer tempId;//模板id
    private Date createTime;//检验日期
    private Integer inspectionSum;//进检轴数
    private Integer samplesNums;//抽检轴数
    private String inspectionBoxNumber;//进检盒号
    private String samplesPackingNumber;//抽检包装编号
    private String inspectionPackingNumber;//进检包装编号
    private String unqualifiedNumber;//不合格包装编号

    private Integer staffId;//员工id

    private String chemicalcomposition;//化学成分
    private String checkUm;//检验直径um
    private String checkWeightg;//检验重量g
    private String checkLengthM;//检验长度m
    private String surface;//表面
    private String settingstopPoint ;//放线停点
    private String bendingtwisting;//弯曲扭曲实验

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

    private String conclusion;//结论

    private Integer qualifiedNum;//合格轴数
    private Integer unqualifiedNum;//不合格轴数

    private Integer state;//状态
    private Integer deleteNo;//删除否

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPpppId() {
        return ppppId;
    }

    public void setPpppId(Integer ppppId) {
        this.ppppId = ppppId;
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

    public Integer getInspectionSum() {
        return inspectionSum;
    }

    public void setInspectionSum(Integer inspectionSum) {
        this.inspectionSum = inspectionSum;
    }

    public Integer getSamplesNums() {
        return samplesNums;
    }

    public void setSamplesNums(Integer samplesNums) {
        this.samplesNums = samplesNums;
    }

    public String getInspectionBoxNumber() {
        return inspectionBoxNumber;
    }

    public void setInspectionBoxNumber(String inspectionBoxNumber) {
        this.inspectionBoxNumber = inspectionBoxNumber;
    }

    public String getSamplesPackingNumber() {
        return samplesPackingNumber;
    }

    public void setSamplesPackingNumber(String samplesPackingNumber) {
        this.samplesPackingNumber = samplesPackingNumber;
    }

    public String getInspectionPackingNumber() {
        return inspectionPackingNumber;
    }

    public void setInspectionPackingNumber(String inspectionPackingNumber) {
        this.inspectionPackingNumber = inspectionPackingNumber;
    }

    public String getUnqualifiedNumber() {
        return unqualifiedNumber;
    }

    public void setUnqualifiedNumber(String unqualifiedNumber) {
        this.unqualifiedNumber = unqualifiedNumber;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getChemicalcomposition() {
        return chemicalcomposition;
    }

    public void setChemicalcomposition(String chemicalcomposition) {
        this.chemicalcomposition = chemicalcomposition;
    }

    public String getCheckUm() {
        return checkUm;
    }

    public void setCheckUm(String checkUm) {
        this.checkUm = checkUm;
    }

    public String getCheckWeightg() {
        return checkWeightg;
    }

    public void setCheckWeightg(String checkWeightg) {
        this.checkWeightg = checkWeightg;
    }

    public String getCheckLengthM() {
        return checkLengthM;
    }

    public void setCheckLengthM(String checkLengthM) {
        this.checkLengthM = checkLengthM;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getSettingstopPoint() {
        return settingstopPoint;
    }

    public void setSettingstopPoint(String settingstopPoint) {
        this.settingstopPoint = settingstopPoint;
    }

    public String getBendingtwisting() {
        return bendingtwisting;
    }

    public void setBendingtwisting(String bendingtwisting) {
        this.bendingtwisting = bendingtwisting;
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

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public Integer getQualifiedNum() {
        return qualifiedNum;
    }

    public void setQualifiedNum(Integer qualifiedNum) {
        this.qualifiedNum = qualifiedNum;
    }

    public Integer getUnqualifiedNum() {
        return unqualifiedNum;
    }

    public void setUnqualifiedNum(Integer unqualifiedNum) {
        this.unqualifiedNum = unqualifiedNum;
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
