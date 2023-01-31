package com.sm.odontologia.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.sm.odontologia.app.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

	public Usuario findByUsername(String cedula);
}
