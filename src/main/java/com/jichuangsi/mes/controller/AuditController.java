package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.entity.AuditSetting;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.ResponseModel;
import com.jichuangsi.mes.model.SelectModel;
import com.jichuangsi.mes.service.AuditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api("后台-审核管理")
@CrossOrigin
@RestController
@RequestMapping("/AuditController")
public class AuditController {

    @Resource
    private AuditService auditService;

    @ApiOperation("审核管理- 新增/编辑页面获取下拉框数据")
    @ApiImplicitParams({})
    @PostMapping("/getAuditBasicInfo")
    public ResponseModel getAuditBasicInfo(){
        try {
            return ResponseModel.sucess("",auditService.getAuditBasicInfo());
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("审核管理- 新增/编辑")
    @ApiImplicitParams({})
    @PostMapping("/saveAudit")
    public ResponseModel saveAudit(@RequestBody AuditSetting auditSetting){
        try {
            auditService.saveAudit(auditSetting);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("审核管理- 查询")
    @ApiImplicitParams({})
    @PostMapping("/findAllAudit")
    public ResponseModel findAllAudit(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",auditService.findAllAudit(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("审核管理- 根据Id查询单条")
    @ApiImplicitParams({})
    @PostMapping("/findAllAuditById")
    public ResponseModel findAllAuditById(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",auditService.findAllAuditById(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }
}
