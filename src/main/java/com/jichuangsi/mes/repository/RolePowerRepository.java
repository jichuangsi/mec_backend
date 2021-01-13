package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.RolePower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolePowerRepository  extends JpaRepository<RolePower,Integer> {
    List<RolePower> findAllByDeleteNo(Integer deleteNo);

//    List<RolePower> findByFidAndStateAndDeleteNoandAndIsNode(Integer fid,Integer state,Integer deleteNo,Integer isNode);
}
