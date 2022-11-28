package br.com.films_catalog.Objetos;

import jakarta.persistence.*;

@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String anoLancamento;

    @Column(nullable = false)
    private String diretor;

    @Column(nullable = false)
    private String sinopse;

    @Deprecated
    public Filme() {}

    public Filme(String nome, String anoLancamento, String diretor, String sinopse) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.diretor = diretor;
        this.sinopse = sinopse;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    @Override
    public String toString() {
        return "\nFilme: " + nome +
                "\nID: " + id +
                "\nAno de lançamento: " + anoLancamento +
                "\nDiretor: " + diretor +
                "\nSinopse: " + sinopse;
    }
}
