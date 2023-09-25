package br.com.fiap.projetoestagio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class SecurityConfig {

    @Autowired
    AuthorizationFilter authorizationFilter;

    @Autowired
    Environment env;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/api/usuarios/login").permitAll()
                // .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                // .addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class)
                // .build();
                .addFilterBefore(authorizationFilter,  UsernamePasswordAuthenticationFilter.class);

                if (env.getActiveProfiles().length > 0 && env.getActiveProfiles()[0].equals("open")){
                    http.authorizeHttpRequests().anyRequest().permitAll();
                } else {
                    http.authorizeHttpRequests().anyRequest().authenticated();
                }

                return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
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
