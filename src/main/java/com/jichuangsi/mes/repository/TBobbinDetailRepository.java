package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.SummaryRecord;
import com.jichuangsi.mes.entity.TBobbinDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TBobbinDetailRepository extends JpaRepository<TBobbinDetail,Integer> {

    List<TBobbinDetail> findByStandardIdAndDeleteNo(Integer standardId,Integer deleteNo);
}
