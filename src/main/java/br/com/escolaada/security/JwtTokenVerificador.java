package br.com.escolaada.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JwtTokenVerificador extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";

    private static final String SECRET_KEY = "secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_secretkey_";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {


        String authHeader = request.getHeader(AUTHORIZATION_HEADER);

        // Bearer <token>

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        try {

            String token = authHeader.replace("Bearer ", "");

            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                    .build()
                    .parseClaimsJws(token);

            //chegou aqui o token é valido

            Claims body = claims.getBody();

            String nomeUsuario = body.getSubject();

            Authentication auth =
                    new UsernamePasswordAuthenticationToken(nomeUsuario, null, new ArrayList<>());

            SecurityContextHolder.getContext().setAuthentication(auth);

        } catch (JwtException e) {
            throw new IllegalStateException(e);
        }

        filterChain.doFilter(request, response);
    }
}
