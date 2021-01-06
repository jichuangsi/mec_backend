package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "templates")
public class Templates {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(255) default null comment '模板编号'")
    private String number;
    @Column(columnDefinition = "varchar(255) default null comment '模板名称'")
    private String name;
    @Column(columnDefinition = "varchar(255) default null comment '备注'")
    private String remark;
    @Column(columnDefinition = "varchar(255) default null comment '文件路径'")
    private String fileRoute;
    @Column(columnDefinition = "int(10) default 0 comment '是否启用'")
    private int closed;
    @Column(columnDefinition = "int(10) default 0 comment '是否删除'")
    private int deleteNo;
    @Column(columnDefinition = "int(10) default 0 comment '线别id'")
    private int XB;
    @Column(columnDefinition = "int(10) default 0 comment 'userid'")
    private int userId;
    @Column(columnDefinition = "int(10) default 0 comment '类型1成品报告2质量证书'")
    private int type;
    private long createTime=new Date().getTime();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFileRoute() {
        return fileRoute;
    }

    public void setFileRoute(String fileRoute) {
        this.fileRoute = fileRoute;
    }

    public int getClosed() {
        return closed;
    }

    public void setClosed(int closed) {
        this.closed = closed;
    }

    public int getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(int deleteNo) {
        this.deleteNo = deleteNo;
    }

    public int getXB() {
        return XB;
    }

    public void setXB(int XB) {
        this.XB = XB;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
