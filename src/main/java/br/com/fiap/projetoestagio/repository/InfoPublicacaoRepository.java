package br.com.fiap.projetoestagio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.projetoestagio.models.InfoPublicacao;

public interface InfoPublicacaoRepository extends JpaRepository<InfoPublicacao, Integer> {
    
}
