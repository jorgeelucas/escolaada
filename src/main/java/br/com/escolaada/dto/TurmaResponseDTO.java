package br.com.escolaada.dto;

import java.util.List;

public record TurmaResponseDTO(String id,
                               String nome,
                               List<AlunoResponseDTO> alunos) {
}
