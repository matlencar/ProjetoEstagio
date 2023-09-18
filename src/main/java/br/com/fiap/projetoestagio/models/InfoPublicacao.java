package br.com.fiap.projetoestagio.models;

// import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class InfoPublicacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size( max = 40)
    private String linguagem;

    @NotBlank
    @Size(max = 60)
    private String areaAtuacao;

    // @OneToMany(mappedBy = "infoPublicacao")
    // private List<Publicacao> publicacoes;
}
