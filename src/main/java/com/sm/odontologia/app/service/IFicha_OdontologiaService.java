package com.sm.odontologia.app.service;

import com.sm.odontologia.app.entity.Ficha_odontologica;

public interface IFicha_OdontologiaService extends IGenericService<Ficha_odontologica, Long> {

    Ficha_odontologica buscarFicha(Long id_persona);

}
