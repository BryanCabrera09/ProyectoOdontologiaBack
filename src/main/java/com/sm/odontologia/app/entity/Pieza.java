package com.sm.odontologia.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pieza")
public class Pieza implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pieza;

	@Column(name = "numero_pieza", length = 10, nullable = false)
	private String numero_pieza;

	@Column(name = "cara_pieza", length = 15, nullable = false)
	private String cara_pieza;

	@Column(name = "tratamiento", length = 30, nullable = false)
	private String tratamiento;

	@ManyToOne
	@JoinColumn(name = "id_odontograma", referencedColumnName = "id_odontograma")
	private Odontograma odontograma;
}
