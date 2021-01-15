package com.jichuangsi.mes.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.jichuangsi.mes.constant.ResultCode;
import com.jichuangsi.mes.entity.*;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.mapper.IMesMapper;
import com.jichuangsi.mes.model.*;
import com.jichuangsi.mes.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MouldService {
    @Resource
    private IMesMapper mesMapper;
    @Resource
    private BasicSettingService basicSettingService;

    @Resource
    private SDictionarierRepository sdRepository;

    @Resource
    private TMouldRepository tMouldRepository;

    @Resource
    private TMouldDetailRepository tMouldDetailRepository;
    @Resource
    private TCuffingcheckRepository cuffingcheckRepository;
    @Resource
    private TCuffingcheckdetailRepository tCuffingcheckdetailRepository;
    @Resource
    private TFinishedproducecheckRepository tFinishedproducecheckRepository;


    @Resource
    private TSuitRepository suitRepository;//套模
    @Resource
    private TSuitdetailRepository suitdetailRepository;//套模明细

    /**
     * 模具管理-查询页面-查询下拉框
     * @param
     * @throws PassportException
     */
    public JSONObject getAllTMouldXiaLa()throws PassportException {
        JSONObject jsonObject=new JSONObject();

        jsonObject.put("XBType",sdRepository.findByDicCode("XB"));//线别类型

        return jsonObject;
    }

    /**
     * 模具管理-查询
     * @param
     * @throws PassportException
     */
    public PageInfo getAllTMould(SelectModel smodel)throws PassportException {
        PageInfo page=new PageInfo();

        if(StringUtils.isEmpty(smodel.getPageNum()) || StringUtils.isEmpty(smodel.getPageSize())|| StringUtils.isEmpty(smodel.getIswhether())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        List<TMouldVo> tMouldVoList = mesMapper.findAllTMouldByCuffingMouldNno(smodel.getIswhether(),smodel.getFindName(),smodel.getFindIdOne(),smodel.getFindById(),(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());

        page.setList(tMouldVoList);
        page.setTotal(mesMapper.countByTMouldByCuffingMouldNno(smodel.getIswhether(),smodel.getFindName(),smodel.getFindIdOne(),smodel.getFindById()));
        page.setPageSize(smodel.getPageSize());
        page.setPageNum(smodel.getPageNum());
        return page;
    }


    /**
     * 模具管理-新增/编辑页面-根据模具id查询模具明细
     * @param
     * @throws PassportException
     */
    public JSONObject getTMouldByID(SelectModel smodel)throws PassportException {
        JSONObject jsonObject=new JSONObject();

        if(StringUtils.isEmpty(smodel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        jsonObject.put("mould",tMouldRepository.findByid(smodel.getFindById()));
        jsonObject.put("mouldDetail",tMouldDetailRepository.findByMouldIdAndDeleteNo(smodel.getFindById(),0));

        return jsonObject;
    }

    /**
     * 模具管理- 新增/编辑页面获取下拉框数据
     * @param
     * @throws PassportException
     */
    public JSONObject getMouldInfo(SelectModel smodel)throws PassportException {
        JSONObject jsonObject = new JSONObject();

        String str = "";
        if(smodel.getIswhether() == 0){
            str = "CT";
        }else{
            str = "CP";
        }
        jsonObject.put("equipmentXiaLa",mesMapper.findAllEquipmentByXiaLa());//使用机型
        jsonObject.put("XBType",sdRepository.findByDicCode("XB"));//线别类型
        jsonObject.put("mouldNumber",str+"-"+tMouldDetailRepository.count());//模具编号
        return jsonObject;
    }

    /**
     * 模具管理-新增/修改 成套/成品模型
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void  saveCompleteSet(TMouldModel tMouldModel)throws PassportException{
        TMould mould =  tMouldModel.gettMould();

        if(StringUtils.isEmpty(mould.getMouldName()) ||StringUtils.isEmpty(mould.getMouldModel())|| StringUtils.isEmpty(mould.getCuffingmouldNno())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        String str = "";
        if(mould.getCuffingmouldNno() == 0){
            str = "CT";
        }else{
            str = "CP";
        }

        mould.setMouldNumber(str+"-"+tMouldDetailRepository.count());
        mould.setScrapNo(0);
        mould.setDeleteNo(0);
        TMould mould1 = tMouldRepository.save(mould);

        Integer tmid = mould1.getId();
        if(mould.getCuffingmouldNno() == 1){//如果是成品模具
            List<TMouldDetail> tMouldDetailList = tMouldModel.gettMouldDetailList();

            tMouldDetailRepository.updateMoulddetailByMouldId(tmid);//把所有的删除否状态改为 1

            for (int i = 0; i < tMouldDetailList.size(); i++) {
                TMouldDetail tMouldDetail = tMouldDetailList.get(i);
                if(StringUtils.isEmpty(tMouldDetail.getSonmouldModel())||StringUtils.isEmpty(tMouldDetail.getSonmouldSpaNum())){
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
                    throw new PassportException(ResultCode.PARAM_MISS_MSG);
                }

                tMouldDetail.setMouldId(mould1.getId());
                tMouldDetail.setDeleteNo(0);
            }
            tMouldDetailRepository.saveAll(tMouldDetailList);
        }

    }


    /**
     * 模具管理-修改状态(state or  delete_no)
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateTmouldByid(UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) ||StringUtils.isEmpty(model.getUpdateType())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        TMould tMould=  tMouldRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(tMould)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        if(model.getUpdateType().equals("S")){//修改state
            tMould.setScrapNo(tMould.getScrapNo() == 0 ? 1 :0);
        }else if(model.getUpdateType().equals("D")){//修改deleteno
            tMould.setDeleteNo(tMould.getDeleteNo() == 0 ? 1 :0);
        }
        tMouldRepository.save(tMould);
    }

    /**
     * 模具管理-成套模具维护-维护页面-根据模具id查询模具信息跟历史检查数据
     * @param
     * @throws PassportException
     */
    public JSONObject getTMouldById(SelectModel smodel)throws PassportException {
        JSONObject jsonObject=new JSONObject();

        if(StringUtils.isEmpty(smodel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        TMouldVo mouldVo = mesMapper.findTMouldById(smodel.getFindById());

        jsonObject.put("tmould",mouldVo);
        jsonObject.put("cuffingcheck",mesMapper.findCuffindHistoryCheckByMouldId(smodel.getFindById()));
        return jsonObject;
    }


    /**
     * 模具管理-成套模具维护-新增/查看维护页面-根据模具id查询模具维护信息
     * @param
     * @throws PassportException
     */
    public JSONObject getTMouldDetailById(SelectModel smodel)throws PassportException {
        JSONObject jsonObject=new JSONObject();

        if(StringUtils.isEmpty(smodel.getFindById()) || StringUtils.isEmpty(smodel.getFindModelName())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        if(smodel.getFindModelName().equals("C")){
            jsonObject.put("tmould",mesMapper.findCuffindCheckByTcId(smodel.getFindById()));
            jsonObject.put("tmouldDetail",mesMapper.findCuffindCheckDetailByTcId(smodel.getFindById()));
        }else if(smodel.getFindModelName().equals("I")){
            jsonObject.put("tmould",mesMapper.findCuffindCheckByMouldId(smodel.getFindById()));
            jsonObject.put("tmouldDetail",mesMapper.findCuffindCheckDetailByMouldId(smodel.getFindById()));
        }

        return jsonObject;
    }


    /**
     * 模具管理-成套模具维护-新增维护
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void savecuffingCheck(UserInfoForToken userInfoForToken,TMouldModel mouldModel)throws PassportException {
        TCuffingcheck cuffingcheck=mouldModel.gettCuffingcheck();

        if(StringUtils.isEmpty(cuffingcheck.getMouldid()) || StringUtils.isEmpty(cuffingcheck.getJudgeresult())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        cuffingcheck.setStaffid(Integer.valueOf(userInfoForToken.getUserId()));
        cuffingcheck.setCreateTime(new Date());
        cuffingcheck.setDeleteno(0);
        TCuffingcheck tCuffingcheck1 = cuffingcheckRepository.save(cuffingcheck);

        Integer cuid = tCuffingcheck1.getId();
        List<TCuffingcheckdetail> list = mouldModel.getCuffingcheckdetails();

        for (int i = 0; i < list.size(); i++) {
            TCuffingcheckdetail tCuffingcheckdetail = list.get(i);
            tCuffingcheckdetail.setCuffingCheckId(cuid);
            tCuffingcheckdetail.setDeleteNo(0);
        }

        tCuffingcheckdetailRepository.saveAll(list);
    }

    /**
     * 模具管理-成套模具维护-历史检查数据-修改状态(delete_no)
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateTCuffingcheckByid(UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        TCuffingcheck tCuffingcheck=  cuffingcheckRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(tCuffingcheck)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        tCuffingcheck.setDeleteno(tCuffingcheck.getDeleteno() == 0 ? 1 :0);
        cuffingcheckRepository.save(tCuffingcheck);
    }


    /**
     * 模具管理-成品模具维护-根据模具id查询模具信息跟历史检查数据
     * @param
     * @throws PassportException
     */
    public JSONObject getTMouldFinishedproducecheckById(SelectModel smodel)throws PassportException {
        JSONObject jsonObject=new JSONObject();

        if(StringUtils.isEmpty(smodel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        TMouldVo mouldVo = mesMapper.findTMouldById(smodel.getFindById());

        jsonObject.put("tmould",mouldVo);
        jsonObject.put("Finishedproducecheck",mesMapper.findFinishedproducecheckByMouldId(smodel.getFindById()));
        return jsonObject;
    }


    /**
     * 模具管理-成品模具维护-新增/查看维护页面-根据模具id查询模具维护信息
     * @param
     * @throws PassportException
     */
    public JSONObject getFinishedproducecheckById(SelectModel smodel)throws PassportException {
        JSONObject jsonObject=new JSONObject();

        if(StringUtils.isEmpty(smodel.getFindById()) || StringUtils.isEmpty(smodel.getFindModelName())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        jsonObject.put("tmould",tMouldRepository.findByid(smodel.getFindById()));
        if(smodel.getFindModelName().equals("C")){//查看
            jsonObject.put("tmouldDetail",tFinishedproducecheckRepository.findByid(smodel.getFindById()));
        }

        return jsonObject;
    }


    /**
     * 模具管理-成品模具维护-新增维护
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void saveFinishedproducecheck(UserInfoForToken userInfoForToken,TFinishedproducecheck tFinishedproducecheck)throws PassportException {

        if(StringUtils.isEmpty(tFinishedproducecheck.getMouldId()) || StringUtils.isEmpty(tFinishedproducecheck.getLengthM()) ||StringUtils.isEmpty(tFinishedproducecheck.getDensity())
                ||StringUtils.isEmpty(tFinishedproducecheck.getWeightMg1()) ||StringUtils.isEmpty(tFinishedproducecheck.getWeightMg2()) ||StringUtils.isEmpty(tFinishedproducecheck.getWeightMg3())
                ||StringUtils.isEmpty(tFinishedproducecheck.getWeightMg4()) ||StringUtils.isEmpty(tFinishedproducecheck.getWeightMg5()) ||StringUtils.isEmpty(tFinishedproducecheck.getWeightMg6())
                ||StringUtils.isEmpty(tFinishedproducecheck.getWeightMg7()) ||StringUtils.isEmpty(tFinishedproducecheck.getWeightMg8()) ||StringUtils.isEmpty(tFinishedproducecheck.getWeightMg9())
                ||StringUtils.isEmpty(tFinishedproducecheck.getWeightMg0()) ||StringUtils.isEmpty(tFinishedproducecheck.getWeightavageMg())||StringUtils.isEmpty(tFinishedproducecheck.getMeasureddiamUm())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        tFinishedproducecheck.setStaffId(Integer.valueOf(userInfoForToken.getUserId()));
        tFinishedproducecheck.setDeleteNo(0);
        tFinishedproducecheck.setCreateTime(new Date());

        Double dMgAgage = getAvageMg(tFinishedproducecheck.getWeightMg1(),tFinishedproducecheck.getWeightMg2(),tFinishedproducecheck.getWeightMg3(),tFinishedproducecheck.getWeightMg4(),
                tFinishedproducecheck.getWeightMg5(),tFinishedproducecheck.getWeightMg6(),tFinishedproducecheck.getWeightMg7(),tFinishedproducecheck.getWeightMg8(),tFinishedproducecheck.getWeightMg9(),tFinishedproducecheck.getWeightMg0());

        tFinishedproducecheck.setWeightavageMg(dMgAgage);//重量平均值mg
        tFinishedproducecheck.setMeasureddiamUm(getMeasureddiamUm(dMgAgage,tFinishedproducecheck.getLengthM(), tFinishedproducecheck.getDensity()));//实测直径um
        tFinishedproducecheckRepository.save(tFinishedproducecheck);
    }

    //计算平均值
    public static Double getAvageMg(Double mg1,Double mg2,Double mg3,Double mg4,Double mg5,Double mg6,Double mg7,Double mg8,Double mg9,Double mg0){
        BigDecimal b1 = new BigDecimal(mg1.toString());
        BigDecimal b2 = new BigDecimal(mg2.toString());
        BigDecimal b3 = new BigDecimal(mg3.toString());
        BigDecimal b4 = new BigDecimal(mg4.toString());
        BigDecimal b5 = new BigDecimal(mg5.toString());
        BigDecimal b6 = new BigDecimal(mg6.toString());
        BigDecimal b7 = new BigDecimal(mg7.toString());
        BigDecimal b8 = new BigDecimal(mg8.toString());
        BigDecimal b9 = new BigDecimal(mg9.toString());
        BigDecimal b0 = new BigDecimal(mg0.toString());

        Double d1 = (b1.add(b2).add(b3).add(b4).add(b5).add(b6).add(b7).add(b8).add(b9).add(b0)).divide(new BigDecimal(10)).doubleValue();
        return d1;
    }

    //计算实测直径um
    public static   Double getMeasureddiamUm(Double avageMg,Double LengthM,Double Density){
        BigDecimal avageMg1  =   new  BigDecimal(avageMg.toString());
        BigDecimal LengthM1  =   new  BigDecimal(LengthM.toString());
        BigDecimal Density1  =   new  BigDecimal(Density.toString());

        Double dou = new Double(new BigDecimal(4000).multiply(avageMg1).divide(LengthM1.multiply(new BigDecimal(Math.PI)).multiply(Density1),8,BigDecimal.ROUND_HALF_UP).doubleValue()) ;
        return Math.sqrt(dou);
    }


    /**
     * 模具管理-成品模具维护-历史检查数据-修改状态(delete_no)
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateFinishedproducecheckByid(UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        TFinishedproducecheck tFinishedproducecheck=  tFinishedproducecheckRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(tFinishedproducecheck)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        tFinishedproducecheck.setDeleteNo(tFinishedproducecheck.getDeleteNo() == 0 ? 1 :0);
        tFinishedproducecheckRepository.save(tFinishedproducecheck);
    }

    /**
     * 套模管理- 新增/编辑页面获取下拉框数据
     * @param
     * @throws PassportException
     */
    public JSONObject getSleeveDieInfo()throws PassportException {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("XBType",sdRepository.findByDicCode("XB"));//线别类型
        jsonObject.put("mouldNumber","MJ-"+basicSettingService.getEquipmentNumber());//模具编号
        return jsonObject;
    }

    public  Integer getEquipmentType(String strType){
        Integer intId = 0;
        switch (strType){
            case "CL"://粗拉
                intId = 73;
                break;
            case "ZL"://中拉
                intId = 74;
                break;
            case "CP"://成品
                intId = 77;
                break;
            case "BCP"://半成品
                intId = 76;
                break;
                default:
                    break;

        }
        return intId;
    }

    /**
     * 套模管理- 新增/编辑页面根据模具类别跟设备类型查询模具信息
     * @param
     * @throws PassportException
     */
    public JSONObject getTmouldByEquipmentTypeandTmouldType(SelectModel smodel)throws PassportException {
        JSONObject jsonObject = new JSONObject();

        if(StringUtils.isEmpty(smodel.getIswhether()) ||StringUtils.isEmpty(smodel.getFindModelName())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        List<TMouldVo> listmodel= mesMapper.findTMouldByequipmentTypeIdAndcuffingmouldNo(smodel.getFindName(),getEquipmentType(smodel.getFindModelName()),smodel.getIswhether());
        jsonObject.put("tmould",listmodel.size() == 0 ? "":listmodel);

        if(smodel.getIswhether() == 1){
            jsonObject.put("tmouldDetail",listmodel.size() == 0 ? "":tMouldDetailRepository.findByMouldIdAndDeleteNo(listmodel.get(0).getId(),0));
        }

        return jsonObject;
    }

    /**
     * 套模管理- 新增/编辑页面(模具类别跟设备类型查询模具信息)-根据id查询明细
     * @param
     * @throws PassportException
     */
    public List<TMouldDetail> getTmouldByEquipmentTypeandTmouldTypeById(SelectModel smodel)throws PassportException {
        if(StringUtils.isEmpty(smodel.getFindById()) || smodel.getIswhether() != 1){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        return tMouldDetailRepository.findByMouldIdAndDeleteNo(smodel.getFindById(),0);
    }


    /**
     * 套模管理-新增/修改
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void  saveTSuit(UserInfoForToken userInfoForToken, TMouldModel tMouldModel)throws PassportException{
        TSuit suit =  tMouldModel.gettSuit();

        if(StringUtils.isEmpty(suit.getConstituteName()) ||StringUtils.isEmpty(suit.getLineTypeId())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        suit.setConstituteNumber("MJ-"+basicSettingService.getEquipmentNumber());
        suit.setStaffId(Integer.valueOf(userInfoForToken.getUserId()));
        suit.setScrapNo(0);
        suit.setDeleteNo(0);
        TSuit suit1 = suitRepository.save(suit);

        Integer tmid = suit1.getId();

        List<TSuitdetail> suitdetails = tMouldModel.gettSuitdetailList();

        suitdetailRepository.updateSuitDetailBySuitId(tmid);//把所有的删除否状态改为 1

        for (int i = 0; i < suitdetails.size(); i++) {
            TSuitdetail tSuitdetail = suitdetails.get(i);
            if(StringUtils.isEmpty(tSuitdetail.getMouldType())){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
                throw new PassportException(ResultCode.PARAM_MISS_MSG);
            }

            tSuitdetail.setSuitId(tmid);
            tSuitdetail.setDeleteNo(0);
        }
        suitdetailRepository.saveAll(suitdetails);

    }

    /**
     * 套模管理-查询
     * @param
     * @throws PassportException
     */
    public PageInfo getAllTSuit(SelectModel smodel)throws PassportException {
        PageInfo page=new PageInfo();

        if(StringUtils.isEmpty(smodel.getPageNum()) || StringUtils.isEmpty(smodel.getPageSize())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        List<TSuitVo> tSuitVos = mesMapper.findAllTSuit(smodel.getFindName(),smodel.getFindIdOne(),smodel.getFindById(),(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());

        page.setList(tSuitVos);
        page.setTotal(mesMapper.countByTSuit(smodel.getFindName(),smodel.getFindIdOne(),smodel.getFindById()));
        page.setPageSize(smodel.getPageSize());
        page.setPageNum(smodel.getPageNum());
        return page;
    }

    /**
     * 套模管理-根据套模id查询套模信息
     * @param
     * @throws PassportException
     */
    public JSONObject getTSuitById(SelectModel smodel)throws PassportException {
        JSONObject jsonObject=new JSONObject();

        if(StringUtils.isEmpty(smodel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        jsonObject.put("tsuit",suitRepository.findByid(smodel.getFindById()));

        List<TSuitdetailVo> tSuitdetailVoList = mesMapper.findTSuitDetailById(smodel.getFindById());
        for (TSuitdetailVo tSuitdetailVo:  tSuitdetailVoList) {
            tSuitdetailVo.setSonmouldModel(StringUtils.isEmpty(tSuitdetailVo.getMouldDetailId()) ? "" :mesMapper.findTmodelDetailByIds(tSuitdetailVo.getMouldDetailId()));
        }
        jsonObject.put("tsuitDetail",tSuitdetailVoList);
        return jsonObject;
    }


    /**
     * 套模管理-根据套模id查询套模信息--预览组合
     * @param
     * @throws PassportException
     */
    public JSONObject getPreviewTSuitById(SelectModel smodel)throws PassportException {
        JSONObject jsonObject=new JSONObject();

        if(StringUtils.isEmpty(smodel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        List<String> stringList = new ArrayList<>();
        stringList.add("粗拉");
        stringList.add("中拉");
        stringList.add("半成品");
        stringList.add("成品");


        List<TSuitdetailVo> tSuitdetailVoList = mesMapper.findTSuitDetailById(smodel.getFindById());
        for (TSuitdetailVo tSuitdetailVo:  tSuitdetailVoList) {
            tSuitdetailVo.setSonmouldModel(StringUtils.isEmpty(tSuitdetailVo.getMouldDetailId()) ? "" :mesMapper.findTmodelDetailByIds(tSuitdetailVo.getMouldDetailId()));
        }
        jsonObject.put("tsuitDetail",tSuitdetailVoList);
        return jsonObject;
    }

    /**
     * 套模管理-修改状态(state or  delete_no)
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateTsuitByid(UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) ||StringUtils.isEmpty(model.getUpdateType())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        TSuit tSuit=  suitRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(tSuit)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        if(model.getUpdateType().equals("S")){//修改state
            tSuit.setScrapNo(tSuit.getScrapNo() == 0 ? 1 :0);
        }else if(model.getUpdateType().equals("D")){//修改deleteno
            tSuit.setDeleteNo(tSuit.getDeleteNo() == 0 ? 1 :0);
        }
        suitRepository.save(tSuit);
    }
}
