package com.cita.Cita.services;

import com.cita.Cita.DTOs.PacienteDTO;
import com.cita.Cita.models.Cita;
import com.cita.Cita.models.Medico;
import com.cita.Cita.models.Paciente;
import com.cita.Cita.repository.CitaRepository;
import com.cita.Cita.repository.MedicoRepository;
import com.cita.Cita.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements PacienteServiceMet{

    @Autowired
    private PacienteRepository pacienteRep;

    @Autowired
    private MedicoRepository medicoRep;

    @Autowired
    private CitaRepository citarep;


    private CitaService citaService;

    private ModelMapper maper = new ModelMapper();

    //FUNCIÓN PARA NO TENER QUE REPETIR LA MISMA LINEA DE CÓDIGO TANTAS VECES
    private PacienteDTO convertirDTO(Paciente p){
        PacienteDTO dto = maper.map(p, PacienteDTO.class);
        return dto;
    }
    @Override
    @Transactional()
    public List<PacienteDTO> listarPaciente() {
        List<Paciente> pacientes = pacienteRep.findAll();
        List<PacienteDTO> dtO = new LinkedList<>();
        List<Cita> citas = new LinkedList<>();
        for(Paciente p: pacientes){
            for(Cita c: citas){
                if(c.getPaciente().getId() == p.getId()){
                    p.getCitas().add(c);
                }
            }
            dtO.add(convertirDTO(p));
        }
        return dtO;
    }

    @Override
    @Transactional
    public PacienteDTO pacientebyid(Long id) {
        Paciente p = pacienteRep.findById(id).orElse(null);
        if(p == null){
            throw new RuntimeException("Paciente no encontrado");
        }else{
            return convertirDTO(p);
        }
    }

    @Override
    @Transactional
    public void deletePaciente(Long id) {
        if(pacienteRep.existsById(id)){
            pacienteRep.deleteById(id);
        }else{
            throw new RuntimeException("El paciente no existe");
        }
    }

    @Override
    @Transactional
    public PacienteDTO savePaciente(Paciente pacientenew) {
        for(Medico m: pacientenew.getMedicos()){
            medicoRep.save(m);
        }
        for(Cita c: pacientenew.getCitas()){
            citarep.save(c);
        }
        pacienteRep.save(pacientenew);
        return convertirDTO(pacientenew);
    }

    @Override
    @Transactional()
    public PacienteDTO update(Paciente request, Long id) {
        Optional<Paciente> busqueda = pacienteRep.findById(id);
        if( busqueda != null){
            Paciente paci = busqueda.get();
            paci.setNombre(request.getNombre());
            paci.setApellidos(request.getApellidos());
            paci.setUsuario(request.getUsuario());
            paci.setClave(request.getClave());
            paci.setNSS(request.getNSS());
            paci.setTelefono(request.getTelefono());
            paci.setDireccion(request.getDireccion());
            if(!request.getCitas().isEmpty()){
                List<Cita> citas = new ArrayList<Cita>();
                for (Cita p: request.getCitas()){
                    citaService.saveCita(p);
                    citas.add(p);
                }
                paci.setCitas(citas);
            }
            pacienteRep.save(paci);
            return convertirDTO(paci);
        }else{
            throw new RuntimeException("El paciente que busca no existe");
        }
    }
}
