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
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SegurancaConfig {

    @Bean
    public InMemoryUserDetailsManager configuracaoDeUsuario() {
        UserDetails jorge = User.withDefaultPasswordEncoder()
                .username("jorge")
                .password("123")
                .roles("ADMIN") //mandatory
                .build();
        return new InMemoryUserDetailsManager(jorge);
    }

    @Bean
    public SecurityFilterChain configuracao(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(auth -> {
                    auth.anyRequest().authenticated();
                })
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(sessionManagerCustomizer ->
                        sessionManagerCustomizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();

    }

}
