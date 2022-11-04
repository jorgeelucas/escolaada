package br.com.escolaada.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SegurancaConfig {

    @Bean
    public SecurityFilterChain configuracao(HttpSecurity http) throws Exception {
        return http
                // this is for H2 to work fine
                .headers(headers -> {
                    headers.frameOptions(frameOptionsConfig -> {
                        frameOptionsConfig.sameOrigin();
                    });
                })
                .csrf(csrf -> {
                    csrf.disable();
                    csrf.ignoringAntMatchers("/h2-console/**");
                })
                .authorizeRequests(auth -> {
                    auth.antMatchers("/h2-console/**").permitAll();
                    auth.anyRequest().authenticated();
                })
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(sessionManagerCustomizer ->
                        sessionManagerCustomizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();

    }

}
