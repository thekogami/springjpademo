package com.poo.springjpademo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String turmaNome;

    public Turma() {
    }

    public Turma(String turmaNome) {
        this.turmaNome = turmaNome;
    }

    public Turma(long id, String turmaNome) {
        this.id = id;
        this.turmaNome = turmaNome;
    }
}