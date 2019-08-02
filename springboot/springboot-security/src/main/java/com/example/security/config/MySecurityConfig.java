package com.example.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @authur wtj
 * @date 2019/8/2    14:10
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    //定义请求的授权规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //        super.configure(web);

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("Vip1")
                .antMatchers("/level2/**").hasRole("Vip2")
                .antMatchers("/level3/**").hasRole("Vip3");

        //开启自动配置的登录功能，如果没有权限就会到登录页面
        //1、/login来到登录页
        //2、重定向到/login?error表示失败
        //3、更多详细规定
        http.formLogin();


        //开启自动配置的注销功能
        //1、访问/logout表示注销，清空session
        //2、默认注销成功会返回/logout?logout 页面
//        http.logout();
        http.logout().logoutUrl("/");//修改注销成功后跳转的页面为首页

    }

    //ctrl + o
    //定义请求的认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication().withUser("zhangsan").password("123456")
                .roles("Vip1","Vip2")
                .and()
                .withUser("lisi").password("123456")
                .roles("Vip2","Vip3")
                .and()
                .withUser("wangwu").password("123456")
                .roles("Vip1","Vip3");
    }



}
