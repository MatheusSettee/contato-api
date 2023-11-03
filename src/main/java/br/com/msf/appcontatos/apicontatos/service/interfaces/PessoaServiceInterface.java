package br.com.msf.appcontatos.apicontatos.service.interfaces;

import br.com.msf.appcontatos.apicontatos.model.entity.Contato;
import br.com.msf.appcontatos.apicontatos.model.entity.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaServiceInterface {
    Pessoa criarPessoa(Pessoa pessoa);

    Contato criarContato(Contato contato);

    Optional<Pessoa> getById(Long id);

    List<Pessoa> getAll();

    Pessoa update(Pessoa pessoa, Long id);

    void delete(Long id);
}