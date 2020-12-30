package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.EquipmentOverhaul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipmentOverhaulRepository  extends JpaRepository<EquipmentOverhaul,Integer> {
    Integer countByEquipmentIdAndEquipmentTime(Integer equipmentId,String equipmentTime);

    EquipmentOverhaul findByid(Integer id);

    @Query(value = "SELECT * FROM t_equipmentoverhaul WHERE equipment_id = ?1 GROUP BY equipment_time  ORDER BY equipment_time DESC ",nativeQuery = true)
    List<EquipmentOverhaul> findAllByEquipmentId(Integer equipmentId);
}
