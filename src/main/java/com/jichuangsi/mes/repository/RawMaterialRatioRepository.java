package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.RawMaterialRatio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface RawMaterialRatioRepository extends JpaRepository<RawMaterialRatio,Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE rawmaterial_ratio SET delete_no = 1 where product_id = ?1",nativeQuery = true)
    void updateratioByOrderId(Integer orderId);
}
