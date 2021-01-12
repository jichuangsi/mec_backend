package com.jichuangsi.mes.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class getDateConfig {


    /**
     * 根据年 月 获取对应的月份 天数
     * */
    public static int getDaysByYearMonth(String findDate) {
        String[] array=findDate.split("-");

        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, Integer.parseInt(array[0]));
        a.set(Calendar.MONTH, Integer.parseInt(array[1]) - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 根据年 月 获取对应的月份日期 list
     * */
    public static List<String> getDaysByYearMonthList() {
        Calendar c = Calendar.getInstance();
        Integer y=c.get(Calendar.YEAR);//年bai
        Integer M = c.get(Calendar.MONTH)+1;//月,注意这里要du加1,计算机第一个月从zhi0开始

        String dateNowStr = y+"-"+M;
        List<String> list = new ArrayList<>();
        Integer intcount = getDaysByYearMonth(dateNowStr);
        for (int i = 0; i < intcount; i++) {
            String str =String.format("%02d",(M))+"-"+String.format("%02d",(i+1));
            list.add(str);
        }
        return list;
    }

    /**
     * 根据年 月 获取对应的日期 list
     * */
    public static List<Integer> getDayListsByYearMonth(String findDate) {
        List<Integer> list = new ArrayList<>();
        Integer intcount = getDaysByYearMonth(findDate);
        for (int i = 0; i < intcount; i++) {
            list.add((i+1));
        }
        return list;
    }
}
