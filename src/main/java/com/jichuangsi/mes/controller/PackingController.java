package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.advice.OperLog;
import com.jichuangsi.mes.entity.TPacking;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.PPProductionModel;
import com.jichuangsi.mes.model.ResponseModel;
import com.jichuangsi.mes.model.SelectModel;
import com.jichuangsi.mes.model.UserInfoForToken;
import com.jichuangsi.mes.service.PackingService;
import com.jichuangsi.mes.service.ProductionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api("后台-包装管理")
@CrossOrigin
@RestController
@RequestMapping("/packingController")
public class PackingController {


    @Resource
    private PackingService packingService;


    @ApiOperation("包装管理- 保存操作-新增/编辑")
    @ApiImplicitParams({})
    @PostMapping("/savePicking")
    @OperLog(operModul = "新增/编辑",operType = "2",operDesc = "包装管理- 保存操作")
    public ResponseModel savePicking(@ModelAttribute UserInfoForToken userInfoForToken, @RequestBody TPacking tPacking) {
        try {
            packingService.savePicking(tPacking);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }
    @ApiOperation("包装管理- 查询")
    @ApiImplicitParams({})
    @PostMapping("/getAllPicking")
    public ResponseModel getAllPicking(@RequestBody SelectModel smodel) {
        try {
            ;
            return ResponseModel.sucess("",packingService.getAllPicking(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }


    @ApiOperation("包装管理- 根据id查询详情")
    @ApiImplicitParams({})
    @PostMapping("/getPickingById")
    public ResponseModel getPickingById(@RequestBody SelectModel smodel) {
        try {
            ;
            return ResponseModel.sucess("",packingService.getPickingById(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }
}
