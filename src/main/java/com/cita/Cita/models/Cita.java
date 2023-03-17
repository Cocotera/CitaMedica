package com.cita.Cita.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

//JPA
@Entity
@Table(name = "CITAS")
@Inheritance(strategy = InheritanceType.JOINED)

//LOMBOK
@Data //cogemos los getter y los setter
@AllArgsConstructor //constructor con todos los parámetros
@NoArgsConstructor //constructor por defecto
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FECHA_HORA", nullable = false)
    private Date fechaHora;

    @Column(name = "MOTIVOCITA", nullable = false)
    private String motivoCita;

    @ManyToOne
    @JoinColumn(name = "MEDICOID")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "PACIENTEID")
    private Paciente paciente;

    @OneToOne(mappedBy = "cita")
    @JoinColumn(name = "ID")
    private Diagnostico diagnostico;

}
