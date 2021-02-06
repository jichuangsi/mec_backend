package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.advice.OperLog;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.*;
import com.jichuangsi.mes.service.PurchaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Api("后台-采购管理")
@CrossOrigin
@RestController
@RequestMapping("/PurchaseController")
public class PurchaseController {

    @Resource
    private PurchaseService purchaseService;

    @ApiOperation("采购订单管理- 新增/编辑页面获取下拉框数据")
    @ApiImplicitParams({})
    @PostMapping("/getPurchaseBasicInfo")
    public ResponseModel getPurchaseBasicInfo(){
        try {
            return ResponseModel.sucess("",purchaseService.getPurchaseBasicInfo());
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("采购订单管理- 明细页面--新增/编辑页面获取下拉框数据")
    @ApiImplicitParams({})
    @PostMapping("/getPurchaseDetailBasicInfo")
    public ResponseModel getPurchaseDetailBasicInfo(){
        try {
            return ResponseModel.sucess("",purchaseService.getPurchaseDetailBasicInfo());
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("采购订单管理- 明细页面--联动下拉框：根据原材料Id查询规格明细下拉框")
    @ApiImplicitParams({})
    @PostMapping("/getPurchaseDetailById")
    public ResponseModel getPurchaseDetailById(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",purchaseService.getPurchaseDetailById(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("采购订单管理- 新增/编辑")
    @ApiImplicitParams({})
    @PostMapping("/savePurchase")
    @OperLog(operModul = "新增/编辑",operType = "2",operDesc = "采购订单管理-新增/编辑")
    public ResponseModel savePurchase(@ModelAttribute UserInfoForToken userInfoForToken,@RequestBody OrderModel orderModel){
        try {
            purchaseService.savePurchase(userInfoForToken,orderModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }


    @ApiOperation("采购订单管理-查询")
    @ApiImplicitParams({})
    @PostMapping("/getAllPurchase")
    public ResponseModel getAllPurchase(@ModelAttribute UserInfoForToken userInfoForToken,@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",purchaseService.getAllPurchase(userInfoForToken,smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("采购订单管理-根据Id查询订单详情")
    @ApiImplicitParams({})
    @PostMapping("/getPurchaseById")
    public ResponseModel getPurchaseById(@ModelAttribute UserInfoForToken userInfoForToken,@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",purchaseService.getPurchaseById(userInfoForToken,smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("采购订单管理-修改状态(delete_no)")
    @ApiImplicitParams({})
    @PostMapping("/updatePurchaseByid")
    @OperLog(operModul = "修改状态",operType = "2",operDesc = "采购订单管理-修改状态(delete_no)")
    public ResponseModel updatePurchaseByid(@RequestBody UpdateModel smodel){
        try {
            purchaseService.updatePurchaseByid(smodel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("采购订单管理-修改订单状态(审核流程点击的通过/驳回)")
    @ApiImplicitParams({})
    @PostMapping("/updatePurchaseOrderAuditByid")
    @OperLog(operModul = "修改订单状态",operType = "2",operDesc = "采购订单管理-修改订单状态(审核流程点击的通过/驳回)")
    public ResponseModel updatePurchaseOrderAuditByid(@ModelAttribute UserInfoForToken userInfoForToken, @RequestBody UpdateModel smodel){
        try {
            purchaseService.updatePurchaseOrderAuditByid(userInfoForToken,smodel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("采购订单管理-修改订单状态(订单审核撤回、结束采购、采购退回、结束退回)")
    @ApiImplicitParams({})
    @PostMapping("/updateOrderStateByid")
    @OperLog(operModul = "修改订单状态",operType = "2",operDesc = "采购订单管理-修改订单状态(订单审核撤回、结束采购、采购退回、结束退回)")
    public ResponseModel updateOrderStateByid(@ModelAttribute UserInfoForToken userInfoForToken,@RequestBody UpdateModel smodel){
        try {
            purchaseService.updateOrderStateByid(userInfoForToken,smodel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("订单审核(采购管理)-查询")
    @ApiImplicitParams({})
    @PostMapping("/getAllPurchaseOrderAudit")
    public ResponseModel getAllPurchaseOrderAudit(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",purchaseService.getAllPurchaseOrderAudit(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("来料检验(采购管理)-查询")
    @ApiImplicitParams({})
    @PostMapping("/getAllPurchaseLLAudit")
    public ResponseModel getAllPurchaseLLAudit(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",purchaseService.getAllPurchaseLLAudit(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }


    @ApiOperation("采购入库-新增采购入库")
    @ApiImplicitParams({})
    @PostMapping("/updateMaterialEnter")
    @OperLog(operModul = "新增采购入库",operType = "2",operDesc = "采购入库-新增采购入库")
    public ResponseModel updateMaterialEnter(@ModelAttribute UserInfoForToken userInfoForToken,@RequestBody UpdateModel smodel){
        try {
            purchaseService.updateMaterialEnter(userInfoForToken,smodel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }











}
