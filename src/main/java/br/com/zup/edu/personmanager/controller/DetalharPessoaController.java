package br.com.zup.edu.personmanager.controller;

import br.com.zup.edu.personmanager.model.Pessoa;
import br.com.zup.edu.personmanager.repository.PessoaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DetalharPessoaController {

    private final PessoaRepository repository;

    public DetalharPessoaController(PessoaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/pessoas/{id}")
    public ResponseEntity<?> detalhar(@PathVariable("id") Long id) {
        Pessoa pessoa = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ResponseEntity.ok(new PessoaResponse(pessoa));
    }
}
