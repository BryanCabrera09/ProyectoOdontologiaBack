package com.sm.odontologia.app.repository;

import com.sm.odontologia.app.entity.Odontograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOdontogramaDao extends JpaRepository<Odontograma, Long> {

    @Query(value = "Select * from odontograma o where o.id_ficha = ?", nativeQuery = true)
    List<Odontograma>buscarOdontograma(Long id_ficha);

}
