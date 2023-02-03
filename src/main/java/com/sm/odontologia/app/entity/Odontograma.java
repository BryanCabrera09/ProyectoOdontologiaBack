package com.sm.odontologia.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "odontograma")
public class Odontograma implements Serializable {

    private static final long serialVersionUID = -4279187336239993447L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_odontograma;

    @JsonIgnore
    @OneToMany(mappedBy = "odontograma")
    private List<Historial_Odontograma> historialOdontograma;

    @JsonIgnore
    @OneToMany(mappedBy = "odontograma")
    private List<Historial_Pieza> historialPieza;

    @ManyToOne
    @JoinColumn(name = "id_ficha", referencedColumnName = "id_ficha")
    private Ficha_odontologica fichaOdontologica;
}
