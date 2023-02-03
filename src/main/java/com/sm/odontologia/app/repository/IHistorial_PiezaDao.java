package com.sm.odontologia.app.repository;

import com.sm.odontologia.app.entity.Historial_Pieza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IHistorial_PiezaDao extends JpaRepository<Historial_Pieza,Long> {
    @Query(value = "Select * from historialPieza o where o.id_historialPieza = ?", nativeQuery = true)
    List<Historial_Pieza>buscarHistorialP(Long id_historialPieza);

}
