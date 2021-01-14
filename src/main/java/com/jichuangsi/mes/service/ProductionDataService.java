package com.jichuangsi.mes.service;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.jichuangsi.mes.constant.ResultCode;
import com.jichuangsi.mes.entity.PPProduct;
import com.jichuangsi.mes.entity.PPProduction;
import com.jichuangsi.mes.entity.ProductPlan;
import com.jichuangsi.mes.entity.TTeam;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.mapper.IMesMapper;
import com.jichuangsi.mes.mapper.IProductionMapper;
import com.jichuangsi.mes.model.MapVo;
import com.jichuangsi.mes.model.PPProductsVo;
import com.jichuangsi.mes.model.SelectModel;
import com.jichuangsi.mes.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sun.applet.Main;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Service
public class ProductionDataService {


    @Resource
    private IProductionMapper iProductionMapper;
    @Resource
    private IMesMapper iMesMapper;

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

    @Resource
    private TTeamRepository tTeamRepository;

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


    /**
     * 生产数据-生产日报细分报表--暂停
     * @param
     * @throws PassportException
     */
//    public PageInfo getProductionSubdivideReport(SelectModel selectModel)throws PassportException {
//        PageInfo page = new PageInfo();
//
//        String createTime = null;
//        if(!StringUtils.isEmpty(selectModel.getFindDate())){
//            createTime = selectModel.getFindDate();
//        }
//
//
//        for (int i = 0; i < 10; i++) {
//
//        }
//
//        page.setList(iProductionMapper.findAllByProductionSubdivideReport(selectModel.getFindName(),selectModel.getFindModelName(),createTime,(selectModel.getPageNum()-1)*selectModel.getPageSize(),selectModel.getPageSize()));
//        page.setTotal(iProductionMapper.countByProductionSubdivideReport(selectModel.getFindName(),selectModel.getFindModelName(),createTime));
//
//        page.setPageSize(selectModel.getPageSize());
//        page.setPageNum(selectModel.getPageNum());
//        return page;
//    }


    /**
     * 生产数据-生产质量分析
     * 统计每个月的数据
     * @param
     * @throws PassportException
     */
    public JSONObject getProductionQualityAnalysis(SelectModel selectModel)throws PassportException {
        JSONObject jsonObject = new JSONObject();
        PageInfo page = new PageInfo();
        String createTime = selectModel.getFindDate();
        if(StringUtils.isEmpty(createTime)){//如果为空，默认查询当月的
            Calendar calendar = Calendar.getInstance();
            Integer year = calendar.get(Calendar.YEAR);
            Integer month = calendar.get(Calendar.MONTH) + 1;
            createTime = year + "-" + ( month<10 ? "0" + month : month);
        }

        //查询有分页的
        List<PPProductsVo>  ppProductsVoList =  iProductionMapper.findAllByProductionQualityAnalysis(createTime,(selectModel.getPageNum()-1)*selectModel.getPageSize(),selectModel.getPageSize());

        for (int s = 0; s < ppProductsVoList.size(); s++) {
            ppProductsVoList.get(s).setNetWeightgRate(ppProductsVoList.get(s).getFinishEdP().divide(ppProductsVoList.get(s).getIncomeHeavy(),8,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
            ppProductsVoList.get(s).setWastagegRate(ppProductsVoList.get(s).getWastageg().divide(ppProductsVoList.get(s).getIncomeHeavy(),8,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
            ppProductsVoList.get(s).setLossgRate(ppProductsVoList.get(s).getLossg().divide(ppProductsVoList.get(s).getIncomeHeavy(),8,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
        }
        page.setList(ppProductsVoList);
        page.setTotal(iProductionMapper.countByProductionQualityAnalysis(createTime));

        page.setPageSize(selectModel.getPageSize());
        page.setPageNum(selectModel.getPageNum());

        //查询全部（当前时间的全部，没有分页）
        List<PPProductsVo> ppProductsVoList1 = iProductionMapper.findAllByProductionQualityAnalysisNoLimit(createTime);
        for (int s = 0; s < ppProductsVoList1.size(); s++) {
            ppProductsVoList1.get(s).setNetWeightgRate(ppProductsVoList1.get(s).getFinishEdP().divide(ppProductsVoList1.get(s).getIncomeHeavy(),2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
            ppProductsVoList1.get(s).setWastagegRate(ppProductsVoList1.get(s).getWastageg().divide(ppProductsVoList1.get(s).getIncomeHeavy(),2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
            ppProductsVoList1.get(s).setLossgRate(ppProductsVoList1.get(s).getLossg().divide(ppProductsVoList1.get(s).getIncomeHeavy(),2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
        }

        //树状图数据
        JSONObject jsonObject1 = new JSONObject();
        List<String> stringList = new ArrayList<>();
        stringList.add("来料");
        stringList.add("成品");
        stringList.add("废料");
        stringList.add("损耗");

        List<BigDecimal> integerList = new ArrayList<>();

        BigDecimal bigDecimal1= ppProductsVoList1.stream().map(PPProductsVo->PPProductsVo.getIncomeHeavy()).reduce(BigDecimal.ZERO,BigDecimal::add);//来料
        BigDecimal bigDecimal2= ppProductsVoList1.stream().map(PPProductsVo->PPProductsVo.getFinishEdP()).reduce(BigDecimal.ZERO,BigDecimal::add);//成品
        BigDecimal bigDecimal3= ppProductsVoList1.stream().map(PPProductsVo->PPProductsVo.getWastageg()).reduce(BigDecimal.ZERO,BigDecimal::add);//废料
        BigDecimal bigDecimal4= ppProductsVoList1.stream().map(PPProductsVo->PPProductsVo.getLossg()).reduce(BigDecimal.ZERO,BigDecimal::add);//损耗

        integerList.add(bigDecimal1);
        integerList.add(bigDecimal2);
        integerList.add(bigDecimal3);
        integerList.add(bigDecimal4);

        jsonObject1.put("oneData",stringList);
        jsonObject1.put("twoData",integerList);

        //扇形图数据
        JSONArray jsonArray = new JSONArray();
        for (int i = 1; i < stringList.size(); i++) {
            JSONObject jsonObjects = new JSONObject();
            jsonObjects.put("name",stringList.get(i));
            jsonObjects.put("value",integerList.get(i).divide(bigDecimal1,8,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));

            jsonArray.add(jsonObjects);
        }

        jsonObject.put("LData",jsonArray);//扇形生产质量图
        jsonObject.put("RData",jsonObject1);//生产质量直方图
        jsonObject.put("list",page);//列表数据

        return jsonObject;
    }

    /**
     * 生产数据-班组生产数据统计
     * 统计每个月的数据
     * @param
     * @throws PassportException
     */
    public JSONObject getProductionTeam(SelectModel selectModel)throws PassportException {
        JSONObject jsonObject = new JSONObject();
        String createTime = selectModel.getFindDate();
        if(StringUtils.isEmpty(createTime)){//如果为空，默认查询当月的
            Calendar calendar = Calendar.getInstance();
            Integer month = calendar.get(Calendar.MONTH) + 1;
            Integer year = calendar.get(Calendar.YEAR);
            createTime = year + "-" + ( month<10 ? "0" + month : month);
        }


        List<String> stringList = new ArrayList<>();
        stringList.add("product");
        stringList.add("成品");
        stringList.add("废料");
        stringList.add("损耗");

        //直方图数据
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("dimensions",stringList);

        //生产质量直方图
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("dimensions",stringList);

        List<PPProductsVo> ppProductsVoArrayList = new ArrayList<>();
        JSONArray jsonArray1 = new JSONArray();
        JSONArray jsonArray2 = new JSONArray();
        List<MapVo> list = iMesMapper.findAllTTeamByXiaLa();

        for (int i = 0; i < list.size(); i++) {
            JSONObject jsonObject3 = new JSONObject();
            JSONObject jsonObject4 = new JSONObject();
            List<PPProductsVo>  ppProductsVoList =  iProductionMapper.findAllByProductionTeam(createTime,list.get(i).getMapKey());

            //设置比例率
            ppProductsVoList.get(0).setNetWeightgRate(ppProductsVoList.get(0).getFinishEdP().divide(ppProductsVoList.get(0).getIncomeHeavy(),8,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
            ppProductsVoList.get(0).setWastagegRate(ppProductsVoList.get(0).getWastageg().divide(ppProductsVoList.get(0).getIncomeHeavy(),8,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
            ppProductsVoList.get(0).setLossgRate(ppProductsVoList.get(0).getLossg().divide(ppProductsVoList.get(0).getIncomeHeavy(),8,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));

            jsonObject3.put("product",list.get(i).getMapValue());//班组
            jsonObject3.put("成品",ppProductsVoList.get(0).getFinishEdP());
            jsonObject3.put("废料",ppProductsVoList.get(0).getWastageg());
            jsonObject3.put("损耗",ppProductsVoList.get(0).getLossg());

            jsonObject4.put("product",list.get(i).getMapValue());//班组
            jsonObject4.put("成品",ppProductsVoList.get(0).getNetWeightgRate());
            jsonObject4.put("废料",ppProductsVoList.get(0).getWastagegRate());
            jsonObject4.put("损耗",ppProductsVoList.get(0).getLossgRate());

            ppProductsVoArrayList.addAll(ppProductsVoList);
            jsonArray1.add(jsonObject3);
            jsonArray2.add(jsonObject4);
        }

        jsonObject1.put("source",jsonArray1);//第一个直方图数据
        jsonObject2.put("source",jsonArray2);//第二个直方图数据

        jsonObject.put("oneData",jsonObject1);//产量直方图数据
        jsonObject.put("twoData",jsonObject2);//生产质量直方图
        jsonObject.put("list",ppProductsVoArrayList);//列表数据
        return jsonObject;
    }
}
