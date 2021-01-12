package com.jichuangsi.mes.service;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.jichuangsi.mes.common.ProductionStateChange;
import com.jichuangsi.mes.common.getDateConfig;
import com.jichuangsi.mes.constant.ResultCode;
import com.jichuangsi.mes.entity.Matters;
import com.jichuangsi.mes.entity.ProductionDiaryReport;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.mapper.IMesMapper;
import com.jichuangsi.mes.mapper.IProductionMapper;
import com.jichuangsi.mes.model.MapVo;
import com.jichuangsi.mes.model.SelectModel;
import com.jichuangsi.mes.model.UserInfoForToken;
import com.jichuangsi.mes.repository.MattersRepository;
import com.jichuangsi.mes.repository.PPProductionRepository;
import com.jichuangsi.mes.repository.ProductionDiaryReportRepository;
import com.jichuangsi.mes.repository.SNoticeRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class HomeService {


    @Resource
    private MattersRepository mattersRepository;
    @Resource
    private SNoticeRepository sNoticeRepository;
    @Resource
    private IProductionMapper iProductionMapper;
    @Resource
    private PPProductionRepository ppProductionRepository;
    @Resource
    private IMesMapper iMesMapper;
    @Resource
    private ProductionDiaryReportRepository productionDiaryReportRepository;//生产日报汇总表

    /**
     * 首页-查询数据
     * @param
     * @throws PassportException
     */
    public JSONObject findMyMatters(UserInfoForToken userInfoForToken)throws PassportException {
        JSONObject job = new JSONObject();
        Date d = new Date();

        Integer num = productionDiaryReportRepository.findByProductDate(DateUtil.today()).stream().mapToInt(ProductionDiaryReport::getNumbers).sum();

        job.put("production",StringUtils.isEmpty(num) ? 0 :num);//生产（成品轴数）
        job.put("productionOrderMatter",ppProductionRepository.findByCreateTimeIsBetweenAndDeleteNo(DateUtil.beginOfDay(d),DateUtil.endOfDay(d),0).size());//生产订单量（生产计划单数量）
        job.put("purchaseAmount",iMesMapper.countByPurchaseMoney(DateUtil.today()));//采购金额（采购支出的金额）
        job.put("salesAmount",iMesMapper.countBySaleMoney(DateUtil.today()));//销售金额（销售收入的金额）
        job.put("myMatter",iMesMapper.findAllMatters(null,Integer.valueOf(userInfoForToken.getUserId()),0, null,null,null));//待办事项
        job.put("noticeList",sNoticeRepository.findByIsshowAndDeleteNoOrderByCreateTimeDesc(1,0));//系统公告

        job.put("dayProduction", getDaysByYearMonthList().get("one"));//月生产量统计横轴日期
        job.put("dayProductionDetail", getDaysByYearMonthList().get("two"));//月生产量统计 竖轴（数据）

        return job;
    }

    public JSONObject getDaysByYearMonthList() {
        JSONObject jsonObject = new JSONObject();
        Calendar c = Calendar.getInstance();
        Integer y=c.get(Calendar.YEAR);//年bai
        Integer M = c.get(Calendar.MONTH)+1;//月,注意这里要du加1,计算机第一个月从zhi0开始

        String dateNowStr = y+"-"+M;
        List<String> list = new ArrayList<>();
//        List<String> list2 = new ArrayList<>();
        List<Integer> countSumList = new ArrayList<>();
        Integer intcount = getDateConfig.getDaysByYearMonth(dateNowStr);
        for (int i = 0; i < intcount; i++) {
            String str =String.format("%02d",(M))+"-"+String.format("%02d",(i+1));
            list.add(str);//日期

//            list2.add(y+"-"+str);
            Integer num = productionDiaryReportRepository.findByProductDate(y+"-"+str).stream().mapToInt(ProductionDiaryReport::getNumbers).sum();
            countSumList.add(StringUtils.isEmpty(num) ? 0:num);
        }

        jsonObject.put("one",list);
        jsonObject.put("two",countSumList);//iMesMapper.findAllByRoleIn(list2));
        return jsonObject;
    }


    /**
     * 工作台-查询今日生产任务
     * 根据状态查询 0 待开始 1进行中 2 已完成
     * @throws PassportException
     */
    public JSONObject findProductionTask(UserInfoForToken userInfoForToken)throws PassportException {
        JSONObject job = new JSONObject();
        Date d = new Date();
        job.put("toStart",iProductionMapper.findByStateOrGxId(0,ProductionStateChange.PSmelting, DateUtil.beginOfDay(d),DateUtil.endOfDay(d)));//待开始（熔炼-草稿）
        job.put("inProgress",iProductionMapper.findByStateOrGxId(1,ProductionStateChange.PSmelting, DateUtil.beginOfDay(d),DateUtil.endOfDay(d)));//进行中（同一批次的在进行中的数据）
        job.put("completed",iProductionMapper.findByStateOrGxId(2,null, DateUtil.beginOfDay(d),DateUtil.endOfDay(d)));//已完成（当天已经完成的）
        job.put("warning",iProductionMapper.findByStateOrGxId(0,ProductionStateChange.PSmelting, DateUtil.beginOfDay(d),DateUtil.endOfDay(d)));//预警信息

        return job;
    }


    /**
     * 待办事项-（待办事项（未读未完成）、进行事项（已读未完成）、完成事项（已完成））
     * @throws PassportException
     */
    public PageInfo findMattersByState(UserInfoForToken userInfoForToken, SelectModel selectModel)throws PassportException {
        PageInfo page=new PageInfo();
        if(StringUtils.isEmpty(selectModel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        Integer finishedNo = null;
        Integer readNo = null;

        switch (selectModel.getFindById())
        {
            case 1://待办事项（未读未完成）
                finishedNo = 0;
                readNo = 0;
                break;
            case 2://进行事项（已读未完成）
                finishedNo = 0;
                readNo = 1;
                break;
            case 3://完成事项（已完成）
                finishedNo = 1;
                readNo = 1;
                break;
        }

        List<Matters> list = iMesMapper.findAllMatters(selectModel.getFindName(),Integer.valueOf(userInfoForToken.getUserId()),finishedNo, readNo,(selectModel.getPageNum()-1)*selectModel.getPageSize(),selectModel.getPageSize());

        page.setList(list);
        page.setTotal(iMesMapper.countByAllMatters(selectModel.getFindName(),Integer.valueOf(userInfoForToken.getUserId()),finishedNo, readNo));
        page.setPageSize(selectModel.getPageSize());
        page.setPageNum(selectModel.getPageNum());
        return page;
    }
}
