package com.restapi.trabajo1.dao;

import com.restapi.trabajo1.models.FormaAsesinato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormaAsesinatoRepository  extends JpaRepository<FormaAsesinato, Long>{
}
