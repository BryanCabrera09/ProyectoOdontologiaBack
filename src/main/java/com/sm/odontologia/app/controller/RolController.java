package com.sm.odontologia.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.odontologia.app.entity.Rol;
import com.sm.odontologia.app.service.IRolService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/rol")
public class RolController {

	@Autowired
	IRolService rolService;

	@PostMapping("/crear")
	public ResponseEntity<Rol> crear(@RequestBody Rol r) {
		try {
			return new ResponseEntity<>(rolService.save(r), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Rol>> obtenerLista() {
		try {
			return new ResponseEntity<>(rolService.findByAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Rol> getById(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<>(rolService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
