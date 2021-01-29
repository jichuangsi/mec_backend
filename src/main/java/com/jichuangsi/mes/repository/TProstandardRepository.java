package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TProstandard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface TProstandardRepository  extends JpaRepository<TProstandard,Integer> {

    List<TProstandard> findByProductIdAndDeleteNo(Integer productId,Integer deleteNo);


    @Transactional
    @Modifying
    @Query(value = "UPDATE t_prostandard SET delete_no = 1 WHERE product_id = ?1",nativeQuery = true)
    void updateprostandardByOrderId(Integer orderId);

}
