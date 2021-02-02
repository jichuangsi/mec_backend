package com.jichuangsi.mes.controller;


import com.jichuangsi.mes.advice.OperLog;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.ResponseModel;
import com.jichuangsi.mes.service.ImportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

@Api("后台-导出")
@CrossOrigin
@RestController
@RequestMapping("/exportController")
public class ExportController {
    @Resource
    private ImportService importService;


//    @ApiOperation("产品管理-规格型号-导入操作")
//    @ApiImplicitParams({})
//    @PostMapping("/export")
//    @OperLog(operModul = "导出",operType = "2",operDesc = "")
//    public ResponseModel export(@RequestParam("file")MultipartFile file) throws IOException {
//        try {
//            // 获取传入文件
//            InputStream inputStream = file.getInputStream();
//            ;
//            return ResponseModel.sucess("",importService.importFiletProstandards(inputStream));
//        }catch (PassportException e){
//            return ResponseModel.fail("",e.getMessage());
//        }
//    }
}
