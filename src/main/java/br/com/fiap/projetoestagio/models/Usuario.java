package br.com.fiap.projetoestagio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(max = 60, message = "O nome deve conter até 60 caracteres")
    private String nome;

    @NotBlank
    @Size(max = 80)
    private String usuario;

    @NotBlank
    @Size(max = 80)
    private String senha;

    @NotNull
    @Size(min = 1, max = 100, message = "")
    private int idade;

    @NotBlank
    @Size(min = 1, max = 600, message = "O usuario pode fazer uma descrição que tenha até 600 caracteres")
    private String descricao;

    @NotBlank
    @Min(value = 20, message = "deve digitar se pertence ao genero Masculino ou Feminino")
    private String genero;

    @NotBlank
    @Max(value = 50, message = "Deve conter todos os 11 digitos do CPF")
    private String cpf;

    @NotBlank
    @Max(value = 50, message = "Deve conter todos os 9 digitos do RG")
    private String rg;

}
