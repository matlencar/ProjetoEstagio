package br.com.fiap.projetoestagio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.projetoestagio.models.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long>{
    
}
