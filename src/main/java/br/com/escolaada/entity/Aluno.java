package br.com.escolaada.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "ALUNO")
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany
    @JoinTable(name="aluno_disciplina",
            joinColumns={@JoinColumn(name = "aluno_id")},
            inverseJoinColumns={@JoinColumn(name = "disciplina_id")})
    private List<Disciplina> disciplinas;

}
