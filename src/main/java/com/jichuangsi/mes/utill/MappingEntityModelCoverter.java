package com.jichuangsi.mes.utill;

import com.jichuangsi.mes.entity.SStaff;
import com.jichuangsi.mes.entity.SSystemlog;
import com.jichuangsi.mes.model.SSystemlogModel;
import com.jichuangsi.mes.model.UserInfoForToken;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MappingEntityModelCoverter {

    public final static UserInfoForToken CONVERTERFROMBACKUSERINFO(SStaff userInfo) {
        UserInfoForToken userInfoForToken = new UserInfoForToken();
        userInfoForToken.setUserId(userInfo.getId().toString());
        userInfoForToken.setUserName(userInfo.getStaffName());
        userInfoForToken.setRoleId(userInfo.getId().toString());
        return userInfoForToken;
    }

    public static final List<SSystemlogModel> CONVERTERFROMSSYSTEMLOGTOSSYSTEMLOGMODEL(List<SSystemlog> sSystemlogs){
        List<SSystemlogModel> sSystemlogsModels=new ArrayList<>();
        for (SSystemlog sl: sSystemlogs) {
            SSystemlogModel model=new SSystemlogModel();
            model.setCreateTime(sl.getCreateTime());
            model.setDeleteNo(sl.getDeleteNo());
            model.setExceptionMessage(sl.getExceptionMessage());
            model.setExceptionName(sl.getExceptionName());
            model.setFailMessage(sl.getFailMessage());
            if(sl.getLoginState() !=null && sl.getLoginState()==1){
                model.setLoginStateName("成功");
            }else {
                model.setLoginStateName("失败");
            }
            model.setLoginState(sl.getLoginState());
            model.setId(sl.getId());
            model.setLogType(sl.getLogType());
            model.setOperaterIp(sl.getOperaterIp());
            model.setOperates(sl.getOperates());
            model.setOperModel(sl.getOperModel());
            model.setRequestMode(sl.getRequestMode());
            model.setRequestParam(sl.getRequestParam());
            model.setRequestTime(sl.getRequestTime());
            model.setRequestURL(sl.getRequestURL());
            model.setStaffId(sl.getStaffId());
            model.setUserName(sl.getUserName());
            model.setUserAgent(sl.getUserAgent());
            model.setDate(getDateToString(sl.getCreateTime()));
            model.setResultSet(sl.getResultSet());
            sSystemlogsModels.add(model);
        }
        return sSystemlogsModels;
    }

     /**
     * 时间戳转换成字符串13位
      * */
     public static String getDateToString(long time) {
         SimpleDateFormat sf = null;
         Date d = new Date(time);
         sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         return sf.format(d);
      }
}
