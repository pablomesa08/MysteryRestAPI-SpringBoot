package com.restapi.trabajo1.services;

import com.restapi.trabajo1.models.Caso;

import java.util.List;

public interface ICasoService {
    public List<Caso> getAllCasos();
    public Caso getCasoById(long id);
    public Caso save(Caso e);
}
