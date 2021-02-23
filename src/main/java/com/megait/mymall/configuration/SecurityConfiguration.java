package com.megait.mymall.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/common.css","/css/**", "/images/**", "/js/**", "**/*.ico")
                .permitAll()

                .mvcMatchers("/", "/login", "/signup", "/check-email", "/check-email-token")
                .permitAll()

                .mvcMatchers(HttpMethod.GET, "/item/*")
                .permitAll()

                .anyRequest().authenticated();


    }
}
