package com.cita.Cita.controllers;

import com.cita.Cita.DTOs.MedicoDTO;
import com.cita.Cita.DTOs.UsuarioDTO;
import com.cita.Cita.repository.UsuarioRepository;
import com.cita.Cita.services.MedicoService;
import com.cita.Cita.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServices usurep;

    @GetMapping("/all")
    public List<UsuarioDTO> listarUsuario(){
        List<UsuarioDTO> usuario = usurep.listarUsuario();
        return usuario;
    }
}
