package com.restapi.trabajo1.services;

import com.restapi.trabajo1.models.Caso;
import com.restapi.trabajo1.repository.ICasoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasoService implements ICasoService{
    @Autowired
    private ICasoRepository casoRepository;

    @Override
    public List<Caso> getAllCasos(){
        return casoRepository.findAll();
    }

    @Override
    public Caso getCasoById(long id){
        return casoRepository.findById(id).orElse(null);
    }

    @Override
    public Caso save(Caso e){
        return casoRepository.save(e);
    }
}
