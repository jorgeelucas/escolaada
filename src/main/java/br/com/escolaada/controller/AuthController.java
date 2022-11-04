package br.com.escolaada.controller;

import br.com.escolaada.dto.LoginDTO;
import br.com.escolaada.dto.TokenDTO;
import br.com.escolaada.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final TokenService tokenService;
    private final AuthenticationManager authManager;

    public AuthController(TokenService tokenService, AuthenticationManager authManager) {
        this.tokenService = tokenService;
        this.authManager = authManager;
    }

    @PostMapping("/greetings")
    public String grettings(Principal principal) {
        return "Olá, " + principal.getName();
    }


    @PostMapping("/token")
    public TokenDTO getToken(@RequestBody LoginDTO loginDTO) {
        log.info("{} solicitou um token", loginDTO.usuario());
        final var authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.usuario(),
                        loginDTO.senha(),
                        new ArrayList<>()));
        final var token = tokenService.gerarToken(authentication);
        TokenDTO tokenDTO = new TokenDTO(token);
        log.info("Token gerado: {}", token);
        return tokenDTO;
    }
}
