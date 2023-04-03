package br.com.fiap.projetoestagio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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

    protected Usuario() {}

    public Usuario(Long id, String nome, int idade, String descricao, String genero, String cpf, String rg, String[] foto) {
        this.nome = nome;
        this.idade = idade;
        this.descricao = descricao;
        this.genero = genero;
        this.cpf = cpf;
        this.rg = rg;
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String isGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String[] getFoto() {
        return foto;
    }

    public void setFoto(String[] foto) {
        this.foto = foto;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getGenero() {
        return genero;
    }
    
    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", idade=" + idade + ", descricao=" + descricao + ", Genero=" + genero
                + ", cpf=" + cpf + ", rg=" + rg + "]";
    }
}
