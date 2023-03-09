package com.sm.odontologia.app.service;

import com.sm.odontologia.app.entity.Pieza;

import java.util.List;

public interface IPiezaService extends IGenericService<Pieza, Long> {

    List<Pieza>listarPiezas();

    List<Pieza>buscarPiezasByIDPersona(Long id_persona);
}
