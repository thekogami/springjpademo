package com.poo.springjpademo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class GradeHoraria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String diaSemana;
    private String horario;
    private String sala;

    @ManyToOne
    private Curso curso;

    @ManyToOne
    private Disciplina disciplina;

    @ManyToOne
    private Professor professor;

    @ManyToOne
    private Turma turma;

    public GradeHoraria(String s) {
    }
}