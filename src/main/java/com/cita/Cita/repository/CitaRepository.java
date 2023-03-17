package com.cita.Cita.repository;

import com.cita.Cita.models.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository <Cita, Long>{
}
