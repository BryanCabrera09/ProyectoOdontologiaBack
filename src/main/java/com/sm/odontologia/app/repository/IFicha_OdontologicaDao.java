package com.sm.odontologia.app.repository;

import com.sm.odontologia.app.entity.Ficha_odontologica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFicha_OdontologicaDao extends JpaRepository<Ficha_odontologica, Long> {

        @Query(value = "Select id_ficha,diagnostico,fecha_consulta,motivo_consulta,observaciones,p.id_persona,o.habilitado from odontoficha o join persona p on p.id_persona=o.id_persona where o.id_persona =? and habilitado=1", nativeQuery = true)
    Ficha_odontologica buscarFicha(@Param("id_persona") Long id_persona);

}
