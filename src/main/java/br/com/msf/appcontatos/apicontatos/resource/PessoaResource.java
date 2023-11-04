package br.com.msf.appcontatos.apicontatos.resource;


import br.com.msf.appcontatos.apicontatos.model.dto.ContatoDto;
import br.com.msf.appcontatos.apicontatos.model.dto.PessoaDto;
import br.com.msf.appcontatos.apicontatos.model.entity.Contato;
import br.com.msf.appcontatos.apicontatos.model.entity.Pessoa;
import br.com.msf.appcontatos.apicontatos.service.ContatoService;
import br.com.msf.appcontatos.apicontatos.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

    private PessoaService pessoaService;
    private ContatoService contatoService;

    @Autowired
    public PessoaResource(PessoaService pessoaService, ContatoService contatoService) {
        this.pessoaService = pessoaService;
        this.contatoService = contatoService;
    }

    @Operation(summary = "Listar todos as pessoas disponíveis")
    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        List<Pessoa> pessoas = pessoaService.getAll();
        if (pessoas == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pessoas);
    }

    @Operation(summary = "Carregar dados de uma pessoa pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarID(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.getById(id);
        if (pessoa.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pessoa.get());
    }

    @Operation(summary = "Adicionar uma nova pessoa")
    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody PessoaDto pessoa) {
        if (pessoa == null || StringUtils.isBlank(pessoa.getNome()) || StringUtils.isBlank(pessoa.getEndereco()) || StringUtils.isBlank(pessoa.getCep()) || StringUtils.isBlank(pessoa.getCidade()) || StringUtils.isBlank(pessoa.getUf())) {
            return ResponseEntity.badRequest().body("Dados da pessoa inválidos");
        }
        try {
            Pessoa novaPessoa = pessoaService.criarPessoa(pessoa);
            return ResponseEntity.ok(novaPessoa);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Buscar todos os contatos de uma pessoa")
    @GetMapping("/{id}/contatos")
    public ResponseEntity<List<Contato>> buscarContatos(@PathVariable Long id) {
        Optional<Pessoa> pessoaOptional = pessoaService.getById(id);
        if (pessoaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<Contato> contatos = pessoaOptional.get().getContatos();
        return ResponseEntity.ok(contatos);
    }

    @Operation(summary = "Adicionar um novo contato para uma pessoa existente")
    @PostMapping("/{id}/contatos")
    public ResponseEntity<?> adicionarContato(@PathVariable Long id, @RequestBody ContatoDto contatoDto) {
        Contato novoContato = new Contato(contatoDto.getTipo(), contatoDto.getNumero(), null, contatoDto.getNome());
        if (novoContato == null || StringUtils.isBlank(novoContato.getNome()) || StringUtils.isBlank(novoContato.getNumero()) || novoContato.getTipo() == null) {
            return ResponseEntity.badRequest().body("Dados de contato inválidos");
        }
        Optional<Pessoa> pessoaOptional = pessoaService.getById(id);
        if (pessoaOptional.isPresent()) {
            Pessoa pessoa = pessoaOptional.get();
            novoContato.setPessoa(pessoa);
            try {
                return ResponseEntity.ok(contatoService.criarContato(novoContato));
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Atualizar uma pessoa existente pelo id")
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody PessoaDto pessoa) {
        Pessoa novoPessoa = pessoaService.update(pessoa, id);
        if (novoPessoa == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(novoPessoa);
    }

    @Operation(summary = "Remover uma pessoa existente pelo id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        pessoaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "retorna os dados de uma Pessoa por ID com mala direta")
    @GetMapping("/maladireta/{id}")
    public ResponseEntity listaPessoaMalaDireta(@PathVariable Long id){
        return ResponseEntity.ok(pessoaService.listarPessoaMalaDireta(id));
    }
   }
