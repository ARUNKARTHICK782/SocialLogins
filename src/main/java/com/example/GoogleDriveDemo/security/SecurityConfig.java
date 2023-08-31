package com.example.GoogleDriveDemo.security;

import com.example.GoogleDriveDemo.JwtAuthConverter;
import com.example.GoogleDriveDemo.KeycloakRoleConverter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig{

    JwtAuthConverter jwtAuthConverter;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }





    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
//        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());


        http
                .csrf((csrf)->csrf.disable())
                .authorizeHttpRequests((req)->{
                    req.anyRequest().authenticated();
                })
                .oauth2Login(Customizer.withDefaults());
//                .oauth2ResourceServer((server)->{
//                    server.jwt(Customizer.withDefaults()).jwt((jwt)->{
//                        jwt.jwtAuthenticationConverter(jwtAuthenticationConverter);
//                    });
//                }).sessionManagement((sessionManagement)->{
//                    sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                })
//                .oauth2Login((oauth2login)->{
//                    oauth2login.loginPage("/index.html");
//                });
        return http.build();
    }
}
