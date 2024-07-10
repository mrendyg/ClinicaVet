package com.andyg.ClinicaVet.service;

import com.andyg.ClinicaVet.persistence.model.DuenoEntity;
import com.andyg.ClinicaVet.persistence.repository.DuenoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenoService {

    @Autowired
    private DuenoRepository duenoRepository;

    public List<DuenoEntity> listsDueno(){
        return duenoRepository.findAll();
    }

    public DuenoEntity getsIdDueno(Long id){
        return duenoRepository.findById(id).orElse(null);
    }

    public DuenoEntity createsDueno(DuenoEntity dueno){
        return duenoRepository.save(dueno);
    }

    public DuenoEntity updatesDueno(DuenoEntity dueno, Long id){
        DuenoEntity updateDueno = duenoRepository.findById(id).get();
        updateDueno.setDni(dueno.getDni());
        updateDueno.setNombre(dueno.getNombre());
        updateDueno.setApellido(dueno.getApellido());
        updateDueno.setCelular(dueno.getCelular());
        return duenoRepository.save(updateDueno);
    }

    public void deletesDueno(Long id){
        DuenoEntity deletedDueno = duenoRepository.findById(id).get();
        duenoRepository.delete(deletedDueno);
    }

}
