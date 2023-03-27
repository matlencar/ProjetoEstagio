package br.com.fiap.projetoestagio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.projetoestagio.models.Publicacao;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Long>{
    
}
