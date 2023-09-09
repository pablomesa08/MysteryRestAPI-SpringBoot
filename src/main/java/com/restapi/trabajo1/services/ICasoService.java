package com.restapi.trabajo1.services;

import com.restapi.trabajo1.models.Caso;
import java.util.List;

public interface ICasoService {
    public List<Caso> findAll();
    public Caso findById(Long id);
    public Caso save(Caso e);
    public void deleteById(Long id);

}
