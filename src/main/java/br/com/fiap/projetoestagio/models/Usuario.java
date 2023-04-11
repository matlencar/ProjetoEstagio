package br.com.fiap.projetoestagio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//masculino feminino
    @NotBlank
    @Size(min = 3 , max = 60, message = "O nome deve conter de 3 até 60 caracteres")
    private String nome;

    @NotBlank
    @Size(min = 14, max = 100, message = "")
    private int idade;

    @NotBlank
    @Size(min = 3, max = 600, message = "O usuario pode fazer uma descrição que tenha até 600 caracteres")
    private String descricao;

    @NotBlank
    @Min(value = 9, message = "deve digitar se pertence ao genero Masculino ou Feminino")
    private String genero;

    @NotBlank
    @Max(value = 11, message = "Deve conter todos os 11 digitos do CPF")
    private String cpf;

    @NotBlank
    @Max(value = 11, message = "Deve conter todos os 9 digitos do RG")
    private String rg;

    @NotBlank
    private String[] foto;

    @OneToMany
    private Publicacao publicacao;

    @OneToOne
    private Cadastro cadastro;

    @OneToOne
    private Login login;

    public Usuario() {}

    
}
