package com.cita.Cita.controllers;

import com.cita.Cita.DTOs.CitaDTO;
import com.cita.Cita.DTOs.PacienteDTO;
import com.cita.Cita.models.Cita;
import com.cita.Cita.models.Paciente;
import com.cita.Cita.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cita")
public class CitaController {

    @Autowired
    private CitaService citser;

    @GetMapping("/all")
    public List<CitaDTO> listarcita(){
        List<CitaDTO> cita = citser.listarCitas();
        return cita;
    }

    @GetMapping("/all/{id}")
    public CitaDTO pacienteid(@PathVariable long id){
        CitaDTO pacDTO = citser.citaByid(id);
        return pacDTO;
    }

    @PostMapping("/all")
    public CitaDTO guardarCita(@RequestBody Cita dto){ return citser.saveCita(dto);}

    @DeleteMapping("/all/{id}")
    public void delete(@PathVariable long id){
        CitaDTO dto = citser.citaByid(id);
        if (dto != null){
            citser.deletecita(id);
        }else{
            throw new RuntimeException("No existe nada con ese id");
        }
    }

    @PutMapping("/all/{id}")
    public void update(@RequestBody Cita request, @PathVariable Long id){ citser.update(request, id);}
}
