package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TProductRepository extends JpaRepository<TProduct,Integer> {
    @Query(value = "SELECT id FROM t_product ORDER BY id DESC LIMIT 1 ",nativeQuery = true)
    Integer findLastId();

//    Integer countAllByIdNotContains();
    Integer countByProductNumber(String pnumber);

    TProduct findByid(Integer id);
}
