package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.SCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SCustomerRepository extends JpaRepository<SCustomer,Integer> {
    @Query(value = "SELECT * FROM s_customer WHERE delete_no = 0 and  client_no = ?1 and if(?2 !='',customer_name like concat('%',?2,'%'),1=1 )  LIMIT ?3,?4",nativeQuery = true)
    List<SCustomer> findAllByPage(Integer clientNo, String deName, Integer pageNum, Integer pageSize);

    @Query(value = "SELECT count(1) FROM s_customer where  delete_no = 0 and  client_no = ?1 and if(?2 !='',customer_name like concat('%',?2,'%'),1=1 )",nativeQuery = true)
    int countById(Integer clientNo,String deName);

    SCustomer findByid(Integer clientId);

    @Query(value = "SELECT count(1) FROM s_customer",nativeQuery = true)
    int countByallId();
}
