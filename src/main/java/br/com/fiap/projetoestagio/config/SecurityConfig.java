package br.com.fiap.projetoestagio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

     @Autowired
     AuthorizationFilter authorizationFilter;

    //  @Autowired
    //  Enviroment env;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

         return http
                 .authorizeHttpRequests()
                 .requestMatchers(HttpMethod.POST, "/api/entrar").permitAll()
                 .requestMatchers(HttpMethod.POST, "/api/login").permitAll()
                 .anyRequest().authenticated()
                 .and()
                 .csrf(csrf -> csrf.disable())
                 .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                 .formLogin(login -> login.disable())
                 .addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class)
                 .build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {

            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString() + "@";
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(encode(rawPassword));
            }
        };
    }
}
