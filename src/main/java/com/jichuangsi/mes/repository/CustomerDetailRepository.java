package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.CustomerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerDetailRepository  extends JpaRepository<CustomerDetail,Integer> {

    @Query(value = "SELECT * FROM customer_detail WHERE delete_no = 0 and customer_id = ?1",nativeQuery = true)
    List<CustomerDetail> findAllByCustomerId(Integer clientid);


    @Transactional
    @Modifying
    @Query(value = "UPDATE customer_detail SET delete_no = 1 where customer_id = ?1",nativeQuery = true)
    void updateByClientId(Integer clientid);
}
