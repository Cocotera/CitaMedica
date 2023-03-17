package com.cita.Cita.services;

import com.cita.Cita.DTOs.CitaDTO;
import com.cita.Cita.DTOs.MedicoDTO;
import com.cita.Cita.models.Cita;
import com.cita.Cita.models.Medico;

import java.util.List;

public interface CitaServiceMet {

    List<CitaDTO> listarCitas();

    CitaDTO citaByid(Long id);

    void deletecita(Long id);

    CitaDTO saveCita(Cita cita);

    CitaDTO update (Cita request, Long id);
}
