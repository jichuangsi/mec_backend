package com.jichuangsi.mes.model;

import java.math.BigDecimal;
import java.util.Date;

public class PPPickingVo {

    private Integer id;//生产领料id
    private Integer PPId;//生产计划单id
    private String PPINumber;//生产领料单号
    private String PPIName;//生产领料名称
    private Integer warehouseId;//领料仓库id
    private BigDecimal totalNet;//总净重g
    private Date createTime;//领料时间
    private Integer deleteNo;//删除否


    private String PPNumber;//生产计划单号
    private String PPIwarehouseName;//生产领料车间


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPPId() {
        return PPId;
    }

    public void setPPId(Integer PPId) {
        this.PPId = PPId;
    }

    public String getPPINumber() {
        return PPINumber;
    }

    public void setPPINumber(String PPINumber) {
        this.PPINumber = PPINumber;
    }

    public String getPPIName() {
        return PPIName;
    }

    public void setPPIName(String PPIName) {
        this.PPIName = PPIName;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public BigDecimal getTotalNet() {
        return totalNet;
    }

    public void setTotalNet(BigDecimal totalNet) {
        this.totalNet = totalNet;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }

    public String getPPNumber() {
        return PPNumber;
    }

    public void setPPNumber(String PPNumber) {
        this.PPNumber = PPNumber;
    }

    public String getPPIwarehouseName() {
        return PPIwarehouseName;
    }

    public void setPPIwarehouseName(String PPIwarehouseName) {
        this.PPIwarehouseName = PPIwarehouseName;
    }
}
