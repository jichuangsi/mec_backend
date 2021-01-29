package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.advice.OperLog;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.*;
import com.jichuangsi.mes.service.ProductionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Api("后台-生产管理")
@CrossOrigin
@RestController
@RequestMapping("/ProductionController")
public class ProductionController {

    @Resource
    private ProductionService productionService;


    @ApiOperation("生产管理-熔炼- 新增/编辑页面获取生产计划单数据")
    @ApiImplicitParams({})
    @PostMapping("/getMeltingInfo")
    public ResponseModel getMeltingInfo(){
        try {
            return ResponseModel.sucess("",productionService.getMeltingInfo());
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产管理-熔炼- 新增/编辑页面根据生产计划单id获取生产计划单数据")
    @ApiImplicitParams({})
    @PostMapping("/getMeltingInfoById")
    public ResponseModel getMeltingInfoById(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionService.getMeltingInfoById(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产管理-熔炼- 新增/编辑页面根据生产计划单产物id获取(基本信息、原料比例、工艺参数、设备信息、操作信息)信息")
    @ApiImplicitParams({})
    @PostMapping("/getMeltingBasicInfoById")
    public ResponseModel getMeltingBasicInfoById(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionService.getMeltingBasicInfoById(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产管理-熔炼- 新增本班产物-根据设备id查询设备信息")
    @ApiImplicitParams({})
    @PostMapping("/getEquipmentXiaLaInfoById")
    @OperLog(operModul = "新增",operType = "2",operDesc = "生产管理-熔炼-新增本班产物-根据设备id查询设备信息")
    public ResponseModel getEquipmentXiaLaInfoById(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionService.getEquipmentXiaLaInfoById(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产管理-下拉框-根据线轴id查询线轴信息")
    @ApiImplicitParams({})
    @PostMapping("/getBobbinXiaLaInfoByBId")
    public ResponseModel getBobbinXiaLaInfoByBId(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionService.getBobbinXiaLaInfoByBId(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产管理- 根据生产管理id查询详情信息")
    @ApiImplicitParams({})
    @PostMapping("/getProductionDetailByPPPId")
    public ResponseModel getProductionDetailByPPPId(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionService.getProductionDetailByPPPId(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产管理- 查询")
    @ApiImplicitParams({})
    @PostMapping("/getAllPPProduction")
    public ResponseModel getAllPPProduction(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionService.getAllPPProduction(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产管理- 草稿/转下班操作(-熔炼)-新增/编辑")
    @ApiImplicitParams({})
    @PostMapping("/savesmeltingProductsList")
    @OperLog(operModul = "新增/编辑",operType = "2",operDesc = "草稿/转下班操作(-熔炼)-新增/编辑")
    public ResponseModel savesmeltingProductsList(@ModelAttribute UserInfoForToken userInfoForToken,@RequestBody PPProductionModel ppProductionModel){
        try {
            productionService.savesmeltingProductsList(userInfoForToken,ppProductionModel);

        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("生产管理- 转下班操作（熔炼、粗拉、中拉、细拉、超细拉、绕线、改绕等）-新增/编辑")
    @ApiImplicitParams({})
    @PostMapping("/savePPProduction")
    @OperLog(operModul = "新增/编辑",operType = "2",operDesc = "转下班操作（熔炼、粗拉、中拉、细拉、超细拉、绕线、改绕等）-新增/编辑")
    public ResponseModel savePPProduction(@ModelAttribute UserInfoForToken userInfoForToken,@RequestBody PPProductionModel ppProductionModel){
        try {
            productionService.savePPProduction(userInfoForToken,ppProductionModel);

        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }


    @ApiOperation("生产管理-修改状态(state or  delete_no)")
    @ApiImplicitParams({})
    @PostMapping("/updatePPPByPPPId")
    @OperLog(operModul = "修改状态",operType = "2",operDesc = "修改状态(state or  delete_no)")
    public ResponseModel updatePPPByPPPId(@RequestBody UpdateModel updateModel){
        try {
            productionService.updatePPPByPPPId(updateModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("生产管理- 撤回上班工序（熔炼、粗拉、中拉、细拉、超细拉、绕线、改绕等）")
    @ApiImplicitParams({})
    @PostMapping("/backToPPProduction")
    @OperLog(operModul = "修改状态",operType = "2",operDesc = "撤回上班工序（熔炼、粗拉、中拉、细拉、超细拉、绕线、改绕等）")
    public ResponseModel backToPPProduction(@RequestBody SelectModel selectModel){
        try {
            productionService.backToPPProduction(selectModel);

        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("生产管理- 退火-导入操作")
    @ApiImplicitParams({})
    @PostMapping("/importFilePPProduction")
    @OperLog(operModul = "导入",operType = "2",operDesc = "退火-导入操作")
    public ResponseModel importFilePPProduction(SelectModel selectModel, @RequestParam("file")MultipartFile file) throws IOException {
        try {
            // 获取传入文件
            InputStream inputStream = file.getInputStream();
            ;
            return ResponseModel.sucess("",productionService.importFilePPProduction(selectModel,inputStream));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产管理- 退火-转上班操作-新增/编辑")
    @ApiImplicitParams({})
    @PostMapping("/transferToPPProduction")
    @OperLog(operModul = "新增/编辑",operType = "2",operDesc = "退火-转上班操作-新增/编辑")
    public ResponseModel transferToPPProduction(@ModelAttribute UserInfoForToken userInfoForToken,@RequestBody SelectModel selectModel) {
        try {
            productionService.transferToPPProduction(userInfoForToken,selectModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

//    @ApiOperation("生产管理- 完成生产（熔炼、粗拉、中拉、细拉、超细拉、绕线、改绕等）")
//    @ApiImplicitParams({})
//    @PostMapping("/finishedPPProduction")
//    public ResponseModel finishedPPProduction(@RequestBody PPProductionModel ppProductionModel){
//        try {
////            productionService.finishedPPProduction(ppProductionModel);
//
//        }catch (PassportException e){
//            return ResponseModel.fail("",e.getMessage());
//        }
//        return ResponseModel.sucessWithEmptyData("");
//    }

    @ApiOperation("生产管理（绕线）- 根据生产管理id查询详情信息")
    @ApiImplicitParams({})
    @PostMapping("/getPWindingDetailByPPPId")
    public ResponseModel getPWindingDetailByPPPId(@RequestBody SelectModel selectModel) {
        try {
            return ResponseModel.sucess("",productionService.getPWindingDetailByPPPId(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }

    }

    @ApiOperation("生产管理（绕线）-新增绕线页面- 根据上班工序产物id查询详情信息")
    @ApiImplicitParams({})
    @PostMapping("/getPWindingDetailByPPWindingDetailId")
    public ResponseModel getPWindingDetailByPPWindingDetailId(@RequestBody SelectModel selectModel) {
        try {
            return ResponseModel.sucess("",productionService.getPWindingDetailByPPWindingDetailId(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产管理(绕线)- 保存明细操作-新增/编辑")
    @ApiImplicitParams({})
    @PostMapping("/savePWindingDetail")
    @OperLog(operModul = "新增/编辑",operType = "2",operDesc = "生产管理(绕线)- 保存明细操作")
    public ResponseModel savePWindingDetail(@RequestBody PPProductionModel ppProductionModel) {
        try {
            productionService.savePWindingDetail(ppProductionModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("生产管理(绕线)- 保存操作-新增/编辑")
    @ApiImplicitParams({})
    @PostMapping("/savePWinding")
    @OperLog(operModul = "新增/编辑",operType = "2",operDesc = "生产管理(绕线)- 保存操作")
    public ResponseModel savePWinding(@RequestBody PPProductionModel ppProductionModel) {
        try {
            productionService.savePWinding(ppProductionModel);
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation("生产管理（改绕）-查询完成生产的生产信息")
    @ApiImplicitParams({})
    @PostMapping("/getAllFinished")
    public ResponseModel getAllFinished() {
        try {
            return ResponseModel.sucess("",productionService.getAllFinished());
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产管理（改绕）-根据生产id查询完成生产的生产信息")
    @ApiImplicitParams({})
    @PostMapping("/getFinishedByPPPId")
    public ResponseModel getFinishedByPPPId(@RequestBody SelectModel selectModel) {
        try {
            return ResponseModel.sucess("",productionService.getFinishedByPPPId(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

//    @ApiOperation(" 生产管理（改绕）- 根据选择需要改绕的数据查询详情信息")
//    @ApiImplicitParams({})
//    @PostMapping("/getPDetourDetailByChooseIds")
//    public ResponseModel getPDetourDetailByChooseIds(UserInfoForToken userInfoForToken,@RequestBody List<SelectModel> selectModel) {
//        try {
//            return ResponseModel.sucess("",productionService.getPDetourDetailByChooseIds(userInfoForToken,selectModel));
//        }catch (PassportException e){
//            return ResponseModel.fail("",e.getMessage());
//        }
//    }
//
//    @ApiOperation("生产管理（改绕）- 根据生产管理id查询详情信息")
//    @ApiImplicitParams({})
//    @PostMapping("/getPDetourDetailByPPPId")
//    public ResponseModel getPDetourDetailByPPPId(@RequestBody SelectModel selectModel) {
//        try {
//            return ResponseModel.sucess("",productionService.getPDetourDetailByPPPId(selectModel));
//        }catch (PassportException e){
//            return ResponseModel.fail("",e.getMessage());
//        }
//    }
//
//    @ApiOperation("生产管理(改绕)- 保存操作-新增/编辑")
//    @ApiImplicitParams({})
//    @PostMapping("/savePDetour")
//    @OperLog(operModul = "新增/编辑",operType = "2",operDesc = "生产管理(改绕)- 保存操作")
//    public ResponseModel savePDetour(@ModelAttribute UserInfoForToken userInfoForToken,@RequestBody PPProductionModel ppProductionModel) {
//        try {
//            productionService.savePDetour(userInfoForToken,ppProductionModel);
//        }catch (PassportException e){
//            return ResponseModel.fail("",e.getMessage());
//        }
//        return ResponseModel.sucessWithEmptyData("");
//    }
//
//    @ApiOperation("生产管理（改绕）-新增改绕页面- 根据待改绕查询详情")
//    @ApiImplicitParams({})
//    @PostMapping("/getPDetourDetailByPPDetourDetailId")
//    public ResponseModel getPDetourDetailByPPDetourDetailId(@RequestBody SelectModel selectModel) {
//        try {
//            return ResponseModel.sucess("",productionService.getPDetourDetailByPPDetourDetailId(selectModel));
//        }catch (PassportException e){
//            return ResponseModel.fail("",e.getMessage());
//        }
//    }
}
