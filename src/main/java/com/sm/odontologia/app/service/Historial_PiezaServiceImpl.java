package com.sm.odontologia.app.service;

import com.sm.odontologia.app.entity.Historial_Pieza;
import com.sm.odontologia.app.repository.IHistorial_PiezaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Historial_PiezaServiceImpl extends GenericServiceImpl<Historial_Pieza, Long> implements IHistorial_PiezaService {

    @Autowired
    IHistorial_PiezaDao historialPiezaRepository;

    @Override
    public CrudRepository<Historial_Pieza, Long> getDao() {
        return historialPiezaRepository;
    }

    public List<Historial_Pieza>buscarHistorialP(Long id){
        return historialPiezaRepository.buscarHistorialP(id);
    }
}
