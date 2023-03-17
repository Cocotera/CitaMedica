package com.cita.Cita.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name= "USUARIOS")
@Inheritance(strategy = InheritanceType.JOINED)

//LOMBOK
@Data //cogemos los getter y los setter
@AllArgsConstructor //constructor con todos los parámetros
@NoArgsConstructor //constructor por defecto
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column (name="NOMBRE")
    private String nombre;

    @Column (name="APELLIDOS")
    private String apellidos;

    @Column (name="USUARIO")
    private String usuario;

    @Column (name="CLAVE")
    private String clave;

}
