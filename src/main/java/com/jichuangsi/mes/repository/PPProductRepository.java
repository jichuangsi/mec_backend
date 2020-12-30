package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.PPProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PPProductRepository  extends JpaRepository<PPProduct,Integer> {

    PPProduct findByid(Integer id);
}
