package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.PPProductionModel;
import com.jichuangsi.mes.model.ResponseModel;
import com.jichuangsi.mes.model.SelectModel;
import com.jichuangsi.mes.model.UpdateModel;
import com.jichuangsi.mes.service.ProductionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api("后台-生产管理")
@CrossOrigin
@RestController
@RequestMapping("/ProductionController")
public class ProductionController {

    @Resource
    private ProductionService productionService;


    @ApiOperation("生产管理-熔炼- 新增/编辑页面获取生产计划单数据")
    @ApiImplicitParams({})
    @PostMapping("/getMeltingInfo")
    public ResponseModel getMeltingInfo(){
        try {
            return ResponseModel.sucess("",productionService.getMeltingInfo());
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产管理-熔炼- 新增/编辑页面根据生产计划单id获取生产计划单数据")
    @ApiImplicitParams({})
    @PostMapping("/getMeltingInfoById")
    public ResponseModel getMeltingInfoById(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionService.getMeltingInfoById(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产管理-熔炼- 新增/编辑页面根据生产计划单产物id获取(基本信息、原料比例、工艺参数、设备信息、操作信息)信息")
    @ApiImplicitParams({})
    @PostMapping("/getMeltingBasicInfoById")
    public ResponseModel getMeltingBasicInfoById(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionService.getMeltingBasicInfoById(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产管理-熔炼- 新增本班产物-根据设备id查询设备信息")
    @ApiImplicitParams({})
    @PostMapping("/getEquipmentXiaLaInfoById")
    public ResponseModel getEquipmentXiaLaInfoById(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionService.getEquipmentXiaLaInfoById(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产管理-下拉框-根据线轴id查询线轴信息")
    @ApiImplicitParams({})
    @PostMapping("/getBobbinXiaLaInfoByBId")
    public ResponseModel getBobbinXiaLaInfoByBId(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionService.getBobbinXiaLaInfoByBId(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产管理- 根据生产管理id查询详情信息")
    @ApiImplicitParams({})
    @PostMapping("/getProductionDetailByPPPId")
    public ResponseModel getProductionDetailByPPPId(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionService.getProductionDetailByPPPId(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产管理- 查询")
    @ApiImplicitParams({})
    @PostMapping("/getAllPPProduction")
    public ResponseModel getAllPPProduction(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionService.getAllPPProduction(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产管理- 草稿/转下班操作(-熔炼)-新增/编辑")
    @ApiImplicitParams({})
    @PostMapping("/savesmeltingProductsList")
    public ResponseModel savesmeltingProductsList(@RequestBody PPProductionModel ppProductionModel){
        try {
            productionService.savesmeltingProductsList(ppProductionModel);

        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("生产管理- 转下班操作（熔炼、粗拉、中拉、细拉、超细拉、绕线、改绕等）-新增/编辑")
    @ApiImplicitParams({})
    @PostMapping("/savePPProduction")
    public ResponseModel savePPProduction(@RequestBody PPProductionModel ppProductionModel){
        try {
            productionService.savePPProduction(ppProductionModel);

        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }


    @ApiOperation("生产管理-修改状态(state or  delete_no)")
    @ApiImplicitParams({})
    @PostMapping("/updatePPPByPPPId")
    public ResponseModel updatePPPByPPPId(@RequestBody UpdateModel updateModel){
        try {
            productionService.updatePPPByPPPId(updateModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("生产管理- 撤回上班工序（熔炼、粗拉、中拉、细拉、超细拉、绕线、改绕等）")
    @ApiImplicitParams({})
    @PostMapping("/backToPPProduction")
    public ResponseModel backToPPProduction(@RequestBody SelectModel selectModel){
        try {
            productionService.backToPPProduction(selectModel);

        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("生产管理- 转退火（熔炼、粗拉、中拉、细拉、超细拉、绕线、改绕等）")
    @ApiImplicitParams({})
    @PostMapping("/finishedPPProduction")
    public ResponseModel finishedPPProduction(@RequestBody PPProductionModel ppProductionModel){
        try {
            productionService.finishedPPProduction(ppProductionModel);

        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

}
