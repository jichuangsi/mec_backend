package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.model.ResponseModel;
import com.jichuangsi.mes.model.SelectModel;
import com.jichuangsi.mes.model.UserInfoForToken;
import com.jichuangsi.mes.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("系统日志相关")
@CrossOrigin
@RestController
@RequestMapping("/operLogController")
public class OperLogController {

    @Autowired
    private LogService logService;

    @ApiOperation("系统日志-查询")
    @ApiImplicitParams({})
    @PostMapping("/getOperLogByPage")
    public ResponseModel getOperLogByPage(@ModelAttribute UserInfoForToken userInfo, @RequestBody SelectModel model){
        return ResponseModel.sucess("",logService.getOperLogeByPage(model));
    }
}
