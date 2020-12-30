package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.RepairReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairReportRepository extends JpaRepository<RepairReport,Integer> {

    Integer countByEquipmentIdAndStateNot(Integer equipmentId,Integer state);

    RepairReport findByid(Integer id);
}
