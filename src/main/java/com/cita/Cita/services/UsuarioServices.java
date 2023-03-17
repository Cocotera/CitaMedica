package com.cita.Cita.services;

import com.cita.Cita.DTOs.MedicoDTO;
import com.cita.Cita.DTOs.UsuarioDTO;
import com.cita.Cita.models.Cita;
import com.cita.Cita.models.Medico;
import com.cita.Cita.models.Usuario;
import com.cita.Cita.repository.MedicoRepository;
import com.cita.Cita.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class UsuarioServices implements UsuarioServiceMet{

    @Autowired
    private UsuarioRepository usuRep;

    private ModelMapper maper = new ModelMapper();

    //FUNCIÓN PARA NO TENER QUE REPETIR LA MISMA LINEA DE CÓDIGO TANTAS VECES
    private UsuarioDTO convertirDTO(Usuario p){
        UsuarioDTO dto = maper.map(p, UsuarioDTO.class);
        return dto;
    }

    @Override
    @Transactional
    public List<UsuarioDTO> listarUsuario() {
        List<Usuario> usuarios = usuRep.findAll();
        List<UsuarioDTO> dtO = new LinkedList<>();
        for(Usuario u: usuarios){
            dtO.add(convertirDTO(u));
        }
        return dtO;
    }
}
