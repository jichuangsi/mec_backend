package com.jichuangsi.mes.utill;

import com.jichuangsi.mes.entity.SStaff;
import com.jichuangsi.mes.model.UserInfoForToken;

public class MappingEntityModelCoverter {

    public final static UserInfoForToken CONVERTERFROMBACKUSERINFO(SStaff userInfo) {
        UserInfoForToken userInfoForToken = new UserInfoForToken();
        userInfoForToken.setUserId(userInfo.getId().toString());
        userInfoForToken.setUserName(userInfo.getStaffName());
        userInfoForToken.setRoleId(userInfo.getId().toString());
        return userInfoForToken;
    }
}
