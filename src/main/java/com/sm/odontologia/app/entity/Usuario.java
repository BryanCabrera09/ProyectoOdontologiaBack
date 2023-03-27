package com.sm.odontologia.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;

	@Column(name = "username", length = 25, nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	private boolean enabled = true;

	@ManyToOne()
	@JoinColumn(name = "id_persona")
	private Persona persona;

	@ManyToOne
	@JoinColumn(name = "rolId")
	private Rol rol;

}