package com.programacao.web.fatec.api_fatec;

import com.programacao.web.fatec.api_fatec.entities.Usuario;
import com.programacao.web.fatec.api_fatec.domain.usuarios.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class InicializadorDeUsuarios {

    @Bean
    CommandLineRunner criarUsuarioAdmin(UsuarioRepository usuarioRepository, PasswordEncoder encoder) {
        return args -> {
            if (usuarioRepository.findByNome("admin") == null) {
                Usuario admin = new Usuario();
                admin.setNome("admin");
                admin.setEmail("admin@email.com");
                admin.setSenha(encoder.encode("1234")); // senha criptografada com BCrypt
                usuarioRepository.save(admin);
                System.out.println("Usuário 'admin' criado com sucesso.");
            } else {
                System.out.println("Usuário 'admin' já existe.");
            }
        };
    }
}