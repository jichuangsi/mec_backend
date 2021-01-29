package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TMould;
import com.jichuangsi.mes.entity.TPacking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TPackingRepository extends JpaRepository<TPacking,Integer> {


    TPacking findByid(Integer id);
}
