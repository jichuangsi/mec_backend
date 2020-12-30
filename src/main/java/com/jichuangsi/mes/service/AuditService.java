package com.jichuangsi.mes.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.jichuangsi.mes.constant.ResultCode;
import com.jichuangsi.mes.entity.AuditSetting;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.mapper.IMesMapper;
import com.jichuangsi.mes.model.AuditModel;
import com.jichuangsi.mes.model.SelectModel;
import com.jichuangsi.mes.repository.AuditSettingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuditService {

    @Resource
    private IMesMapper mesMapper;
    @Resource
    private AuditSettingRepository auditSettingRepository;


    /**
     * 审核管理- 新增/编辑页面获取下拉框数据
     * @param
     * @throws PassportException
     */
    public JSONObject getAuditBasicInfo()throws PassportException {
        JSONObject job = new JSONObject();

        job.put("auditXiaLa",mesMapper.findStaffAllXiaLa());//原材料下拉框

        return job;
    }

    /**
     * 审核管理- 新增/编辑
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void saveAudit(AuditSetting auditSetting)throws PassportException {
        if(StringUtils.isEmpty(auditSetting.getAuditLevel()) || StringUtils.isEmpty(auditSetting.getLevelName())|| StringUtils.isEmpty(auditSetting.getStaffId())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        if(auditSettingRepository.countByAuditLevelAndAuditType(auditSetting.getAuditLevel(),auditSetting.getAuditType()) >0){//防止数据重复
            throw new PassportException(ResultCode.DICTIONARY_ISEXIST_MSG);
        }

        auditSetting.setDeleteNo(0);

       auditSettingRepository.save(auditSetting);
    }


    /**
     * 审核管理- 查询
     * @param
     * @throws PassportException
     */
    public PageInfo findAllAudit(SelectModel smodel)throws PassportException {
        int total=0;
        PageInfo page=new PageInfo();

        if(StringUtils.isEmpty(smodel.getFindModelName())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        List<AuditModel> listauditSetting = mesMapper.findAllAuditSetting(smodel.getFindModelName(),(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize() );

        page.setTotal(mesMapper.countByAuditSetting(smodel.getFindModelName()));
        page.setList(listauditSetting);
        page.setPageSize(smodel.getPageSize());
        page.setPageNum(smodel.getPageNum());
        return page;
    }

    /**
     * 审核管理- 根据Id查询
     * @param
     * @throws PassportException
     */
    public AuditModel findAllAuditById(SelectModel smodel)throws PassportException {

        if(StringUtils.isEmpty(smodel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        AuditModel listauditSetting = mesMapper.findAllAuditSettingById(smodel.getFindById());


        return listauditSetting;
    }

}
