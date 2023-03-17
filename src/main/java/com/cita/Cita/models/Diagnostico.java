package com.cita.Cita.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name="DIAGNOSTICOS")
@Inheritance (strategy = InheritanceType.JOINED)

//LOMBOK
@Data //cogemos los getter y los setter
@AllArgsConstructor //constructor con todos los parámetros
@NoArgsConstructor //constructor por defecto
public class Diagnostico {

    @Id
    @GeneratedValue ( strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "VALORACION", nullable = false)
    private String valoracionEspecialista;

    @Column(name = "ENFERMEDAD", nullable = false)
    private String enfermedad;

    @OneToOne()
    @JoinColumn(name="CITAID")
    private Cita cita;
}
