package com.sm.odontologia.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "odontoficha")
public class Ficha_odontologica implements Serializable {

	private static final long serialVersionUID = -3475904368250184896L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ficha;

	@Column(name = "diagnostico", length = 100, nullable = false)
	private String diagnostico;

	@Column(name = "observaciones", length = 50, nullable = false)
	private String observaciones;

	@Column(name = "fecha_consulta", nullable = false)
	private Date fecha_consulta;

	@Column(name = "motivo_consulta", length = 100, nullable = false)
	private String motivo_consulta;

	@Column(name = "antecedentes", length = 100, nullable = false)
	private String antecedentes;

	@Column(name = "examenes", length = 100, nullable = false)
	private String examenes;

	@JsonIgnore
	@OneToMany(mappedBy = "fichaOdontologica")
	private List<Odontograma> odontograma;

	@ManyToOne
	@JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "id_odontologo", referencedColumnName = "id_odontologo")
	private Odontologo odontologo;

	@ManyToOne
	@JoinColumn(name = "id_tratamiento", referencedColumnName = "id_tratamiento")
	private Tratamiento tratamiento;

}
