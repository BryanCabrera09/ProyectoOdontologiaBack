package com.sm.odontologia.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sm.odontologia.app.entity.Pieza;

public interface IPiezaDao extends JpaRepository<Pieza, Long> {

	@Query(value = "SELECT * FROM pieza WHERE id_pieza = ?", nativeQuery = true)
	List<Pieza> buscarPieza(Long id_pieza);

	@Query(value = "Select p.id_pieza,p.fecha_consulta,p.cara_pieza,p.nombre_tratamiento, per.nombre,per.apellido, o.id_odontograma,p.numero_pieza " +
			"from pieza p join odontograma o on p.id_odontograma=o.id_odontograma join odontoficha f on f.id_ficha=o.id_ficha " +
			"join persona per on per.id_persona=f.id_persona", nativeQuery = true)
	List<Pieza> buscarPiezas();

	@Query(value = "Select p.id_pieza, p.fecha_consulta, p.cara_pieza, p.numero_pieza, p.nombre_tratamiento,per.cedula, per.nombre, per.apellido,o.id_odontograma, o.fecha_odontograma from pieza p join odontograma o on o.id_odontograma=p.id_odontograma join odontoficha f on f.id_ficha=o.id_ficha join persona per on per.id_persona = f.id_persona where per.id_persona = ?", nativeQuery = true)
	List<Pieza>buscarPiezasByIDPersona(Long id_persona);

}
