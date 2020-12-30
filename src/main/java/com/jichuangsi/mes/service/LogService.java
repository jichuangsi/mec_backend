package com.jichuangsi.mes.service;

import com.jichuangsi.mes.common.IPConfig;
import com.jichuangsi.mes.entity.SSystemlog;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.repository.LogRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

@Service
public class LogService  {

    @Resource
    private LogRepository logRepository;

    /**
     * 日志管理-新增日志
     * @param
     * @throws PassportException
     */
    public void addLog(Integer staffId,String operates, HttpServletRequest request,InputStream inputStream)throws PassportException {
        SSystemlog slog = new SSystemlog();
        slog.setDeleteNo(0);
        slog.setLoginState(1);
        slog.setOperaterIp(IPConfig.getIp(request));//操作IP
        slog.setOperates(operates);
        slog.setRequestMode(request.getMethod());//请求方式
        slog.setRequestParam(request.getParameterNames().toString());
        slog.setRequestTime("1000");
        slog.setRequestURL(request.getServletPath());
        slog.setStaffId(staffId);//员工ID
        logRepository.save(slog);
    }

}
