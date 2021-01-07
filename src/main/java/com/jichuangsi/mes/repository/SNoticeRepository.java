package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.SNotice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SNoticeRepository  extends JpaRepository<SNotice,Integer> {

    SNotice findByid(Integer id);

    List<SNotice> findByIsshowAndDeleteNoOrderByCreateTimeDesc(Integer ishow,Integer deleteNo);
}
