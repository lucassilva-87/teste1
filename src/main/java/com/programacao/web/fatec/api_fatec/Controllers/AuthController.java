package com.programacao.web.fatec.api_fatec.Controllers;


import com.programacao.web.fatec.api_fatec.dtos.AuthRequest;
import com.programacao.web.fatec.api_fatec.security.JwtUtil;
import com.programacao.web.fatec.api_fatec.security.UsuarioDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioDetailsService usuarioDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> autenticar(@RequestBody AuthRequest authRequest) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        UserDetails userDetails = usuarioDetailsService.loadUserByUsername(authRequest.getUsername());
        String token = jwtUtil.gerarToken(userDetails.getUsername());

        return ResponseEntity.ok(Map.of("token", token));
    }

    @GetMapping("/me")
    public ResponseEntity<?> getUsuarioAtual(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok("Usuário logado: " + userDetails.getUsername());
    }
}
