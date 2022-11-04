package br.com.escolaada.security;

import br.com.escolaada.dto.LoginDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class JwtUsernameAndPasswordAutenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager autenticador;

    private static final String SECRET_KEY = "secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_";

    public JwtUsernameAndPasswordAutenticationFilter(AuthenticationManager autenticador) {
        this.autenticador = autenticador;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        // http://localhost:8080/login
        // { usuario: maria, senha: 123}

        //request.getInputStream()

        try {

            LoginDTO credenciais = new ObjectMapper()
                    .readValue(request.getInputStream(), LoginDTO.class);

            Authentication credsAuth = new UsernamePasswordAuthenticationToken(
                            credenciais.usuario(),
                            credenciais.senha());

            return autenticador.authenticate(credsAuth);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        // criar o token

        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("nomeUsuario", authResult.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 600_000)) // 10 * 60 * 1000 = 10 min
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                .compact();

        String bearerToken = "Bearer " + token;

        response.addHeader("Authorization", bearerToken);
    }
}
