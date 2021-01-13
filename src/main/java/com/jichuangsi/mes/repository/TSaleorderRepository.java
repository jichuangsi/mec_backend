package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TSaleorder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TSaleorderRepository  extends JpaRepository<TSaleorder,Integer> {

    TSaleorder findByid(Integer id);



    List<TSaleorder> findByCreateTimeIsBetweenAndDeleteNo(Date startTime, Date endTime, Integer deleteNo);
}
