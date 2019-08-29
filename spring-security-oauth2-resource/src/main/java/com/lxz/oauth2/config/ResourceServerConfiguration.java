package com.lxz.oauth2.config;

import com.sun.net.httpserver.HttpServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true,jsr250Enabled = true)  //全局方法拦截
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    //1.用户访问资源（带着access_token）
    //2.通过access_token 去连接认证服务器
    //3.通过认证服务去判断 有没有访问资源的权限

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyAuthority("SystemContent")
                .antMatchers("/view/**").hasAnyAuthority("SystemContentView");
    }
}
