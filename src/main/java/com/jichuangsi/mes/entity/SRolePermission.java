package com.jichuangsi.mes.entity;

import javax.persistence.*;

@Entity
@Table(name = "s_rolepermission")//角色权限表 (一个角色能拥有的权限列表)
public class SRolePermission {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//角色权限ID
    private Integer roleId;//角色ID
    private Integer rolePowerId;//权限配置ID
    private Integer state;//是否可访问

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRolePowerId() {
        return rolePowerId;
    }

    public void setRolePowerId(Integer rolePowerId) {
        this.rolePowerId = rolePowerId;
    }
}
