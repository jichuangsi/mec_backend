package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.model.ResponseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("测试相关")
@RestController
@RequestMapping("/TestController")
public class TestController {

    @ApiOperation("Test")
    @ApiImplicitParams({})
    @PostMapping("/Test")
    public ResponseModel test(){
        return  ResponseModel.sucessWithEmptyData("");
    }
}
