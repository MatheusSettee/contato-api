package br.com.msf.appcontatos.apicontatos.resource;

import br.com.msf.appcontatos.apicontatos.model.entity.Contato;
import br.com.msf.appcontatos.apicontatos.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contatos")
public class ContatoResource {

    private ContatoService contatoService;

    @Autowired
    public ContatoResource(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @Operation(summary = "Listar todos os contatos disponíveis")
    @GetMapping
    public ResponseEntity<List<Contato>> listarContatos() {
        List<Contato> contatos = contatoService.getAll();
        if (contatos == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(contatos);
    }

    @Operation(summary = "Carregar dados de um contato pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<Contato> buscarID(@PathVariable Long id) {
        Optional<Contato> contato = contatoService.getById(id);
        if (contato.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(contato.get());
    }

    @Operation(summary = "Atualizar um contato existente pelo id")
    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizar(@RequestBody Contato contato) {
        Contato novoContato = contatoService.update(contato);
        if (novoContato == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(novoContato);
    }

    @Operation(summary = "Remover um contato existente pelo id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        contatoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
