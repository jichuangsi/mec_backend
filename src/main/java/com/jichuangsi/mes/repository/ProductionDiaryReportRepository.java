package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.ProductionDiaryReport;
import com.jichuangsi.mes.entity.ProductionStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductionDiaryReportRepository extends JpaRepository<ProductionDiaryReport,Integer> {

    ProductionDiaryReport findByProductionNumberAndProductDate(String productionNumber,String productTime);

    List<ProductionDiaryReport> findByProductionNumber(String productionNumber);
}
