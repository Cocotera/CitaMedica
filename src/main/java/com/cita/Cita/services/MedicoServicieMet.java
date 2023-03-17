package com.cita.Cita.services;

import com.cita.Cita.DTOs.MedicoDTO;
import com.cita.Cita.models.Medico;

import java.util.List;

public interface MedicoServicieMet {

    List<MedicoDTO> listarMedico();

    MedicoDTO medicobyid(Long id);

    void deleteMedico(Long id);

    MedicoDTO saveMedico(Medico medico);

    MedicoDTO update (Medico request, Long id);
}
