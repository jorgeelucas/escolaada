package br.com.escolaada.utils;

import br.com.escolaada.dto.TurmaRequestDTO;
import br.com.escolaada.dto.TurmaResponseDTO;
import br.com.escolaada.entity.Turma;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TurmaMapper {

    TurmaMapper INSTANCE = Mappers.getMapper(TurmaMapper.class);

    Turma toEntity(TurmaRequestDTO turmaRequestDTO);

    TurmaResponseDTO toResponseDTO(Turma turma);

}

