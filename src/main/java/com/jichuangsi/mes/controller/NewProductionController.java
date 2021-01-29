package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.advice.OperLog;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.*;
import com.jichuangsi.mes.service.NewProductionService;
import com.jichuangsi.mes.service.ProductionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api("后台-新的-生产管理")
@CrossOrigin
@RestController
@RequestMapping("/NewProductionController")
public class NewProductionController {
    @Resource
    private NewProductionService newProductionService;


    //生产管理：
    // 净重= 毛重-轴重
    //损耗 = 总毛重-总轴重-总废料

    @ApiOperation("【新】-生产管理-熔炼- 新增/编辑页面根据生产计划单id获取生产计划单数据and原材料数据")
    @ApiImplicitParams({})
    @PostMapping("/getMeltingInfoById")
    public ResponseModel getMeltingInfoById(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",newProductionService.getMeltingInfoById(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("【新】-生产管理-(粗拉、中拉、细拉、超细拉、退火、绕线、改绕等)- 查询生产批号")
    @ApiImplicitParams({})
    @PostMapping("/getProductionList")
    public ResponseModel getProductionList(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",newProductionService.getProductionList(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }


    @ApiOperation("【新】-生产管理-熔炼[开始生产]操作-新增/编辑")
    @ApiImplicitParams({})
    @PostMapping("/saveStartProduction")
    @OperLog(operModul = "新增/编辑",operType = "2",operDesc = "生产管理-熔炼[开始生产]-新增/编辑")
    public ResponseModel saveStartProduction(@ModelAttribute UserInfoForToken userInfoForToken, @RequestBody PPProductionModel ppProductionModel){
        try {
            newProductionService.saveStartProduction(userInfoForToken,ppProductionModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }


    @ApiOperation("【新】-生产管理-粗拉、中拉、细拉、超细拉、退火、绕线、改绕等[开始生产]操作-新增/编辑")
    @ApiImplicitParams({})
    @PostMapping("/saveStartProduction2")
    @OperLog(operModul = "新增/编辑",operType = "2",operDesc = "生产管理-熔炼-新增/编辑")
    public ResponseModel saveStartProduction2(@ModelAttribute UserInfoForToken userInfoForToken, @RequestBody PPProductionModel ppProductionModel){
        try {
            newProductionService.saveStartProduction2(userInfoForToken,ppProductionModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }


}
