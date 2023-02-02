package com.sm.odontologia.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@Table(name = "persona")
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_persona;

	@Size(min = 10, max = 10, message = "Cedula longitud maxima permitida 10 caracteres")
	@NotNull(message = "Cedula no puede ser nulo")
	@Column(name = "cedula")
	private String cedula;

	@Size(max = 45, message = "Nombre longitud maxima permitida 45 caracteres")
	@NotNull(message = "Nombre no puede ser nulo")
	@Column(name = "nombre")
	private String nombre;

	@Size(max = 45, message = "Apellido longitud maxima permitida 45 caracteres")
	@NotNull(message = "Apellido no puede ser nulo")
	@Column(name = "apellido")
	private String Apellido;

	@Size(max = 45, message = "Correo longitud maxima permitida 45 caracteres")
	@NotNull(message = "Correo no puede ser nulo")
	@Column(name = "email")
	private String email;

	@NotNull(message = "Fecha de Nacimiento no puede ser nulo")
	@Column(name = "fecha_nacimiento")
	private Date fechaNac;

	@NotNull(message = "Genero no puede ser nulo")
	@Column(name = "genero")
	private String genero;

	@Size(min = 10, max = 10, message = "Celular longitud maxima permitida 10 caracteres")
	@NotNull(message = "Celular no puede ser nulo")
	@Column(name = "celular")
	private String celular;

	@Size(max = 50, message = "Direccion longitud maxima permitida 50 caracteres")
	@NotNull(message = "Direccion no puede ser nulo")
	@Column(name = "direccion")
	private String direccion;

	@Size(min = 9, max = 10, message = "Telefono longitud maxima permitida 10 caracteres")
	@NotNull(message = "Telefono no puede ser nulo")
	@Column(name = "telefono")
	private String telefono;


	@JsonIgnore
	@OneToMany(mappedBy = "persona")
	private List<Paciente> paciente;


}
