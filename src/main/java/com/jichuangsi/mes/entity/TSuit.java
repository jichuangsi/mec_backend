package com.jichuangsi.mes.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_suit")
public class TSuit {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//套模组合ID
    private String constituteNumber;//组合编号
    private String constituteName;//名称
    private String remark;//备注
    private Integer lineTypeId;//线别类型ID
    private String scopeApplication;//适用范围描述
    private Integer staffId;//员工id
    private Integer scrapNo;//报废否
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

    public String getConstituteNumber() {
        return constituteNumber;
    }

    public void setConstituteNumber(String constituteNumber) {
        this.constituteNumber = constituteNumber;
    }

    public String getConstituteName() {
        return constituteName;
    }

    public void setConstituteName(String constituteName) {
        this.constituteName = constituteName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getLineTypeId() {
        return lineTypeId;
    }

    public void setLineTypeId(Integer lineTypeId) {
        this.lineTypeId = lineTypeId;
    }

    public String getScopeApplication() {
        return scopeApplication;
    }

    public void setScopeApplication(String scopeApplication) {
        this.scopeApplication = scopeApplication;
    }

    public Integer getScrapNo() {
        return scrapNo;
    }

    public void setScrapNo(Integer scrapNo) {
        this.scrapNo = scrapNo;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
