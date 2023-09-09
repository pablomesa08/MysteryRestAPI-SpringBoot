package com.restapi.trabajo1.services;

import com.restapi.trabajo1.dao.IVictimaRepository;
import com.restapi.trabajo1.models.Victima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VictimaService implements IVictimaService{
    @Autowired
    private IVictimaRepository vs;

    @Override
    public List<Victima> findAll() {
        return vs.findAll();
    }

    @Override
    public Victima findById(Long id) {
        return vs.findById(id).orElse(null);
    }

    @Override
    public Victima save(Victima e) {
        return vs.save(e);
    }

    @Override
    public void deleteById(Long id) {
        vs.deleteById(id);
    }

    @Override
    public List<Victima> findByCasoId(Long casoId) {
        return vs.findByCasoId(casoId);
    }

    @Override
    public List<Victima> findByFamiliaId(Long familiaId) {
        return vs.findByFamiliaId(familiaId);
    }

    @Override
    public List<Victima> findByFormaAsesinatoId(Long formaAsesinatoId) {
        return vs.findByFormaAsesinatoId(formaAsesinatoId);
    }
}
