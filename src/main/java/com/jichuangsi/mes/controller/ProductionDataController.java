package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.ResponseModel;
import com.jichuangsi.mes.model.SelectModel;
import com.jichuangsi.mes.service.ProductionDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api("后台-生产数据")
@CrossOrigin
@RestController
@RequestMapping("/ProductionDataController")
public class ProductionDataController {

    @Resource
    private ProductionDataService productionDataService;

    @ApiOperation("生产数据-批号生产回溯")
    @ApiImplicitParams({})
    @PostMapping("/getProductionInfoByNumber")
    public ResponseModel getProductionInfoByNumber(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionDataService.getProductionInfoByNumber(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产数据-批号生产回溯-根据生产id查询对应本班信息")
    @ApiImplicitParams({})
    @PostMapping("/getProductionInfoByPPPId")
    public ResponseModel getProductionInfoByPPPId(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionDataService.getProductionInfoByPPPId(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产数据-生产日报汇总")
    @ApiImplicitParams({})
    @PostMapping("/getProductionDiaryReport")
    public ResponseModel getProductionDiaryReport(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionDataService.getProductionDiaryReport(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }


    @ApiOperation("生产数据-生产日报细分报表")//暂停
    @ApiImplicitParams({})
    @PostMapping("/getProductionSubdivideReport")
    public ResponseModel getProductionSubdivideReport(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionDataService.getProductionDiaryReport(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }



    @ApiOperation("生产数据-生产质量分析")
    @ApiImplicitParams({})
    @PostMapping("/getProductionQualityAnalysis")
    public ResponseModel getProductionQualityAnalysis(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionDataService.getProductionQualityAnalysis(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation("生产数据-班组生产数据统计")
    @ApiImplicitParams({})
    @PostMapping("/getProductionTeam")
    public ResponseModel getProductionTeam(@RequestBody SelectModel selectModel){
        try {
            return ResponseModel.sucess("",productionDataService.getProductionTeam(selectModel));
        }catch (PassportException e){
            return ResponseModel.fail("",e.getMessage());
        }
    }

}
