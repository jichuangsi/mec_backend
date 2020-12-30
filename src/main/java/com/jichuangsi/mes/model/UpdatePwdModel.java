package com.jichuangsi.mes.model;

public class UpdatePwdModel {

    private Integer userid;
    private String oldPwd;
    private String firstPwd;
    private String secondPwd;

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getFirstPwd() {
        return firstPwd;
    }

    public void setFirstPwd(String firstPwd) {
        this.firstPwd = firstPwd;
    }

    public String getSecondPwd() {
        return secondPwd;
    }

    public void setSecondPwd(String secondPwd) {
        this.secondPwd = secondPwd;
    }
}
