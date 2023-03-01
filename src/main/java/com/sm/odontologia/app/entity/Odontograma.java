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

	private Date fecha_creacion;
	@ManyToOne
	@JoinColumn(name = "id_ficha", referencedColumnName = "id_ficha")
	private Ficha_odontologica fichaOdontologica;

    @ManyToOne
    @JoinColumn(name = "id_ficha", referencedColumnName = "id_ficha")
    private Ficha_odontologica fichaOdontologica;

    @JsonIgnore
    @OneToMany(mappedBy = "odontograma")
    private List<Pieza> pieza;
}
