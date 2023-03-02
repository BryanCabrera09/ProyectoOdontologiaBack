package com.sm.odontologia.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.sm.odontologia.app.entity.Rol;
import com.sm.odontologia.app.repository.IRolDao;

@Service
public class RolServiceImpl extends GenericServiceImpl<Rol, Long> implements IRolService {

	@Autowired
	IRolDao rolRepository;

	@Override
	public CrudRepository<Rol, Long> getDao() {
		return rolRepository;
	}

}
