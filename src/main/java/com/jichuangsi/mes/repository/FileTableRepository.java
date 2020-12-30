package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.FileTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileTableRepository extends JpaRepository<FileTable,Integer> {

    FileTable findByid(Integer id);

}
