package br.com.escolaada.service;

import br.com.escolaada.dto.AlunoResponseDTO;
import br.com.escolaada.dto.TurmaRequestDTO;
import br.com.escolaada.dto.TurmaResponseDTO;
import br.com.escolaada.entity.Aluno;
import br.com.escolaada.entity.Turma;
import br.com.escolaada.repository.AlunoRepository;
import br.com.escolaada.repository.TurmaRepository;
import br.com.escolaada.service.exceptions.AlunoNaoEncontradoException;
import br.com.escolaada.service.exceptions.TurmaNaoEncontradaException;
import br.com.escolaada.utils.AlunoMapper;
import br.com.escolaada.utils.TurmaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final AlunoRepository alunoRepository;

    // CONVERTER
    private static final TurmaMapper CONVERTER = TurmaMapper.INSTANCE;
    private static final AlunoMapper alunoMapper = AlunoMapper.INSTANCE;

    public TurmaResponseDTO cadastrarTurma(TurmaRequestDTO turmaRequestDTO) {

        //convert turma
        Turma entity = CONVERTER.toEntity(turmaRequestDTO);

        //generate UID
        final var uid = UUID.randomUUID().toString();
        entity.setId(uid);

        //saving turma
        Turma savedEntity = turmaRepository.save(entity);

        //converting and returning
        return CONVERTER.toResponseDTO(savedEntity);
    }

    public TurmaResponseDTO addAlunoNaTurma(String idTurma, Long idAluno) {

        // busca turma por id
        Turma turma = this.findById(idTurma);

        Aluno aluno = alunoRepository.findById(idAluno)
                .orElseThrow(() -> new AlunoNaoEncontradoException(idAluno));

        turma.getAlunos().add(aluno);

        Turma savedTurma = turmaRepository.save(turma);

        return CONVERTER.toResponseDTO(savedTurma);
    }

    private Turma findById(String id) {
        return turmaRepository.findById(id)
                .orElseThrow(() -> new TurmaNaoEncontradaException(id));
    }

    public List<TurmaResponseDTO> todas() {
        return turmaRepository.findAll()
                .stream()
                .map(turma -> new TurmaResponseDTO(turma.getId(), turma.getNome(), alunoMapper.toDTOs(turma.getAlunos())))
                .toList();
    }

}
