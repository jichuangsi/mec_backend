package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.Matters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface MattersRepository extends JpaRepository<Matters,Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE matters SET finished_no = 1 , read_no = 1 WHERE staff_id = ?1 AND type = ?2 AND order_id = ?3",nativeQuery = true)
    void updateByStaffIdAndTypeAndOrderId(Integer staffId,Integer type,Integer orderId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE matters SET read_no = 1 WHERE staff_id = ?1 AND type = ?2 AND order_id = ?3",nativeQuery = true)
    void updateReadNoByStaffIdAndTypeAndOrderId(Integer staffId,Integer type,Integer orderId);

}
