package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.PPAnnealingInfo;
import com.jichuangsi.mes.entity.PickingStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PickingStockRepository   extends JpaRepository<PickingStock,Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE picking_stock SET delete_no = 1 AND ppiid = ?1",nativeQuery = true)
    void updateByPPIId(Integer orderId);


    List<PickingStock> findByPPIId(Integer id);
}
