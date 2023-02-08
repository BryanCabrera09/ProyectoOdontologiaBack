package com.sm.odontologia.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.sm.odontologia.app.entity.Odontologo;
import com.sm.odontologia.app.repository.IOdontologoDao;

@Service
public class OdontologoServiceImpl extends GenericServiceImpl<Odontologo, Long> implements IOdontologoService {

	@Autowired
	IOdontologoDao odontologoRepository;

	@Override
	public CrudRepository<Odontologo, Long> getDao() {
		return odontologoRepository;
	}

	public List<Odontologo> buscarOdontologo(Long id) {
		return odontologoRepository.buscarOdontologo(id);
	}
}
