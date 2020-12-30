package com.jichuangsi.mes.entity;

import javax.persistence.*;

@Entity
@Table(name = "s_staffrole")//用户角色表(一个用户能有很多角色，一个角色也有很多用户)
public class SStaffRole {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//用户角色ID
    private Integer staffId;//用户ID (一个用户能有多个角色)
    private Integer roleId;//用户角色ID

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
