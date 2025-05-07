package com.programacao.web.fatec.api_fatec.domain.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programacao.web.fatec.api_fatec.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByNome(String username);
   
}

