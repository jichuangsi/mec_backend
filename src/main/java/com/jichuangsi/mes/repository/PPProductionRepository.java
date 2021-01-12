package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.PPProduction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PPProductionRepository  extends JpaRepository<PPProduction,Integer> {

    PPProduction findByid(Integer id);


    List<PPProduction> findByCreateTimeIsBetweenAndGXId(Date startTime, Date endTime, Integer gxid);


    Integer countByProductionNumberAndGXId(String number,Integer gxId);

    List<PPProduction> findByCreateTimeIsBetweenAndDeleteNo(Date startTime, Date endTime, Integer deleteNo);
}
