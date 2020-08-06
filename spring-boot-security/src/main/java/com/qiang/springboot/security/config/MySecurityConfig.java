package com.qiang.springboot.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制申请的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        http.formLogin().usernameParameter("user").passwordParameter("pwd").loginPage("/userlogin");//
        http.logout().logoutSuccessUrl("/");//注销功能
        http.rememberMe().rememberMeParameter("remember");//记住我
    }


    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("123").password(new BCryptPasswordEncoder().encode("123")).roles("VIP1")
                .and()
                .withUser("456").password(new BCryptPasswordEncoder().encode("456")).roles("VIP1","VIP2")
                .and()
                .withUser("789").password(new BCryptPasswordEncoder().encode("789")).roles("VIP1","VIP2","VIP3");

    }
}
