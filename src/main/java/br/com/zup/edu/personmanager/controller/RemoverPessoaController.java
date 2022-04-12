package br.com.zup.edu.personmanager.controller;

import br.com.zup.edu.personmanager.model.Pessoa;
import br.com.zup.edu.personmanager.repository.PessoaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@RestController
public class RemoverPessoaController {

    private final PessoaRepository repository;

    public RemoverPessoaController(PessoaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @DeleteMapping("/pessoas/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") Long id) {
        Pessoa pessoa = repository.findById(id).orElseThrow(() -> {
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada");
        });

        if (pessoa.tem18AnosOuMaisDeIdade()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Não é possível remover pessoas com 18 anos ou mais");
        }

        repository.delete(pessoa);

        return ResponseEntity.noContent().build();
    }
}
