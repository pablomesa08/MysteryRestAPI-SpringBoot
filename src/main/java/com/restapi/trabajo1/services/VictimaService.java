package com.restapi.trabajo1.services;

import com.restapi.trabajo1.repository.IVictimaRepository;
import com.restapi.trabajo1.models.Victima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VictimaService implements IVictimaService {
    @Autowired
    private IVictimaRepository victimaRepository;

    @Override
    public List<Victima> getAllVictimas(){
        return victimaRepository.findAll();
    }

    @Override
    public Victima getVictimaById(long id){
        return victimaRepository.findById(id).orElse(null);
    }

    @Override
    public Victima save(Victima e){
        return victimaRepository.save(e);
    }

}
