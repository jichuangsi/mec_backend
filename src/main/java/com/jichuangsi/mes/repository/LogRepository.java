package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.SSystemlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<SSystemlog,Integer> {
}
