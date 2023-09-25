package br.com.fiap.projetoestagio.repository;

import br.com.fiap.projetoestagio.models.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    Optional<Usuario> findByEmail(String email);

}
