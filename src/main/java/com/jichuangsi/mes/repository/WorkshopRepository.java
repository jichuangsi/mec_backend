package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.Workshop;
import com.jichuangsi.mes.model.MapVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkshopRepository extends JpaRepository<Workshop,Integer> {
    Workshop findFirstByOrderByIdDesc();//获取最新一条数据回填

}
