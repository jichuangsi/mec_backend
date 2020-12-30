package com.jichuangsi.mes.model;

public class fileTableVo {

    private Integer id;
    private String fileName;//文件名称
    private String fileRoute;//文件路径
    private String filePassword;//文件验证密码
    private Integer deleteNo;//删除否
    private Integer staffId;//上传人
    private String staffName;//上传人

    private String createTime;//创建时间

    private String isEncryptionstr;//是否加密
    private Integer isEncryption;//是否加密

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

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getIsEncryptionstr() {
        return isEncryptionstr;
    }

    public void setIsEncryptionstr(String isEncryptionstr) {
        this.isEncryptionstr = isEncryptionstr;
    }

    public Integer getIsEncryption() {
        return isEncryption;
    }

    public void setIsEncryption(Integer isEncryption) {
        this.isEncryption = isEncryption;
    }
}
