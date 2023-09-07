package com.restapi.trabajo1.services;

import com.restapi.trabajo1.models.Familia;
import com.restapi.trabajo1.repository.IFamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamiliaService implements IFamiliaService {
    @Autowired
    private IFamiliaRepository familiaRepository;

    @Override
    public List<Familia> getAllFamilias(){
        return familiaRepository.findAll();
    }

    @Override
    public Familia getFamiliaById(long id){
        return familiaRepository.findById(id).orElse(null);
    }

    @Override
    public Familia save(Familia e){
        return familiaRepository.save(e);
    }

}
