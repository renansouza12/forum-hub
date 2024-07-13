package com.renan.forum_hub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.renan.forum_hub.domain.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    
    UserDetails findByLogin(String login);
}
