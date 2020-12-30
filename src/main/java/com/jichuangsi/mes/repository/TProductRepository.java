package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TProductRepository extends JpaRepository<TProduct,Integer> {
//    Integer countAllByIdNotContains();
    Integer countByProductNumber(String pnumber);

    TProduct findByid(Integer id);
}
