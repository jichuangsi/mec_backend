package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.PPPWindingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PPPWindingInfoRepository   extends JpaRepository<PPPWindingInfo,Integer> {
    PPPWindingInfo findByPPPPIdAndPPPId(Integer ppppid,Integer pppid);
}
