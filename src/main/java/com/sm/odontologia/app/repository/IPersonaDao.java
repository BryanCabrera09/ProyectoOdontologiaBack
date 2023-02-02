package com.sm.odontologia.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sm.odontologia.app.entity.Persona;

public interface IPersonaDao extends JpaRepository<Persona, Long> {

	public Persona findByCedula(String cedula);

	Boolean existsByCedula(String cedula);

	public Persona findByEmail(String email);

	Boolean existsByEmail(String email);

	@Query(value = "Select * from persona p where p.cedula = ?", nativeQuery = true)
	List<Persona> buscarPersona(String cedula);
}
