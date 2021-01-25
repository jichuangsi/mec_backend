//package com.jichuangsi.mes.Shiro;
//
//import com.jichuangsi.mes.entity.RolePower;
//import com.jichuangsi.mes.entity.SRole;
//import com.jichuangsi.mes.entity.SStaff;
//import com.jichuangsi.mes.entity.SStaffRole;
//import com.jichuangsi.mes.mapper.IMesMapper;
//import com.jichuangsi.mes.repository.SRoleRepository;
//import com.jichuangsi.mes.repository.SStaffRoleRepository;
//import com.jichuangsi.mes.repository.UserRepository;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class MyShiroRealm extends AuthorizingRealm {
//
//
//    @Resource
//    private UserRepository userRepository;
//    @Resource
//    private SRoleRepository sRoleRepository;
//    @Resource
//    private SStaffRoleRepository sStaffRoleRepository;
//    /**
//     *  执行授权访问控制逻辑
//     *
//     * @param principals
//     * @return
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
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
//    }
//
//    /**
//     *  执行认证逻辑
//     *
//     * @param token
//     * @return
//     * @throws AuthenticationException
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
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
//    }
//}
