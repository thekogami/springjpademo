package com.poo.springjpademo.repository;

import com.poo.springjpademo.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    @Query("SELECT c FROM Curso c WHERE c.nome = :nome")
    Curso findCursoByCursoNome(@Param("nome")String nome);
}