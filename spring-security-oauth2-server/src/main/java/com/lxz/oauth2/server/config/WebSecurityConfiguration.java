package com.lxz.oauth2.server.config;

import com.lxz.oauth2.server.config.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true,jsr250Enabled = true)  //全局方法拦截
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean()  {
        return new UserDetailsServiceImpl();
    }

    //加密方式
    @Bean
    public BCryptPasswordEncoder passwordEncode(){
        return  new BCryptPasswordEncoder();
    }
    //认证用户 _账号/密码
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //PasswordEncoderFactories
        //内存模式：
        //auth.inMemoryAuthentication()
        //        .withUser("admin").password(passwordEncode().encode("123456")).roles("ADMIN")
        //        .and()
        //        .withUser("user").password(passwordEncode().encode("123456")).roles("USER");

        //jdbc:
        auth.userDetailsService(userDetailsServiceBean());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略checkToken 地址
        web.ignoring().antMatchers("/oauth/check_token");
    }
}











































