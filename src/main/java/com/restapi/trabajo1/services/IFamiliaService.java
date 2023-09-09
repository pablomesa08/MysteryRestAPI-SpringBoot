package com.restapi.trabajo1.services;

import com.restapi.trabajo1.models.Familia;

import java.util.List;

public interface IFamiliaService {
    public List<Familia> findAll();

    public Familia findById(Long id);

    public Familia save(Familia e);

    public void deleteById(Long id);
}
