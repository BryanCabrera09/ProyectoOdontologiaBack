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
@Table(name = "historialOdontograma")
public class Historial_Odontograma implements Serializable {

	private static final long serialVersionUID = -8521249714562072921L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_historialOdonto;

	@ManyToOne
	@JoinColumn(name = "id_odontograma", referencedColumnName = "id_odontograma")
	private Odontograma odontograma;

	@ManyToOne
	@JoinColumn(name = "id_ficha", referencedColumnName = "id_ficha")
	private Ficha_odontologica fichaOdontologica;

}
