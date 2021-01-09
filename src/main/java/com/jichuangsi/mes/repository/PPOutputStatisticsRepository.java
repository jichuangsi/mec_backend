package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.PPOutputStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PPOutputStatisticsRepository  extends JpaRepository<PPOutputStatistics,Integer> {
    PPOutputStatistics findByPpId(Integer ppid);

    PPOutputStatistics findByPpNumber(String ppnumber);
}
