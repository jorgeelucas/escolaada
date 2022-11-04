package br.com.escolaada.config;

import br.com.escolaada.security.JwtTokenVerificador;
import br.com.escolaada.security.JwtUsernameAndPasswordAutenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SegurancaConfig {

    private final AuthenticationManager autenticador;

    public SegurancaConfig(AuthenticationManager autenticador) {
        this.autenticador = autenticador;
    }

    @Bean
    public SecurityFilterChain configuracao(HttpSecurity http) throws Exception {
        return http
                // this is for H2 to work fine
                .headers(headers -> {
                    headers.frameOptions(frameOptionsConfig -> {
                        frameOptionsConfig.sameOrigin();
                    });
                })
                .addFilter(new JwtUsernameAndPasswordAutenticationFilter(autenticador))
                .addFilterAfter(new JwtTokenVerificador(), JwtUsernameAndPasswordAutenticationFilter.class)
                .csrf(csrf -> {
                    csrf.disable();
                    csrf.ignoringAntMatchers("/h2-console/**");
                })
                .authorizeRequests(auth -> {
                    auth.antMatchers("/h2-console/**").permitAll();
                    auth.anyRequest().authenticated();
                })
                .sessionManagement(sessionManagerCustomizer ->
                        sessionManagerCustomizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();

    }

}
