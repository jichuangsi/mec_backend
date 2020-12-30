package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment,Integer> {
    Integer countByEquipmentNumber(String equipmentNumber);

    Equipment findByid(Integer id);
}
