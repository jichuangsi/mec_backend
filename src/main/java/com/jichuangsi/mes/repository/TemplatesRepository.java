package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.Templates;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TemplatesRepository extends JpaRepository<Templates,Integer> {
    @Query(value = "SELECT * FROM templates WHERE type = ?1 and delete_no =0 and (name like CONCAT('%',?2,'%') or ?2 is null ) LIMIT ?3,?4",nativeQuery = true)
    List<Templates> findAllByPage(@Param("type") int type, @Param("name") String name, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    @Query(value = "SELECT count(1) FROM templates WHERE type = ?1 and delete_no =0 and (name like CONCAT('%',?2,'%') or ?2 is null ) ",nativeQuery = true)
    int countAllBytype(@Param("type") int type, @Param("name") String name);

    Templates findById(int id);

    List<Templates> findAllByClosed(int closed);

    Templates findByIdAndDeleteNo(int id,int deleteNo);
}
