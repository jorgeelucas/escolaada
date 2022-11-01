package br.com.escolaada.repository;

import br.com.escolaada.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
