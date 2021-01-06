package com.jichuangsi.mes.service;

import com.alibaba.fastjson.JSONObject;
import com.jichuangsi.mes.config.Md5Util;
import com.jichuangsi.mes.constant.ResultCode;
import com.jichuangsi.mes.entity.SStaff;
import com.jichuangsi.mes.entity.SStaffRole;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.model.BackUserLoginModel;
import com.jichuangsi.mes.model.UpdatePwdModel;
import com.jichuangsi.mes.model.UserInfoForToken;
import com.jichuangsi.mes.model.UserInfoModel;
import com.jichuangsi.mes.repository.SStaffRoleRepository;
import com.jichuangsi.mes.repository.UserRepository;
import com.jichuangsi.mes.utill.MappingEntityModelCoverter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private SStaffRoleRepository sstaffRoleRepository;

    @Resource
    private BackTokenService backTokenService;
    @Resource
    private LogService logService;
    /**
     * 用户注册
     * @param usermodel
     * @throws PassportException
     */
    public void registBackUser(UserInfoModel usermodel)throws PassportException {
        if (StringUtils.isEmpty(usermodel.getStaffNum()) || StringUtils.isEmpty(usermodel.getLoginPassword())
                || StringUtils.isEmpty(usermodel.getStaffName())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
//        if (userRepository.countByStaffNum(usermodel.getStaffNum())>0){
//            throw new PassportException(ResultCode.ACCOUNT_ISEXIST_MSG);
//        }

        Integer staffcount = userRepository.countByid()+1;
        String strnum = "YG000"+staffcount;

        SStaff setstaff = new SStaff();
        setstaff.setDepartmentId(usermodel.getDepartmentId());
        setstaff.setStaffNum(strnum);
        setstaff.setStaffName(usermodel.getStaffName());
        setstaff.setStaffAge(usermodel.getStaffAge());
        setstaff.setPostId(usermodel.getPostId().toString());
        setstaff.setGender(usermodel.getGender());
        setstaff.setPhone(usermodel.getPhone());
        setstaff.seteMail(usermodel.geteMail());
        setstaff.setIdcard(usermodel.getIdcard());
        setstaff.setStaffAddress(usermodel.getStaffAddress());
        setstaff.setDepartmentId(usermodel.getDepartmentId());
        setstaff.setWorkshopId(usermodel.getWorkshopId());
        setstaff.setState(0);
        setstaff.setDeleteNo(0);
        setstaff.setLoginPassword(Md5Util.encodeByMd5(usermodel.getLoginPassword()));
        userRepository.save(setstaff);//保存用户信息

        Integer staffid = setstaff.getId();
        //用户角色批量存进数据库
        String str = usermodel.getRoleId();
        String[] strArr = str.split("\\,");
        if(strArr.length != 0){
            for (int i = 0; i < strArr.length; i++) {
                SStaffRole sr = new SStaffRole();
                sr.setRoleId(Integer.valueOf(strArr[i]) );
                sr.setStaffId(staffid);
                sstaffRoleRepository.save(sr);
            }
        }
    }

    /**
     * 用户登录
     * @param model
     * @return
     * @throws PassportException
     */
    public String loginBackUser(BackUserLoginModel model,HttpServletRequest request,InputStream inputStream)throws PassportException{
        if (StringUtils.isEmpty(model.getAccount()) || StringUtils.isEmpty(model.getPwd())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        SStaff backUser=userRepository.findByStaffNumAndLoginPassword(model.getAccount(),Md5Util.encodeByMd5(model.getPwd()));
        if (backUser==null){
            throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);
        }

        String user=JSONObject.toJSONString(MappingEntityModelCoverter.CONVERTERFROMBACKUSERINFO(backUser));
        try {

            logService.addLog(backUser.getId(),"登录",request,inputStream);//新增一条日志
            //记录用户信息
            HttpSession session = request.getSession();
            session.setAttribute("userId", backUser.getId());

            return backTokenService.createdToken(user);
        }catch (UnsupportedEncodingException e){
            throw new PassportException(e.getMessage());
        }
    }

    /**
     * 用户修改密码
     * @param userInfoForToken
     * @param model
     * @throws PassportException
     */
    public void updateBackUserPwd(UserInfoForToken userInfoForToken, UpdatePwdModel model,HttpServletRequest request)throws PassportException {
        if(StringUtils.isEmpty(model.getOldPwd()) ||StringUtils.isEmpty(model.getFirstPwd()) || StringUtils.isEmpty(model.getSecondPwd())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        if(!(model.getFirstPwd().equals(model.getSecondPwd()))){
            throw new PassportException(ResultCode.PWD_NOT_MSG);
        }

        //记录用户信息
        SStaff user=userRepository.findByid(Integer.valueOf(userInfoForToken.getUserId()));

        if(StringUtils.isEmpty(user)){
            throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);
        }

        if (!user.getLoginPassword().equals(Md5Util.encodeByMd5(model.getOldPwd()))){
            throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);
        }

        user.setLoginPassword(Md5Util.encodeByMd5(model.getSecondPwd()));
        user.setId(user.getId());
        userRepository.save(user);
    }

    /**
     * 获取角色可访问页面方法
     * @param userInfo
     * @return
     * @throws PassportException
     */
    public boolean getUrlMethodByRole(UserInfoForToken userInfo,String url)throws PassportException{
        if (userInfo.getRoleId().equalsIgnoreCase("123456")){
            return true;
        }
        List<SStaffRole> relations=sstaffRoleRepository.findByStaffId(Integer.valueOf(userInfo.getUserId()));
        List<Integer> roleIds=new ArrayList<>();
        relations.forEach(userRoleRelation -> {
            roleIds.add(userRoleRelation.getRoleId());
        });
        if (roleIds.size()==0){
            throw new PassportException(ResultCode.USER_NOROLE_MSG);
        }
//        List<UrlMapping> urlMappings= visaMapper.findMethodByRoleIn(roleIds);
        Map<String,String> urlList=null;
//        if (null!=urlMappings){
//            urlList=new HashMap<String,String>();
//            for (UrlMapping item:urlMappings) {
//                urlList.put(item.getId(),item.getRoleUrl());
//            }
//            //通用方法
//            urlList.put("获取用户信息","/backRoleConsole/getBackuserById");
//            urlList.put("查询角色","/backRoleConsole/getAllRole");
//            urlList.put("查询父节点","/backRoleConsole/getAllParentNode");
//            urlList.put("查询角色对应url列表","/backRoleConsole/getUrlByUserRole");
//        }
        if(null!=urlList && urlList.size()!=0){
            for (Map.Entry<String,String> entry: urlList.entrySet()) {
                if (url.equals(entry.getValue())|| url.startsWith(entry.getValue())){
                    return true;
                }
            }
        }
        return false;
    }


}
