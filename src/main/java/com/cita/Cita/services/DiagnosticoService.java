package com.cita.Cita.services;

import com.cita.Cita.DTOs.CitaDTO;
import com.cita.Cita.DTOs.DiagnosticoDTO;
import com.cita.Cita.DTOs.PacienteDTO;
import com.cita.Cita.models.Cita;
import com.cita.Cita.models.Diagnostico;
import com.cita.Cita.models.Paciente;
import com.cita.Cita.repository.CitaRepository;
import com.cita.Cita.repository.DiagnosticoRepository;
import com.cita.Cita.repository.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class DiagnosticoService implements DiagnosticoServiceMet{

    @Autowired
    private DiagnosticoRepository diagRep;

    @Autowired
    private CitaRepository citarep;

    private ModelMapper maper = new ModelMapper();

    //FUNCIÓN PARA NO TENER QUE REPETIR LA MISMA LINEA DE CÓDIGO TANTAS VECES
    private DiagnosticoDTO convertirDTO(Diagnostico p){
        DiagnosticoDTO dto = maper.map(p, DiagnosticoDTO.class);
        return dto;
    }
    @Override
    public List<DiagnosticoDTO> listarDiagnostico() {
        List<Diagnostico> diag = diagRep.findAll();
        List<DiagnosticoDTO> dtO = new LinkedList<>();
        for(Diagnostico d: diag){
            dtO.add(convertirDTO(d));
        }
        return dtO;
    }

    @Override
    public DiagnosticoDTO diagnosticoByid(Long id) {
        Diagnostico d = diagRep.findById(id).orElse(null);
        if(d == null){
            throw new RuntimeException("Diagnostico no encontrada");
        }else{
            return convertirDTO(d);
        }
    }

    @Override
    public void deletediagnostico(Long id) {
        if(diagRep.existsById(id)){
            diagRep.deleteById(id);
        }else{
            throw new RuntimeException("El diagnostico no existe");
        }
    }

    @Override
    public DiagnosticoDTO saveDiagnostico(Diagnostico newdiag) {
        diagRep.save(newdiag);
        return convertirDTO(newdiag);
    }

    @Override
    public DiagnosticoDTO update(Diagnostico request, Long id) {
        Optional<Diagnostico> busqueda = diagRep.findById(id);
        if( busqueda != null){
            Diagnostico dia = busqueda.get();
            dia.setEnfermedad(request.getEnfermedad());
            dia.setValoracionEspecialista(request.getValoracionEspecialista());
            dia.setCita(request.getCita());
            diagRep.save(dia);
            return convertirDTO(dia);
        }else{
            throw new RuntimeException("Diagnostico que busca no existe");
        }
    }
}
