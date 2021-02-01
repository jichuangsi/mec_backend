package com.jichuangsi.mes.service;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.jichuangsi.mes.constant.ResultCode;
import com.jichuangsi.mes.constant.ResultSetting;
import com.jichuangsi.mes.entity.ELBLData;
import com.jichuangsi.mes.entity.TProstandard;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.SelectModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImportService {

    /**
     * 生产管理- 退火-导入操作
     * 1、上传excel文件
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public List<TProstandard> importFiletProstandards(InputStream is)throws PassportException,IOException {

        // 2.应用HUtool ExcelUtil获取ExcelReader指定输入流和sheet
        ExcelReader excelReader = ExcelUtil.getReader(is);
        // 可以加上表头验证
        // 3.读取第1行到最后一行数据
        List<List<Object>> read = excelReader.read(1, excelReader.getRowCount());
        List<TProstandard> tProstandardList = new ArrayList<>();
        for(int i = 0; i < read.size(); i++){
            TProstandard tProstandard = new TProstandard();
            //el数据
            tProstandard.setUmStart(new BigDecimal(read.get(i).get(0).toString()));
            tProstandard.setMilStart(new BigDecimal(read.get(i).get(0).toString()).divide(ResultSetting.RETURNCP_Um,8,BigDecimal.ROUND_DOWN));//通过获取umstart值计算得来
            tProstandard.setElStart(new BigDecimal(read.get(i).get(1).toString()));
            tProstandard.setElEnd(new BigDecimal(read.get(i).get(2).toString()));
            tProstandard.setBlStart(new BigDecimal(read.get(i).get(3).toString()));
            tProstandard.setBlEend(new BigDecimal(read.get(i).get(4).toString()));
            tProstandard.setCoarseStart(new BigDecimal(read.get(i).get(5).toString()));
            tProstandard.setCoarseEnd(new BigDecimal(read.get(i).get(6).toString()));
            tProstandard.setDiamStart(new BigDecimal(read.get(i).get(7).toString()));
            tProstandard.setDiamEnd(new BigDecimal(read.get(i).get(8).toString()));
            tProstandard.setSemiStart(new BigDecimal(read.get(i).get(9).toString()));
            tProstandard.setSemiEnd(new BigDecimal(read.get(i).get(10).toString()));
            tProstandard.setSuperfineStart(new BigDecimal(read.get(i).get(11).toString()));
            tProstandard.setSuperfineEnd(new BigDecimal(read.get(i).get(12).toString()));



            tProstandardList.add(tProstandard);
        }
        return  tProstandardList;
    }
}
