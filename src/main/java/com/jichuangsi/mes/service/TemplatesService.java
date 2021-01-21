package com.jichuangsi.mes.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.jichuangsi.mes.common.ProductionStateChange;
import com.jichuangsi.mes.constant.ResultCode;
import com.jichuangsi.mes.entity.*;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.mapper.IMesMapper;
import com.jichuangsi.mes.mapper.IProductionMapper;
import com.jichuangsi.mes.model.*;
import com.jichuangsi.mes.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TemplatesService {
    @Resource
    private TemplatesRepository templatesRepository;
    @Resource
    private SDictionarierRepository sdRepository;

    @Resource
    private IMesMapper iMesMapper;
    @Resource
    private IProductionMapper iProductionMapper;
    @Resource
    private ProductPlanRepository productPlanRepository;
    @Resource
    private PPProductRepository ppProductRepository;
    @Resource
    private PPProductionRepository ppProductionRepository;
    @Resource
    private TSamplingReportRepository tSamplingReportRepository;
    @Resource
    private TSamplingReportDetailRepository tSamplingReportDetailRepository;
    @Resource
    private TCertificateReportRepository tCertificateReportRepository;

    /**
     * 新增模板—下拉框
     * @return
     */
    public JSONObject getTemplatesBasicInfo(){
        JSONObject job = new JSONObject();

        job.put("XB",sdRepository.findByDicCode("XB"));//线别

        long mbNum =templatesRepository.count();
        String strnum = "MB000"+mbNum;

        job.put("templatesNumber",strnum);//模板编号

        return job;
    }

    /**
     * 新增模板
     * @param templates
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)
    public void addTemplate(UserInfoForToken userInfoForToken,Templates templates) throws PassportException{
        if(StringUtils.isEmpty(templates.getType()) || StringUtils.isEmpty(templates.getFileRoute())
                || StringUtils.isEmpty(templates.getXB()) || StringUtils.isEmpty(templates.getName())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        if(!StringUtils.isEmpty(templates.getId())){
            if(templatesRepository.findById(templates.getId())==null){
                throw new PassportException(ResultCode.PARAM_MISS_MSG);
            }
        }else {
            long mbNum =templatesRepository.count();
            String strnum = "MB000"+mbNum;
            templates.setNumber(strnum);
            templates.setUserId(Integer.valueOf(userInfoForToken.getUserId()));//赋值用户id
        }
        templatesRepository.save(templates);
    }

    /**
     * 模板条件查询
     * @param model
     * @return
     */
    public PageInfo getAllListByPage(SelectModel model){
        PageInfo page=new PageInfo();
        List<Templates> templates = templatesRepository.findAllByPage(model.getFindById(),model.getFindName(),(model.getPageNum()-1)*model.getPageSize(),model.getPageSize());
        page.setList(templates);
        page.setTotal(templatesRepository.countAllBytype(model.getFindById(),model.getFindName()));
        page.setPageSize(model.getPageSize());
        page.setPageNum(model.getPageNum());
        return page;
    }

    /**
     * 根据id查询数据
     * @param model
     * @return
     */
    public Templates getTemplateById(SelectModel model) throws PassportException{
        if(StringUtils.isEmpty(model.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        Templates templates = templatesRepository.findByIdAndDeleteNo(model.getFindById(),0);
        return templates;
    }

    /**
     * 下载预览文件
     * @param id
     * @return
     * @throws PassportException
     */
    public String downloadFile(int id) throws PassportException{
        if(StringUtils.isEmpty(id)){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        Templates templates=templatesRepository.findById(id);
        return templates.getFileRoute();
    }

    /**
     * 模板-修改状态 （delete_no状态）
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateTemplateById(UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) ||StringUtils.isEmpty(model.getUpdateType())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        Templates templates=templatesRepository.findById((int)model.getUpdateID());

        if (StringUtils.isEmpty(templates)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        if(model.getUpdateType().equals("S")){
            templates.setClosed(templates.getClosed() == 0 ? 1 :0);
        }else if(model.getUpdateType().equals("D")){
            templates.setDeleteNo(templates.getDeleteNo() == 0 ? 1 :0);
        }

        templatesRepository.save(templates);
    }

    /**
     * TSamplingReport
     *抽样检验- 根据选择需要查询详情信息
     * @param
     * @throws PassportException
     */
    public JSONObject getTemplatesByChooseIds(UserInfoForToken userInfoForToken, SelectModel selectModel)throws PassportException {
        JSONObject jsonObject = new JSONObject();

        if(StringUtils.isEmpty(selectModel.getFindById()) || StringUtils.isEmpty(selectModel.getFindIdOne())||StringUtils.isEmpty(selectModel.getPageSize())||StringUtils.isEmpty(selectModel.getPageNum())||StringUtils.isEmpty(selectModel.getFindName())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        PPProduction ppProduction = ppProductionRepository.findByid(selectModel.getFindById());//这个库存里面找出来的
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

        //        抽样检验报告数据
        TSamplingReport tSamplingReport = new TSamplingReport();
        tSamplingReport.setStaffId(Integer.valueOf(userInfoForToken.getUserId()));//员工id
        tSamplingReport.setReportName(selectModel.getFindName());//报告名称
        tSamplingReport.setInspectionSum(selectModel.getPageSize());//进检轴数
        tSamplingReport.setSamplesNums(selectModel.getPageNum());//抽检轴数
        tSamplingReport.setPppId(selectModel.getFindById());//生产id
        tSamplingReport.setPpppId(selectModel.getFindIdOne());//生产产物id

        jsonObject.put("tSamplingReport",tSamplingReport);//抽样检验数据

//        抽样检验报告明细
        ProductsVo productsVo = iProductionMapper.findBypppProducts(selectModel.getFindById()%10,selectModel.getFindIdOne());//根据产物id查询详情
        List<TSamplingReportDetail> tSamplingReportDetailList = new ArrayList<>();
        for(int i = 0; i < selectModel.getPageNum(); i++){
            TSamplingReportDetail tSamplingReportDetail = new TSamplingReportDetail();
            tSamplingReportDetail.setWireUm(productsVo.getWireDiameterUm().toString());
            tSamplingReportDetail.setLengthM(productsVo.getLengthM().toString());
            tSamplingReportDetailList.add(tSamplingReportDetail);
        }
        jsonObject.put("samplingReportDetailList",tSamplingReportDetailList);//抽样检验数据list：根据传过来的数量生成具体数据


        jsonObject.put("tempXiaLa",iMesMapper.findAllTemplatesXiaLa(1));//检验报告模板下拉框
        jsonObject.put("staffXiaLa",iMesMapper.findStaffAllXiaLa());//抽样检验数据list：根据传过来的数量生成具体数据

        return jsonObject;
    }

    /**
     * 模板(抽样检验)- 新增/修改
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void saveTSamplingReport(TSamplingReportModel model)throws PassportException {
        TSamplingReport tSamplingReport = model.gettSamplingReport();

        List<TSamplingReportDetail> samplingReportDetailList = model.getSamplingReportDetailList();
        if(StringUtils.isEmpty(tSamplingReport.getReportName()) ||StringUtils.isEmpty(tSamplingReport.getStaffId())||StringUtils.isEmpty(tSamplingReport.getTempId())|| samplingReportDetailList.size() == 0){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        tSamplingReport.setState(0);
        tSamplingReport.setDeleteNo(0);
        TSamplingReport tSamplingReport1=tSamplingReportRepository.save(tSamplingReport);//保存报告基本信息

        for(int i = 0; i < samplingReportDetailList.size(); i++){
            samplingReportDetailList.get(i).setSamplingRId(tSamplingReport1.getId());
        }

        tSamplingReportDetailRepository.saveAll(samplingReportDetailList);//保存list
    }


    /**
     * 抽样检验-修改状态 （delete_no状态）
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateTSamplingReportById(UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) ||StringUtils.isEmpty(model.getUpdateType())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        TSamplingReport tSamplingReport=tSamplingReportRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(tSamplingReport)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        if(model.getUpdateType().equals("S")){
            tSamplingReport.setState(tSamplingReport.getState() == 0 ? 1 :0);
        }else if(model.getUpdateType().equals("D")){
            tSamplingReport.setDeleteNo(tSamplingReport.getDeleteNo() == 0 ? 1 :0);
        }

        tSamplingReportRepository.save(tSamplingReport);
    }

    /**
     * 抽样检查-查询全部
     * @param model
     * @return
     */
    public PageInfo getAllTSamplingReport(SelectModel model)throws PassportException{
        PageInfo page=new PageInfo();
        List<TSamplingReportVo> tSamplingReportVoList = iProductionMapper.findAllTSamplingReport(model.getFindName(),(model.getPageNum()-1)*model.getPageSize(),model.getPageSize());
        page.setList(tSamplingReportVoList);
        page.setTotal(iProductionMapper.countByTSamplingReport(model.getFindName()));
        page.setPageSize(model.getPageSize());
        page.setPageNum(model.getPageNum());
        return page;
    }
    /**
     * 抽样检查-根据id查询
     * @param model
     * @return
     */
    public JSONObject getTSamplingReportById(SelectModel model)throws PassportException{
        JSONObject jsonObject=new JSONObject();

        TSamplingReport tSamplingReport = tSamplingReportRepository.findByid(model.getFindById());
        if(StringUtils.isEmpty(tSamplingReport)){
            throw new PassportException(ResultCode.DATA_NOEXIST_MSG);
        }

        PPProduction ppProduction = ppProductionRepository.findByid(tSamplingReport.getPppId());//这个库存里面找出来的
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

        jsonObject.put("TSamplingReport",tSamplingReport);
        jsonObject.put("twoList",tSamplingReportDetailRepository.findBySamplingRId(model.getFindById()));

        jsonObject.put("tempXiaLa",iMesMapper.findAllTemplatesXiaLa(1));//检验报告模板下拉框
        jsonObject.put("staffXiaLa",iMesMapper.findStaffAllXiaLa());//抽样检验数据list：根据传过来的数量生成具体数据
        return jsonObject;
    }

    /**
     * TCertificateReport
     *质量证书- 根据选择需要查询详情信息
     * @param
     * @throws PassportException
     */
    public JSONObject getTCertificateReportByChooseIds(UserInfoForToken userInfoForToken, SelectModel selectModel)throws PassportException {
        JSONObject jsonObject = new JSONObject();

        if(StringUtils.isEmpty(selectModel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        PPProduction ppProduction = ppProductionRepository.findByid(selectModel.getFindById());//这个库存里面找出来的
        if(StringUtils.isEmpty(ppProduction)){
            throw new PassportException(ResultCode.DATA_NOEXIST_MSG);
        }

        PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());//根据产物id查询产物基本信息
        ProductPlan productPlan = productPlanRepository.findByid(ppProduct.getPpId());//生产计划单

        if(productPlan.getRelationNo() == 0){
            jsonObject.put("BasicInfo",iProductionMapper.findMeltingBasicInfoByNoSaleId(ppProduct.getId()));//基本信息：不关联销售订单 根据生产计划单产物id
            jsonObject.put("RawMaterialRatio",iProductionMapper.findRawMaterialRatioByNoSaleId(ppProduct.getProductDetailId()));// 原料比例： 根据产品明细id RawMaterialRatio
        }else{
            jsonObject.put("BasicInfo",iProductionMapper.findMeltingBasicInfoById(ppProduct.getId()));//基本信息：关联销售订单 根据生产计划单产物id
            jsonObject.put("RawMaterialRatio",iProductionMapper.findRawMaterialRatioBySaleId(ppProduct.getProductDetailId()));// 原料比例： 根据产品明细id RawMaterialRatio
        }

//        jsonObject.put("RawMaterialRatio",iProductionMapper.findRawMaterialRatioById(ppProduct.getProductDetailId()));// 原料比例： 根据产品明细id RawMaterialRatio

        // 质量证书
        TCertificateReport tCertificateReport = new TCertificateReport();
        tCertificateReport.setStaffId(Integer.valueOf(userInfoForToken.getUserId()));//员工id
        tCertificateReport.setPppId(selectModel.getFindById());//pppid

        jsonObject.put("tCertificateReport",tCertificateReport);//抽样检验数据

        jsonObject.put("tempXiaLa",iMesMapper.findAllTemplatesXiaLa(2));//检验报告模板下拉框
        jsonObject.put("staffXiaLa",iMesMapper.findStaffAllXiaLa());//抽样检验数据list：根据传过来的数量生成具体数据

        return jsonObject;
    }


    /**
     * 质量证书- 新增/修改
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void saveTCertificateReport(TCertificateReport tCertificateReport)throws PassportException {

        if(StringUtils.isEmpty(tCertificateReport.getReportName()) ||StringUtils.isEmpty(tCertificateReport.getStaffId())||StringUtils.isEmpty(tCertificateReport.getTempId())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        tCertificateReport.setDeleteNo(0);
        tCertificateReport.setState(0);
        tCertificateReportRepository.save(tCertificateReport);//保存list
    }


    /**
     * 质量证书-修改状态 （delete_no状态）
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateTCertificateReportById(UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) ||StringUtils.isEmpty(model.getUpdateType())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        TCertificateReport tCertificateReport=tCertificateReportRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(tCertificateReport)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        if(model.getUpdateType().equals("S")){
            tCertificateReport.setState(tCertificateReport.getState() == 0 ? 1 :0);
        }else if(model.getUpdateType().equals("D")){
            tCertificateReport.setDeleteNo(tCertificateReport.getDeleteNo() == 0 ? 1 :0);
        }

        tCertificateReportRepository.save(tCertificateReport);
    }

    /**
     * 质量证书-查询全部
     * @param model
     * @return
     */
    public PageInfo getAllTCertificateReport(SelectModel model)throws PassportException{
        PageInfo page=new PageInfo();
        List<TSamplingReportVo> tcertificate = iProductionMapper.findAllTCertificateReport(model.getFindName(),(model.getPageNum()-1)*model.getPageSize(),model.getPageSize());
        page.setList(tcertificate);
        page.setTotal(iProductionMapper.countByTCertificateReport(model.getFindName()));
        page.setPageSize(model.getPageSize());
        page.setPageNum(model.getPageNum());
        return page;
    }
    /**
     * 质量证书-根据id查询
     * @param model
     * @return
     */
    public JSONObject getTCertificateReportById(SelectModel model)throws PassportException{
        JSONObject jsonObject=new JSONObject();

        TCertificateReport tCertificateReport=tCertificateReportRepository.findByid(model.getFindById());

        if (StringUtils.isEmpty(tCertificateReport)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}


        PPProduction ppProduction = ppProductionRepository.findByid(tCertificateReport.getPppId());//这个库存里面找出来的
        if(StringUtils.isEmpty(ppProduction)){
            throw new PassportException(ResultCode.DATA_NOEXIST_MSG);
        }

        PPProduct ppProduct = ppProductRepository.findByid(ppProduction.getPproductId());//根据产物id查询产物基本信息
        ProductPlan productPlan = productPlanRepository.findByid(ppProduct.getPpId());//生产计划单

        if(productPlan.getRelationNo() == 0){
            jsonObject.put("BasicInfo",iProductionMapper.findMeltingBasicInfoByNoSaleId(ppProduct.getId()));//基本信息：不关联销售订单 根据生产计划单产物id
            jsonObject.put("RawMaterialRatio",iProductionMapper.findRawMaterialRatioByNoSaleId(ppProduct.getProductDetailId()));// 原料比例： 根据产品明细id RawMaterialRatio
        }else{
            jsonObject.put("BasicInfo",iProductionMapper.findMeltingBasicInfoById(ppProduct.getId()));//基本信息：关联销售订单 根据生产计划单产物id
            jsonObject.put("RawMaterialRatio",iProductionMapper.findRawMaterialRatioBySaleId(ppProduct.getProductDetailId()));// 原料比例： 根据产品明细id RawMaterialRatio
        }

        jsonObject.put("tCertificateReport",tCertificateReport);

        jsonObject.put("tempXiaLa",iMesMapper.findAllTemplatesXiaLa(2));//检验报告模板下拉框
        jsonObject.put("staffXiaLa",iMesMapper.findStaffAllXiaLa());//抽样检验数据list：根据传过来的数量生成具体数据
        return jsonObject;
    }

}
