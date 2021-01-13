package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.MesPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MesPostRepository extends JpaRepository<MesPost,Integer> {

    @Query(value = "SELECT * FROM mes_post WHERE delete_no = 0 and if(?1 !='',post_name like concat('%',?1,'%'),1=1 ) order by id desc LIMIT ?2,?3",nativeQuery = true)
    List<MesPost> findAllByPage(String deName, Integer pageNum, Integer pageSize);

    @Query(value = "SELECT count(1) FROM mes_post where  delete_no = 0 and if(?1 !='',post_name like concat('%',?1,'%'),1=1)",nativeQuery = true)
    int countById(String deName);

    MesPost findByid(Integer id);
}
