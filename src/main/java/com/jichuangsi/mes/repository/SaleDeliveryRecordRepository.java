package com.jichuangsi.mes.repository;

import com.jichuangsi.mes.entity.SCustomer;
import com.jichuangsi.mes.entity.SaleDeliveryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleDeliveryRecordRepository  extends JpaRepository<SaleDeliveryRecord,Integer> {

    List<SaleDeliveryRecord> findBySaleOrderId(Integer orderId);
}
