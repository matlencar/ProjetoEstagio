package br.com.fiap.projetoestagio.models;

import java.time.LocalDate;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.projetoestagio.controllers.InfoPublicacaoController;
import br.com.fiap.projetoestagio.controllers.PublicacaoController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
// import lombok.Getter;
import lombok.NoArgsConstructor;
// import lombok.Setter;
// import lombok.ToString;

// @Setter
// @Getter
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Publicacao extends EntityModel<Publicacao> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 200, message = "O texto deve ter no maximo 200 letras")
    @NotBlank
    private String texto;

    @Size(max = 100)
    @NotBlank
    private String titulo;

    public EntityModel<Publicacao> toEntityModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(PublicacaoController.class).show(id)).withSelfRel(),
                linkTo(methodOn(PublicacaoController.class).destroy(id)).withRel("delete"),
                linkTo(methodOn(PublicacaoController.class).index(null, Pageable.unpaged())).withRel("all"),
                linkTo(methodOn(InfoPublicacaoController.class).show(this.getInfoPublicacao().getId())).withRel("info publicacao"));
    }

    @ManyToOne
    @JoinColumn // Nome da coluna de chave estrangeira em Publicacao
    private InfoPublicacao infoPublicacao;
}
