package com.tzm.springcloud.authserver.service;

import com.tzm.springcloud.authserver.dao.RoleMapper;
import com.tzm.springcloud.authserver.dao.UserMapper;
import com.tzm.springcloud.authserver.model.Role;
import com.tzm.springcloud.authserver.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service("customUserDetailService")
@Slf4j
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getByUsername(username);
        LOG.info("loadByUsername:{}", user.toString());

        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                user.getEnabled(),
                user.getAccountNonExpired(),
                user.getCredentialsNonExpired(),
                user.getAccountNonLocked(),
                this.obtainGrantedAuthorities(user));
    }

    private Set<GrantedAuthority> obtainGrantedAuthorities(User user) {
        Set<Role> roles = roleMapper.queryByUserId(user.getId());
        LOG.info("user:{},roles:{}", user.getUsername(), roles);
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getCode()))
                .collect(Collectors.toSet());
    }
}
