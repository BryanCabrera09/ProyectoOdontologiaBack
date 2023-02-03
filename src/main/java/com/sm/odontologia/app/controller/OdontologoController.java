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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.odontologia.app.entity.Odontologo;
import com.sm.odontologia.app.service.IOdontologoService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/odontologo")
public class OdontologoController {

	@Autowired
	IOdontologoService odontologoService;

	@GetMapping("/listar")
	public ResponseEntity<List<Odontologo>> obtenerLista() {
		try {
			return new ResponseEntity<>(odontologoService.findByAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Odontologo> getById(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<>(odontologoService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/crear")
	public ResponseEntity<Odontologo> crear(@RequestBody Odontologo o) {
		try {
			return new ResponseEntity<>(odontologoService.save(o), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {

		try {
			odontologoService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar al Odontologo");
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*@PutMapping("/actualizar/{id}")
	public ResponseEntity<Odontologo> actualizarUsuario(@PathVariable Long id, @RequestBody Odontologo o) {
		Odontologo Odontologo = odontologoService.findById(id);
		if (Odontologo == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				Odontologo.setNombre(o.getNombre());
				Odontologo.setCarrera(a.getCarrera());
				Odontologo.setDocente(a.getDocente());
				Odontologo.setHora_ini(a.getHora_ini());
				Odontologo.setHora_fin(a.getHora_fin());
				return new ResponseEntity<>(odontologoService.save(Odontologo), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
	}*/
}
