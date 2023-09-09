package com.restapi.trabajo1.services;

import com.restapi.trabajo1.dao.IFamiliaRepository;
import com.restapi.trabajo1.models.Familia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamiliaService implements IFamiliaService{
    @Autowired
    private IFamiliaRepository fs;

    @Override
    public List<Familia> findAll() {
        return fs.findAll();
    }

    @Override
    public Familia findById(Long id) {
        return fs.findById(id).orElse(null);
    }

    @Override
    public Familia save(Familia e) {
        return fs.save(e);
    }

    @Override
    public void deleteById(Long id) {
        fs.deleteById(id);
    }
}
