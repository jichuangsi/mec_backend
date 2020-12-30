package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TTeam;
import com.jichuangsi.mes.model.MapVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TTeamRepository  extends JpaRepository<TTeam,Integer> {

    @Query(value = "SELECT * FROM t_team WHERE delete_no = 0 and if(?1 !='',team_name like concat('%',?1,'%'),1=1) LIMIT ?2,?3",nativeQuery = true)
    List<TTeam> findAllByPage(String deName, Integer pageNum, Integer pageSize);

    @Query(value = "SELECT count(1) FROM t_team where  delete_no = 0 and if(?1 !='',team_name like concat('%',?1,'%'),1=1)",nativeQuery = true)
    int countById(String deName);

    @Query(value = "SELECT id as MapKey,team_name as MapValue FROM t_team WHERE delete_no = 0 and state = 0",nativeQuery = true)
    List<MapVo> findAllXiaLa();

    TTeam findByid(Integer id);
}
