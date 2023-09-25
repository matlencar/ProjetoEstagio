package br.com.fiap.projetoestagio.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.projetoestagio.models.Publicacao;

@Repository
public interface PublicacaoRepository extends JpaRepository<Publicacao, Integer>{


    Page<Publicacao> findByTextoContaining(String texto, Pageable pageable);

    List<Publicacao> findByPublicacaoId(int id);

    // List<Publicacao> findById(int id);

    // Page<Publicacao> findByPublicacaoContaining(String publicacao, org.springframework.data.domain.Pageable pageable);
    
}