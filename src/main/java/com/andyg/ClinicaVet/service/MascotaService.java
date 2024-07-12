package com.andyg.ClinicaVet.service;

import com.andyg.ClinicaVet.persistence.DTO.MascotaDuenoDTO;
import com.andyg.ClinicaVet.persistence.model.MascotaEntity;
import com.andyg.ClinicaVet.persistence.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    public List<MascotaEntity> listsMascota(){
        return mascotaRepository.findAll();
    }

    public MascotaEntity getsIdMascota(Long id){
        return mascotaRepository.findById(id).orElse(null);
    }

    public MascotaEntity createsMascota(MascotaEntity mascota){
        return mascotaRepository.save(mascota);
    }



    public MascotaEntity updatesMascota(MascotaEntity mascota, Long id){
        MascotaEntity updatedMascota = mascotaRepository.findById(id).get();
        updatedMascota.setNombre(mascota.getNombre());
        updatedMascota.setEspecie(mascota.getEspecie());
        updatedMascota.setRaza(mascota.getRaza());
        updatedMascota.setColor(mascota.getColor());
        updatedMascota.setDueno(mascota.getDueno());
        return mascotaRepository.save(updatedMascota);
    }

    public void deletesMascota(Long id){
        MascotaEntity deletedMascota = mascotaRepository.findById(id).get();
        mascotaRepository.delete(deletedMascota);
    }

    public List<MascotaDuenoDTO> getMascotaDueno(){
        List<MascotaEntity> mascotaEntityList = mascotaRepository.findAll();
        List<MascotaDuenoDTO> mascotaDuenoDTOList = new ArrayList<>();
        MascotaDuenoDTO mascotaDuenoDTO = new MascotaDuenoDTO();


        for (MascotaEntity mascota : mascotaEntityList) {
                mascotaDuenoDTO.setNombreDueno(mascota.getDueno().getNombre());
                mascotaDuenoDTO.setApellidoDueno(mascota.getDueno().getApellido());
                mascotaDuenoDTO.setNombreMascota(mascota.getNombre());
                mascotaDuenoDTO.setEspecieMascota(mascota.getEspecie());
                mascotaDuenoDTO.setRazaMascota(mascota.getRaza());

                mascotaDuenoDTOList.add(mascotaDuenoDTO);
                mascotaDuenoDTO = new MascotaDuenoDTO();//reseteo
        }
        return mascotaDuenoDTOList;
    }

    //Buque de mascotas especie perro raza caniche
    public List<MascotaEntity> getsMarcotaCaniche(){
        String keyword1 = "Perro";
        String keyword2 = "Caniche";
        String keywordCompare1;
        String keywordCompare2;

        List<MascotaEntity> listaMascotas = this.listsMascota();
        List<MascotaEntity> listaMascotaCaniche = new ArrayList<MascotaEntity>();

        for(MascotaEntity mascotaEntity : listaMascotas){
            keywordCompare1 = mascotaEntity.getEspecie();
            keywordCompare2 = mascotaEntity.getRaza();
            boolean contienePerro = keywordCompare1.contains(keyword1);
            boolean contieneCaniche = keywordCompare2.contains(keyword2);

            if (contienePerro && contieneCaniche){
                listaMascotaCaniche.add(mascotaEntity);
            }
        }

        return listaMascotaCaniche;
    }

}
