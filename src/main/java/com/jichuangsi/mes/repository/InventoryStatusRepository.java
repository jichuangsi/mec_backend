package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.InventoryStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryStatusRepository extends JpaRepository<InventoryStatus,Integer> {


    InventoryStatus findByProductIdAndWarehouseIdAndInventoryType(Integer productId,Integer warehouseId,Integer inventoryType);


    InventoryStatus findByid(Integer id);

    List<InventoryStatus> findAllByProductIdAndWarehouseIdAndInventoryType(Integer productId,Integer warehouseId,Integer inventoryType);
}
