package com.sm.odontologia.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.sm.odontologia.app.entity.Tratamiento;
import com.sm.odontologia.app.repository.ITratamientoDao;

@Service
public class TratamientoServiceImpl extends GenericServiceImpl<Tratamiento, Long> implements ITratamientoService {

	@Autowired
	ITratamientoDao tratamientoRepository;

	@Override
	public CrudRepository<Tratamiento, Long> getDao() {
		return tratamientoRepository;
	}

	public List<Tratamiento> buscarPieza(Long id) {
		return tratamientoRepository.buscarTratamiento(id);
	}
}
