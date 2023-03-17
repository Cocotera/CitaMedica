package com.cita.Cita.services;

import com.cita.Cita.DTOs.MedicoDTO;
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
public class MedicoService implements MedicoServicieMet{

    @Autowired
    private MedicoRepository medicoRep;
    private CitaService citaService;

    @Autowired
    private CitaRepository citarep;

    @Autowired
    private PacienteRepository pacRep;

    private ModelMapper maper = new ModelMapper();

    //FUNCIÓN PARA NO TENER QUE REPETIR LA MISMA LINEA DE CÓDIGO TANTAS VECES
    private MedicoDTO convertirDTO(Medico p){
        MedicoDTO dto = maper.map(p, MedicoDTO.class);
        return dto;
    }

    @Override
    @Transactional
    public List<MedicoDTO> listarMedico() {
        List<MedicoDTO> medicosDTO= new ArrayList<MedicoDTO>();
        List<Medico> medicos=medicoRep.findAll();
        for (Medico medico: medicos){
            medicosDTO.add( convertirDTO(medico));
        }
        return medicosDTO;
    }

    @Override
    public MedicoDTO medicobyid(Long id) {
        Medico m = medicoRep.findById(id).orElse(null);
        if(m == null){
            throw new RuntimeException("Medico no encontrado");
        }else{
            return convertirDTO(m);
        }
    }

    @Override
    public void deleteMedico(Long id) {
        if(medicoRep.existsById(id)){
            medicoRep.deleteById(id);
        }else{
            throw new RuntimeException("El medico no existe");
        }
    }

    @Override
    @Transactional
    public MedicoDTO saveMedico(Medico mediconew) {
        for(Paciente p: mediconew.getPacientes()){
            pacRep.save(p);
        }
        for(Cita c: mediconew.getCitas()){
            citarep.save(c);
        }
        medicoRep.save(mediconew);
        return convertirDTO(mediconew);
    }

    @Override
    @Transactional
    public MedicoDTO update(Medico request, Long id) {
        Optional<Medico> busqueda = medicoRep.findById(id);
        if( busqueda != null){
            Medico med = busqueda.get();
            med.setNombre(request.getNombre());
            med.setApellidos(request.getApellidos());
            med.setUsuario(request.getUsuario());
            med.setClave(request.getClave());
            med.setNumColegiado(request.getNumColegiado());
            if(!request.getCitas().isEmpty()){
                List<Cita> citas = new ArrayList<Cita>();
                for (Cita p: request.getCitas()){
                    citaService.saveCita(p);
                    citas.add(p);
                }
                med.setCitas(citas);
            }
            medicoRep.save(med);
            return convertirDTO(med);
        }else{
            throw new RuntimeException("El medico que busca no existe");
        }
    }
}
