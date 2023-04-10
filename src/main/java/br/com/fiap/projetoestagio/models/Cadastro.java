package br.com.fiap.projetoestagio.models;


import java.util.GregorianCalendar;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@Entity
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email(message="Por favor forneça um endereço de email valido")
    @Pattern(regexp=".+@.+\\..+", message="Por favor forneça um endereço de email valido")
    private String email;

    @NotBlank
    @Size(min = 6, max = 8, message = "A senha deve conter entre 6 a 8 caracteres")
    private String senha;

    @NotBlank
    @Size(min = 3 , max = 60, message = "O nome deve conter de 3 até 60 caracteres")
    private String nome;

    @NotBlank
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private GregorianCalendar dataNascimento;

    @NotBlank
    @Size(max = 11, message = "O CPF do usuario deve conter todos os 11 digitos completos")
    private String cpf;

    @OneToOne
    private Usuario usuario;

    public Cadastro() {}

    // public Cadastro(Long id, String email, String senha, String nome, GregorianCalendar dataNascimento, String cpf) {
    //     this.email = email;
    //     this.senha = senha;
    //     this.nome = nome;
    //     this.dataNascimento = dataNascimento;
    //     this.cpf = cpf;
    // }

    // public String getEmail() {
    //     return email;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

    // public String getSenha() {
    //     return senha;
    // }

    // public void setSenha(String senha) {
    //     this.senha = senha;
    // }

    // public String getNome() {
    //     return nome;
    // }

    // public void setNome(String nome) {
    //     this.nome = nome;
    // }

    // public GregorianCalendar getDataNascimento() {
    //     return dataNascimento;
    // }

    // public void setDataNascimento(GregorianCalendar dataNascimento) {
    //     this.dataNascimento = dataNascimento;
    // }

    // public String getCpf() {
    //     return cpf;
    // }

    // public void setCpf(String cpf) {
    //     this.cpf = cpf;
    // }

    // @Override
    // public String toString() {
    //     return "Cadastro [email=" + email + ", senha=" + senha + ", nome=" + nome + ", dataNascimento=" + dataNascimento
    //             + ", cpf=" + cpf + "]";
    // }

    // public Long getId() {
    //     return id;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }

}
