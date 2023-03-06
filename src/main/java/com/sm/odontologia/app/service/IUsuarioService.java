package com.sm.odontologia.app.service;

import java.util.List;

import com.sm.odontologia.app.entity.Usuario;

public interface IUsuarioService extends IGenericService<Usuario, Long> {

	public Usuario save(Usuario usuario);

	public Usuario search(String username);

	public void delete(Long id);

	public List<Usuario> getUsuarios();

	public List<Usuario> buscarUsuario(String cedula);

	public List<Usuario> listarUsuario();

}
