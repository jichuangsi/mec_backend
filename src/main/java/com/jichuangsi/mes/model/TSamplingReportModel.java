package com.jichuangsi.mes.model;

import com.jichuangsi.mes.entity.TSamplingReport;
import com.jichuangsi.mes.entity.TSamplingReportDetail;

import java.util.List;

public class TSamplingReportModel {

    TSamplingReport tSamplingReport;

    List<TSamplingReportDetail> samplingReportDetailList;

    public TSamplingReport gettSamplingReport() {
        return tSamplingReport;
    }

    public void settSamplingReport(TSamplingReport tSamplingReport) {
        this.tSamplingReport = tSamplingReport;
    }

    public List<TSamplingReportDetail> getSamplingReportDetailList() {
        return samplingReportDetailList;
    }

    public void setSamplingReportDetailList(List<TSamplingReportDetail> samplingReportDetailList) {
        this.samplingReportDetailList = samplingReportDetailList;
    }
}
