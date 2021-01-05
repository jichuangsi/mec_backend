package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.entity.TWarehouse;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.ResponseModel;
import com.jichuangsi.mes.model.SelectModel;
import com.jichuangsi.mes.model.UpdateModel;
import com.jichuangsi.mes.service.WarehouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api("后台-库存管理")
@CrossOrigin
@RestController
@RequestMapping("/warehouseController")
public class WarehouseController {

    @Resource
    private WarehouseService warehouseService;

    @ApiOperation("仓库管理- 新增/编辑页面获取下拉框数据")
    @ApiImplicitParams({})
    @PostMapping("/getwarehouseBasicInfo")
    public ResponseModel getwarehouseBasicInfo(){
        try {
            return ResponseModel.sucess("",warehouseService.getwarehouseBasicInfo());
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("仓库管理- 新增/编辑")
    @ApiImplicitParams({})
    @PostMapping("/saveWarehouse")
    public ResponseModel saveWarehouse(@RequestBody TWarehouse tWarehouse){
        try {
            warehouseService.saveWarehouse(tWarehouse);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("仓库管理-查询")
    @ApiImplicitParams({})
    @PostMapping("/getAllWarehouse")
    public ResponseModel getAllWarehouse(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",warehouseService.getAllWarehouse(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("仓库管理-根据Id查询订单详情")
    @ApiImplicitParams({})
    @PostMapping("/getWarehourseById")
    public ResponseModel getWarehourseById(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",warehouseService.getWarehourseById(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("仓库管理-修改状态(state or  delete_no)")
    @ApiImplicitParams({})
    @PostMapping("/updateWarehouseByid")
    public ResponseModel updateWarehouseByid(@RequestBody UpdateModel smodel){
        try {
            warehouseService.updateWarehouseByid(smodel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }


    @ApiOperation("库存管理-出入库管理-查询")
    @ApiImplicitParams({})
    @PostMapping("/getAllWarehousing")
    public ResponseModel getAllWarehousing(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",warehouseService.getAllWarehousing(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("库存管理-出入库管理-查询下拉框")
    @ApiImplicitParams({})
    @PostMapping("/getWarehousXiaLa")
    public ResponseModel getWarehousXiaLa(){
        try {
            return ResponseModel.sucess("",warehouseService.getWarehousXiaLa());
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("库存管理-出入库管理-入库查询(原材料、成品、废料、线轴、其他等)")
    @ApiImplicitParams({})
    @PostMapping("/getAllWarehousingProduct")
    public ResponseModel getAllWarehousingProduct(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",warehouseService.getAllWarehousingProduct(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("库存管理-出入库管理-入库查询(根据Id查询明细)")
    @ApiImplicitParams({})
    @PostMapping("/getAllWarehousingProductById")
    public ResponseModel getAllWarehousingProductById(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",warehouseService.getAllWarehousingProductById(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("库存管理-出入库管理-入库操作")
    @ApiImplicitParams({})
    @PostMapping("/updateWarehouseIn")
    public ResponseModel updateWarehouseIn(@RequestBody List<UpdateModel> smodel){//List<UpdateModel> smodel
        try {
            warehouseService.updateWarehouseIn(smodel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("库存管理-出入库管理-调拨/出库数据查询")
    @ApiImplicitParams({})
    @PostMapping("/getAllWarehousingChuKu")
    public ResponseModel getAllWarehousingChuKu(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",warehouseService.getAllWarehousingChuKu(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("库存管理-出入库管理-调拨/出库数据根据产品id查询明细")
    @ApiImplicitParams({})
    @PostMapping("/getAllWarehousingChuKuById")
    public ResponseModel getAllWarehousingChuKuById(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",warehouseService.getAllWarehousingChuKuById(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("库存管理-出入库管理-调拨操作")
    @ApiImplicitParams({})
    @PostMapping("/updateWarehouseAllocation")
    public ResponseModel updateWarehouseAllocation(@RequestBody List<UpdateModel> smodel){
        try {
            warehouseService.updateWarehouseAllocation(smodel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("库存管理-出入库管理-出库操作")
    @ApiImplicitParams({})
    @PostMapping("/updateWarehouseOut")
    public ResponseModel updateWarehouseOut(@RequestBody List<UpdateModel> updateModels){
        try {
            warehouseService.updateWarehouseOut(updateModels);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }



    @ApiOperation("库存管理-库存状况-页面查询(原材料、半成品、成品、废料、线轴、其他等)")
    @ApiImplicitParams({})
    @PostMapping("/getAllInventoryStates")
    public ResponseModel getAllInventoryStates(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",warehouseService.getAllInventoryStates(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("库存管理- 库存状况-库存详情获取下拉框数据")
    @ApiImplicitParams({})
    @PostMapping("/getwarehouseInventoryStatesBasicInfo")
    public ResponseModel getwarehouseInventoryStatesBasicInfo(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",warehouseService.getwarehouseInventoryStatesBasicInfo(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("库存管理-库存状况-页面查询 根据id查询明细(原材料、半成品、成品、废料、线轴、其他等)")
    @ApiImplicitParams({})
    @PostMapping("/getAllInventoryStatesById")
    public ResponseModel getAllInventoryStatesById(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",warehouseService.getAllInventoryStatesById(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("库存管理-库存状况-盘点库存操作")
    @ApiImplicitParams({})
    @PostMapping("/updateInventoryStateSum")
    public ResponseModel updateInventoryStateSum(@RequestBody UpdateModel smodel){
        try {
            warehouseService.updateInventoryStateSum(smodel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }

}
