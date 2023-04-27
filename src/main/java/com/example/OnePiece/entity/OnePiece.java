package com.example.OnePiece.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class OnePiece {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int age;

    private String ability;

    private int strength;

    private String crew;


}
