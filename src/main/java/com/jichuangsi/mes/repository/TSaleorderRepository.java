package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TSaleorder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TSaleorderRepository  extends JpaRepository<TSaleorder,Integer> {

    TSaleorder findByid(Integer id);
}
