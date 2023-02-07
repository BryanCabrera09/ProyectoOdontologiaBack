package com.sm.odontologia.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tratamiento")
public class Tratamiento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tratamiento;

	@Column(name = "nombre_tratamiento", length = 50, nullable = false)
	private String nombre;

	@Column(name = "descripcion", length = 100, nullable = false)
	private String descripcion;

	@JsonIgnore
	@OneToMany(mappedBy = "tratamiento")
	private List<Ficha_odontologica> ficha;
}
