package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TFinishedproducecheck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TFinishedproducecheckRepository  extends JpaRepository<TFinishedproducecheck,Integer> {


    List<TFinishedproducecheck> findAllByMouldId(Integer mouldId);

    TFinishedproducecheck findByid(Integer id);
}
