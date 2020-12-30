package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.OrderAuditPocess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;


public interface OrderAuditPocessRepository extends JpaRepository<OrderAuditPocess,Integer> {

    @Query(value = "SELECT * FROM order_auditpocess WHERE audit_type = ?1 and order_id = ?2 and finished = 0 ORDER BY audit_level ASC",nativeQuery = true)
    List<OrderAuditPocess> findByAuditTypeAndOrderId(String deName, Integer orderId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE order_auditpocess SET  finished = 1  WHERE audit_type = ?1 AND order_id = ?2 and  staff_id = ?3 and finished = 0   ORDER BY audit_level ASC LIMIT 1",nativeQuery = true)
    void updateByAuditTypeAndOrderIdandAndStaffId(String deName, Integer orderId,Integer staffId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE order_auditpocess SET  finished = 0  WHERE audit_type = ?1 AND order_id = ?2",nativeQuery = true)
    void updateByAuditTypeAndOrderId(String deName, Integer orderId);


    @Query(value = "SELECT count(1) FROM order_auditpocess WHERE (audit_type = ?1 or audit_type = ?2) and order_id = ?3 ",nativeQuery = true)
    Integer findByAuditTypeTwoAndOrderId(String deName, String deNameTwo, Integer orderId);
}
