package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.SStaffRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface SStaffRoleRepository  extends JpaRepository<SStaffRole,Integer> {

    List<SStaffRole> findByStaffIdAndDeleteNo(Integer uid,Integer deleteNo);


    List<SStaffRole> findByStaffIdAndRoleIdAndDeleteNo(Integer uid,Integer roleId,Integer deleteNo);


    @Transactional
    @Modifying
    @Query(value = "UPDATE s_staffrole SET delete_no = 1 where staff_id = ?1",nativeQuery = true)
    void updateByStaffId(Integer staffId);

}
