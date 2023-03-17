package com.cita.Cita.controllers;

import com.cita.Cita.DTOs.PacienteDTO;
import com.cita.Cita.models.Paciente;
import com.cita.Cita.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacSer;

    @GetMapping("/all")
    public List<PacienteDTO> listarpaciente(){
        List<PacienteDTO> paciente = pacSer.listarPaciente();
        return paciente;
    }

    @GetMapping("/all/{id}")
    public PacienteDTO pacienteid(@PathVariable long id){
        PacienteDTO pacDTO = pacSer.pacientebyid(id);
        return pacDTO;
    }

    @PostMapping("/all")
    public PacienteDTO guardarPaciente(@RequestBody Paciente dto){ return pacSer.savePaciente(dto);}

    @DeleteMapping("/all/{id}")
    public void delete(@PathVariable long id){
        PacienteDTO dto = pacSer.pacientebyid(id);
        if (dto != null){
            pacSer.deletePaciente(id);
        }else{
            throw new RuntimeException("No existe nada con ese id");
        }
    }

    @PutMapping("/all/{id}")
    public void update(@RequestBody Paciente request, @PathVariable Long id){ pacSer.update(request, id);}
}
