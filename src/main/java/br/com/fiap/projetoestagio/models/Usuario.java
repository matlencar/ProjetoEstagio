package br.com.fiap.projetoestagio.models;
public class Usuario {

    private Long id;
    private String nome;
    private int idade;
    private String descricao;
    private String genero;
    private String cpf;
    private String rg;
    private String[] foto;

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
