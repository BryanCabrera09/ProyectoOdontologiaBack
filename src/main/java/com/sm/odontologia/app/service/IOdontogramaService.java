package com.sm.odontologia.app.service;

import com.sm.odontologia.app.entity.Odontograma;

import java.util.List;

public interface IOdontogramaService extends IGenericService<Odontograma, Long> {
	List<Odontograma>buscarOdontograma(Long id_ficha);
}
