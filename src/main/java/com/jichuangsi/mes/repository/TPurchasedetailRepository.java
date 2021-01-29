package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TPurchasedetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface TPurchasedetailRepository  extends JpaRepository<TPurchasedetail,Integer> {


    @Transactional
    @Modifying
    @Query(value = "UPDATE t_purchasedetail SET delete_no = 1 where purchase_id = ?1",nativeQuery = true)
    void updatepurchasedetailByOrderId(Integer orderId);
}
