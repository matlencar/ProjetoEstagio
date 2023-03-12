package br.com.fiap.projetoestagio.models;



public class Usuario {

    private String nome;
    private int idade;
    private String descricao;
    private String genero;
    private int cpf;
    private int rg;
    private long[] foto;

    public Usuario(String nome, int idade, String descricao, String genero, int cpf, int rg, long[] foto) {
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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public long[] getFoto() {
        return foto;
    }

    public void setFoto(long[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", idade=" + idade + ", descricao=" + descricao + ", Genero=" + genero
                + ", cpf=" + cpf + ", rg=" + rg + "]";
    }
}
