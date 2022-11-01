package br.com.escolaada.service.exceptions;

public class AlunoNaoEncontradoException extends RuntimeException {

    private static final String MESSAGE_ = "Aluno de id %s não encontrado.";
    public AlunoNaoEncontradoException(Long idAluno) {
        super(MESSAGE_.formatted(idAluno));
    }
}
