package br.com.escolaada.repository;

import br.com.escolaada.entity.Aluno;
import br.com.escolaada.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findAllByDisciplinasContaining(Disciplina disciplina);
}
