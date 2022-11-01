package br.com.escolaada.service;

import br.com.escolaada.dto.DisciplinaDTO;
import br.com.escolaada.dto.DisciplinaRequestDTO;
import br.com.escolaada.entity.Disciplina;
import br.com.escolaada.repository.DisciplinaRepository;
import br.com.escolaada.utils.DisciplinaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public List<DisciplinaDTO> getAll() {
        return disciplinaRepository
                .findAll().stream()
                .map(DisciplinaMapper.INSTANCE::toResponseDTO)
                .toList();

    }

    public DisciplinaDTO addDisciplina(DisciplinaRequestDTO disciplinaRequestDTO) {
        DisciplinaMapper mapper = DisciplinaMapper.INSTANCE;

        return mapper.toResponseDTO(disciplinaRepository.save(mapper.toEntity(disciplinaRequestDTO)));
    }
}
