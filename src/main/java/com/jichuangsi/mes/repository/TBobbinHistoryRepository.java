package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TBobbinDetail;
import com.jichuangsi.mes.entity.TBobbinHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TBobbinHistoryRepository extends JpaRepository<TBobbinHistory,Integer> {

    List<TBobbinHistory> findByBobbinDetailIdOrderByCreateTimeDesc(Integer bdId);
}
