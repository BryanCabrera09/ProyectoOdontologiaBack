package com.sm.odontologia.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persona")
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_persona;

	@Size(min = 10, max = 10, message = "Cedula longitud maxima permitida 10 caracteres")
	@Column(name = "cedula", nullable = false)
	private String cedula;

	@Column(name = "nombre", length = 45, nullable = false)
	private String nombre;

	@Column(name = "apellido", length = 45, nullable = false)
	private String apellido;

	@Column(name = "email", length = 50, nullable = false)
	private String email;

	@Column(name = "fecha_nacimiento", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date fechaNac;

	@Column(name = "genero", nullable = false)
	private String genero;

	@Size(min = 10, max = 10, message = "Celular longitud maxima permitida 10 caracteres")
	@Column(name = "celular", nullable = false)
	private String celular;

	@Column(name = "direccion", length = 50, nullable = false)
	private String direccion;

	@Size(min = 9, max = 10, message = "Telefono longitud maxima permitida 10 caracteres")
	@Column(name = "telefono", nullable = false)
	private String telefono;
	
	private boolean enabled = true;

	@OneToMany(mappedBy = "persona",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Ficha_odontologica> ficha_odontologica = new ArrayList<>();

	@JsonIgnore
	@OneToOne(mappedBy = "persona")
	private Usuario usuario;

}
