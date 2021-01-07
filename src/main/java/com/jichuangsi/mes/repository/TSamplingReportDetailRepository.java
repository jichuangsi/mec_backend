package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TSamplingReportDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TSamplingReportDetailRepository extends JpaRepository<TSamplingReportDetail,Integer> {
    List<TSamplingReportDetail> findBySamplingRId(Integer sid);
}
