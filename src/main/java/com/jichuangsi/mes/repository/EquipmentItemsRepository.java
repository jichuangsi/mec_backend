package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.EquipmentItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface EquipmentItemsRepository  extends JpaRepository<EquipmentItems,Integer> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE t_equipmentitems SET delete_no = 1 where equipment_id = ?1",nativeQuery = true)
    void updateByEquipmentId(Integer EquipmentId);

    List<EquipmentItems> findAllByEquipmentIdAndDeleteNo(Integer equipmentId,Integer deleteNo);
}
