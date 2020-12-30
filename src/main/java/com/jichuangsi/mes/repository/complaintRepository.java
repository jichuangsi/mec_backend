package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface complaintRepository   extends JpaRepository<complaint,Integer> {

    complaint findByid(Integer id);
}
