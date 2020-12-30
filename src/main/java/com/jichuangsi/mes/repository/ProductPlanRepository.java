package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.ProductPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductPlanRepository  extends JpaRepository<ProductPlan,Integer> {
    ProductPlan findByid(Integer id);

    List<ProductPlan> findAllByDeleteNo(Integer deleteNo);
}
