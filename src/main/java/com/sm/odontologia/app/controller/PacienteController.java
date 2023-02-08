package com.sm.odontologia.app.controller;

import com.sm.odontologia.app.entity.Odontologo;
import com.sm.odontologia.app.entity.Paciente;
import com.sm.odontologia.app.service.IOdontologoService;
import com.sm.odontologia.app.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

    @Autowired
    IPacienteService pacienteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Paciente>> obtenerLista() {
        try {
            return new ResponseEntity<>(pacienteService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Paciente> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(pacienteService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Paciente> crear(@RequestBody Paciente p) {
        try {
            return new ResponseEntity<>(pacienteService.save(p), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}" )
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            pacienteService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar al paciente");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
/*
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Odontologo> actualizarPaciente(@PathVariable Long id, @RequestBody Paciente P) {
        Paciente paciente = pacienteService.findById(id);
        if (paciente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                paciente.setNombre(o.getNombre());
                paciente.setCarrera(a.getCarrera());
                paciente.setDocente(a.getDocente());
                paciente.setHora_ini(a.getHora_ini());
                paciente.setHora_fin(a.getHora_fin());
                return new ResponseEntity<>(pacienteService.save(paciente), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }*/
}
