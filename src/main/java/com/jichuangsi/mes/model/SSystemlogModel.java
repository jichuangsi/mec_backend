package com.jichuangsi.mes.model;


import javax.persistence.*;
import java.util.Date;

public class SSystemlogModel {

    private Integer id;
    private Integer staffId;//用户ID
    private String operates;//用户操作
    private String requestURL;//请求路径
    private String requestMode;//请求方式
    private String requestParam;//请求参数
    private String requestTime;//请求时长
    private long createTime= new Date().getTime();//时间
    private Integer loginState;//状态1成功2失败
    private String loginStateName;//状态1成功2失败
    private String operaterIp;//操作IP
    private Integer deleteNo;
    private String userAgent;
    private String exceptionName;
    private String exceptionMessage;
    private Integer logType;//日志类型 登陆1 操作2 异常3
    private String operModel;//操作模块
    private String userName;//用户名称
    private String failMessage;
    private String date;
    private String resultSet;


    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public String getRequestMode() {
        return requestMode;
    }

    public void setRequestMode(String requestMode) {
        this.requestMode = requestMode;
    }

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

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

    public String getOperates() {
        return operates;
    }

    public void setOperates(String operates) {
        this.operates = operates;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public Integer getLoginState() {
        return loginState;
    }

    public void setLoginState(Integer loginState) {
        this.loginState = loginState;
    }

    public String getOperaterIp() {
        return operaterIp;
    }

    public void setOperaterIp(String operaterIp) {
        this.operaterIp = operaterIp;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public Integer getLogType() {
        return logType;
    }

    public String getOperModel() {
        return operModel;
    }

    public void setOperModel(String operModel) {
        this.operModel = operModel;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFailMessage() {
        return failMessage;
    }

    public void setFailMessage(String failMessage) {
        this.failMessage = failMessage;
    }

    public String getLoginStateName() {
        return loginStateName;
    }

    public void setLoginStateName(String loginStateName) {
        this.loginStateName = loginStateName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResultSet() {
        return resultSet;
    }

    public void setResultSet(String resultSet) {
        this.resultSet = resultSet;
    }
}
