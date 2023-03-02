package com.sm.odontologia.app.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

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

	@Column(name = "nombre_tratamiento", length = 30, nullable = false)
	private String tratamiento;

	@Column(name = "fecha_consulta")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDateTime fecha_creacion;

	@ManyToOne
	@JoinColumn(name = "id_odontograma", referencedColumnName = "id_odontograma")
	private Odontograma odontograma;
}
