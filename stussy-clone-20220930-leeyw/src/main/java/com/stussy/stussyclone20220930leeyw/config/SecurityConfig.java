package com.stussy.stussyclone20220930leeyw.config;


import com.stussy.stussyclone20220930leeyw.security.AuthFailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic().disable();
        http.authorizeRequests()
                .antMatchers("/account/mypage" , "/index")
                .authenticated()
//                .antMatchers("/admin/**")
//                .hasRole("ADMIN")
                .antMatchers("/admin/**" , "/api/admin/**")
                .hasRole("ADMIN")
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .usernameParameter("email")
                .loginPage("/account/login")            //login page Get 요청
                .loginProcessingUrl("/account/login")   //login service Post요청
                .failureHandler(new AuthFailureHandler())   //예외를 던질 클래스
                .defaultSuccessUrl("/index");
     }

}

//        .antMatchers("/admin/**")
//        .hasRole("ADMIN")
//        이 주소로 들어오려면 Role 인지 확인하고 뒤에 권환을 확인한다. 확인해서 ADMIN 인지 확인