package com.sm.odontologia.app.repository;

import com.sm.odontologia.app.entity.Historial_Odontograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IHistorial_OdontogramaDao extends JpaRepository<Historial_Odontograma, Long> {

	@Query(value = "Select * from historialOdontograma o where o.id_historialOdonto = ?", nativeQuery = true)
	List<Historial_Odontograma> buscarHistorialOdonto(Long id_historialOdonto);

}
