package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.*;
import com.jichuangsi.mes.service.SaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Api("后台-销售管理")
@CrossOrigin
@RestController
@RequestMapping("/saleController")
public class SaleController  {

    @Resource
    private SaleService saleService;

    @ApiOperation("销售订单管理- 新增/编辑页面获取下拉框数据")
    @ApiImplicitParams({})
    @PostMapping("/getSaleBasicInfo")
    public ResponseModel getSaleBasicInfo(){
        try {
            return ResponseModel.sucess("",saleService.getSaleBasicInfo());
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("销售订单管理- 明细页面--新增/编辑页面获取下拉框数据")
    @ApiImplicitParams({})
    @PostMapping("/getSaleDetailBasicInfo")
    public ResponseModel getSaleDetailBasicInfo(){
        try {
            return ResponseModel.sucess("",saleService.getSaleDetailBasicInfo());
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("销售订单管理- 明细页面--联动下拉框：根据原材料Id查询规格明细下拉框")
    @ApiImplicitParams({})
    @PostMapping("/getSaleDetailById")
    public ResponseModel getSaleDetailById(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",saleService.getSaleDetailBasicInfo(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("销售订单管理- 新增/编辑")
    @ApiImplicitParams({})
    @PostMapping("/saveSale")
    public ResponseModel saveSale(@ModelAttribute UserInfoForToken userInfoForToken, @RequestBody SaleModel saleModel){
        try {
            saleService.saveSale(userInfoForToken,saleModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("销售订单管理-查询")
    @ApiImplicitParams({})
    @PostMapping("/getAllSale")
    public ResponseModel getAllSale(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",saleService.getAllSale(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("销售订单管理-(销售订单审核)-查询")
    @ApiImplicitParams({})
    @PostMapping("/getAllSaleOrderAudit")
    public ResponseModel getAllSaleOrderAudit(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",saleService.getAllSaleOrderAudit(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("销售订单管理-根据Id查询订单详情")
    @ApiImplicitParams({})
    @PostMapping("/getSaleById")
    public ResponseModel getSaleById(@ModelAttribute UserInfoForToken userInfoForToken,@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",saleService.getSaleById(userInfoForToken,smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("销售订单管理-修改状态(delete_no)")
    @ApiImplicitParams({})
    @PostMapping("/updateSaleByid")
    public ResponseModel updateSaleByid(@RequestBody UpdateModel smodel){
        try {
            saleService.updateSaleByid(smodel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("销售订单管理-修改订单状态 （订单撤回，结束销售，销售退回等）")
    @ApiImplicitParams({})
    @PostMapping("/updateSaleOrderStateByid")
    public ResponseModel updateSaleOrderStateByid(@ModelAttribute UserInfoForToken userInfoForToken,@RequestBody UpdateModel smodel){
        try {
            saleService.updateSaleOrderStateByid(userInfoForToken,smodel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("销售订单管理-审核详情修改订单状态(审核流程点击的通过/驳回)")
    @ApiImplicitParams({})
    @PostMapping("/updateSaleAuditStateByid")
    public ResponseModel updateSaleAuditStateByid(@ModelAttribute UserInfoForToken userInfoForToken,@RequestBody UpdateModel smodel){
        try {
            saleService.updateSaleAuditStateByid(userInfoForToken,smodel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("销售出库-新增销售出库")
    @ApiImplicitParams({})
    @PostMapping("/updateMaterialOuter")
    public ResponseModel updateMaterialOuter(@ModelAttribute UserInfoForToken userInfoForToken,@RequestBody UpdateModel smodel){
        try {
            saleService.updateMaterialOuter(userInfoForToken,smodel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }
}
