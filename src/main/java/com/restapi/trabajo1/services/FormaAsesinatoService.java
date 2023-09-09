package com.restapi.trabajo1.services;

import com.restapi.trabajo1.dao.IFormaAsesinatoRepository;
import com.restapi.trabajo1.models.FormaAsesinato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormaAsesinatoService implements IFormaAsesinatoService{
    @Autowired
    private IFormaAsesinatoRepository fas;

    @Override
    public List<FormaAsesinato> findAll() {
        return fas.findAll();
    }

    @Override
    public FormaAsesinato findById(Long id) {
        return fas.findById(id).orElse(null);
    }

    @Override
    public FormaAsesinato save(FormaAsesinato e) {
        return fas.save(e);
    }

    @Override
    public void deleteById(Long id) {
        fas.deleteById(id);
    }
}
