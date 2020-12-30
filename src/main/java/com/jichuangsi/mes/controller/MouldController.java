package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.entity.TFinishedproducecheck;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.ResponseModel;
import com.jichuangsi.mes.model.SelectModel;
import com.jichuangsi.mes.model.TMouldModel;
import com.jichuangsi.mes.model.UpdateModel;
import com.jichuangsi.mes.service.MouldService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api("后台-基础设置管理-模具管理")
@CrossOrigin
@RestController
@RequestMapping("/mouldController")
public class MouldController {

    @Resource
    private MouldService mouldService;


    @ApiOperation("模具管理-查询页面-查询下拉框")
    @ApiImplicitParams({})
    @PostMapping("/getAllTMouldXiaLa")
    public ResponseModel getAllTMouldXiaLa(){
        try {
            return ResponseModel.sucess("",mouldService.getAllTMouldXiaLa());
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("模具管理-查询")
    @ApiImplicitParams({})
    @PostMapping("/getAllTMould")
    public ResponseModel getAllTMould(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",mouldService.getAllTMould(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("模具管理-根据模具id查询模具信息")
    @ApiImplicitParams({})
    @PostMapping("/getTMouldByID")
    public ResponseModel getTMouldByID(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",mouldService.getTMouldByID(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("模具管理- 新增/编辑成套页面获取下拉框数据")
    @ApiImplicitParams({})
    @PostMapping("/getMouldInfo")
    public ResponseModel getMouldInfo(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",mouldService.getMouldInfo(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }


    @ApiOperation("模具管理-新增/修改 成套/成品模型")
    @ApiImplicitParams({})
    @PostMapping("/saveCompleteSet")
    public ResponseModel saveCompleteSet(@RequestBody TMouldModel mouldModel){
        try {
            mouldService.saveCompleteSet(mouldModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("模具管理-修改状态(state or  delete_no)")
    @ApiImplicitParams({})
    @PostMapping("/updateTmouldByid")
    public ResponseModel updateTmouldByid(@RequestBody UpdateModel updateModel){
        try {
            mouldService.updateTmouldByid(updateModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("模具管理-成套模具维护-根据模具id查询模具信息跟历史检查数据")
    @ApiImplicitParams({})
    @PostMapping("/getTMouldById")
    public ResponseModel getTMouldById(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",mouldService.getTMouldById(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("模具管理-成套模具维护-新增维护页面-根据模具id查询模具信息")
    @ApiImplicitParams({})
    @PostMapping("/getTMouldDetailById")
    public ResponseModel getTMouldDetailById(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",mouldService.getTMouldDetailById(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("模具管理-成套模具维护-新增维护")
    @ApiImplicitParams({})
    @PostMapping("/savecuffingCheck")
    public ResponseModel savecuffingCheck(@RequestBody TMouldModel mouldModel){
        try {
            mouldService.savecuffingCheck(mouldModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("模具管理-成套模具维护-历史检查数据-修改状态(delete_no)")
    @ApiImplicitParams({})
    @PostMapping("/updateTCuffingcheckByid")
    public ResponseModel updateTCuffingcheckByid(@RequestBody UpdateModel updateModel){
        try {
            mouldService.updateTCuffingcheckByid(updateModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("模具管理-成品模具维护-根据模具id查询模具信息跟历史检查数据")
    @ApiImplicitParams({})
    @PostMapping("/getTMouldFinishedproducecheckById")
    public ResponseModel getTMouldFinishedproducecheckById(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",mouldService.getTMouldFinishedproducecheckById(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

    }

    @ApiOperation("模具管理-成品模具维护-新增/查看维护页面-根据模具id查询模具维护信息")
    @ApiImplicitParams({})
    @PostMapping("/getFinishedproducecheckById")
    public ResponseModel getFinishedproducecheckById(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",mouldService.getFinishedproducecheckById(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

    }

    @ApiOperation("模具管理-成品模具维护-新增维护")
    @ApiImplicitParams({})
    @PostMapping("/saveFinishedproducecheck")
    public ResponseModel saveFinishedproducecheck(@RequestBody TFinishedproducecheck tFinishedproducecheck){
        try {
            mouldService.saveFinishedproducecheck(tFinishedproducecheck);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");

    }

    @ApiOperation("模具管理-成品模具维护-历史检查数据-修改状态(delete_no)")
    @ApiImplicitParams({})
    @PostMapping("/updateFinishedproducecheckByid")
    public ResponseModel updateFinishedproducecheckByid(@RequestBody UpdateModel updateModel){
        try {
            mouldService.updateFinishedproducecheckByid(updateModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }


    @ApiOperation("套模管理- 新增/编辑页面获取下拉框数据")
    @ApiImplicitParams({})
    @PostMapping("/getSleeveDieInfo")
    public ResponseModel getSleeveDieInfo(){
        try {
            return ResponseModel.sucess("",mouldService.getSleeveDieInfo());
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

    }

    @ApiOperation("套模管理- 新增/编辑页面-根据模具类别跟设备类型查询模具信息")
    @ApiImplicitParams({})
    @PostMapping("/getTmouldByEquipmentTypeandTmouldType")
    public ResponseModel getTmouldByEquipmentTypeandTmouldType(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",mouldService.getTmouldByEquipmentTypeandTmouldType(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

    }

    @ApiOperation("套模管理- 新增/编辑页面(模具类别跟设备类型查询模具信息)-根据id查询明细")
    @ApiImplicitParams({})
    @PostMapping("/getTmouldByEquipmentTypeandTmouldTypeById")
    public ResponseModel getTmouldByEquipmentTypeandTmouldTypeById(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",mouldService.getTmouldByEquipmentTypeandTmouldTypeById(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

    }

    @ApiOperation("套模管理-新增/修改")
    @ApiImplicitParams({})
    @PostMapping("/saveTSuit")
    public ResponseModel saveTSuit(@RequestBody TMouldModel tMouldModel){
        try {
            mouldService.saveTSuit(tMouldModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("套模管理-查询")
    @ApiImplicitParams({})
    @PostMapping("/getAllTSuit")
    public ResponseModel getAllTSuit(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",mouldService.getAllTSuit(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("套模管理-根据套模id查询套模信息")
    @ApiImplicitParams({})
    @PostMapping("/getTSuitById")
    public ResponseModel getTSuitById(@RequestBody SelectModel smodel){
        try {
            return ResponseModel.sucess("",mouldService.getTSuitById(smodel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("套模管理-修改状态(state or  delete_no)")
    @ApiImplicitParams({})
    @PostMapping("/updateTsuitByid")
    public ResponseModel updateTsuitByid(@RequestBody UpdateModel updateModel){
        try {
            mouldService.updateTsuitByid(updateModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }
}
