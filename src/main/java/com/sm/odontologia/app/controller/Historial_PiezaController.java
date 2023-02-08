package com.sm.odontologia.app.controller;

import com.sm.odontologia.app.entity.Historial_Pieza;
import com.sm.odontologia.app.service.IHistorial_PiezaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/historialPieza")
public class Historial_PiezaController {

    @Autowired
    IHistorial_PiezaService historialPiezaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Historial_Pieza>> obtenerLista() {
        try {
            return new ResponseEntity<>(historialPiezaService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Historial_Pieza> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(historialPiezaService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Historial_Pieza> crear(@RequestBody Historial_Pieza h) {
        try {
            return new ResponseEntity<>(historialPiezaService.save(h), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            historialPiezaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar el historial de pieza");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
/*
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Odontograma> actualizarOdontograma(@PathVariable Long id, @RequestBody Odontograma o) {
        Odontograma odontograma = odontogramaService.findById(id);
        if (odontograma == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                odontograma.setDiagnostico(f.getDiagnostico());
                odontograma.setObservaciones(f.getObservaciones());
                odontograma.setFecha_consulta(f.getFecha_consulta());
                odontograma.setMotivo_consulta(f.getMotivo_consulta());
                odontograma.setAntecedentes(f.getAntecedentes());
                odontograma.setExamenes(f.getExamenes());
                return new ResponseEntity<>(odontogramaService.save(odontograma), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }*/
}
