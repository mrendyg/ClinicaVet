package com.andyg.ClinicaVet.controller;

import com.andyg.ClinicaVet.persistence.DTO.MascotaDuenoDTO;
import com.andyg.ClinicaVet.persistence.model.DuenoEntity;
import com.andyg.ClinicaVet.persistence.model.MascotaEntity;
import com.andyg.ClinicaVet.persistence.repository.DuenoRepository;
import com.andyg.ClinicaVet.persistence.repository.MascotaRepository;
import com.andyg.ClinicaVet.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascota")
public class MascotaController {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private DuenoRepository duenoRepository;

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<MascotaEntity> mascotaList(){
        return mascotaService.listsMascota();
    }

    @GetMapping("/list/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MascotaEntity getIdMascota(@PathVariable Long id){
        return mascotaService.getsIdMascota(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MascotaEntity createMascota(@RequestBody MascotaEntity mascota){
        return mascotaService.createsMascota(mascota);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MascotaEntity updateMascota(@RequestBody MascotaEntity mascota, @PathVariable Long id){
        return mascotaService.updatesMascota(mascota, id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMascota(@PathVariable Long id){
        mascotaService.deletesMascota(id);
    }

    @GetMapping("/mascotadueno")
    @ResponseStatus(HttpStatus.OK)
    public List<MascotaDuenoDTO> listMascotaDueno(){
        return mascotaService.getMascotaDueno();
    }

    @GetMapping("/caniche")
    @ResponseStatus(HttpStatus.OK)
    public List<MascotaEntity> getMascotaCaniche(){
        return mascotaService.getsMarcotaCaniche();
    }
}
