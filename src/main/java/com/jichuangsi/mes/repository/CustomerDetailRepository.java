package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.CustomerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDetailRepository  extends JpaRepository<CustomerDetail,Integer> {

    @Query(value = "SELECT * FROM customer_detail WHERE delete_no = 0 and customer_id = ?1",nativeQuery = true)
    List<CustomerDetail> findAllByCustomerId(Integer clientid);
}
