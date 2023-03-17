package com.cita.Cita.controllers;

import com.cita.Cita.DTOs.CitaDTO;
import com.cita.Cita.DTOs.DiagnosticoDTO;
import com.cita.Cita.models.Cita;
import com.cita.Cita.models.Diagnostico;
import com.cita.Cita.services.CitaService;
import com.cita.Cita.services.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diagnostico")
public class DiagnosticoController {
    @Autowired
    private DiagnosticoService diaser;

    @GetMapping("/all")
    public List<DiagnosticoDTO> listardiagnostico(){
        List<DiagnosticoDTO> diag = diaser.listarDiagnostico();
        return diag;
    }

    @GetMapping("/all/{id}")
    public DiagnosticoDTO diagnosticoID(@PathVariable long id){
        DiagnosticoDTO pacDTO = diaser.diagnosticoByid(id);
        return pacDTO;
    }

    @PostMapping("/all")
    public DiagnosticoDTO guardarDiagnostico(@RequestBody Diagnostico dto){ return diaser.saveDiagnostico(dto);}

    @DeleteMapping("/all/{id}")
    public void delete(@PathVariable long id){
        DiagnosticoDTO dto = diaser.diagnosticoByid(id);
        if (dto != null){
            diaser.deletediagnostico(id);
        }else{
            throw new RuntimeException("No existe nada con ese id");
        }
    }

    @PutMapping("/all/{id}")
    public void update(@RequestBody Diagnostico request, @PathVariable Long id){ diaser.update(request, id);}
}
