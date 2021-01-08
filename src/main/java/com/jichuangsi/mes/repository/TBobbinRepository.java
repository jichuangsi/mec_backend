package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TBobbin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TBobbinRepository extends JpaRepository<TBobbin,Integer> {
    Integer countByBobbinNumber(String number);

//    @Query(value = "SELECT * FROM t_bobbin  WHERE id != 0 and if(?1 !='',  bobbin_name like concat('%',?1,'%'),1=1 ) ",nativeQuery = true)
//    List<TBobbin> findByBobbinName(String bobbinName);

    TBobbin findByid(Integer id);
}
