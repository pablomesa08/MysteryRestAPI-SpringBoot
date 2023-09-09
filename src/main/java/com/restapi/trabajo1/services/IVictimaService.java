package com.restapi.trabajo1.services;


import com.restapi.trabajo1.models.Victima;

import java.util.List;

public interface IVictimaService {
    public List<Victima> findAll();
    public Victima save(Victima e);
    public Victima findById(Long id);
    public void deleteById(Long id);

    public List<Victima> findByCasoId(Long casoId);

    public List<Victima> findByFamiliaId(Long familiaId);

    public List<Victima> findByFormaAsesinatoId(Long formaAsesinatoId);
}
