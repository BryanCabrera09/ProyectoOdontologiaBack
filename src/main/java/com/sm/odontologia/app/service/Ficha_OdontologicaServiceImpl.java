package com.sm.odontologia.app.service;

import com.sm.odontologia.app.entity.Ficha_odontologica;
import com.sm.odontologia.app.repository.IFicha_OdontologicaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ficha_OdontologicaServiceImpl extends GenericServiceImpl<Ficha_odontologica, Long> implements IFicha_OdontologiaService {

    @Autowired
    IFicha_OdontologicaDao fichaodontoRepository;

    @Override
    public CrudRepository<Ficha_odontologica, Long> getDao() {
        return fichaodontoRepository;
    }

    @Override
    public Ficha_odontologica buscarFicha(Long id_persona) {
        return fichaodontoRepository.buscarFicha(id_persona);
    }

//    public List<Ficha_odontologica> buscarFichaOdonto(Long id) {
//        return fichaodontoRepository.buscarFicha(id);
//
//    }


}
