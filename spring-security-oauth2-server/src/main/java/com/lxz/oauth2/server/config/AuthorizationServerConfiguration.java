package com.lxz.oauth2.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    //配置数据源
    @Bean
    @Primary    //覆盖默认的配置
    @ConfigurationProperties(prefix = "spring.datasource") //指定配置的谁
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

   @Autowired
   public BCryptPasswordEncoder bCryptPasswordEncoder;

    //配置客户端  客户端信息  认证客户端   分配_授权码
    //步骤：1.客户端那这 client 和 secret 去访问认证服务器
    //     2.认证服务器（授权码模式）
    //     3.redirectUris 返回授权码
   @Override
   public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
       //内存模式：
       //clients.inMemory()
       //        .withClient("client")        //客户端ID
       //        .secret(bCryptPasswordEncoder.encode("secret"))                    //密码
       //        .authorizedGrantTypes("authorization_code")  //模式 ：授权码模式
       //        .scopes("app")           //授权范围
       //        .redirectUris("http://www.funtl.com");       //回调地址 授权吗

        clients.withClientDetails(jdbcClientDetatails());
   }

    //配置Token
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore());
    }

    //Token走数据库
   @Bean
   public TokenStore tokenStore(){
       return new JdbcTokenStore(dataSource());
   }

   //Client
   @Bean
   public ClientDetailsService jdbcClientDetatails(){
       return new JdbcClientDetailsService(dataSource());
   }






}





































