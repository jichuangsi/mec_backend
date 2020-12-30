package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.SStaffRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SStaffRoleRepository  extends JpaRepository<SStaffRole,Integer> {

    List<SStaffRole> findByStaffId(Integer uid);

}
