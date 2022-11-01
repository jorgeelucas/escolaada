package br.com.escolaada.controller;

import br.com.escolaada.dto.TurmaRequestDTO;
import br.com.escolaada.dto.TurmaResponseDTO;
import br.com.escolaada.service.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turmas")
@RequiredArgsConstructor
public class TurmaController {

    private final TurmaService turmaService;

    @GetMapping
    public List<TurmaResponseDTO> getTurmas() {
        return turmaService.todas();
    }

    @PostMapping
    public TurmaResponseDTO addTurma(@RequestBody TurmaRequestDTO request) {
        return turmaService.cadastrarTurma(request);
    }

    @PostMapping("/{turma_id}/aluno")
    public TurmaResponseDTO addAlunoNaTurma(@RequestParam(value = "aluno") Long id,
                                            @PathVariable("turma_id") String idTurma) {
        return turmaService.addAlunoNaTurma(idTurma, id);
    }

}
