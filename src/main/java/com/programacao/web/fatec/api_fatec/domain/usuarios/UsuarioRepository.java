package com.programacao.web.fatec.api_fatec.domain.usuarios;

import com.programacao.web.fatec.api_fatec.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNome(String nome); // usado para autenticação
}


