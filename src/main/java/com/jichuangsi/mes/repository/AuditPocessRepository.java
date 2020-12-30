package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.AuditPocess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditPocessRepository extends JpaRepository<AuditPocess,Integer> {

    List<AuditPocess> findByAuditOrderId(Integer auditorderId);
}
