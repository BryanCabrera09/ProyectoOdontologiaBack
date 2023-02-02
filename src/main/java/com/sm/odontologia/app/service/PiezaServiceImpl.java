package com.sm.odontologia.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.sm.odontologia.app.entity.Pieza;
import com.sm.odontologia.app.repository.IPiezaDao;

@Service
public class PiezaServiceImpl extends GenericServiceImpl<Pieza, Long> implements IPiezaService {

	@Autowired
	IPiezaDao piezaRepository;

	@Override
	public CrudRepository<Pieza, Long> getDao() {
		return piezaRepository;
	}

	public List<Pieza> buscarPieza(Long id) {
		return piezaRepository.buscarPieza(id);
	}
}
