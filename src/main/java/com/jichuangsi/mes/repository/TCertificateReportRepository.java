package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TCertificateReport;
import com.jichuangsi.mes.entity.Templates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TCertificateReportRepository  extends JpaRepository<TCertificateReport,Integer> {
    TCertificateReport findByid(Integer id);
}
