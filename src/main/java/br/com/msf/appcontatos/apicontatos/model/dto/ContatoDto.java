package br.com.msf.appcontatos.apicontatos.model.dto;

import br.com.msf.appcontatos.apicontatos.model.enums.Tipo;

public class ContatoDto {
    private Tipo tipo;
    private String nome;
    private String numero;

    public ContatoDto(Tipo tipo, String nome, String numero) {
        this.tipo = tipo;
        this.nome = nome;
        this.numero = numero;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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

