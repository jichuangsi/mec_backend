package com.jichuangsi.mes.service;

import com.github.pagehelper.PageInfo;
import com.jichuangsi.mes.common.IPConfig;
import com.jichuangsi.mes.entity.SSystemlog;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.SelectModel;
import com.jichuangsi.mes.repository.LogRepository;
import com.jichuangsi.mes.utill.MappingEntityModelCoverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;

@Service
public class LogService  {

    @Resource
    private LogRepository logRepository;

    public void addLog2(SSystemlog sSystemlog)throws PassportException {
        logRepository.save(sSystemlog);
    }

    /**
     * 系统日志-条件分页查询
     * @param model
     * @return
     */
    public PageInfo getOperLogeByPage(SelectModel model){
        PageInfo page=new PageInfo();
        List<SSystemlog> logs=logRepository.getAllByLogTypeAndPage(model.getFindById(),model.getFindName(),model.getFindIdOne(),(model.getPageNum()-1)*model.getPageSize(),model.getPageSize());
        page.setList(MappingEntityModelCoverter.CONVERTERFROMSSYSTEMLOGTOSSYSTEMLOGMODEL(logs));
        page.setTotal(logRepository.countAllByLogType(model.getFindById(),model.getFindName(),model.getFindIdOne()));
        page.setPageSize(model.getPageSize());
        page.setPageNum(model.getPageNum());
        return page;
    }
}
