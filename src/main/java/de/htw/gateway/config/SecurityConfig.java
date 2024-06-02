package de.htw.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.csrf.CsrfTokenRequestHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // https://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html#authorize-requests

        // auf /open kommt immer ein 401 unauthorized status code ... und der gateway server schmeißt ein IllegalStateException: Could not obtain the keys

        // die debug meldungen sagen auch dass das csrf nicht matcht ... vmtl muss das ausgeschaltet werden

        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/open").permitAll()
                        .requestMatchers("/user").hasRole("USER")
                        .requestMatchers("/admin").hasRole("ADMIN")
                );

        return http.build();
    }
}

