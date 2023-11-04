package br.com.msf.appcontatos.apicontatos.service;

import br.com.msf.appcontatos.apicontatos.model.dto.MalaDiretaDto;
import br.com.msf.appcontatos.apicontatos.model.dto.PessoaDto;
import br.com.msf.appcontatos.apicontatos.model.entity.Contato;
import br.com.msf.appcontatos.apicontatos.model.entity.Pessoa;
import br.com.msf.appcontatos.apicontatos.repository.ContatoRepository;
import br.com.msf.appcontatos.apicontatos.repository.PessoaRepository;
import br.com.msf.appcontatos.apicontatos.service.interfaces.PessoaServiceInterface;
import br.com.msf.appcontatos.apicontatos.util.extensions.EnderecoExtensions;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService implements PessoaServiceInterface {

    private PessoaRepository pessoaRepository;
    private ContatoRepository contatoRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Pessoa criarPessoa(PessoaDto pessoa) {
        Pessoa novaPessoa = new Pessoa(pessoa.getNome(), pessoa.getEndereco(), pessoa.getCep(), pessoa.getCidade(), pessoa.getUf());
        return pessoaRepository.save(novaPessoa);
    }

    @Override
    public Contato criarContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Override
    public Optional<Pessoa> getById(Long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public List<Pessoa> getAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa update(PessoaDto pessoa, Long id) {

        Optional<Pessoa> upPessoa = pessoaRepository.findById(id);

        if (upPessoa.isPresent()) {
            Pessoa newPessoa = upPessoa.get();
            if (pessoa.getNome() != null && pessoa.getNome() != "") {
                newPessoa.setNome(pessoa.getNome());
            }
            if (pessoa.getEndereco() != null && pessoa.getEndereco() != "") {
                newPessoa.setEndereco(pessoa.getEndereco());
            }
            if (pessoa.getCep() != null && pessoa.getCep() != "") {
                newPessoa.setCep(pessoa.getCep());
            }
            if (pessoa.getCidade() != null && pessoa.getCidade() != "") {
                newPessoa.setCidade(pessoa.getCidade());
            }
            if (pessoa.getUf() != null && pessoa.getUf() != "") {
                newPessoa.setUf(pessoa.getUf());
            }
            return pessoaRepository.save(newPessoa);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }

    public MalaDiretaDto listarPessoaMalaDireta(Long id){
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        if(pessoaOptional.isEmpty()){
            throw new EntityNotFoundException();
        }
        Pessoa pessoa = pessoaOptional.get();

        String malaDireta = EnderecoExtensions.buildMalaDireta(
                pessoa.getEndereco(),
                pessoa.getCep(),
                pessoa.getCidade(),
                pessoa.getUf()
        );
        return new MalaDiretaDto(pessoa.getId(), pessoa.getNome(), malaDireta);
    }
}