package com.renan.forum_hub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renan.forum_hub.domain.usuario.Usuario;
import com.renan.forum_hub.dto.AuthenticationDTO;
import com.renan.forum_hub.infra.security.TokenJwtDTO;
import com.renan.forum_hub.infra.security.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var authenticationToken = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication =  manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generateToken((Usuario) authentication.getPrincipal());


        return ResponseEntity.ok(new TokenJwtDTO(tokenJWT));
    }
}
