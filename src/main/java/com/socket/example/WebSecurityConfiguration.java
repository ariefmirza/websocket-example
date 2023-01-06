// © 2022 Rakuten Symphony. All rights reserved.
package com.socket.example;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/","/notification.html","/bots.html","/upload.html");
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .authorizeHttpRequests()
//                .mvcMatchers("/","/notification.html","/bots.html","upload.html")
//                .permitAll()
//                .and()
//                .authorizeHttpRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .logout(logout -> logout.logoutSuccessUrl("/"));
//        return httpSecurity.build();
//    }
}
