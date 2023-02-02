package com.sm.odontologia.app.service;

import java.util.List;
import java.util.Set;

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
	public Usuario search(String cedula) {
		return UsuarioDao.findByUsername(cedula);
	}

	@Override
	public void delete(Long id) {
		UsuarioDao.deleteById(id);
	}

	@Override
	public List<Usuario> getUsuarios() {
		return (List<Usuario>) UsuarioDao.findAll();
	}

	@Override
	public List<Usuario> buscarUsuario(String cedula) {
		return ((IUsuarioService) UsuarioDao).buscarUsuario(cedula);
	}

}
