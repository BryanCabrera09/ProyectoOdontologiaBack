package com.sm.odontologia.app.repository;

import com.sm.odontologia.app.entity.Odontograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOdontogramaDao extends JpaRepository<Odontograma, Long> {

    @Query(value = "Select * from odontograma o join odontoficha f on f.id_ficha=o.id_ficha  where o.id_ficha = ? AND f.habilitado = true order by o.id_odontograma DESC", nativeQuery = true)
    List<Odontograma>buscarOdontograma(Long id_ficha);

    @Query(value="Select * from odontograma order by odontograma.id_odontograma DESC LIMIT 1" , nativeQuery = true)
    Odontograma buscarOdon();

}
