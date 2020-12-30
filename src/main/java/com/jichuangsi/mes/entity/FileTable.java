package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "file_table")
public class FileTable {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private String fileName;//文件名称
    private String fileRoute;//文件路径
    private String filePassword;//
    private Integer staffId;//上传人
    private long createTime= new Date().getTime();//创建时间
    private Integer deleteNo;//删除否

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileRoute() {
        return fileRoute;
    }

    public void setFileRoute(String fileRoute) {
        this.fileRoute = fileRoute;
    }

    public String getFilePassword() {
        return filePassword;
    }

    public void setFilePassword(String filePassword) {
        this.filePassword = filePassword;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
