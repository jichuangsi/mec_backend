package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.RolePower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePowerRepository  extends JpaRepository<RolePower,Integer> {

//    List<RolePower> findByFidAndStateAndDeleteNoandAndIsNode(Integer fid,Integer state,Integer deleteNo,Integer isNode);
}
