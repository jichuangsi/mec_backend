package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.*;
import com.jichuangsi.mes.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

@Api("后台角色相关")
@CrossOrigin
@RestController
@RequestMapping("/userController")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation("后台用户注册")
    @ApiImplicitParams({})
    @PostMapping("/registUser")
    public ResponseModel registUser(@RequestBody UserInfoModel user){
        try {
            userService.registBackUser(user);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("后台用户登录")
    @ApiImplicitParams({})
    @PostMapping("/loginUser")
    public ResponseModel loginUser(@RequestBody BackUserLoginModel model,HttpServletRequest request,InputStream inputStream){
        try {
            return ResponseModel.sucess("",userService.loginBackUser(model,request,inputStream));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("后台修改密码")
    @ApiImplicitParams({})
    @PostMapping("/updateUserPwd")
    public ResponseModel updateUserPwd(@ModelAttribute UserInfoForToken userInfoForToken, @RequestBody UpdatePwdModel model){
        try {
            userService.updateBackUserPwd(userInfoForToken,model);
            return ResponseModel.sucessWithEmptyData("");
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }



}
