package br.com.escolaada.utils;

import br.com.escolaada.dto.AlunoRequestDTO;
import br.com.escolaada.dto.AlunoResponseDTO;
import br.com.escolaada.entity.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlunoMapper {

    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    AlunoResponseDTO toAlunoResponseDTO(Aluno aluno);
    Aluno toEntity(AlunoRequestDTO alunoRequestDTO);

    List<AlunoResponseDTO> toDTOs(List<Aluno> alunos);

}
