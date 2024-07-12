package com.andyg.ClinicaVet.persistence.DTO;

import com.andyg.ClinicaVet.persistence.model.DuenoEntity;
import com.andyg.ClinicaVet.persistence.model.MascotaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MascotaDuenoDTO {

    private String nombreMascota;
    private String especieMascota;
    private String razaMascota;
    private String nombreDueno;
    private String ApellidoDueno;



}
