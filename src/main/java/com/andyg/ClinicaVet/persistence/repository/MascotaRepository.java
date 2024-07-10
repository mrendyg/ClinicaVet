package com.andyg.ClinicaVet.persistence.repository;

import com.andyg.ClinicaVet.persistence.model.MascotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MascotaRepository extends JpaRepository<MascotaEntity, Long> {


}
