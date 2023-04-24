package br.com.fiap.projetoestagio.models;

import java.time.LocalDate;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.projetoestagio.controllers.PublicacaoController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Publicacao extends EntityModel<Publicacao> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max = 200, message = "O texto deve ter no minimo 5 letras e no maximo 200 letras")
    @NotBlank
    private String texto;

    @NotBlank
    private LocalDate data;

    @Size(min = 5, max = 100, message = "O titulo da postagem deve conter entre 5 a 100 letras")
    @NotBlank
    private String titulo;

    @OneToMany
    private Usuario usuario;

    public EntityModel<Publicacao> toEntityModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(PublicacaoController.class).show(id)).withSelfRel(),
            linkTo(methodOn(PublicacaoController.class).destroy(id)).withRel("delete"),
            linkTo(methodOn(PublicacaoController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(PublicacaoController.class).show(this.getUsuario().getId())).withRel("texto")
        );
    }
    
}
