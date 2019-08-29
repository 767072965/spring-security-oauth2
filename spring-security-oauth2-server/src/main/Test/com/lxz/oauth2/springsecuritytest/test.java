package com.lxz.oauth2.springsecuritytest;


import com.lxz.oauth2.OAuth2ServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.soap.Addressing;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("com.lxz")
public class test {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void test(){
        String secret = bCryptPasswordEncoder.encode("secret");

        System.out.println("secret:"+secret);
    }
}
