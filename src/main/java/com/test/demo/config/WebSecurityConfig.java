package com.test.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    protected void configure (HttpSecurity http) throws Exception{
        http
            .authorizeRequests()
            			.antMatchers("/**").permitAll();
//                    .antMatchers("/", "/index", "/home", "/login", "/css/style.css", "/images/**", "/shoppingCart").permitAll()
//                    .anyRequest().authenticated()
//                    .and()
//            .formLogin()
//                    .loginPage("/login")
//                    .defaultSuccessUrl("/")
//                    .permitAll()
//                    .and()
//            .logout()
//                    .permitAll();
    }

}