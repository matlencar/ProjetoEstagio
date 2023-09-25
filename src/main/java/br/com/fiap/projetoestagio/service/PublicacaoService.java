package br.com.fiap.projetoestagio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.projetoestagio.models.InfoPublicacao;
import br.com.fiap.projetoestagio.models.Publicacao;
import br.com.fiap.projetoestagio.models.PublicacaoDto;
import br.com.fiap.projetoestagio.repository.InfoPublicacaoRepository;
import br.com.fiap.projetoestagio.repository.PublicacaoRepository;

@Service
public class PublicacaoService {
    
    @Autowired
    PublicacaoRepository publicacaoRepository;

    @Autowired
    InfoPublicacaoRepository infoPublicacaoRepository;

    public List<PublicacaoDto> findAll() {

        var publicacoes = publicacaoRepository.findAll();
        List<PublicacaoDto> dtos = new ArrayList<>();


        publicacoes.forEach(publicacao -> {
            var publi = publicacaoRepository.findByPublicacaoId(publicacao.getId());
            var titulo = publi.stream().map(Publicacao::getTitulo).reduce(null);
            var texto = publi.stream().map(Publicacao::getTexto).reduce(null);

            dtos.add(new PublicacaoDto(publicacao, titulo, texto));

        });

        return dtos;
        
    }
}
