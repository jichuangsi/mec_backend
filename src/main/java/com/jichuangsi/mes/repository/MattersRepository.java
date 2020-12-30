package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.Matters;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MattersRepository extends JpaRepository<Matters,Integer> {

List<Matters> findByStaffIdAndFinishedNo(Integer staffId,Integer finishedNo);
}
