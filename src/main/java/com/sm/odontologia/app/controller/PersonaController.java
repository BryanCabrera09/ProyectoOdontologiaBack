package com.sm.odontologia.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.odontologia.app.entity.Persona;
import com.sm.odontologia.app.service.IPersonaService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/persona")
public class PersonaController {

	@Autowired
	IPersonaService personaService;

	@GetMapping("/listar")
	public ResponseEntity<List<Persona>> obtenerLista() {
		try {
			return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/listarP")
	public ResponseEntity<List<Persona>> obtenerPacientes() {
		try {
			return new ResponseEntity<>(personaService.listar(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Persona> getById(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<>(personaService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/buscarcedul/{cedula}")
	public Persona obtenerUsuario(@PathVariable("cedula") String cedula) {
		return personaService.search(cedula);
	}

	@PostMapping("/crear")
	public ResponseEntity<Persona> crear(@RequestBody Persona p) {
		try {
			return new ResponseEntity<>(personaService.save(p), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {

		try {
			personaService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar a Persona");
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Persona> actualizarUsuario(@PathVariable Long id, @RequestBody Persona p) {
		Persona persona = personaService.findById(id);
		if (persona == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				persona.setNombre(p.getNombre());
				persona.setApellido(p.getApellido());
				persona.setEmail(p.getEmail());
				persona.setGenero(p.getGenero());
				persona.setCelular(p.getCelular());
				persona.setDireccion(p.getDireccion());
				persona.setTelefono(p.getTelefono());
				persona.setEnabled(p.isEnabled());
				return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
}
