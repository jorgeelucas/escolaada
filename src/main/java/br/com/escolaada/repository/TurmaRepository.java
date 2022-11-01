package br.com.escolaada.repository;

import br.com.escolaada.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, String> {
}
