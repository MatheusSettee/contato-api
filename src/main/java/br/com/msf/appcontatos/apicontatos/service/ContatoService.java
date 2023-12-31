package br.com.msf.appcontatos.apicontatos.service;

import br.com.msf.appcontatos.apicontatos.model.dto.ContatoDto;
import br.com.msf.appcontatos.apicontatos.model.entity.Contato;
import br.com.msf.appcontatos.apicontatos.repository.ContatoRepository;
import br.com.msf.appcontatos.apicontatos.service.interfaces.ContatoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService implements ContatoServiceInterface {

    private ContatoRepository contatoRepository;

    @Autowired
    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    @Override
    public Contato criarContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Override
    public Optional<Contato> getById(Long id) {
        return contatoRepository.findById(id);
    }

    @Override
    public List<Contato> getAll() {
        return contatoRepository.findAll();
    }

    @Override
    public Contato update(Long id, ContatoDto contato) {

        Optional<Contato> upContato = contatoRepository.findById(id);

        if (upContato.isPresent()) {
            Contato newContato = upContato.get();
            if (contato.getNome() != null) {
                newContato.setNome(contato.getNome());
            }
            if (contato.getNumero() != null) {
                newContato.setNumero(contato.getNumero());
            }
            if (contato.getTipo() != null) {
                newContato.setTipo(contato.getTipo());
            }
            return contatoRepository.save(newContato);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        contatoRepository.deleteById(id);
    }


}
