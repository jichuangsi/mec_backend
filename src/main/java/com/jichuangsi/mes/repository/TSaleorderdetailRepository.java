package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TSaleorderdetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface TSaleorderdetailRepository   extends JpaRepository<TSaleorderdetail,Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE t_saleorderdetail SET delete_no = 1 where saleorder_id = ?1",nativeQuery = true)
    void updatesaleorderdetailByOrderId(Integer orderId);
}
