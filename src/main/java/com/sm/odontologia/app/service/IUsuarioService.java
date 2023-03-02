package com.sm.odontologia.app.service;

import java.util.List;

import com.sm.odontologia.app.entity.Usuario;

public interface IUsuarioService {

	public Usuario save(Usuario usuario);

	public Usuario search(String cedula);

	public void delete(Long id);

	public List<Usuario> getUsuarios();

	public List<Usuario> buscarUsuario(String cedula);

}
