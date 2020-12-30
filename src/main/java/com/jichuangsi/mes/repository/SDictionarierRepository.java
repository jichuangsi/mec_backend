package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.SDictionarier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SDictionarierRepository  extends JpaRepository<SDictionarier,Integer> {

    SDictionarier findByid(Integer id);

    Integer countByNameAndDictFID(String name,Integer fid);

    List<SDictionarier> findByDictFIDAndDeleteNoAndState(Integer fid,Integer deleteNo,Integer state);

    @Query(value = "SELECT * FROM s_dictionarier WHERE delete_no = 0 and state = 0 and dictfid in(SELECT s_dictionarier.id as fid FROM s_dictionarier WHERE s_dictionarier.dic_code = ?1)",nativeQuery = true)
    List<SDictionarier> findByDicCode(String code);


}
