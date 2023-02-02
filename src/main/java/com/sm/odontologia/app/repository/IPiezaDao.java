package com.sm.odontologia.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sm.odontologia.app.entity.Pieza;

public interface IPiezaDao extends JpaRepository<Pieza, Long> {

	@Query(value = "SELECT * FROM pieza WHERE id_pieza = ?", nativeQuery = true)
	List<Pieza> buscarPieza(Long id_pieza);
}
