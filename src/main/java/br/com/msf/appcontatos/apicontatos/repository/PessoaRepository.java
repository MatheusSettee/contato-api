package br.com.msf.appcontatos.apicontatos.repository;

import br.com.msf.appcontatos.apicontatos.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
