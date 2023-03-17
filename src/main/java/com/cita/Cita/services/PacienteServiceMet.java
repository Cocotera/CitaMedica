package com.cita.Cita.services;

import com.cita.Cita.DTOs.PacienteDTO;
import com.cita.Cita.models.Paciente;

import java.util.List;

public interface PacienteServiceMet {

    List<PacienteDTO> listarPaciente();

    PacienteDTO pacientebyid(Long id);

    void deletePaciente(Long id);

    PacienteDTO savePaciente(Paciente paciente);

    PacienteDTO update (Paciente request, Long id);
}
