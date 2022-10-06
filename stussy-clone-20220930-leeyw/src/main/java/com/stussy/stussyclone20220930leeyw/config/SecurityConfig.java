package com.stussy.stussyclone20220930leeyw.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic().disable();
        http.authorizeRequests()
                .antMatchers("/account/mypage" , "/index")
                .authenticated()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/account/login")
                .defaultSuccessUrl("/index");
     }

}
//
//
//        http.csrf().disable();
//                http.httpBasic().disable();                   //
//                http.authorizeRequests()                      //
//                .antMatchers("/account/mypage" , "/index")    //경로
//                .authenticated()                              //인증을 해라
//                .anyRequest()                                 //
//                .permitAll()                                  //
//                .and()                                        //그리고
//                .formLogin()                                  //formLogin에 대한 설정을 할것이다.
//                .loginPage("/account/login")                  //
//                .defaultSuccessUrl("/index");                 //

