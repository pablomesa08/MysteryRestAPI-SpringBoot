package com.restapi.trabajo1.services;

import com.restapi.trabajo1.models.Victima;

import java.util.List;

public interface IVictimaService {
    public List<Victima> getAllVictimas();
    public Victima getVictimaById(long id);
    public Victima save(Victima e);

}
