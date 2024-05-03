package com.poo.springjpademo.repository;

import com.poo.springjpademo.entity.Curso;
import com.poo.springjpademo.entity.Disciplina;
import com.poo.springjpademo.entity.Professor;
import com.poo.springjpademo.entity.Turma;
import com.poo.springjpademo.entity.GradeHoraria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeHorariaRepository extends JpaRepository<GradeHoraria, Long> {

    List<GradeHoraria> findByDiaSemana(String diaSemana);
    List<GradeHoraria> findByCurso(Curso curso);
    List<GradeHoraria> findByDisciplina(Disciplina disciplina);
    List<GradeHoraria> findByProfessor(Professor professor);
    List<GradeHoraria> findByTurma(Turma turma);
}