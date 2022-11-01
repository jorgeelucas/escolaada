package br.com.escolaada.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AlunoResponseDTO {
    private String nome;
    private List<DisciplinaDTO> disciplinas;
}
