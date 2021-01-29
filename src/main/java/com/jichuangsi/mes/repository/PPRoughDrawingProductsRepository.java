package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.PPRoughDrawingProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface PPRoughDrawingProductsRepository  extends JpaRepository<PPRoughDrawingProducts,Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE pp_roughdrawingProducts SET delete_no = 1 WHERE pppid = ?1",nativeQuery = true)
    void updateByPPPId(Integer orderId);
}
