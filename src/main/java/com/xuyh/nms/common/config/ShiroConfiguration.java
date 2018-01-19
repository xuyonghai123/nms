package com.xuyh.nms.common.config;

import com.xuyh.nms.common.shiro.AuthorizationFilter;
import com.xuyh.nms.common.shiro.MyShiroRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        logger.info("开始ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("authc",new AuthorizationFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/login/logout","anon");
        filterChainDefinitionMap.put("/login/login","anon");
        filterChainDefinitionMap.put("/user/info","anon");
        filterChainDefinitionMap.put("/**","authc");
        shiroFilterFactoryBean.setLoginUrl("/login/login");
        shiroFilterFactoryBean.setSuccessUrl("/user/info");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return  securityManager;
    }

    @Bean
    public MyShiroRealm myShiroRealm(){
        return new MyShiroRealm();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
