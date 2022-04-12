package br.com.zup.edu.personmanager.repository;

import br.com.zup.edu.personmanager.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
