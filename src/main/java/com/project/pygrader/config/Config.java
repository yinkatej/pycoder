package com.project.pygrader.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Config {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((authorize)-> authorize
                        .requestMatchers("/", "/program", "/resource/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/admin/")
                        .failureForwardUrl("/admin?error")
                        .successForwardUrl("/admin/dashboard")
                        .permitAll()

                ).logout(logout -> logout.logoutSuccessUrl("/admin/?logout"));

        return http.build();
    }

    @Bean
    public UserDetailsService user(){
        User.UserBuilder user = User.withDefaultPasswordEncoder();
        UserDetails users = user.username("admin")
                .password("password")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(users);
    }

}
