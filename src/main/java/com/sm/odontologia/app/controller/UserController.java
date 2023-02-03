package com.sm.odontologia.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.sm.odontologia.app.entity.Rol;
import com.sm.odontologia.app.entity.Usuario;
import com.sm.odontologia.app.entity.UsuarioRol;
import com.sm.odontologia.app.repository.IUsuarioDao;
import com.sm.odontologia.app.service.IUsuarioService;

import java.util.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UserController {

	@Autowired
	IUsuarioDao userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/users/all")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<List<Usuario>> getUsuarios() {
		return ResponseEntity.ok().body(usuarioService.getUsuarios());
	}

	@GetMapping("/search/{username}")
	public Usuario obtenerUsuario(@PathVariable("username") String username) {
		return usuarioService.search(username);
	}

	@DeleteMapping("/delete/{usuarioId}")
	public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId) {
		usuarioService.delete(usuarioId);
	}

	@PostMapping("/")
	public Usuario registerUser(@RequestBody Usuario usuario) throws Exception {

		Rol rol = new Rol();
		Set<UsuarioRol> userRoles = new HashSet<>();

		// VERIFICAR SI HAY EXISTENCIA DE USUARIO EN NUESTRA BD..
		if (!userRepository.existsByUsername(usuario.getUsername())) {

			rol.setRolNombre("PACIENTE");
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			UsuarioRol usuarioRol = new UsuarioRol();
			usuarioRol.setUsuario(usuario);
			usuarioRol.setRol(rol);

			userRoles.add(usuarioRol);
			return usuarioService.save(usuario, userRoles);

		} else {

			throw new Exception("Error: Usuario ya esta en la BD!");
		}

	}

}
