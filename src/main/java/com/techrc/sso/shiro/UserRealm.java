package com.techrc.sso.shiro;

import com.techrc.sso.model.User;
import com.techrc.sso.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class UserRealm extends AuthorizingRealm {

    public UserRealm(){
        System.out.println("=============myRealm===========");

    }

    @Resource
    private UserService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User userInfo = (User) principals.getPrimaryPrincipal();
       /* for (SysRole role : userInfo.getRoleList()) {
            authorizationInfo.addRole(role.getRole());
            for (SysPermission p : role.getPermissions()) {
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }*/
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("==============MyShiroRealm.doGetAuthenticationInfo()============");
        //获取用户的输入的账号.
        String username = (String) token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User userInfo = userInfoService.findByUsername(username);
        System.out.println("-------------->>userInfo="+userInfo.getRealName());
        System.out.println("-------------->>userInfo="+userInfo.getPassword());
        ByteSource.Util.bytes(username+ "" +userInfo.getCredentialsSalt());
        if (userInfo == null) {
            return null;
        }
        /*if (userInfo.getState() == 1) { //账户冻结
            throw new LockedAccountException();
        }*/
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //注册时加密的密码
                ByteSource.Util.bytes(username+ "" +userInfo.getCredentialsSalt()),// salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

}
