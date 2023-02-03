package com.sm.odontologia.app.repository;

import com.sm.odontologia.app.entity.Ficha_odontologica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFicha_OdontologicaDao extends JpaRepository<Ficha_odontologica, Long> {

    @Query(value = "Select * from odontoficha o where o.id_ficha = ?", nativeQuery = true)
    List<Ficha_odontologica>buscarFicha(Long id_ficha);

}
