package com.sm.odontologia.app.repository;

import com.sm.odontologia.app.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPacienteDao extends JpaRepository<Paciente,Long> {
    @Query(value = "Select * from paciente o where o.id_paciente = ?", nativeQuery = true)
    List<Paciente> buscarPaciente(Long id_paciente);
}
