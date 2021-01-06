package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.ELBLData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ELBLDataRepository  extends JpaRepository<ELBLData,Integer> {
    List<ELBLData> findByPPPIdAndGxId(Integer pppId,Integer gxId);
}
