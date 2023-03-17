package com.cita.Cita.services;

import com.cita.Cita.DTOs.CitaDTO;
import com.cita.Cita.DTOs.DiagnosticoDTO;
import com.cita.Cita.models.Cita;
import com.cita.Cita.models.Diagnostico;

import java.util.List;

public interface DiagnosticoServiceMet {

    List<DiagnosticoDTO> listarDiagnostico();

    DiagnosticoDTO diagnosticoByid(Long id);

    void deletediagnostico(Long id);

    DiagnosticoDTO saveDiagnostico(Diagnostico diagnostico);

    DiagnosticoDTO update (Diagnostico request, Long id);

}
