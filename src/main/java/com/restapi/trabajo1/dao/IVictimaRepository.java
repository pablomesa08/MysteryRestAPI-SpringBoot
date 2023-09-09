package com.restapi.trabajo1.dao;

import com.restapi.trabajo1.models.Victima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVictimaRepository extends JpaRepository<Victima, Long>{

    List<Victima> findByCasoId(Long casoId);

    List<Victima> findByFamiliaId(Long familiaId);

    List<Victima> findByFormaAsesinatoId(Long formaAsesinatoId);
}
