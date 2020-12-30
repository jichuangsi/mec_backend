package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TSuit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TSuitRepository  extends JpaRepository<TSuit,Integer> {

    TSuit findByid(Integer id);
}
