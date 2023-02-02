package com.sm.odontologia.app.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "paciente")
public class Paciente extends Persona implements Serializable {
    private static final long serialVersionUID = -8743356424363980633L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id_paciente;

    @ManyToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Persona persona;

}