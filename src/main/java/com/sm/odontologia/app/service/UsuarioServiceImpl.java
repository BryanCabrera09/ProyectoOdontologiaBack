package com.sm.odontologia.app.service;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.odontologia.app.entity.Usuario;
import com.sm.odontologia.app.entity.UsuarioRol;
import com.sm.odontologia.app.repository.IRolDao;
import com.sm.odontologia.app.repository.IUsuarioDao;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao UsuarioDao;

	@Autowired
	private IRolDao rolRepository;

	@Override
	public Usuario save(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
		Usuario usuarioLocal = UsuarioDao.findByUsername(usuario.getUsername());
		if (usuarioLocal != null) {
			System.out.println("El usuario ya existe");
			throw new Exception("El usuario ya esta presente");
		} else {
			for (UsuarioRol usuarioRol : usuarioRoles) {
				rolRepository.save(usuarioRol.getRol());
			}
			usuario.getUsuarioRoles().addAll(usuarioRoles);
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
