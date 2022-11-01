package br.com.escolaada.controller;

import br.com.escolaada.dto.DisciplinaDTO;
import br.com.escolaada.dto.DisciplinaRequestDTO;
import br.com.escolaada.entity.Disciplina;
import br.com.escolaada.service.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
@RequiredArgsConstructor
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @PostMapping
    public DisciplinaDTO newDisciplina(@RequestBody DisciplinaRequestDTO disciplinaRequestDTO) {
        return disciplinaService.addDisciplina(disciplinaRequestDTO);
    }

    @GetMapping
    public List<DisciplinaDTO> getAll() {
        return disciplinaService.getAll();
    }

}
