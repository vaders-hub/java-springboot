package com.tutorial.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
//        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/member/**").authenticated()
                .antMatchers("/list/**").hasAuthority("manager");

        http.csrf().disable();
        http.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess", true);
        http.exceptionHandling().accessDeniedPage("/accessDenied");
        http.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");
    }

    @Autowired
    public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
        String query1 = "select id id, concat('{noop}', password) password, true enabled from member where id=?";
        String query2 = "select id, role from member where id=?";

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(query1)
                .authoritiesByUsernameQuery(query2);
    }

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
//    }
}
