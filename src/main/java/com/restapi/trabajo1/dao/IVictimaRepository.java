package com.restapi.trabajo1.dao;

import com.restapi.trabajo1.models.Victima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IVictimaRepository extends JpaRepository<Victima, Long>{
}
