package com.sm.odontologia.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Long id_persona;

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
}
