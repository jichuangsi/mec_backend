package com.jichuangsi.mes.controller;


import com.jichuangsi.mes.advice.OperLog;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.*;
import com.jichuangsi.mes.service.ProductionInventoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api("后台-生产库存管理")
@CrossOrigin
@RestController
@RequestMapping("/ProductionInventoryController")
public class ProductionInventoryController {

    @Resource
    private ProductionInventoryService productionInventoryService;



    @ApiOperation("生产库存管理-生产领料-查询当前生产计划单")
    @ApiImplicitParams({})
    @PostMapping("/getPPPlanInfo")
    public ResponseModel getPPPlanInfo(){
        try {
            return ResponseModel.sucess("",productionInventoryService.getPPPlanInfo());
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产库存管理-生产领料-根据生产计划单id查询生产计划单详情")
    @ApiImplicitParams({})
    @PostMapping("/getPPPlanInfoById")
    public ResponseModel getPPPlanInfoById(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionInventoryService.getPPPlanInfoById(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }


    @ApiOperation("生产库存管理- 生产领料-新增/编辑")
    @ApiImplicitParams({})
    @PostMapping("/saveProductionPicking")
    @OperLog(operModul = "新增/编辑",operType = "2",operDesc = "生产库存管理- 生产领料- 保存操作")
    public ResponseModel saveProductionPicking( @RequestBody ProductionPickingModel productionPickingModel){
        try {
            productionInventoryService.saveProductionPicking(productionPickingModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }


    @ApiOperation("生产库存管理-生产领料- 查询")
    @ApiImplicitParams({})
    @PostMapping("/getAllPPPicking")
    public ResponseModel getAllPPPicking(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionInventoryService.getAllPPPicking(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }


    @ApiOperation("生产库存管理-生产领料- 根据id查询详情")
    @ApiImplicitParams({})
    @PostMapping("/getPPPickingById")
    public ResponseModel getPPPickingById(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionInventoryService.getPPPickingById(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产库存管理-修改状态(delete_no)")
    @ApiImplicitParams({})
    @PostMapping("/updatePPIByPPIId")
    @OperLog(operModul = "修改状态",operType = "2",operDesc = "修改状态(delete_no)")
    public ResponseModel updatePPIByPPIId(@RequestBody UpdateModel updateModel){
        try {
            productionInventoryService.updatePPIByPPIId(updateModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }



    @ApiOperation("生产库存管理-生产入库-查询车间库存")
    @ApiImplicitParams({})
    @PostMapping("/getWorkshopInventory")
    public ResponseModel getWorkshopInventory(){
        try {
            return ResponseModel.sucess("",productionInventoryService.getWorkshopInventory());
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }


    @ApiOperation("生产库存管理-生产入库-根据id查询车间库存")
    @ApiImplicitParams({})
    @PostMapping("/getWorkshopInventoryById")
    public ResponseModel getWorkshopInventoryById(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionInventoryService.getWorkshopInventoryById(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产库存管理-生产入库-入库操作")
    @ApiImplicitParams({})
    @PostMapping("/UpdateWareHouseId")
    public ResponseModel UpdateWareHouseId(@RequestBody SelectModel selectModel){
        try {
            productionInventoryService.UpdateWareHouseId(selectModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }
}
