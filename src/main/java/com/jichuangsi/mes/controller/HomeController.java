package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.*;
import com.jichuangsi.mes.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Api("后台-首页")
@CrossOrigin
@RestController
@RequestMapping("/HomeController")
public class HomeController {


    @Resource
    private HomeService homeService;

    @ApiOperation("首页Mes-查询数据")
    @ApiImplicitParams({})
    @PostMapping("/findMyMatters")
    public ResponseModel findMyMatters(@ModelAttribute UserInfoForToken userInfoForToken){
        try {
            return ResponseModel.sucess("",homeService.findMyMatters(userInfoForToken));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("首页ERP-查询数据")
    @ApiImplicitParams({})
    @PostMapping("/findMyERPMatters")
    public ResponseModel findMyERPMatters(@ModelAttribute UserInfoForToken userInfoForToken)throws PassportException,Exception{
        try {
            return ResponseModel.sucess("",homeService.findMyERPMatters(userInfoForToken));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("工作台-查询今日生产任务")
    @ApiImplicitParams({})
    @PostMapping("/findProductionTask")
    public ResponseModel findProductionTask(@ModelAttribute UserInfoForToken userInfoForToken){
        try {
            return ResponseModel.sucess("",homeService.findProductionTask(userInfoForToken));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("待办事项-（待办事项（未读未完成）、进行事项（已读未完成）、完成事项（已完成））")
    @ApiImplicitParams({})
    @PostMapping("/findMattersByState")
    public ResponseModel findMattersByState(@ModelAttribute UserInfoForToken userInfoForToken, @RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",homeService.findMattersByState(userInfoForToken,selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }



    @ApiOperation("首页-查询该用户的权限")
    @ApiImplicitParams({})
    @PostMapping("/getMyRolePower")
    public ResponseModel getMyRolePower(@ModelAttribute UserInfoForToken userInfoForToken, @RequestBody BackUserLoginModel loginModel)throws PassportException,Exception{
        try {
            return ResponseModel.sucess("",homeService.getMyRolePower(userInfoForToken,loginModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }


}
