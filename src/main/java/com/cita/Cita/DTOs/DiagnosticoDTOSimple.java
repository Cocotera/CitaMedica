package com.cita.Cita.DTOs;

import lombok.*;

//LOMBOK
@Data //cogemos los getter y los setter
@AllArgsConstructor //constructor con todos los parámetros
@NoArgsConstructor //constructor por defecto
public class DiagnosticoDTOSimple{

    private Long id;
    private String valoracionEspecialista;
    private String enfermedad;

}
