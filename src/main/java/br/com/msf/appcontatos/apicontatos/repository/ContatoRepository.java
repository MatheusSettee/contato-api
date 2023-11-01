package br.com.msf.appcontatos.apicontatos.repository;

import br.com.msf.appcontatos.apicontatos.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
