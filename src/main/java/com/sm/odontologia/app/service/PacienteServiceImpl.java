package com.sm.odontologia.app.service;

import com.sm.odontologia.app.entity.Paciente;
import com.sm.odontologia.app.repository.IPacienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl extends GenericServiceImpl<Paciente, Long> implements IPacienteService {
    @Autowired
    IPacienteDao pacienteDao;

    @Override
    public CrudRepository<Paciente, Long> getDao() {
        return pacienteDao;
    }

    public List<Paciente> buscarPaciente(Long id) {
        return pacienteDao.buscarPaciente(id);
    }

}
