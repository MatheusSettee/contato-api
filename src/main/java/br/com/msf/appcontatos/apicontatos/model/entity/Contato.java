package br.com.msf.appcontatos.apicontatos.model.entity;

import br.com.msf.appcontatos.apicontatos.model.enums.Tipo;
import jakarta.persistence.*;

@Entity
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    private Tipo tipo;
    private String nome;
    private String numero;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Contato() {
    }

    public Contato(Long id, Tipo tipo, String numero, Pessoa pessoa, String nome) {
        this.id = id;
        this.tipo = tipo;
        this.numero = numero;
        this.pessoa = pessoa;
        this.nome = nome;
    }
    public Contato(Tipo tipo, String numero, Pessoa pessoa, String nome) {
        this.tipo = tipo;
        this.numero = numero;
        this.pessoa = pessoa;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }


    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
