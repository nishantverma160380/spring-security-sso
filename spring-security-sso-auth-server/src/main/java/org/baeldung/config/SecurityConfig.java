package org.baeldung.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ErrorAttributes errorAttributes;

    @Bean
    public AppErrorController appErrorController(){return new AppErrorController(errorAttributes);}
    
    @Override
    protected void configure(HttpSecurity http) throws Exception { // @formatter:off
        http.requestMatchers()
            .antMatchers("/login", "/oauth/authorize")
            .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .permitAll();
    } // @formatter:on

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // @formatter:off
        auth.parentAuthenticationManager(authenticationManager)
            .inMemoryAuthentication()
            .withUser("john")
            .password("123")
            .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN");

    } // @formatter:on

}
