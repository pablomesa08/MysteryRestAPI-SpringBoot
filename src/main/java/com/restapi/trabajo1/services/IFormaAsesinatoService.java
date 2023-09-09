package com.restapi.trabajo1.services;

import com.restapi.trabajo1.models.FormaAsesinato;

import java.util.List;

public interface IFormaAsesinatoService {
    public List<FormaAsesinato> findAll();
    public FormaAsesinato findById(Long id);
    public FormaAsesinato save(FormaAsesinato e);
    public void deleteById(Long id);

}
