package com.jichuangsi.mes.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Lob;

public class NoticeVo {

    private Integer id;//公告ID
    private String noticeName;//名称
    private String createTime;//发布时间
    private Integer staffId;//员工ID(发布人)
    private String staffName;//员工ID(发布人)

    @Lob
    @Basic(fetch = FetchType.LAZY) @Column(columnDefinition = "text")
    private String noticeContent;//公告内容
    private String noticeRoute;//
    private Integer isshow;//是否显示在首页
    private Integer deleteNo;//删除否

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeRoute() {
        return noticeRoute;
    }

    public void setNoticeRoute(String noticeRoute) {
        this.noticeRoute = noticeRoute;
    }

    public Integer getIsshow() {
        return isshow;
    }

    public void setIsshow(Integer isshow) {
        this.isshow = isshow;
    }

    public Integer getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(Integer deleteNo) {
        this.deleteNo = deleteNo;
    }
}
