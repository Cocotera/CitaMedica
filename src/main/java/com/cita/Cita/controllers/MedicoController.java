package com.cita.Cita.controllers;

import com.cita.Cita.DTOs.MedicoDTO;
import com.cita.Cita.DTOs.PacienteDTO;
import com.cita.Cita.models.Medico;
import com.cita.Cita.models.Paciente;
import com.cita.Cita.services.MedicoService;
import com.cita.Cita.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoService medSer;

    @GetMapping("/all")
    public List<MedicoDTO> listarmedico(){
        List<MedicoDTO> medico = medSer.listarMedico();
        return medico;
    }

    @GetMapping("/all/{id}")
    public MedicoDTO medicoID(@PathVariable long id){
        MedicoDTO MedDTO = medSer.medicobyid(id);
        return MedDTO;
    }

    @PostMapping("/all")
    public MedicoDTO guardarMedico(@RequestBody Medico dto){ return medSer.saveMedico(dto);}

    @DeleteMapping("/all/{id}")
    public void delete(@PathVariable long id){
        MedicoDTO dto = medSer.medicobyid(id);
        if (dto != null){
            medSer.deleteMedico(id);
        }else{
            throw new RuntimeException("No existe nada con ese id");
        }
    }

    @PutMapping("/all/{id}")
    public void update(@RequestBody Medico request, @PathVariable Long id){ medSer.update(request, id);}
}
