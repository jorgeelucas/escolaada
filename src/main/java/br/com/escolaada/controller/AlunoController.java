package br.com.escolaada.controller;

import br.com.escolaada.dto.AlunoRequestDTO;
import br.com.escolaada.dto.AlunoResponseDTO;
import br.com.escolaada.dto.DisciplinaDTO;
import br.com.escolaada.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Void> addAluno(@RequestBody AlunoRequestDTO aluno) {
        alunoService.createStudent(aluno);
        return ResponseEntity.created(null).build();
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> getAllStudents() {
        return ResponseEntity.ok(alunoService.getAll());
    }

    @PostMapping("/disciplina")
    public ResponseEntity<List<AlunoResponseDTO>> getAllStudentsByDisciplina(@RequestBody DisciplinaDTO disciplina) {
        return ResponseEntity.ok(alunoService.getAllByDisciplina(disciplina));
    }

}
