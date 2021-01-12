package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.InventoryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InventoryStatusRepository extends JpaRepository<InventoryStatus,Integer> {


    InventoryStatus findByProductIdAndWarehouseIdAndInventoryType(Integer productId,Integer warehouseId,Integer inventoryType);


    InventoryStatus findByid(Integer id);

    List<InventoryStatus> findAllByProductIdAndWarehouseIdAndInventoryType(Integer productId,Integer warehouseId,Integer inventoryType);


//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE inventory_status SET inventorysum = 0 ,inventorynumbers =  0 where ppp_id = ?1 and inventory_type = ?2",nativeQuery = true)  //or  inventory_type = 4
//    void updateByProductIdAndInventoryType(Integer productId,Integer inventoryType);

    @Transactional
    @Modifying
    @Query(value = "UPDATE inventory_status SET delete_no = 1,state = 1 where ppp_id = ?1 and inventory_type = ?2",nativeQuery = true)  //or  inventory_type = 4
    void updateDeleteNoByProductIdAndInventoryType(Integer productId,Integer inventoryType);

}
