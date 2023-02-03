package com.sm.odontologia.app.service;

import com.sm.odontologia.app.entity.Historial_Odontograma;
import com.sm.odontologia.app.repository.IHistorial_OdontogramaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Historial_OdontogramaServiceImpl extends GenericServiceImpl<Historial_Odontograma,Long> implements IHistorial_OdontogramaService{
    @Autowired
    IHistorial_OdontogramaDao historialOdontoRepository;
    @Override
    public CrudRepository<Historial_Odontograma, Long> getDao() {
        return historialOdontoRepository;
    }

    public List<Historial_Odontograma>buscarHistorialO(Long id){
        return historialOdontoRepository.buscarHistorialOdonto(id);
    }
}
