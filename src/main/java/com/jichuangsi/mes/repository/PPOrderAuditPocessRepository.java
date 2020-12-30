package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.PPOrderAuditPocess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PPOrderAuditPocessRepository  extends JpaRepository<PPOrderAuditPocess,Integer> {

    @Query(value = "SELECT * FROM pp_order_auditpocess WHERE order_id = ?1 and finished = 0 ORDER BY audit_level ASC",nativeQuery = true)
    List<PPOrderAuditPocess> findByOrderId(Integer orderId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE pp_order_auditpocess SET  finished = 1  WHERE order_id = ?1 and  staff_id = ?2 and finished = 0   ORDER BY audit_level ASC LIMIT 1",nativeQuery = true)
    void updateByOrderIdAndStaffId(Integer orderId,Integer staffId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE pp_order_auditpocess SET  finished = 0  WHERE order_id = ?1",nativeQuery = true)
    void updateByOrderId(Integer orderId);


    @Query(value = "SELECT count(1) FROM pp_order_auditpocess WHERE order_id = ?1 ",nativeQuery = true)
    Integer countByOrderId(Integer orderId);

}
