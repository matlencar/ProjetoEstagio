package br.com.fiap.projetoestagio.repository;

import br.com.fiap.projetoestagio.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
