package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository  extends JpaRepository<Stock,Integer> {
    Integer countByStockNumber(String pnumber);

    @Query(value = "SELECT count(1) FROM t_stock ",nativeQuery = true)
    Integer countByid();


    @Query(value = "SELECT * FROM t_stock  WHERE delete_no = 0 and material_type = ?1 and if(?2 !='',  stock_name like concat('%',?2,'%'),1=1 ) ",nativeQuery = true)
    List<Stock> findByMaterialTypeAndProductName(Integer materialType,String productName);

    Stock findByid(Integer id);
}
