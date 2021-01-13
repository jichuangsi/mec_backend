package com.jichuangsi.mes.entity;

import javax.persistence.*;

//角色表
@Entity
@Table(name = "s_role")
public class SRole {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//角色ID
    private String roleName;//名称
    private String remark;//备注
    private String rolePower;//权限配置（这里是一个角色能享受到的模块。模块ID都会放在这里。用,号隔开）例如 1,2,4,5,6等
    private Integer state;
    private Integer deleteNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRolePower() {
        return rolePower;
    }

    public void setRolePower(String rolePower) {
        this.rolePower = rolePower;
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
