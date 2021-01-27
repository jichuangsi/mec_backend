package com.jichuangsi.mes.model;

import com.jichuangsi.mes.entity.PickingStock;
import com.jichuangsi.mes.entity.ProductionPicking;
import com.jichuangsi.mes.entity.ProductionStock;

import java.util.List;

public class ProductionPickingModel {

    ProductionPicking productionPicking;//生产领料

    List<PickingStock> pickingStockList;//产品管理-熔炼使用的原料

    public ProductionPicking getProductionPicking() {
        return productionPicking;
    }

    public void setProductionPicking(ProductionPicking productionPicking) {
        this.productionPicking = productionPicking;
    }

    public List<PickingStock> getPickingStockList() {
        return pickingStockList;
    }

    public void setPickingStockList(List<PickingStock> pickingStockList) {
        this.pickingStockList = pickingStockList;
    }
}
