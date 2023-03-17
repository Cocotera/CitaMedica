package com.cita.Cita.DTOs;

import lombok.*;
import java.util.Date;

//LOMBOK
@Data //cogemos los getter y los setter
@AllArgsConstructor //constructor con todos los parámetros
@NoArgsConstructor //constructor por defecto
public class CitaDTOSimple{
    private Long id;
    private Date fechaHora;
    private String motivoCita;

}
