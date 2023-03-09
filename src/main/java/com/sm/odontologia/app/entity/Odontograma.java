package com.sm.odontologia.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.*;
import org.springframework.format.annotation.DateTimeFormat.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
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
    private Long id_odontograma;

	@Column(name = "fecha_Odontograma", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
	private Date fecha_Odontograma;

    @JsonIgnore
    @OneToMany(mappedBy = "odontograma")
    private List<Historial_Odontograma> historialOdontograma;

    @ManyToOne
    @JoinColumn(name = "id_ficha", referencedColumnName = "id_ficha")
    private Ficha_odontologica fichaOdontologica;

    @JsonIgnore
    @OneToMany(mappedBy = "odontograma")
    private List<Pieza> pieza;
}
