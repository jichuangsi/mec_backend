package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.entity.FileTable;
import com.jichuangsi.mes.entity.SNotice;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.ResponseModel;
import com.jichuangsi.mes.model.SelectModel;
import com.jichuangsi.mes.model.UpdateModel;
import com.jichuangsi.mes.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Api("后台-文件管理")
@CrossOrigin
@RestController
@RequestMapping("/fileController")
public class FileController {

    @Resource
    private FileService fileService;

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

//    参数MultipartFile可以使用数组的形式，比如：@RequestParam("upFile") MultipartFile[] file

//    超级管理员可以不用输入密码直接修改
    @ApiOperation("文件管理-上传文件")
    @ApiImplicitParams({})
    @PostMapping("/upload")
    public ResponseModel upload(@RequestParam("file") MultipartFile file,SelectModel selectModel)throws IOException,PassportException{
        try {
            return ResponseModel.sucess("",fileService.upload(file,selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("文件管理-下载文件")
    @ApiImplicitParams({})
    @PostMapping("/downloadFile")
    public ResponseModel downloadFile(@RequestBody SelectModel selectModel) {
        try {
            return ResponseModel.sucess("",fileService.downloadFile(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

    }

//    @PostMapping("/batch")
//    public String handleFileUpload(HttpServletRequest request) {
//        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
//        MultipartFile file = null;
//        BufferedOutputStream stream = null;
//        for (int i = 0; i < files.size(); ++i) {
//            file = files.get(i);
//            String filePath = "C:/software/file/";
//            if (!file.isEmpty()) {
//                try {
//                    byte[] bytes = file.getBytes();
//                    stream = new BufferedOutputStream(new FileOutputStream(
//                            new File(filePath + file.getOriginalFilename())));//设置文件路径及名字
//                    stream.write(bytes);// 写入
//                    stream.close();
//                } catch (Exception e) {
//                    stream = null;
//                    return "第 " + i + " 个文件上传失败 ==> "
//                            + e.getMessage();
//                }
//            } else {
//                return "第 " + i
//                        + " 个文件上传失败因为文件为空";
//            }
//        }
//        return "上传成功";
//    }

    @ApiOperation("文件管理-查询")
    @ApiImplicitParams({})
    @PostMapping("/getAllFile")
    public ResponseModel getAllFile(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",fileService.getAllFile(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }


    @ApiOperation("文件管理- 新增/编辑")
    @ApiImplicitParams({})
    @PostMapping("/saveFile")
    public ResponseModel saveFile(@RequestBody FileTable fileTable){
        try {
            fileService.saveFile(fileTable);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }


    @ApiOperation("文件管理-根据Id查询文件信息")
    @ApiImplicitParams({})
    @PostMapping("/getFileById")
    public ResponseModel getFileById(@RequestBody SelectModel smodel, HttpSession session){
        try {
            return ResponseModel.sucess("",fileService.getFileById(smodel,session));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("文件管理-修改状态(delete_no)")
    @ApiImplicitParams({})
    @PostMapping("/updateFileByid")
    public ResponseModel updateFileByid(@RequestBody UpdateModel smodel){
        try {
            fileService.updateFileByid(smodel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("系统公告-查询")
    @ApiImplicitParams({})
    @PostMapping("/getAllNotice")
    public ResponseModel getAllNotice(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",fileService.getAllNotice(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }


    @ApiOperation("系统公告- 新增/编辑")
    @ApiImplicitParams({})
    @PostMapping("/saveSysAnnouncement")
    public ResponseModel saveSysAnnouncement(@RequestBody SNotice sNotice){
        try {
            fileService.saveSysAnnouncement(sNotice);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("系统公告-根据Id查询系统公告")
    @ApiImplicitParams({})
    @PostMapping("/getNoticeById")
    public ResponseModel getNoticeById(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",fileService.getNoticeById(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("系统公告-修改状态(isshow or delete_no)")
    @ApiImplicitParams({})
    @PostMapping("/updateNoticeByid")
    public ResponseModel updateNoticeByid(@RequestBody UpdateModel smodel){
        try {
            fileService.updateNoticeByid(smodel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }



}
