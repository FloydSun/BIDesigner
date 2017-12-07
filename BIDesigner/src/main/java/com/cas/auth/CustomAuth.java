package com.cas.auth;

import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.security.auth.login.FailedLoginException;
import java.security.GeneralSecurityException;
import java.util.List;

public class CustomAuth extends AbstractUsernamePasswordAuthenticationHandler {
  
    private JdbcTemplate jdbcTemplate;
          
    public JdbcTemplate getJdbcTemplate() {  
        return jdbcTemplate;  
    }  
  
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
        this.jdbcTemplate = jdbcTemplate;  
    }  
  
    @Override
    protected HandlerResult authenticateUsernamePasswordInternal(UsernamePasswordCredential credentials)
            throws GeneralSecurityException, PreventedException
    {

        final String username = credentials.getUsername();  
        final String password = credentials.getPassword();

        String sql = "select * from user where USER_ID=? and PASSWORD=?";

        List list=jdbcTemplate.queryForList(sql, new String[]{username,password});
        if(list != null && list.size() > 0){
            return createHandlerResult(credentials, this.principalFactory.createPrincipal(username), null);
        }
        throw new FailedLoginException();

    }
}