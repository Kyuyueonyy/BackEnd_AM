package org.scoula.security.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 문자셋필터
    // post방식의 전달시 body에 들어있는 값 한글 인코딩 필터
    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(encodingFilter(), CsrfFilter.class);

        // 경로별 접근권한설정
        // form-login 기본 설정은 비활성화 되어서 사라짐
        // 권한이 없으면 403ERROR 발생
        // --> 이 에러 화면 보다는 로그인하는 페이지를 보여주는 것이 더 나음
        http.authorizeRequests()
                .antMatchers("/security/all").permitAll()
                .antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/security/member").access("hasRole('ROLE_MEMBER')");

        //http.formLogin(); // form-login 화면 다시 활성화, 나머지는 모두 디폴트
        //403에러가 발생했을 때 form-login 화면으로 다시 redirect!

        http.formLogin()
                .loginPage("/security/login")
                .loginProcessingUrl("/security/login")
                .defaultSuccessUrl("/");

        http.logout()                // 로그아웃설정시작
                .logoutUrl("/security/logout") // 로그아웃호출url
                .invalidateHttpSession(true)                 // 세션 invalidate
                .deleteCookies("remember-me", "JSESSION-ID") // 삭제할 쿠키 목록
                .logoutSuccessUrl("/");         // 로그아웃이후이동할페이지

    }
    //위 작업을 하면 처음에 떴던 login redirect가 사라짐

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        log.info("configure .........................................");
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}1234") //pw 암호화하지 않겠다는 의미
                .roles("ADMIN","MEMBER"); // ROLE_ADMIN 권한만 부여
        auth.inMemoryAuthentication()
                .withUser("member")
                .password("{noop}1234")
                .roles("MEMBER"); // ROLE_MEMBER 권한만 부여
    }


}