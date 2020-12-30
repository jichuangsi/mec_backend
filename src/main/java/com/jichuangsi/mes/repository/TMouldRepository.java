package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TMould;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TMouldRepository extends JpaRepository<TMould,Integer> {

    TMould findByid(Integer id);

}
