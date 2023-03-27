package br.com.fiap.projetoestagio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.projetoestagio.models.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{
    
}