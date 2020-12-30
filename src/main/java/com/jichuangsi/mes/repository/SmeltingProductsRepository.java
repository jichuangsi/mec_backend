package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.SmeltingProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface SmeltingProductsRepository extends JpaRepository<SmeltingProducts,Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE smelting_products SET delete_no = 1 AND pppid = ?1",nativeQuery = true)
    void updateByPPPId(Integer orderId);


    List<SmeltingProducts> findByPPPIdAndDeleteNo(Integer pppid,Integer deleteNo);
}
