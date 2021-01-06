package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.PPAnnealingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PPAnnealingInfoRepository  extends JpaRepository<PPAnnealingInfo,Integer> {


    PPAnnealingInfo findByPppId(Integer pppid);

}
