package com.qcm.platform.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.qcm.platform.repo.LoginDao;
 
 
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
 
    @Autowired
    protected LoginDao loginDao;
    
 
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
 
        String role = loginDao.getUserRole(username, password);
 
        if (role == null || role.isEmpty()) {
            throw new BadCredentialsException("Username not found.");
        }
 
//        if (!password.equals(user.getPassword())) {
//            throw new BadCredentialsException("Wrong password.");
//        }
 
        return new UsernamePasswordAuthenticationToken(username, password, Collections.singleton(new SimpleGrantedAuthority(role)));
    }
 
    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}