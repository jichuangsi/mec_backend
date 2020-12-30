package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.AuditSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuditSettingRepository extends JpaRepository<AuditSetting,Integer> {
    Integer countByAuditLevelAndAuditType(Integer auditLevel,String auditType);

    @Query(value = "SELECT * FROM audit_setting WHERE delete_no = 0 ORDER BY audit_level ASC",nativeQuery = true)
    List<AuditSetting> listauditByauditType(String auditType);

    @Query(value = "SELECT staff_id FROM audit_setting WHERE delete_no = 0 and audit_type = ?1 and audit_level = ?2 ",nativeQuery = true)
    Integer getstaffIdByauditTypeandLevel(String auditType,String level);
}
