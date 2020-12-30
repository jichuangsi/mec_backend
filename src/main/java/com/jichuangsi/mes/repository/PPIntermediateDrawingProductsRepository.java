package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.PPIntermediateDrawingProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface PPIntermediateDrawingProductsRepository  extends JpaRepository<PPIntermediateDrawingProducts,Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE pp_intermediateDrawingProducts SET delete_no = 1 AND pppid = ?1",nativeQuery = true)
    void updateByPPPId(Integer orderId);
}
