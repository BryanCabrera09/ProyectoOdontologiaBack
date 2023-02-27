package com.sm.odontologia.app.service;

import java.util.List;
import java.util.Set;

import com.sm.odontologia.app.entity.Usuario;
import com.sm.odontologia.app.entity.UsuarioRol;

public interface IUsuarioService {

	public Usuario save(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

	public Usuario search(String cedula);

	public void delete(Long id);

	public List<Usuario> getUsuarios();

	public List<Usuario> buscarUsuario(String cedula);

}
