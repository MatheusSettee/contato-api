package br.com.msf.appcontatos.apicontatos.service.interfaces;

import br.com.msf.appcontatos.apicontatos.model.dto.ContatoDto;
import br.com.msf.appcontatos.apicontatos.model.entity.Contato;

import java.util.List;
import java.util.Optional;

public interface ContatoServiceInterface {
    Contato criarContato(Contato contato);

    Optional<Contato> getById(Long id);

    List<Contato> getAll();

    Contato update(Long id, ContatoDto contato);

    void delete(Long id);
}