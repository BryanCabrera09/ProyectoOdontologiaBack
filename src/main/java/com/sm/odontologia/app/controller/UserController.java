package com.sm.odontologia.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.sm.odontologia.app.entity.Persona;
import com.sm.odontologia.app.entity.Usuario;
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
	private IUsuarioService usuarioService;

	@GetMapping("/users/all")
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

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario u) {
		Usuario usuario = usuarioService.findById(id);
		if (usuario == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				usuario.setUsername(u.getUsername());
				usuario.setPassword(u.getPassword());
				usuario.setEnabled(u.isEnabled());
				return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@PostMapping("/signin")
	public ResponseEntity<?> IniciarSesion(@RequestBody Usuario usuario) throws Exception {
		// COMPROBAR SI sEXISTE EL NOMBRE DE USUARIO EN NUESTRA BD..
		if (userRepository.existsByUsername(usuario.getUsername())) {

			// COMPROBAR SI CONINCIDE USUARIO Y CONTRASEÑA EN NUESTRA BD..
			if (userRepository.existsByPassword(usuario.getPassword())) {

				return null;

			} else {

				throw new Exception("Error: Datos Erroneos!");
			}

		} else {

			throw new Exception("Error: Datos Erroneos!");
		}
	}

	@PostMapping("/signup")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) throws Exception {

		// VERIFICAR SI HAY EXISTENCIA DE USUARIO EN NUESTRA BD..
		if (!userRepository.existsByUsername(usuario.getUsername())) {

			return usuarioService.save(usuario);

		} else {

			throw new Exception("Error: Usuario ya esta en la BD!");
		}

	}

}
