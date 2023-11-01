package br.com.msf.appcontatos.apicontatos.model.dto;

import java.util.List;

public class PessoaDto {

    private Long id;
    private String nome;
    private String endereco;
    private String cep;
    private String cidade;
    private String uf;
    private List<ContatoDto> contatos;

    public PessoaDto(Long id, String nome, String endereco, String cep, String cidade, String uf, List<ContatoDto> contatos) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.contatos = contatos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<ContatoDto> getContatos() {
        return contatos;
    }

    public void setContatos(List<ContatoDto> contatos) {
        this.contatos = contatos;
    }
}
