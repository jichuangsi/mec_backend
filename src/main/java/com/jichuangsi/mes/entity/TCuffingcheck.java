package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_cuffingcheck")
public class TCuffingcheck {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//成套模具检查ID
    private Integer mouldid;//模具ID
    private Integer judgeresult;//综合判定(0合格/1不合格)
    private Integer staffid;//员工ID
    private String remark;//备注
    private Date createTime;//日期
    private Integer deleteno;//删除否

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMouldid() {
        return mouldid;
    }

    public void setMouldid(Integer mouldid) {
        this.mouldid = mouldid;
    }

    public Integer getJudgeresult() {
        return judgeresult;
    }

    public void setJudgeresult(Integer judgeresult) {
        this.judgeresult = judgeresult;
    }

    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDeleteno() {
        return deleteno;
    }

    public void setDeleteno(Integer deleteno) {
        this.deleteno = deleteno;
    }
}
