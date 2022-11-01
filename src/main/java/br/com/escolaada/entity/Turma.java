package br.com.escolaada.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Turma {

    @Id
    private String id;

    private String nome;

    @OneToMany
    private List<Aluno> alunos;

}
