package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.advice.OperLog;
import com.jichuangsi.mes.entity.TCertificateReport;
import com.jichuangsi.mes.entity.Templates;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.*;
import com.jichuangsi.mes.service.TemplatesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

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
    @OperLog(operModul = "新增/修改",operType = "2",operDesc = "新增/修改模板")
    public ResponseModel addTemplate(@ModelAttribute UserInfoForToken userInfoForToken,@RequestBody Templates templates)throws IOException,PassportException {
        try {
            templatesService.addTemplate(userInfoForToken,templates);
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

    @ApiOperation("模板-根据id查询数据")
    @ApiImplicitParams({})
    @PostMapping("/getTemplateById")
    public ResponseModel getTemplateById(@RequestBody SelectModel model)throws PassportException{
        return ResponseModel.sucess("",templatesService.getTemplateById(model));
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

    @ApiOperation("模板-修改状态 修改的类型    是Delete_no “D”还是state \"S\"")
    @ApiImplicitParams({})
    @PostMapping("/updateTemplateStatus")
    @OperLog(operModul = "修改状态",operType = "2",operDesc = "模板-修改状态（state or delete_no）")
    public ResponseModel updateTemplateStatus(@RequestBody UpdateModel model){
        try {
            templatesService.updateTemplateById(model);
            return ResponseModel.sucessWithEmptyData("");
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("模板模板(抽样检验)- 根据选择需要查询详情信息")
    @ApiImplicitParams({})
    @PostMapping("/getTemplatesByChooseIds")
    public ResponseModel getTemplatesByChooseIds(UserInfoForToken userInfoForToken, @RequestBody SelectModel selectModel) {
        try {
            return ResponseModel.sucess("",templatesService.getTemplatesByChooseIds(userInfoForToken,selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("模板(抽样检验)- 新增/修改")
    @ApiImplicitParams({})
    @PostMapping("/saveTSamplingReport")
    @OperLog(operModul = "新增/修改",operType = "2",operDesc = "模板(抽样检验)- 新增/修改")
    public ResponseModel saveTSamplingReport(@RequestBody TSamplingReportModel model) {
        try {
            templatesService.saveTSamplingReport(model);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("抽样检验-修改状态 （state or delete_no状态）")
    @ApiImplicitParams({})
    @PostMapping("/updateTSamplingReportById")
    @OperLog(operModul = "修改状态",operType = "2",operDesc = "抽样检验-修改状态 （state or delete_no状态）")
    public ResponseModel updateTSamplingReportById(@RequestBody UpdateModel model) {
        try {
            templatesService.updateTSamplingReportById(model);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("抽样检查-查询全部")
    @ApiImplicitParams({})
    @PostMapping("/getAllTSamplingReport")
    public ResponseModel getAllTSamplingReport(@RequestBody SelectModel selectModel)throws PassportException {
        return ResponseModel.sucess("",templatesService.getAllTSamplingReport(selectModel));
    }

    @ApiOperation("抽样检查-根据id查询")
    @ApiImplicitParams({})
    @PostMapping("/getTSamplingReportById")
    public ResponseModel getTSamplingReportById(@RequestBody SelectModel selectModel) throws PassportException{
        return ResponseModel.sucess("",templatesService.getTSamplingReportById(selectModel));
    }




    @ApiOperation("质量证书- 根据选择需要查询详情信息")
    @ApiImplicitParams({})
    @PostMapping("/getTCertificateReportByChooseIds")
    public ResponseModel getTCertificateReportByChooseIds(@ModelAttribute UserInfoForToken userInfoForToken,@RequestBody SelectModel selectModel) throws PassportException{
        return ResponseModel.sucess("",templatesService.getTCertificateReportByChooseIds(userInfoForToken,selectModel));
    }
    @ApiOperation("质量证书- 新增/修改")
    @ApiImplicitParams({})
    @PostMapping("/saveTCertificateReport")
    @OperLog(operModul = "新增/修改",operType = "2",operDesc = "质量证书- 新增/修改")
    public ResponseModel saveTCertificateReport(@RequestBody TCertificateReport tCertificateReport) {
        try {
            templatesService.saveTCertificateReport(tCertificateReport);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("质量证书-修改状态 （state or delete_no状态）")
    @ApiImplicitParams({})
    @PostMapping("/updateTCertificateReportById")
    @OperLog(operModul = "修改状态",operType = "2",operDesc = "质量证书-修改状态 （state or delete_no状态）")
    public ResponseModel updateTCertificateReportById(@RequestBody UpdateModel model) {
        try {
            templatesService.updateTCertificateReportById(model);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("质量证书-查询全部")
    @ApiImplicitParams({})
    @PostMapping("/getAllTCertificateReport")
    public ResponseModel getAllTCertificateReport(@RequestBody SelectModel selectModel)throws PassportException {
        return ResponseModel.sucess("",templatesService.getAllTCertificateReport(selectModel));
    }

    @ApiOperation("质量证书-根据id查询")
    @ApiImplicitParams({})
    @PostMapping("/getTCertificateReportById")
    public ResponseModel getTCertificateReportById(@RequestBody SelectModel selectModel) throws PassportException{
        return ResponseModel.sucess("",templatesService.getTCertificateReportById(selectModel));
    }


}
