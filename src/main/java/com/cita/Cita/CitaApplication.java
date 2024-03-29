package com.cita.Cita;

import com.cita.Cita.models.Cita;
import com.cita.Cita.models.Diagnostico;
import com.cita.Cita.repository.CitaRepository;
import com.cita.Cita.repository.DiagnosticoRepository;
import com.cita.Cita.repository.PacienteRepository;
import com.cita.Cita.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class CitaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitaApplication.class, args);
	}

}
