package br.com.exercicios.exercicio009.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Flowers")
@Getter
@Setter
public class ModeloFlor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column()
    String nome;

    @Column()
    String localizacao;



}
