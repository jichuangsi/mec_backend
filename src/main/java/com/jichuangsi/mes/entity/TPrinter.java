package com.jichuangsi.mes.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_printer")
public class TPrinter {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//打印机ID
    private String printerName;//打印机名字
    private String printerNumber;//编号
    private String printerModel;//型号
    private Integer printerTypeId;//类型(普通打印机 标签打印机)
    private String remark;
    private Integer deleteNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    public String getPrinterNumber() {
        return printerNumber;
    }

    public void setPrinterNumber(String printerNumber) {
        this.printerNumber = printerNumber;
    }

    public String getPrinterModel() {
        return printerModel;
    }

    public void setPrinterModel(String printerModel) {
        this.printerModel = printerModel;
    }

    public Integer getPrinterTypeId() {
        return printerTypeId;
    }

    public void setPrinterTypeId(Integer printerTypeId) {
        this.printerTypeId = printerTypeId;
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
