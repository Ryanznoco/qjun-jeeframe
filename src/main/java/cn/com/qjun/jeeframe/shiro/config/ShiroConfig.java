package cn.com.qjun.jeeframe.shiro.config;

import cn.com.qjun.jeeframe.shiro.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author RenQiang
 * @date 2018/3/10
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);

        Map<String, Filter> filters = filterFactoryBean.getFilters();

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/login", "authc");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/validateCode.jpg", "anon");
        filterChainDefinitionMap.put("/**", "user");
        filterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        //登录页面地址
        filterFactoryBean.setLoginUrl("/login");
        //登录成功跳转地址
        filterFactoryBean.setSuccessUrl("/index");
        //认证失败时跳转的地址
        filterFactoryBean.setUnauthorizedUrl("/403");
        return filterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(Realm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean
    public Realm userRealm(HashedCredentialsMatcher matcher) {
        UserRealm realm = new UserRealm();
        realm.setCredentialsMatcher(matcher);
        return realm;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("MD5");
        return matcher;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
