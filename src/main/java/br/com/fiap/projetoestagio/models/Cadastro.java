package br.com.fiap.projetoestagio.models;


import java.util.GregorianCalendar;

public class Cadastro {

    private String email;
    private String senha;
    private String nome;
    private GregorianCalendar dataNascimento;
    private String cpf;

    public Cadastro(String email, String senha, String nome, GregorianCalendar dataNascimento, String cpf) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GregorianCalendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(GregorianCalendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cadastro [email=" + email + ", senha=" + senha + ", nome=" + nome + ", dataNascimento=" + dataNascimento
                + ", cpf=" + cpf + "]";
    }

    
}
