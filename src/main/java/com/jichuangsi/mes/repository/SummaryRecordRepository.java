package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.SSystemlog;
import com.jichuangsi.mes.entity.SummaryRecord;
import com.jichuangsi.mes.entity.TBobbin;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SummaryRecordRepository  extends JpaRepository<SummaryRecord,Integer> {

//    WHERE (create_time like CONCAT('%',?1,'%') is null )
    @Query(value = "SELECT * FROM t_summary_record WHERE (create_time like CONCAT('%',?1,'%') is null )  order by create_time desc LIMIT ?2,?3",nativeQuery = true)
    List<SummaryRecord> getAllByCreateTimeAndPage(@Param("createTime")String createTime, @Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);


    @Query(value = "SELECT count(1) FROM t_summary_record WHERE (create_time like CONCAT('%',?1,'%') is null )",nativeQuery = true)
    Integer countAllByCreateTime(@Param("createTime")String createTime);


//    @Query(value = "SELECT SUM(settlement_account) as settlementAccount,create_time as createTime FROM t_summary_record GROUP BY create_time  order by create_time desc LIMIT ?1,?2",nativeQuery = true)
//    List<SummaryRecord> getAllByCreateTimeAndPageByMonth( @Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);
//
//
//    @Query(value = "SELECT count(1) FROM (SELECT * FROM t_summary_record GROUP BY create_time)a ",nativeQuery = true)
//    Integer countAllByCreateTimeByMonth();

}
