package com.jichuangsi.mes.model;

public class SelectModel {


    private String findModelName;//需要查询的模块名字


    private Integer findById;//根据Id查询数据

    private String findName;//查询条件:模糊查询的栏
    private String findDate;//查询条件:根据开单日期查询
    private Integer findIdOne;//查询条件:根据某ID下拉框查询
    private Integer pageNum;//页数
    private Integer pageSize;//页码



    private Integer iswhether;//

    public Integer getIswhether() {
        return iswhether;
    }

    public void setIswhether(Integer iswhether) {
        this.iswhether = iswhether;
    }

    public String getFindDate() {
        return findDate;
    }

    public void setFindDate(String findDate) {
        this.findDate = findDate;
    }

    public Integer getFindById() {
        return findById;
    }

    public void setFindById(Integer findById) {
        this.findById = findById;
    }

    public Integer getFindIdOne() {
        return findIdOne;
    }

    public void setFindIdOne(Integer findIdOne) {
        this.findIdOne = findIdOne;
    }

    public String getFindModelName() {
        return findModelName;
    }

    public void setFindModelName(String findModelName) {
        this.findModelName = findModelName;
    }

    public String getFindName() {
        return findName;
    }

    public void setFindName(String findName) {
        this.findName = findName;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
