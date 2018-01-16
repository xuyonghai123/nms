package com.xuyh.nms.common.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyShiroRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("22222222222222222222222222222222222222222");
        logger.info("MyShiroRealm:"+authenticationToken);
        String userName = (String) authenticationToken.getPrincipal();
        logger.info("userInfo:",userName);

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("admin","111111",getName());
        SecurityUtils.getSubject().getSession().setAttribute("JSESSIONID","22B983D91CBDF95DD71FD4AAE9BCAA5B");
        return authenticationInfo;
    }
}
