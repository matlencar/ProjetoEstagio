package br.com.fiap.projetoestagio.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.projetoestagio.models.Publicacao;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Long>{

    Page<Publicacao> findByPublicacaoContaining(String publicacao, Pageable pageable);

    Page<Publicacao> findAll(Pageable pageable);
    
}
