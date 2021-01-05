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

}
