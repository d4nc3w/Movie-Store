package com.example.moviestoreapplication.authentication;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> request
                .requestMatchers("/register/**", "/confirm").permitAll()
                .requestMatchers("/css/**", "/javascript/**", "/images/**").permitAll()
                .requestMatchers("/images/background.jpg", "/images/logo.png").permitAll()
                .requestMatchers("/adminPage/**").hasAnyRole("ADMIN")
                .requestMatchers("/deleteMovie").hasAnyRole("EMPLOYEE", "ADMIN")
                .requestMatchers("/addMovie").hasAnyRole("EMPLOYEE", "ADMIN")
                .requestMatchers("/editMovie").hasAnyRole("EMPLOYEE", "ADMIN")
                .requestMatchers("/buyMovie").hasAnyRole("CLIENT", "EMPLOYEE", "ADMIN")
                .requestMatchers("/movie").hasAnyRole( "GUEST", "CLIENT", "EMPLOYEE", "ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
                .requestMatchers(PathRequest.toH2Console()).permitAll()
                .anyRequest().authenticated());
        http.formLogin(login -> login.loginPage("/login").permitAll());
        http.logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout/**", HttpMethod.GET.name()))
                .logoutSuccessUrl("/"));
        http.csrf(csrf -> csrf.ignoringRequestMatchers(PathRequest.toH2Console()));
        http.headers(config -> config.frameOptions(options -> options.sameOrigin()));

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers("/images/background.jpg", "/images/logo.png");
    }
}
