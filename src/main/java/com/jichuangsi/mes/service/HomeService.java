package com.jichuangsi.mes.service;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.jichuangsi.mes.common.ProductionStateChange;
import com.jichuangsi.mes.constant.ResultCode;
import com.jichuangsi.mes.entity.Matters;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.mapper.IMesMapper;
import com.jichuangsi.mes.mapper.IProductionMapper;
import com.jichuangsi.mes.model.MapVo;
import com.jichuangsi.mes.model.SelectModel;
import com.jichuangsi.mes.model.UserInfoForToken;
import com.jichuangsi.mes.repository.MattersRepository;
import com.jichuangsi.mes.repository.SNoticeRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
    private IMesMapper iMesMapper;

    /**
     * 首页-查询数据
     * @param
     * @throws PassportException
     */
    public JSONObject findMyMatters(UserInfoForToken userInfoForToken)throws PassportException {
        JSONObject job = new JSONObject();

        job.put("production",0);//生产（成品轴数）
        job.put("productionOrderMatter",0);//生产订单量（生产计划单数量）
        job.put("purchaseAmount",0);//采购金额（采购支出的金额）
        job.put("salesAmount",0);//销售金额（销售收入的金额）
        job.put("myMatter",iMesMapper.findAllMatters(null,Integer.valueOf(userInfoForToken.getUserId()),0, null));//待办事项
        job.put("noticeList",sNoticeRepository.findByIsshowAndDeleteNoOrderByCreateTimeDesc(1,0));//系统公告

        return job;
    }

    /**
     * 工作台-查询今日生产任务
     * @param 根据状态查询 0 待开始 1进行中 2 已完成
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
    public List<Matters> findMattersByState(UserInfoForToken userInfoForToken, SelectModel selectModel)throws PassportException {

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

        List<Matters> list = iMesMapper.findAllMatters(selectModel.getFindName(),Integer.valueOf(userInfoForToken.getUserId()),finishedNo, readNo);

        return list;
    }
}
