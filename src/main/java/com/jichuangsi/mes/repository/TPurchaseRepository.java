package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TPurchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TPurchaseRepository extends JpaRepository<TPurchase,Integer> {

    Integer countByPurchaseOrder(String ordernum);

    TPurchase findByid(Integer id);
}
