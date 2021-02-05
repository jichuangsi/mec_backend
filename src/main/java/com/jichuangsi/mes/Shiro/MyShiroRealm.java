package com.jichuangsi.mes.Shiro;

import com.jichuangsi.mes.entity.RolePower;
import com.jichuangsi.mes.entity.SRole;
import com.jichuangsi.mes.entity.SStaff;
import com.jichuangsi.mes.entity.SStaffRole;
import com.jichuangsi.mes.mapper.IMesMapper;
import com.jichuangsi.mes.repository.SRoleRepository;
import com.jichuangsi.mes.repository.SStaffRoleRepository;
import com.jichuangsi.mes.repository.UserRepository;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.security.Permissions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


public class MyShiroRealm extends AuthorizingRealm {


    @Resource
    private UserRepository userRepository;
    @Resource
    private SRoleRepository sRoleRepository;
    @Resource
    private SStaffRoleRepository sStaffRoleRepository;
    @Resource
    private IMesMapper iMesMapper;
    private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);
    /**
     *  执行授权访问控制逻辑
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("====执行授权访问控制逻辑=====");
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Subject subject=SecurityUtils.getSubject();
        SStaff user=(SStaff) subject.getPrincipal();

//        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
//
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        List<String> roleList=new ArrayList<>();
//        // 获取用户名
//        SStaff stafff = (SStaff) principals.getPrimaryPrincipal();
//        String username = stafff.getStaffName();
//
//        List<SStaffRole> list = sStaffRoleRepository.findByStaffId(stafff.getId());
//        for(SStaffRole role:list){
//
//            SRole sRole = sRoleRepository.findByid(role.getRoleId());
//
//            roleList.add(sRole.getRoleName());
//        }
//
//        // 给该用户设置角色，角色信息存在 t_role 表中取
//        authorizationInfo.addRoles(roleList);
//        // 给该用户设置权限，权限信息存在 t_permission 表中取
//        authorizationInfo.addStringPermissions(roleList);
//        return authorizationInfo;


        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        List<SStaffRole> list = sStaffRoleRepository.findByStaffId(user.getId());

        List<String> listAll = new ArrayList<String>(new HashSet<String>(iMesMapper.findRolePowerIdsByStaffId(user.getId())));

        for (SStaffRole role : list) {
            SRole sRole = sRoleRepository.findByid(role.getRoleId());

            //添加角色
            simpleAuthorizationInfo.addRole(sRole.getRoleName());
            simpleAuthorizationInfo.addStringPermissions(listAll);
            //添加权限
//            for (Permissions permissions : role.getPermissions()) {
//                simpleAuthorizationInfo.addStringPermission(permissions.getPermissionsName());
//            }
        }
        return simpleAuthorizationInfo;
    }

    /**
     *  执行认证逻辑
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("====执行认证逻辑=====");
        if (StringUtils.isEmpty(token.getPrincipal())) {
            return null;
        }
        //获取用户信息
        String name = token.getPrincipal().toString();
        SStaff user = userRepository.findByStaffNum(name);
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getLoginPassword(), this.getName());
            return simpleAuthenticationInfo;
        }
//
//        // 根据 Token 获取用户名，如果您不知道该 Token 怎么来的，先可以不管，下文会解释
//        String username = (String) token.getPrincipal();
//        // 根据用户名从数据库中查询该用户
//        SStaff user = userRepository.findByStaffNum(username);
//        if(user != null) {
//            // 把当前用户存到 Session 中
//            SecurityUtils.getSubject().getSession().setAttribute("user", user);
//            // 传入用户名和密码进行身份认证，并返回认证信息
//            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getStaffName(), user.getLoginPassword(), "myRealm");
//            return authcInfo;
//        } else {
//            return null;
//        }
    }
}
