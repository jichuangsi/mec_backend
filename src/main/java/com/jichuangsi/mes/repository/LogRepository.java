package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.SSystemlog;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LogRepository extends JpaRepository<SSystemlog,Integer> {
    @Query(value = "SELECT * FROM s_systemlog WHERE log_type = ?1 and delete_no =0 and (user_name like CONCAT('%',?2,'%') or ?2 is null ) and if(?3=0,1=1,login_state=?3) order by create_time desc LIMIT ?4,?5",nativeQuery = true)
    List<SSystemlog> getAllByLogTypeAndPage(@Param("logType")int logType, @Param("userName")String userName, @Param("log_status")int status, @Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);

    @Query(value = "SELECT count(1) FROM s_systemlog WHERE log_type = ?1 and delete_no =0 and (user_name like CONCAT('%',?2,'%') or ?2 is null ) and if(?3=0,1=1,login_state=?3)",nativeQuery = true)
    int countAllByLogType(@Param("logType")int logType, @Param("userName")String userName, @Param("log_status")int status);
}
