package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TSamplingReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TSamplingReportRepository  extends JpaRepository<TSamplingReport,Integer> {

    TSamplingReport findByid(Integer id);
}
