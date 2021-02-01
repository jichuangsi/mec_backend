package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TMouldDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface TMouldDetailRepository extends JpaRepository<TMouldDetail,Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE t_moulddetail SET delete_no = 1 WHERE mould_id = ?1",nativeQuery = true)
    void updateMoulddetailByMouldId(Integer orderId);

    List<TMouldDetail> findByMouldIdAndDeleteNo(Integer mouldId,Integer deleteNo);

}
