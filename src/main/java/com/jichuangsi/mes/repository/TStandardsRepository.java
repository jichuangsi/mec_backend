package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TStandards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface TStandardsRepository   extends JpaRepository<TStandards,Integer> {

    TStandards findByid(Integer id);

    List<TStandards> findByMaterialIdAndMaterialTypeAndDeleteNo(Integer materId,Integer materialType,Integer deleteNo);

    @Transactional
    @Modifying
    @Query(value = "UPDATE t_standards SET delete_no = 1 WHERE material_id = ?1",nativeQuery = true)
    void updateByOrderId(Integer orderId);
}
