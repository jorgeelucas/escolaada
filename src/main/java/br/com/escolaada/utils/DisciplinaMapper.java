package br.com.escolaada.utils;

import br.com.escolaada.dto.DisciplinaDTO;
import br.com.escolaada.dto.DisciplinaRequestDTO;
import br.com.escolaada.entity.Disciplina;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DisciplinaMapper {

    DisciplinaMapper INSTANCE = Mappers.getMapper(DisciplinaMapper.class);

    DisciplinaDTO toResponseDTO(Disciplina disciplina);

    Disciplina toEntity(DisciplinaDTO disciplina);

    Disciplina toEntity(DisciplinaRequestDTO disciplinaRequestDTO);
}
