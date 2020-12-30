package com.jichuangsi.mes.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "s_systemlog")
public class SSystemlog {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private Integer staffId;//用户ID
    private String operates;//用户操作
    private String requestURL;//请求路径
    private String requestMode;//请求方式
    private String requestParam;//请求参数
    private String requestTime;//请求时长
    private long createTime= new Date().getTime();//时间
    private Integer loginState;//状态
    private String operaterIp;//操作IP
    private Integer deleteNo;

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
}
