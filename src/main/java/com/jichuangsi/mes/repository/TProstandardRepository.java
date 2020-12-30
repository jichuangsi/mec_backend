package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.TProstandard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface TProstandardRepository  extends JpaRepository<TProstandard,Integer> {

//    @Query(value = "SELECT product_id,delete_no,\n" +
//            "(case  el_start when 0.00000000 then &lt; else el_start end)\n" +
//            "(case  bl_start when 0.00000000 then "" else bl_start end),\n" +
//            "(case  coarse_start when 0.00000000 then **<=** else coarse_start end),\n" +
//            "(case  diam_start when 0.00000000 then **<=** else diam_start end),\n" +
//            "(case  semi_start when 0.00000000 then **<=** else semi_start end),\n" +
//            "(case  el_end when 0.00000000 then **<=** else el_end end),\n" +
//            "(case  bl_eend when 0.00000000 then **<=** else bl_eend end),\n" +
//            "(case  coarse_end when 0.00000000 then **<=** else coarse_end end),\n" +
//            "(case  diam_end when 0.00000000 then **<=** else diam_end end),\n" +
//            "(case  semi_end when 0.00000000 then **<=** else semi_end end)\n" +
//            "FROM t_prostandard tpro\n" +
//            "WHERE tpro.product_id = ?1 and tpro.delete_no = ?2,1=1 ) ",nativeQuery = true)
    List<TProstandard> findByProductIdAndDeleteNo(Integer productId,Integer deleteNo);


    @Transactional
    @Modifying
    @Query(value = "UPDATE t_prostandard SET delete_no = 1 AND product_id = ?1",nativeQuery = true)
    void updateprostandardByOrderId(Integer orderId);

}
