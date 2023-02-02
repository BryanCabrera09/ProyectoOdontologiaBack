package com.sm.odontologia.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sm.odontologia.app.entity.Tratamiento;

public interface ITratamientoDao extends JpaRepository<Tratamiento, Long> {

	@Query(value = "SELECT * FROM tratamiento WHERE id_tratamiento = ?", nativeQuery = true)
	List<Tratamiento> buscarTratamiento(Long id_tratamiento);
}
