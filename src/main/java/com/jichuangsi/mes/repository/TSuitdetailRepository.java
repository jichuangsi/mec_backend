package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TSuitdetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface TSuitdetailRepository  extends JpaRepository<TSuitdetail,Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE t_suitdetail SET delete_no = 1 AND suit_id = ?1",nativeQuery = true)
    void updateSuitDetailBySuitId(Integer suitId);

}
