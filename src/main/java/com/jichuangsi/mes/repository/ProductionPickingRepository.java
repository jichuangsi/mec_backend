package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.ProductionPicking;
import com.jichuangsi.mes.entity.ProductionStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionPickingRepository extends JpaRepository<ProductionPicking,Integer> {

    ProductionPicking findByid(Integer id);
}
