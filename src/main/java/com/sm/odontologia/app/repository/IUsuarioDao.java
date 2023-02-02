package com.sm.odontologia.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sm.odontologia.app.entity.Usuario;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

	public Usuario findByUsername(String username);

	Boolean existsByUsername(String username);

	// Metodos Query
	@Query(value = "SELECT * FROM usuario WHERE username = ?", nativeQuery = true)
	List<Usuario> buscarUsername(String username);

}
