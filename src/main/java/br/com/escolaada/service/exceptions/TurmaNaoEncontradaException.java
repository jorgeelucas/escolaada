package br.com.escolaada.service.exceptions;

public class TurmaNaoEncontradaException extends RuntimeException {

    private static final String MESSAGE_ = "turma não encontrada: %s";

    public TurmaNaoEncontradaException(String msg) {
        super(MESSAGE_.formatted(msg));
    }

}
