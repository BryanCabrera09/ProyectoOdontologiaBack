package com.sm.odontologia.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.sm.odontologia.app.entity.Persona;
import com.sm.odontologia.app.repository.IPersonaDao;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements IPersonaService {

	@Autowired
	IPersonaDao personaRepository;

	@Override
	public CrudRepository<Persona, Long> getDao() {
		return personaRepository;
	}

	public Persona buscarCedula(String cedula) {
		return personaRepository.findByCedula(cedula);
	}

	@Override
	public Persona search(String cedula) {
		
		return personaRepository.findByCedula(cedula);
	}
}
