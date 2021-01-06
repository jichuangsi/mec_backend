package com.jichuangsi.mes.controller;


import com.jichuangsi.mes.entity.*;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.*;
import com.jichuangsi.mes.service.SysService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;

@Api("后台系统设置")
@CrossOrigin
@RestController
@RequestMapping("/SysController")
public class SysController {
    @Resource
    private SysService sysService;

    @ApiOperation("系统管理-查询(员工管理，部门管理，职称管理，班组管理，角色管理)")
    @ApiImplicitParams({})
    @PostMapping("/getAllSysByName")
    public ResponseModel getAllSysByName(@RequestBody SelectModel smodel,HttpServletRequest request,InputStream inputStream){
        try {
            return ResponseModel.sucess("",sysService.getAllSysByName(smodel,request,inputStream));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("系统管理-根据id查询详情(员工管理，部门管理，职称管理，班组管理，角色管理)")
    @ApiImplicitParams({})
    @PostMapping("/getAllSysByNameId")
    public ResponseModel getAllSysByNameId(@RequestBody SelectModel smodel,HttpServletRequest request,InputStream inputStream){
        try {
            return ResponseModel.sucess("",sysService.getAllSysByNameId(smodel,request,inputStream));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("系统管理-用户修改状态 （state或者delete_no状态）(员工管理，部门管理，职称管理，班组管理，角色管理) ")
    @ApiImplicitParams({})
    @PostMapping("/updateSysStateById")
    public ResponseModel updateSysStateById(@RequestBody UpdateModel model){
        try {
            sysService.updateSysStateById(model);
            return ResponseModel.sucessWithEmptyData("");
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("新增/编辑员工页面获取下拉框数据")
    @ApiImplicitParams({})
    @PostMapping("/getStaffBasicInfo")
    public ResponseModel getStaffBasicInfo(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",sysService.getStaffBasicInfo(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("部门管理/班组管理--下拉框")
    @ApiImplicitParams({})
    @PostMapping("/getBasicInfo")
    public ResponseModel getBasicInfo(){
        try {
            return ResponseModel.sucess("",sysService.getBasicInfo());
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("员工管理-根据员工ID查询单条信息")//暂停
    @ApiImplicitParams({})
    @PostMapping("/getInfoById")
    public ResponseModel getInfoById(@ModelAttribute UserInfoForToken userInfo){
        try {
            return ResponseModel.sucess("",sysService.getInfoById(userInfo));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("部门管理-新增部门")
    @ApiImplicitParams({})
    @PostMapping("/addDepartment")
    public ResponseModel addDepartment(@RequestBody Department department,HttpServletRequest request,InputStream inputStream){
        try {
            sysService.addDepartment(department,request,inputStream);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("职称管理-新增职称")
    @ApiImplicitParams({})
    @PostMapping("/addMesPost")
    public ResponseModel addMesPost(@RequestBody MesPost mesPost,HttpServletRequest request,InputStream inputStream){
        try {
            sysService.addMesPost(mesPost,request,inputStream);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("班组管理-新增班组")
    @ApiImplicitParams({})
    @PostMapping("/addTeam")
    public ResponseModel addTeam(@RequestBody TTeam tteam){
        try {
            sysService.addTeam(tteam);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("角色管理-新增角色")
    @ApiImplicitParams({})
    @PostMapping("/addRole")
    public ResponseModel addRole(@RequestBody SRole srole){
        try {
            sysService.addRole(srole);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation(value = "厂房管理-上传图片", notes = "")
    @ApiImplicitParams({ })
    @PostMapping("/localUploadPic")
    public ResponseModel localUploadPic(@RequestParam MultipartFile file){
        try {
            return ResponseModel.sucess("",sysService.localUploadPic(file));
        }catch (Exception e) {
            return ResponseModel.fail("", e.getMessage());
        }
    }

    @ApiOperation(value = "厂房管理-新增", notes = "")
    @ApiImplicitParams({
    })
    @PostMapping("/addWorkShop")
    public ResponseModel addWorkShop(@RequestBody Workshop workshop){
        try {
            sysService.addWorkShop(workshop);
            return ResponseModel.sucessWithEmptyData("");
        }catch (Exception e) {
            return ResponseModel.fail("", e.getMessage());
        }
    }

    @ApiOperation("客户管理-新增/编辑(客户/供应商)")
    @ApiImplicitParams({})
    @PostMapping("/saveCustomer")
    public ResponseModel saveCustomer(@ModelAttribute UserInfoForToken userInfoForToken,@RequestBody ClientModel client){
        try {
            sysService.saveCustomer(userInfoForToken,client);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("客户管理-修改客户/供应商状态 （state或者delete_no状态）")
    @ApiImplicitParams({})
    @PostMapping("/updateCustomerById")
    public ResponseModel updateCustomerById(@RequestBody UpdateModel smodel){
        try {
            sysService.updateCustomerById(smodel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("客户管理-查询客户/供应商列表")
    @ApiImplicitParams({})
    @PostMapping("/findCustomer")
    public ResponseModel findCustomer(@RequestParam Integer clientNo,@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",sysService.findCustomer(clientNo,smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("客户管理-根据Id查询客户/供应商")
    @ApiImplicitParams({})
    @PostMapping("/getClientInfoById")
    public ResponseModel getClientInfoById(@RequestParam Integer clientId){
        try {
            return ResponseModel.sucess("",sysService.getClientInfoById(clientId));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("客户投诉管理--客户/供应商下拉框")
    @ApiImplicitParams({})
    @PostMapping("/findClientAllXiaLa")
    public ResponseModel findClientAllXiaLa(@RequestParam Integer clientNo){
        try {
            return ResponseModel.sucess("",sysService.findClientAllXiaLa(clientNo));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("客户投诉管理-新增/编辑")
    @ApiImplicitParams({})
    @PostMapping("/saveComplaint")
    public ResponseModel saveComplaint(@ModelAttribute UserInfoForToken userInfoForToken,@RequestBody complaint clienttousu){
        try {
            sysService.saveComplaint(userInfoForToken,clienttousu);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("客户投诉管理-修改状态 （delete_no状态）")
    @ApiImplicitParams({})
    @PostMapping("/updateComplaintById")
    public ResponseModel updateComplaintById(@RequestBody UpdateModel smodel){
        try {
            sysService.updateComplaintById(smodel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("客户投诉管理-查询")
    @ApiImplicitParams({})
    @PostMapping("/findComplaint")
    public ResponseModel findComplaint(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",sysService.findComplaint(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("客户投诉管理-根据Id查询单条数据")
    @ApiImplicitParams({})
    @PostMapping("/findUserComplaintById")
    public ResponseModel findUserComplaintById(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",sysService.findUserComplaintById(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("字典管理-查询")
    @ApiImplicitParams({})
    @PostMapping("/findDictionary")
    public ResponseModel findDictionary(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",sysService.findDictionary(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("字典管理-根据父类id查询子类")
    @ApiImplicitParams({})
    @PostMapping("/findDictionaryByFid")
    public ResponseModel findDictionaryByFid(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",sysService.findDictionaryByFid(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("字典管理-新增字典明细")
    @ApiImplicitParams({})
    @PostMapping("/saveDictionary")
    public ResponseModel saveDictionary(@ModelAttribute UserInfoForToken userInfoForToken,@RequestBody SDictionarier sDictionarier){
        try {
            sysService.saveDictionary(userInfoForToken,sDictionarier);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("字典管理-根据Id修改状态 （state ‘S’或deleteno 'D'）")
    @ApiImplicitParams({})
    @PostMapping("/updateStateById")
    public ResponseModel updateStateById(@RequestBody UpdateModel model){
        try {
            sysService.updateStateById(model);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

}
