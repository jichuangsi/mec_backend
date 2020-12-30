package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.ResponseModel;
import com.jichuangsi.mes.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Api("后台-首页")
@CrossOrigin
@RestController
@RequestMapping("/HomeController")
public class HomeController {


    @Resource
    private HomeService homeService;

    @ApiOperation("首页- 查询我的办事项")
    @ApiImplicitParams({})
    @PostMapping("/findMyMatters")
    public ResponseModel findMyMatters(HttpSession session){
        try {
            return ResponseModel.sucess("",homeService.findMyMatters(session));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }
}
