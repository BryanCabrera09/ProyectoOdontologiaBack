package com.sm.odontologia.app.service;

import com.sm.odontologia.app.entity.Odontograma;
import com.sm.odontologia.app.repository.IOdontogramaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontogramaServiceImpl extends GenericServiceImpl<Odontograma, Long> implements IOdontogramaService {
    @Autowired
    IOdontogramaDao odontogramaRepository;


    @Override
    public CrudRepository<Odontograma, Long> getDao() {
        return odontogramaRepository;

    }

    public List<Odontograma> buscarOdontograma(Long id) {
        return odontogramaRepository.buscarOdontograma(id);
    }
}
