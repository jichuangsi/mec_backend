package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TCuffingcheck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TCuffingcheckRepository extends JpaRepository<TCuffingcheck,Integer> {

    TCuffingcheck findByid(Integer id);
}
