package com.cita.Cita.services;

import com.cita.Cita.DTOs.CitaDTO;
import com.cita.Cita.DTOs.MedicoDTO;
import com.cita.Cita.models.Cita;
import com.cita.Cita.models.Diagnostico;
import com.cita.Cita.models.Medico;
import com.cita.Cita.repository.CitaRepository;
import com.cita.Cita.repository.DiagnosticoRepository;
import com.cita.Cita.repository.MedicoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService implements CitaServiceMet{

    @Autowired
    private CitaRepository citarep;

    @Autowired
    private DiagnosticoRepository diagRep;

    private ModelMapper maper = new ModelMapper();

    //FUNCIÓN PARA NO TENER QUE REPETIR LA MISMA LINEA DE CÓDIGO TANTAS VECES
    private CitaDTO convertirDTO(Cita t){
        CitaDTO dto = maper.map(t, CitaDTO.class);
        return dto;
    }

    @Override
    public List<CitaDTO> listarCitas() {
        List<Cita> citas = citarep.findAll();
        List<CitaDTO> dtO = new LinkedList<>();
        for(Cita c: citas){
            dtO.add(convertirDTO(c));
        }
        return dtO;
    }

    @Override
    public CitaDTO citaByid(Long id) {
        Cita c = citarep.findById(id).orElse(null);
        if(c == null){
            throw new RuntimeException("Cita no encontrada");
        }else{
            return convertirDTO(c);
        }
    }

    @Override
    public void deletecita(Long id) {
        if(citarep.existsById(id)){
            citarep.deleteById(id);
        }else{
            throw new RuntimeException("La cita no existe");
        }
    }

    @Override
    public CitaDTO saveCita(Cita newcita) {
        citarep.save(newcita);
        return convertirDTO(newcita);
    }

    @Override
    public CitaDTO update(Cita request, Long id) {
        Optional<Cita> busqueda = citarep.findById(id);
        if( busqueda != null){
            Cita cit = busqueda.get();
            cit.setFechaHora(request.getFechaHora());
            cit.setMotivoCita(request.getMotivoCita());
            cit.setMedico(request.getMedico());
            cit.setPaciente(request.getPaciente());
            citarep.save(cit);
            return convertirDTO(cit);
        }else{
            throw new RuntimeException("Cita que busca no existe");
        }
    }
}
