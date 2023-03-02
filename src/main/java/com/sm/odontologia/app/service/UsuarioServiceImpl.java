package com.sm.odontologia.app.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.odontologia.app.entity.Usuario;
import com.sm.odontologia.app.repository.IUsuarioDao;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao UsuarioDao;

	@Override
	public Usuario save(Usuario usuario) {
		Usuario usuarioLocal = UsuarioDao.findByUsername(usuario.getUsername());
		if (usuarioLocal != null) {
			System.out.println("El usuario ya existe");
		} else {

			usuarioLocal = UsuarioDao.save(usuario);
		}
		return usuarioLocal;
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario search(String username) {
		return UsuarioDao.findByUsername(username);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		UsuarioDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> getUsuarios() {
		return (List<Usuario>) UsuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> buscarUsuario(String username) {
		return ((IUsuarioService) UsuarioDao).buscarUsuario(username);
	}

}
