package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.entity.Templates;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.ResponseModel;
import com.jichuangsi.mes.model.SelectModel;
import com.jichuangsi.mes.model.UpdateModel;
import com.jichuangsi.mes.service.TemplatesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@Api("质量检验相关")
@CrossOrigin
@RestController
@RequestMapping("/templatesController")
public class TemplatesController {

    @Resource
    private TemplatesService templatesService;

    @ApiOperation("新增/修改模板")
    @ApiImplicitParams({
            /*@ApiImplicitParam(paramType = "body", name = "id", value = "模板id（新增不传", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "body", name = "fileRoute", value = "路径", required = false),
            @ApiImplicitParam(paramType = "body", name = "name", value = "模板名称", required = false),
            @ApiImplicitParam(paramType = "body", name = "remark", value = "备注", required = false),
            @ApiImplicitParam(paramType = "body", name = "type", value = "类型1成品报告2质量证书", required = false),
            @ApiImplicitParam(paramType = "body", name = "xb", value = "线别id", required = false, dataType = "int")*/
    })
    @PostMapping("/addTemplate")
    public ResponseModel addTemplate(@RequestBody Templates templates)throws IOException,PassportException {
        try {
            templatesService.addTemplate(templates);
            return ResponseModel.sucessWithEmptyData("");
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("新增模板-下拉选项框")
    @ApiImplicitParams({})
    @PostMapping("/getAddTemplateInfo")
    public ResponseModel getAddTemplateInfo(){
        return ResponseModel.sucess("",templatesService.getTemplatesBasicInfo());
    }

    @ApiOperation("模板-查询")
    @ApiImplicitParams({})
    @PostMapping("/getTemplateByPage")
    public ResponseModel getTemplateByPage(@RequestBody SelectModel model){
        return ResponseModel.sucess("",templatesService.getAllListByPage(model));
    }

    @ApiOperation("模板-下载预览")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path", name = "id", value = "模板id", required = true, dataType = "Integer")
    })
    @PostMapping("/getTemplateById/{id}")
    public ResponseModel getTemplateById(@PathVariable("id") int id){
        try {
            return ResponseModel.sucess("",templatesService.downloadFile(id));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("模板-修改状态")
    @ApiImplicitParams({})
    @PostMapping("/updateTemplateStatus")
    public ResponseModel updateTemplateStatus(@RequestBody UpdateModel model){
        try {
            templatesService.updateTemplateById(model);
            return ResponseModel.sucessWithEmptyData("");
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("模板-修改状态")
    @ApiImplicitParams({})
    @PostMapping("/test")
    public ResponseModel test(){
        return ResponseModel.sucess("",templatesService.test());
    }
}
