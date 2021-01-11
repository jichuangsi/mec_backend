package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.advice.OperLog;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.*;
import com.jichuangsi.mes.service.ProductionPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Api("后台-生产计划单")
@CrossOrigin
@RestController
@RequestMapping("/ProductionPlanController")
public class ProductionPlanController {


    @Resource
    private ProductionPlanService productionPlanService;


    @ApiOperation("生产计划单- 新增/编辑页面获取下拉框数据")
    @ApiImplicitParams({})
    @PostMapping("/getPPBasicInfo")
    public ResponseModel getPPBasicInfo(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionPlanService.getPPBasicInfo(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产计划单- 新增/编辑页面-设置产物-获取生产数据")
    @ApiImplicitParams({})
    @PostMapping("/getPPProductInfo")
    public ResponseModel getPPProductInfo(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionPlanService.getPPProductInfo(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产计划单- 新增/编辑页面-设置产物-根据销售订单id/产品id查询明细")
    @ApiImplicitParams({})
    @PostMapping("/getPPProductInfoById")
    public ResponseModel getPPProductInfoById(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionPlanService.getPPProductInfoById(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产计划单- 新增/编辑")
    @ApiImplicitParams({})
    @PostMapping("/saveProductPlan")
    @OperLog(operModul = "新增/编辑",operType = "2",operDesc = "生产计划单- 保存操作")
    public ResponseModel saveProductPlan(@ModelAttribute UserInfoForToken userInfoForToken,@RequestBody ProductPlanModel productPlanModel){
        try {
            productionPlanService.saveProductPlan(userInfoForToken,productPlanModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }


    @ApiOperation("生产计划单-查询")
    @ApiImplicitParams({})
    @PostMapping("/getAllProductPlan")
    public ResponseModel getAllProductPlan(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",productionPlanService.getAllProductPlan(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产计划单-修改状态(state or  delete_no)")
    @ApiImplicitParams({})
    @PostMapping("/updateProductPlanByid")
    @OperLog(operModul = "修改状态",operType = "2",operDesc = "生产计划单-修改状态(state or  delete_no)")
    public ResponseModel updateProductPlanByid(@RequestBody UpdateModel updateModel){
        try {
            productionPlanService.updateProductPlanByid(updateModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }


    @ApiOperation("生产计划单-根据生产计划单id查询详情")
    @ApiImplicitParams({})
    @PostMapping("/getProductPlanById")
    public ResponseModel getProductPlanById(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",productionPlanService.getProductPlanById(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产计划单-审核详情修改生产计划单状态(审核流程点击的通过/驳回)")
    @ApiImplicitParams({})
    @PostMapping("/updatePPStateByid")
    @OperLog(operModul = "修改状态",operType = "2",operDesc = "生产计划单-审核详情修改生产计划单状态(审核流程点击的通过/驳回)")
    public ResponseModel updatePPStateByid(@ModelAttribute UserInfoForToken userInfoForToken, @RequestBody UpdateModel smodel){
        try {
            productionPlanService.updatePPStateByid(userInfoForToken,smodel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }
}
