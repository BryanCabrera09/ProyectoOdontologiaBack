package com.sm.odontologia.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.sm.odontologia.app.entity.JwtRequest;
import com.sm.odontologia.app.entity.JwtResponse;
import com.sm.odontologia.app.entity.Usuario;
import com.sm.odontologia.app.repository.IRolDao;
import com.sm.odontologia.app.repository.IUsuarioDao;
import com.sm.odontologia.app.security.JwtUtils;
import com.sm.odontologia.app.service.IUsuarioService;
import com.sm.odontologia.app.service.UserDetailsServiceImpl;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthCtrl {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	IUsuarioDao userRepository;

	@Autowired
	IRolDao roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	IUsuarioService usuarioService;

	@PostMapping("/generate-token")
	public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			autenticar(jwtRequest.getUsername(), jwtRequest.getPassword());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new Exception("Usuario no encontrado");
		}

		UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void autenticar(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException exception) {
			throw new Exception("USUARIO DESHABILITADO " + exception.getMessage());
		} catch (BadCredentialsException e) {
			throw new Exception("Credenciales invalidas " + e.getMessage());
		}
	}

	@GetMapping("/actual-usuario")
	public Usuario obtenerUsuarioActual(Principal principal) {
		return (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
	}

}
