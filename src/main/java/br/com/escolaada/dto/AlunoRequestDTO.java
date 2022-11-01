package br.com.escolaada.dto;

import lombok.Data;

import java.util.List;

@Data
public class AlunoRequestDTO {
    private String nome;
    private List<DisciplinaDTO> disciplinas;
}
