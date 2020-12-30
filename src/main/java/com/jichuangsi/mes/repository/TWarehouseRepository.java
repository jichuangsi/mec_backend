package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TWarehouseRepository  extends JpaRepository<TWarehouse,Integer> {
    TWarehouse findByid(Integer id);
}
