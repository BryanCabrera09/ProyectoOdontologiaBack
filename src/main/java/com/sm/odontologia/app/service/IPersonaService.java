package com.sm.odontologia.app.service;

import com.sm.odontologia.app.entity.Persona;

import java.util.List;

public interface IPersonaService extends IGenericService<Persona, Long> {

	public Persona search(String cedula);

	public List<Persona> listar();
}
