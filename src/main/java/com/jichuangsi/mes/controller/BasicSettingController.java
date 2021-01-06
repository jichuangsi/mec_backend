package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.*;
import com.jichuangsi.mes.service.BasicSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

@Api("后台-基础设置管理")
@CrossOrigin
@RestController
@RequestMapping("/BasicSettingController")
public class BasicSettingController {

    @Resource
    private BasicSettingService bsService;

    @ApiOperation("基础设置-查询(产品型号规格，原材料型号规格，线轴型号规格，其他型号规格等)")
    @ApiImplicitParams({})
    @PostMapping("/getAllBasicSettingByName")
    public ResponseModel getAllBasicSettingByName(@RequestBody SelectModel smodel, HttpServletRequest request, InputStream inputStream){
        try {
            return ResponseModel.sucess("",bsService.getAllBasicSettingByName(smodel,request,inputStream));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("基础设置-根据Id查询单条数据(产品型号规格，原材料型号规格，线轴型号规格，其他型号规格等)")
    @ApiImplicitParams({})
    @PostMapping("/getAllBasicSettingByNameAndId")
    public ResponseModel getAllBasicSettingByNameAndId(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",bsService.getAllBasicSettingByNameAndId(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }


    @ApiOperation("产品管理- 新增/编辑产品页面获取下拉框数据")
    @ApiImplicitParams({})
    @PostMapping("/getProductBasicInfo")
    public ResponseModel getProductBasicInfo(){
        try {
            return ResponseModel.sucess("",bsService.getProductBasicInfo());
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("原材料管理/线轴管理/其他管理- 获取下拉框数据")
    @ApiImplicitParams({})
    @PostMapping("/getRawStockInfo")
    public ResponseModel getRawStockInfo(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",bsService.getRawStockInfo(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("产品管理-新增产品")
    @ApiImplicitParams({})
    @PostMapping("/saveProduct")
    public ResponseModel saveProduct(@RequestBody ClientModel model){
        try {
            bsService.saveProduct(model);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("原材料规格型号维护-新增原材料")
    @ApiImplicitParams({})
    @PostMapping("/saveRawStock")
    public ResponseModel saveRawStock(@RequestBody ClientModel model){
        try {
            bsService.saveRawStock(model);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("线轴型号规格维护-新增线轴")
    @ApiImplicitParams({})
    @PostMapping("/saveBobbin")
    public ResponseModel saveBobbin(@RequestBody ClientModel model){
        try {
            bsService.saveBobbin(model);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("其他规格型号维护-新增其他东西")
    @ApiImplicitParams({})
    @PostMapping("/saveElseOther")
    public ResponseModel saveElseOther(@RequestBody ClientModel model){
        try {
            bsService.saveElseOther(model);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }


    @ApiOperation("基础设置-根据Id修改订单状态 （state ‘S’或deleteno 'D'）(产品型号规格，原材料型号规格，线轴型号规格，其他型号规格等)")
    @ApiImplicitParams({})
    @PostMapping("/updateStateById")
    public ResponseModel updateStateById(@RequestBody UpdateModel model){
        try {
            bsService.updateStateById(model);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }


//-------------------------------------------仪器设备管理维修------------------------------------------------------------------------------

    @ApiOperation("设备管理- 新增/编辑设备页面获取下拉框数据")
    @ApiImplicitParams({})
    @PostMapping("/getEquipmentBasicInfo")
    public ResponseModel getEquipmentBasicInfo(){
        try {
            return ResponseModel.sucess("",bsService.getEquipmentBasicInfo());
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("设备管理- 新增/编辑")
    @ApiImplicitParams({})
    @PostMapping("/saveEquipment")
    public ResponseModel saveEquipment(@RequestBody EquipmentModel model){
        try {
            bsService.saveEquipment(model);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("设备管理-查询")
    @ApiImplicitParams({})
    @PostMapping("/getAllEquipment")
    public ResponseModel getAllEquipment(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",bsService.getAllEquipment(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("设备管理-根据Id查询单条数据")
    @ApiImplicitParams({})
    @PostMapping("/getAllEquipmentById")
    public ResponseModel getAllEquipmentById(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",bsService.getAllEquipmentById(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("设备管理-根据Id修改设备状态 （state ‘S’或deleteno 'D'）")
    @ApiImplicitParams({})
    @PostMapping("/updateEquipmentStateById")
    public ResponseModel updateEquipmentStateById(@RequestBody UpdateModel updateModel){
        try {
            bsService.updateEquipmentStateById(updateModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("设备管理-检修页面- 检修-新增(年月)")
    @ApiImplicitParams({})
    @PostMapping("/saveOverhaulYM")
    public ResponseModel saveOverhaulYM(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",bsService.saveOverhaulYM(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

    }

    @ApiOperation("设备管理-检修页面- 新增检修页面(每一天)获取检项数据")
    @ApiImplicitParams({})
    @PostMapping("/getEquipmentOverhaulBasicInfo")
    public ResponseModel getEquipmentOverhaulBasicInfo(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",bsService.getEquipmentOverhaulBasicInfo(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("设备管理-检修页面-新增检修")
    @ApiImplicitParams({})
    @PostMapping("/saveEquipmentOverhaulRecord")
    public ResponseModel saveEquipmentOverhaulRecord(@ModelAttribute UserInfoForToken userInfoForToken,@RequestBody EquipmentModel equipmentModel){
        try {
            bsService.saveEquipmentOverhaulRecord(userInfoForToken,equipmentModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("设备管理-检修页面- 根据设备ID查询已创建的年月点检信息")
    @ApiImplicitParams({})
    @PostMapping("/getEquipmentRecordYMByEquipmentId")
    public ResponseModel getEquipmentRecordYMByEquipmentId(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",bsService.getEquipmentRecordYMByEquipmentId(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("设备管理-检修页面- 根据设备id跟年月 查询该设备的点检信息")
    @ApiImplicitParams({})
    @PostMapping("/getEquipmentRecordByYMandEquipmentId")
    public ResponseModel getEquipmentRecordByYMandEquipmentId(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",bsService.getEquipmentRecordByYMandEquipmentId(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }


    @ApiOperation("设备管理-历史报修页面-查询")
    @ApiImplicitParams({})
    @PostMapping("/getAllRepairReport")
    public ResponseModel getAllRepairReport(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",bsService.getAllRepairReport(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }


    @ApiOperation("设备管理-历史报修页面-新增报修操作")
    @ApiImplicitParams({})
    @PostMapping("/saveRepairReport")
    public ResponseModel saveRepairReport(@RequestBody UpdateModel updateModel){
        try {
            bsService.saveRepairReport(updateModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("设备管理-历史报修页面-根据报修单id查询详情")
    @ApiImplicitParams({})
    @PostMapping("/getRepairReportById")
    public ResponseModel getRepairReportById(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",bsService.getRepairReportById(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("设备管理-历史报修页面-根据报修单Id修改状态 （state ‘S’或deleteno 'D'）")
    @ApiImplicitParams({})
    @PostMapping("/updateRepairReportStateById")
    public ResponseModel updateRepairReportStateById(@RequestBody UpdateModel updateModel){
        try {
            bsService.updateRepairReportStateById(updateModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("设备管理-历史报修页面-根据报修单Id修改报修流程(待处理 待维修 待检验 已完成等)")
    @ApiImplicitParams({})
    @PostMapping("/updateRepairReportAuditPocessById")
    public ResponseModel updateRepairReportAuditPocessById(@RequestBody UpdateModel updateModel){
        try {
            bsService.updateRepairReportAuditPocessById(updateModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }
}
