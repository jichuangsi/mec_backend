package com.jichuangsi.mes.service;


import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.fastjson.JSONObject;
import com.jichuangsi.mes.entity.SDictionarier;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.mapper.IMesMapper;
import com.jichuangsi.mes.model.GXLossBiVo;
import com.jichuangsi.mes.model.SelectModel;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExportService {


    @Resource
    private IMesMapper mesMapper;


    /**
     * 基础设置管理-产品页面 --新增/编辑页面获取的下拉框
     * @param
     * @throws PassportException
     */
    public void export(HttpServletResponse response)throws PassportException {

//        // 通过工具类创建writer，默认创建xls格式
//        ExcelWriter writer = ExcelUtil.getWriter();
//
//        //自定义标题别名
//        writer.addHeaderAlias("name", "姓名");
//        writer.addHeaderAlias("age", "年龄");
//        writer.addHeaderAlias("birthDay", "生日");
//
//        // 合并单元格后的标题行，使用默认标题样式
//        writer.merge(2, "申请人员信息");
//
//        // 一次性写出内容，使用默认样式，强制输出标题
//        writer.write(list, true);
//
//        //out为OutputStream，需要写出到的目标流
//        //response为HttpServletResponse对象
//        response.setContentType("application/vnd.ms-excel;charset=utf-8");
//
//        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
//        String name = StringUtils.toUtf8String("申请学院");
//        response.setHeader("Content-Disposition","attachment;filename="+name+".xls");
//        ServletOutputStream out= null;
//        try {
//            out = response.getOutputStream();
//            writer.flush(out, true);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//        // 关闭writer，释放内存
//            writer.close();
//        }
//        //此处记得关闭输出Servlet流
//        IoUtil.close(out);
    }

}
