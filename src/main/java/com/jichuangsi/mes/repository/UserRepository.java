package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.SStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<SStaff,Integer> {
    @Query(value = "SELECT count(1) FROM s_staff where staff_num = ?1 and if(?2 !='',id != ?2,1=1)  ",nativeQuery = true)
    Integer countByStaffNum(String staffnum,Integer staffId);

    SStaff findByStaffNumAndLoginPasswordAndDeleteNo(String account,String Pwd,Integer deleteNo);

    SStaff findByid(Integer id);

    @Query(value = "SELECT count(1) FROM s_staff",nativeQuery = true)
    Integer countByid();

    SStaff findByStaffNum(String account);
}
