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

import com.sm.odontologia.app.entity.Tratamiento;
import com.sm.odontologia.app.service.ITratamientoService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/tratamiento")
public class TratamientoController {

	@Autowired
	ITratamientoService tratamientoService;

	@GetMapping("/listar")
	public ResponseEntity<List<Tratamiento>> obtenerLista() {
		try {
			return new ResponseEntity<>(tratamientoService.findByAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Tratamiento> getById(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<>(tratamientoService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/crear")
	public ResponseEntity<Tratamiento> crear(@RequestBody Tratamiento t) {
		try {
			return new ResponseEntity<>(tratamientoService.save(t), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		try {
			tratamientoService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar el Tratamiento");
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Tratamiento> actualizarUsuario(@PathVariable Long id, @RequestBody Tratamiento t) {
		Tratamiento tratamiento = tratamientoService.findById(id);
		if (tratamiento == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				tratamiento.setNombre(t.getNombre());
				tratamiento.setDescripcion(t.getDescripcion());
				return new ResponseEntity<>(tratamientoService.save(tratamiento), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
	}
}
