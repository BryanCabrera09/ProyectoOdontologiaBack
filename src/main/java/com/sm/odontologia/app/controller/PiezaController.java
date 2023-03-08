package com.sm.odontologia.app.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

import com.sm.odontologia.app.entity.Pieza;
import com.sm.odontologia.app.service.IPiezaService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/pieza")
public class PiezaController {

	@Autowired
	IPiezaService piezaService;

	@GetMapping("/listar")
	public ResponseEntity<List<Pieza>> obtenerLista() {
		try {
			return new ResponseEntity<>(piezaService.findByAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/listarP")
	public ResponseEntity<List<Pieza>> obtenerListaConcat() {
		try {
			return new ResponseEntity<>(piezaService.listarPiezas(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Pieza> getById(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<>(piezaService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/crear")
	public ResponseEntity<Pieza> crear(@RequestBody Pieza p) {
		try {
			p.setFecha_creacion(LocalDateTime.now());
			return new ResponseEntity<>(piezaService.save(p), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {

		try {
			piezaService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar la Pieza");
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Pieza> actualizarUsuario(@PathVariable Long id, @RequestBody Pieza p) {
		Pieza pieza = piezaService.findById(id);
		if (pieza == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				pieza.setNumero_pieza(p.getNumero_pieza());
				pieza.setCara_pieza(p.getCara_pieza());
				pieza.setTratamiento(p.getTratamiento());
				return new ResponseEntity<>(piezaService.save(pieza), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
	}
}
