package br.com.fiap.projetoestagio.models;

public class InfoComplementar {

    private String linguagem;
    private int nivelLinguagem;
    private String idioma;
    private int nivelIdioma;

    public InfoComplementar(String linguagem, int nivelLinguagem, String idioma, int nivelIdioma) {
        this.linguagem = linguagem;
        this.nivelLinguagem = nivelLinguagem;
        this.idioma = idioma;
        this.nivelIdioma = nivelIdioma;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public int getNivelLinguagem() {
        return nivelLinguagem;
    }

    public void setNivelLinguagem(int nivelLinguagem) {
        this.nivelLinguagem = nivelLinguagem;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getNivelIdioma() {
        return nivelIdioma;
    }

    public void setNivelIdioma(int nivelIdioma) {
        this.nivelIdioma = nivelIdioma;
    }

}
