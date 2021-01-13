package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.SRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SRoleRepository  extends JpaRepository<SRole,Integer> {

    @Query(value = "SELECT * FROM s_role WHERE delete_no = 0 and if(?1 !='',role_name like concat('%',?1,'%'),1=1) order by id desc LIMIT ?2,?3",nativeQuery = true)
    List<SRole> findAllByPage(String deName, Integer pageNum, Integer pageSize);

    @Query(value = "SELECT count(1) FROM s_role where  delete_no = 0 and if(?1 !='',role_name like concat('%',?1,'%'),1=1)",nativeQuery = true)
    int countById(String deName);

    SRole findByid(Integer id);
}
