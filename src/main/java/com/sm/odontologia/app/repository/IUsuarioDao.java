package com.sm.odontologia.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sm.odontologia.app.entity.Usuario;

@Repository
public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

	public Usuario findByUsername(String username);

	Boolean existsByUsername(String username);

	// Metodos Query
	@Query(value = "SELECT * FROM usuario WHERE username = ?", nativeQuery = true)
	List<Usuario> buscarUsername(String username);

	public boolean existsByPassword(String password);

	@Query(value = "Select u.username, p.cedula,p.nombre, p.apellido, u.enabled, u.id_usuario, u.password, u.id_persona, u.rol_id, r.rol_nombre from usuario u join persona p on u.id_persona = p.id_persona join roles r on u.rol_id = r.rol_id", nativeQuery = true)
	List<Usuario>listarUsuario();


}
