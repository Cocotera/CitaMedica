package com.cita.Cita.DTOs;

import lombok.*;
import java.util.*;

//LOMBOK
@Data //cogemos los getter y los setter
@AllArgsConstructor //constructor con todos los parámetros
@NoArgsConstructor //constructor por defecto
public class MedicoDTO extends UsuarioDTO{

    private String numColegiado;
    private List<PacienteDTO> pacientes;
    private List<CitaDTOSimple> citas;

}
