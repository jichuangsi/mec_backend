package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.EquipmentCheckRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentCheckRecordRepository  extends JpaRepository<EquipmentCheckRecord,Integer> {

//    @Query(value = "SELECT count(1) FROM t_equipmentcheckrecord WHERE equipment_time = ?1 and equipment_id = ?2 and frequency = ?3",nativeQuery = true)
    Integer countByEquipmentTimeAndEquipmentIdAndFrequency(String equiTime, Integer equipmentId, Integer frequency);
}
