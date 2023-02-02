package com.sm.odontologia.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sm.odontologia.app.entity.Odontologo;

public interface IOdontologoDao extends JpaRepository<Odontologo, Long> {

	@Query(value = "Select * from odontologo o where o.id_odontologo = ?", nativeQuery = true)
	List<Odontologo> buscarOdontologo(Long id_odontologo);
}
