package com.jichuangsi.mes.service;

import com.alibaba.fastjson.JSONObject;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.UserInfoForToken;
import com.jichuangsi.mes.repository.MattersRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class HomeService {


    @Resource
    private MattersRepository mattersRepository;

    /**
     * 采购订单管理- 明细页面--联动下拉框：根据原材料Id查询规格明细下拉框
     * @param
     * @throws PassportException
     */
    public JSONObject findMyMatters(UserInfoForToken userInfoForToken)throws PassportException {
        JSONObject job = new JSONObject();

        job.put("myMatter",mattersRepository.findByStaffIdAndFinishedNo(Integer.valueOf(userInfoForToken.getUserId()),0) );//原材料下拉框

        return job;
    }
}
