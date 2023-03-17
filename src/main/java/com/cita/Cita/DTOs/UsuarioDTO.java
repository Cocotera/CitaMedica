package com.cita.Cita.DTOs;

import lombok.*;

//LOMBOK
@Data //cogemos los getter y los setter
@AllArgsConstructor //constructor con todos los parámetros
@NoArgsConstructor //constructor por defecto
public class UsuarioDTO {

    private Long id;
    private String usuario;
    private String nombre;
    private String apellidos;
    private String clave;

}
