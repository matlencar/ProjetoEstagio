package br.com.fiap.projetoestagio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.projetoestagio.models.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer>{
    
}
