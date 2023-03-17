package com.cita.Cita.DTOs;

import lombok.*;
import java.util.*;

//LOMBOK
@Data //cogemos los getter y los setter
@AllArgsConstructor //constructor con todos los parámetros
@NoArgsConstructor //constructor por defecto
public class PacienteDTO extends UsuarioDTO{

    private String NSS;

    private String numTarjeta;

    private String telefono;

    private String direccion;

    //private List<MedicoDTOSimple> medicos;

    private List<CitaDTOSimple> citas;

}
