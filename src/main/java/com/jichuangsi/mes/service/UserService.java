package com.jichuangsi.mes.service;

import com.alibaba.fastjson.JSONObject;
import com.jichuangsi.mes.config.Md5Util;
import com.jichuangsi.mes.config.TreeBeanUtil;
import com.jichuangsi.mes.constant.ResultCode;
import com.jichuangsi.mes.entity.SRole;
import com.jichuangsi.mes.entity.SStaff;
import com.jichuangsi.mes.entity.SStaffRole;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.mapper.IMesMapper;
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
import java.util.*;
import java.util.stream.Collectors;

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
    @Resource
    private IMesMapper mesMapper;
    /**
     * 用户注册
     * @param usermodel
     * @throws PassportException
     */
    public void registBackUser(UserInfoModel usermodel)throws PassportException {
        if (StringUtils.isEmpty(usermodel.getStaffNum()) || StringUtils.isEmpty(usermodel.getStaffName())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        if (StringUtils.isEmpty(usermodel.getId()) && StringUtils.isEmpty(usermodel.getLoginPassword())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
//        if (userRepository.countByStaffNum(usermodel.getStaffNum())>0){
//            throw new PassportException(ResultCode.ACCOUNT_ISEXIST_MSG);
//        }

        Integer staffcount = userRepository.countByid()+1;
        String strnum = "YG000"+staffcount;

        SStaff setstaff = new SStaff();

        setstaff.setId(StringUtils.isEmpty(usermodel.getId()) ? null :usermodel.getId());

        setstaff.setDepartmentId(usermodel.getDepartmentId());
        setstaff.setStaffNum(StringUtils.isEmpty(usermodel.getId()) ? strnum : usermodel.getStaffNum());
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

        if(!StringUtils.isEmpty(usermodel.getLoginPassword())){
            setstaff.setLoginPassword(Md5Util.encodeByMd5(usermodel.getLoginPassword()));
        }
        userRepository.save(setstaff);//保存用户信息

        Integer staffid = setstaff.getId();
        //用户角色批量存进数据库
        String str = usermodel.getRoleId();
        String[] strArr = str.split("\\,");
        if(strArr.length != 0){
            for (int i = 0; i < strArr.length; i++) {
                Integer roleId = Integer.valueOf(strArr[i]);
                if(sstaffRoleRepository.findByStaffIdAndRoleId(staffid,roleId).size() == 0){
                    SStaffRole sr = new SStaffRole();
                    sr.setRoleId(roleId);
                    sr.setStaffId(staffid);
                    sstaffRoleRepository.save(sr);
                }
            }
        }
    }

    /**
     * 用户登录
     * @param model
     * @return
     * @throws PassportException
     */
    public JSONObject loginBackUser(BackUserLoginModel model,HttpServletRequest request,InputStream inputStream)throws PassportException{
        if (StringUtils.isEmpty(model.getAccount()) || StringUtils.isEmpty(model.getPwd())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        JSONObject jsonObject = new JSONObject();
        SStaff backUser=userRepository.findByStaffNumAndLoginPassword(model.getAccount(),Md5Util.encodeByMd5(model.getPwd()));
        if (backUser==null){
            throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);
        }

        String user=JSONObject.toJSONString(MappingEntityModelCoverter.CONVERTERFROMBACKUSERINFO(backUser));
        try {

            jsonObject.put("accessToken",backTokenService.createdToken(user));
            jsonObject.put("userId",backUser.getId());
            jsonObject.put("userName",backUser.getStaffName());
            return jsonObject;
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
    public void updateBackUserPwd(UserInfoForToken userInfoForToken, UpdatePwdModel model)throws PassportException {
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




}
