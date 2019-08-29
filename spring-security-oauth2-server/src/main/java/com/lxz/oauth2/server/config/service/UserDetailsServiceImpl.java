package com.lxz.oauth2.server.config.service;

import com.lxz.oauth2.entity.TbPermission;
import com.lxz.oauth2.entity.TbUser;
import com.lxz.oauth2.service.TbPermissionService;
import com.lxz.oauth2.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private TbPermissionService tbPermissionService;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        TbUser user = tbUserService.getUserByUsername(s);

        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        if (user!=null){
            List<TbPermission> permissions = tbPermissionService.getPermissionByUserId(user.getId());

            permissions.forEach(tbPermission -> {
                GrantedAuthority grantedAuthority=new SimpleGrantedAuthority(tbPermission.getEnname());

                grantedAuthorities.add(grantedAuthority);
            });
        }
        return new User(user.getUsername(),user.getPassword(),grantedAuthorities);
    }
}






















