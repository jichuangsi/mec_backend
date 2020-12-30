package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.PPProduction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface PPProductionRepository  extends JpaRepository<PPProduction,Integer> {

    PPProduction findByid(Integer id);


    Integer countByCreateTimeIsBetween(Date startTime,Date endTime);


    Integer countByProductionNumberAndGXId(String number,Integer gxId);
}
