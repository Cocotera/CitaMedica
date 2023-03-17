package com.cita.Cita.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "MEDICOS")
@Inheritance ( strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "id")

//LOMBOK
@Data //cogemos los getter y los setter
@AllArgsConstructor //constructor con todos los parámetros
@NoArgsConstructor //constructor por defecto
public class Medico extends Usuario {

    @Column(name = "NUMCOLEGIADO", nullable = false)
    private String numColegiado;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "MEDICOSPACIENTES",
            joinColumns = @JoinColumn(name = "MEDICOID"),
            inverseJoinColumns = @JoinColumn(name = "PACIENTEID"))
    private List<Paciente> pacientes;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas;

}
