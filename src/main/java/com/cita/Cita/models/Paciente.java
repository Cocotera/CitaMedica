package com.cita.Cita.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "PACIENTES")
@Inheritance (strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "ID")

//LOMBOK
@Data //cogemos los getter y los setter
@AllArgsConstructor //constructor con todos los parámetros
@NoArgsConstructor //constructor por defecto
public class Paciente extends Usuario {

    @Column(name = "NSS")
    private String NSS;

    @Column(name = "NUMTARJETA")
    private String numTarjeta;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "DIRECCION")
    private String direccion;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "MEDICOSPACIENTES",
            joinColumns = @JoinColumn(name = "PACIENTEID"),
            inverseJoinColumns = @JoinColumn(name = "MEDICOID"))
    private List<Medico> medicos;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Cita> citas;

}
