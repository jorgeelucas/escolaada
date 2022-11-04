package br.com.escolaada.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.MINUTES;

@Service
public class TokenService {

    private final JwtEncoder encoder;

    public TokenService(JwtEncoder encoder) {
        this.encoder = encoder;
    }

    public String gerarToken(Authentication authentication) {
        Instant now = Instant.now();

        String escopo = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(5, MINUTES))
                .subject(authentication.getName())
                .claim("escopo", escopo)
                .build();

        return encoder.encode(JwtEncoderParameters.from(jwtClaimsSet))
                .getTokenValue();

    }

}
