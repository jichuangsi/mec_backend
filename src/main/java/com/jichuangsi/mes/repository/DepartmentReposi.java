package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.Department;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentReposi extends JpaRepository<Department,Integer> {

    @Query(value = "SELECT * FROM department WHERE delete_no = 0 and (department_name like CONCAT('%',?1,'%') or ?1 is null ) LIMIT ?2,?3",nativeQuery = true)
    List<Department> findAllByPage(@Param("deName")String deName, @Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);

    @Query(value = "SELECT count(1) FROM department where  delete_no = 0 and (department_name like CONCAT('%',?1,'%') or ?1 is null )",nativeQuery = true)
    int countById(String deName);

    Department findByid(Integer id);
}
