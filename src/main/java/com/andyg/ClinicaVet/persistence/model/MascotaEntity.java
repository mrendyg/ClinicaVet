package com.andyg.ClinicaVet.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mascota")
public class MascotaEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especie;
    private String raza;
    private String color;

    @OneToOne
    @JoinColumn(name = "dueno_id", referencedColumnName = "id")
    private DuenoEntity dueno;

}
