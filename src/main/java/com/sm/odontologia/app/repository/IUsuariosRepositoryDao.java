package com.sm.odontologia.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sm.odontologia.app.entity.Usuario;

@Repository
public interface IUsuariosRepositoryDao extends JpaRepository<Usuario, Long> {

	public Usuario findByUsername(String username);

	public Usuario findByCorreo(String correo);

	Boolean existsByUsername(String username);

	Boolean existsByCorreo(String correo);

	// Metodos Query
	@Query(value = "SELECT * FROM usuarios WHERE username = ?", nativeQuery = true)
	List<Usuario> buscarUsername(String username);

}
