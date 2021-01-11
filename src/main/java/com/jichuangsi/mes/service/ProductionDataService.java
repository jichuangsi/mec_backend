package com.jichuangsi.mes.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.jichuangsi.mes.constant.ResultCode;
import com.jichuangsi.mes.entity.PPProduct;
import com.jichuangsi.mes.entity.PPProduction;
import com.jichuangsi.mes.entity.ProductPlan;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.mapper.IProductionMapper;
import com.jichuangsi.mes.model.MapVo;
import com.jichuangsi.mes.model.SelectModel;
import com.jichuangsi.mes.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ProductionDataService {


    @Resource
    private IProductionMapper iProductionMapper;

    @Resource
    private ProductPlanRepository productPlanRepository;
    @Resource
    private PPProductRepository ppProductRepository;
    @Resource
    private TSuitRepository suitRepository;
    @Resource
    private PPProductionRepository ppProductionRepository;
    @Resource
    private PPAnnealingInfoRepository ppAnnealingInfoRepository;


    /**
     * 生产数据-批号生产回溯
     * @param
     * @throws PassportException
     */
    public JSONObject getProductionInfoByNumber(SelectModel selectModel)throws PassportException {
        JSONObject jsonObject = new JSONObject();

        if(StringUtils.isEmpty(selectModel.getFindName())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        List<MapVo> list = iProductionMapper.findAllProductionInfoByNumber(selectModel.getFindName());//根据生产批号查询生产工序信息

        if(list.size() == 0){
            throw new PassportException(ResultCode.DATA_NOEXIST_MSG);
        }

        PPProduction ppProduction = ppProductionRepository.findByid(list.get(0).getMapKey());
        if(StringUtils.isEmpty(ppProduction)){
            throw new PassportException(ResultCode.DATA_NOEXIST_MSG);
        }

        PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());//根据产物id查询产物基本信息

        ProductPlan productPlan = productPlanRepository.findByid(ppProduct.getPpId());//生产计划单

        if(productPlan.getRelationNo() == 0){
            jsonObject.put("BasicInfo",iProductionMapper.findMeltingBasicInfoByNoSaleId(ppProduct.getId()));//基本信息：不关联销售订单 根据生产计划单产物id
        }else{
            jsonObject.put("BasicInfo",iProductionMapper.findMeltingBasicInfoById(ppProduct.getId()));//基本信息：关联销售订单 根据生产计划单产物id
        }

        jsonObject.put("productionList",list);// 生产工序

        jsonObject.put("ProcessTechnology",suitRepository.findByid(productPlan.getSuitId()));//工艺参数 根据套模id
        jsonObject.put("equipmentInfo",iProductionMapper.findEquipmentByEquipmentId(ppProduction.getEquipmentId()));//设备信息
        jsonObject.put("OperationInfo",iProductionMapper.findGXSchedulingByPPIdAndGXIdAndSfId(ppProduct.getPpId(),ppProduction.getGXId(),ppProduction.getStaffId()));//操作信息

        jsonObject.put("PPProductionInfo", ppProduction);//熔炼信息
        jsonObject.put("ppAnnealingInfo", ppAnnealingInfoRepository.findByPppId(ppProduction.getId()));//退火信息

        Integer id = ppProduction.getId()%10;

        jsonObject.put("twoListName",ppProduction.getGxName());//本班工序名称
        jsonObject.put("twoList",iProductionMapper.findProductsVoByPPPId(ppProduction.getId(),id));//本班产物

        return jsonObject;
    }


    /**
     * 生产数据-批号生产回溯-根据生产id查询对应本班信息
     * @param
     * @throws PassportException
     */
    public JSONObject getProductionInfoByPPPId(SelectModel selectModel)throws PassportException {
        JSONObject jsonObject = new JSONObject();

        if(StringUtils.isEmpty(selectModel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        PPProduction ppProduction = ppProductionRepository.findByid(selectModel.getFindById());
        if(StringUtils.isEmpty(ppProduction)){
            throw new PassportException(ResultCode.DATA_NOEXIST_MSG);
        }

        PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());//根据产物id查询产物基本信息

        ProductPlan productPlan = productPlanRepository.findByid(ppProduct.getPpId());//生产计划单

        jsonObject.put("ProcessTechnology",suitRepository.findByid(productPlan.getSuitId()));//工艺参数 根据套模id
        jsonObject.put("equipmentInfo",iProductionMapper.findEquipmentByEquipmentId(ppProduction.getEquipmentId()));//设备信息
        jsonObject.put("OperationInfo",iProductionMapper.findGXSchedulingByPPIdAndGXIdAndSfId(ppProduct.getPpId(),ppProduction.getGXId(),ppProduction.getStaffId()));//操作信息

        jsonObject.put("PPProductionInfo", ppProduction);//熔炼信息
        jsonObject.put("ppAnnealingInfo", ppAnnealingInfoRepository.findByPppId(ppProduction.getId()));//退火信息

        Integer id = ppProduction.getId()%10;

        jsonObject.put("twoListName",ppProduction.getGxName());//本班工序名称
        jsonObject.put("twoList",iProductionMapper.findProductsVoByPPPId(ppProduction.getId(),id));//本班产物

        return jsonObject;
    }


    /**
     * 生产数据-生产日报汇总
     * @param
     * @throws PassportException
     */
    public PageInfo getProductionDiaryReport(SelectModel selectModel)throws PassportException {
        PageInfo page = new PageInfo();

        String createTime = null;
        if(!StringUtils.isEmpty(selectModel.getFindDate())){
            createTime = selectModel.getFindDate();
        }

        page.setList(iProductionMapper.findAllByProductionDiaryReport(selectModel.getFindName(),selectModel.getFindModelName(),createTime,(selectModel.getPageNum()-1)*selectModel.getPageSize(),selectModel.getPageSize()));
        page.setTotal(iProductionMapper.countByProductionDiaryReport(selectModel.getFindName(),selectModel.getFindModelName(),createTime));

        page.setPageSize(selectModel.getPageSize());
        page.setPageNum(selectModel.getPageNum());
        return page;
    }
}
