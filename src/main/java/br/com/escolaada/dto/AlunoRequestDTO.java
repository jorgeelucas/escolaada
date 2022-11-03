package br.com.escolaada.dto;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class AlunoRequestDTO {
    private String nome;

    @NotNull(message = "O email não pode estar nulo")
    @Email
    private String email;

    @CPF
    private String cpf;

    private List<DisciplinaDTO> disciplinas;
}
