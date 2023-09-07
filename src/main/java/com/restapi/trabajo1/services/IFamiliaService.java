package com.restapi.trabajo1.services;

import com.restapi.trabajo1.models.Familia;

import java.util.List;

public interface IFamiliaService {
    public List<Familia> getAllFamilias();
    public Familia getFamiliaById(long id);
    public Familia save(Familia e);

}
