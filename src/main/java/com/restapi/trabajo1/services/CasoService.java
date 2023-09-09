package com.restapi.trabajo1.services;

import com.restapi.trabajo1.models.Caso;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.restapi.trabajo1.dao.ICasoRepository;
import java.util.List;


@Service
public class CasoService implements ICasoService {

    @Autowired
    private ICasoRepository cs;

    @Override
    public List<Caso> findAll() {
        return cs.findAll();
    }

    @Override
    public Caso findById(Long id) {
        return cs.findById(id).orElse(null);
    }

    @Override
    public Caso save(Caso e) {
        return cs.save(e);
    }

    @Override
    public void deleteById(Long id) {
        cs.deleteById(id);
    }
}
