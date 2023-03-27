package br.com.fiap.projetoestagio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.projetoestagio.models.InfoComplementar;

public interface InfoComplementarRepository extends JpaRepository<InfoComplementar, Long> {
    
}
