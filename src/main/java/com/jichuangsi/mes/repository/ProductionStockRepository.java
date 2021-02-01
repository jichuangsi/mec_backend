package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.ProductionStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ProductionStockRepository extends JpaRepository<ProductionStock,Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE production_stock SET delete_no = 1 where pppid = ?1",nativeQuery = true)
    void updateByPPPId(Integer orderId);
}
