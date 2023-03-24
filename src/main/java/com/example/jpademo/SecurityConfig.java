package com.example.jpademo;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    private static final String[] PERMIT_URL_ARRAY = {
            /* swagger v2 */
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            /* swagger v3 */
            "/v3/api-docs/**",
            "/swagger-ui/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers("/user/**").hasRole("ADMIN")
                .requestMatchers("/code/**").hasRole("ADMIN")
                .requestMatchers("/code_detail/**").hasRole("ADMIN")
//                .requestMatchers("/lecture/**").permitAll()
                .requestMatchers("/lecture/**").hasRole("ADMIN")
                .requestMatchers(PERMIT_URL_ARRAY).permitAll()
//                .requestMatchers("/code_detail/**").hasRole("USER")
//                .requestMatchers("/code/**").hasRole("USER")
                //                .antMatchers("/code/**").hasRole("ADMIN")
//                .antMatchers("/user/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        ;
        http.formLogin().permitAll();
        http.logout().permitAll();

        return http.build();
    }



    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.ignoring().requestMatchers("/static/css/**","/static/img/**","/static/js/**");
    }
}
