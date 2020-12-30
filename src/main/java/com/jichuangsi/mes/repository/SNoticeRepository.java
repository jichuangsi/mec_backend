package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.SNotice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SNoticeRepository  extends JpaRepository<SNotice,Integer> {

    SNotice findByid(Integer id);
}
