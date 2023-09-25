package br.com.fiap.projetoestagio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.projetoestagio.models.InfoPublicacao;
import br.com.fiap.projetoestagio.models.Publicacao;

@Repository
public interface InfoPublicacaoRepository extends JpaRepository<InfoPublicacao, Integer> {
    
    // List<Publicacao> findByPublicacaoId(int id);
}
