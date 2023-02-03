package com.sm.odontologia.app.service;

import com.sm.odontologia.app.entity.Persona;

public interface IPersonaService extends IGenericService<Persona, Long> {

	public Persona search(String cedula);
}
