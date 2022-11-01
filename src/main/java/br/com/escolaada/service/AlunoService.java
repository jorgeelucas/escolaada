package br.com.escolaada.service;

import br.com.escolaada.dto.AlunoRequestDTO;
import br.com.escolaada.dto.AlunoResponseDTO;
import br.com.escolaada.dto.DisciplinaDTO;
import br.com.escolaada.entity.Aluno;
import br.com.escolaada.entity.Disciplina;
import br.com.escolaada.repository.AlunoRepository;
import br.com.escolaada.utils.AlunoMapper;
import br.com.escolaada.utils.DisciplinaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoResponseDTO createStudent(AlunoRequestDTO alunoRequest) {
        //convert to entity
        Aluno aluno = AlunoMapper.INSTANCE.toEntity(alunoRequest);

        //save entity
        Aluno savedStudent = alunoRepository.save(aluno);

        //convert to dto and return
        return AlunoMapper.INSTANCE.toAlunoResponseDTO(savedStudent);
    }

    public List<AlunoResponseDTO> getAll() {
        return alunoRepository.findAll()
                .stream()
                .map(AlunoMapper.INSTANCE::toAlunoResponseDTO)
                .toList();
    }

    public List<AlunoResponseDTO> getAllByDisciplina(DisciplinaDTO disciplinaDTO) {

        Disciplina disciplina = DisciplinaMapper.INSTANCE.toEntity(disciplinaDTO);

        return alunoRepository.findAllByDisciplinasContaining(disciplina)
                .stream().map(AlunoMapper.INSTANCE::toAlunoResponseDTO)
                .toList();
    }
}
