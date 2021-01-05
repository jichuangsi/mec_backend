package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.InventoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface InventoryRecordRepository extends JpaRepository<InventoryRecord,Integer> {



    @Transactional
    @Modifying
    @Query(value = "UPDATE inventory_record SET inventory_type = 0 AND product_detailid = ?1 where inventory_type = ?2 or  inventory_type = 4",nativeQuery = true)
    void updateByPIdAndInventoryType(Integer productId,Integer inventoryType);
}
