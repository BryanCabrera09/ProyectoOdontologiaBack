package com.sm.odontologia.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "historialPieza")
public class Historial_Pieza implements Serializable {
    private static final long serialVersionUID = 8329875806660704304L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_historialPieza;

    @Column(name = "superior", length = 10, nullable = false)
    private String superior;

    @Column(name = "inferior", length = 10, nullable = false)
    private String inferior;

    @Column(name = "izquierda", length = 10, nullable = false)
    private String izquierda;

    @Column(name = "derecha", length = 10, nullable = false)
    private String derecha;

    @Column(name = "centro", length = 10, nullable = false)
    private String centro;


    @ManyToOne
    @JoinColumn(name = "id_odontograma", referencedColumnName = "id_odontograma")
    private Odontograma odontograma;



}
