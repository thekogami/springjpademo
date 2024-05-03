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
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String numSala;

    public Sala() {
    }

    public Sala(String numSala) {
        this.numSala = numSala;
    }

    public Sala(long id, String numSala) {
        this.id = id;
        this.numSala = numSala;
    }

}