package com.sm.odontologia.app.controller;

import com.sm.odontologia.app.entity.Ficha_odontologica;
import com.sm.odontologia.app.service.IFicha_OdontologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/ficha")
public class Ficha_OdontoController {

	@Autowired
	IFicha_OdontologiaService ficha_odontologiaService;

	@GetMapping("/listar")
	public ResponseEntity<List<Ficha_odontologica>> obtenerLista() {
		try {
			return new ResponseEntity<>(ficha_odontologiaService.findByAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Ficha_odontologica> getById(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<>(ficha_odontologiaService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/crear")
	public ResponseEntity<Ficha_odontologica> crear(@RequestBody Ficha_odontologica f) {
		try {
			return new ResponseEntity<>(ficha_odontologiaService.save(f), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {

		try {
			ficha_odontologiaService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar la ficha");
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Ficha_odontologica> actualizarFicha(@PathVariable Long id,
			@RequestBody Ficha_odontologica f) {
		Ficha_odontologica fichaOdontologica = ficha_odontologiaService.findById(id);
		if (fichaOdontologica == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				fichaOdontologica.setDiagnostico(f.getDiagnostico());
				fichaOdontologica.setObservaciones(f.getObservaciones());
				fichaOdontologica.setFecha_consulta(f.getFecha_consulta());
				fichaOdontologica.setMotivo_consulta(f.getMotivo_consulta());
				return new ResponseEntity<>(ficha_odontologiaService.save(fichaOdontologica), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
	}
}
