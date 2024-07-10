package com.andyg.ClinicaVet.controller;

import com.andyg.ClinicaVet.persistence.model.DuenoEntity;
import com.andyg.ClinicaVet.persistence.model.MascotaEntity;
import com.andyg.ClinicaVet.persistence.repository.DuenoRepository;
import com.andyg.ClinicaVet.service.DuenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dueno")
public class DuenoController {

    @Autowired
    private DuenoRepository duenoRepository;

    @Autowired
    private DuenoService duenoService;

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<DuenoEntity> listDueno(){
        return duenoService.listsDueno();
    }

    @GetMapping("/list/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DuenoEntity getIdDueno(@PathVariable Long id){
        return duenoService.getsIdDueno(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public DuenoEntity createDueno(@RequestBody DuenoEntity dueno){
        return duenoService.createsDueno(dueno);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DuenoEntity updateDueno(@RequestBody DuenoEntity dueno, @PathVariable Long id){
        return duenoService.updatesDueno(dueno, id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDueno(@PathVariable Long id){
        duenoService.deletesDueno(id);
    }


}
