package com.tutorial.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BoardUserDetailsService boardUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll();
//                .antMatchers("/member/**").authenticated()
//                .antMatchers("/list/**").hasAuthority("manager");

        http.csrf().disable();
        http.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess", true);
        http.exceptionHandling().accessDeniedPage("/accessDenied");
        http.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");

        http.userDetailsService(boardUserDetailsService);
    }

    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailsService).passwordEncoder(encoder());
//    }

}
