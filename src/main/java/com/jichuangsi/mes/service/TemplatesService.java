package com.jichuangsi.mes.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.jichuangsi.mes.constant.ResultCode;
import com.jichuangsi.mes.entity.Templates;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.SelectModel;
import com.jichuangsi.mes.model.UpdateModel;
import com.jichuangsi.mes.model.fileTableVo;
import com.jichuangsi.mes.repository.SDictionarierRepository;
import com.jichuangsi.mes.repository.TemplatesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TemplatesService {
    @Resource
    private TemplatesRepository templatesRepository;
    @Resource
    private SDictionarierRepository sdRepository;

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
    public void addTemplate(Templates templates) throws PassportException{
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

        templates.setDeleteNo(templates.getDeleteNo() == 0 ? 1 :0);
        templatesRepository.save(templates);
    }

    public JSONArray test(){
        //创建要序列化的集合对象
        //List<Templates> list = new ArrayList<>();
        List<Templates>t=templatesRepository.findAllByClosed(0);
        String d=JSONArray.toJSONString(t);
        JSONArray js=JSONArray.parseArray(d);
        return js;
    }
}
