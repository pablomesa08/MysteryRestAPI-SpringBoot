package com.restapi.trabajo1.repository;

import com.restapi.trabajo1.models.Victima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IVictimaRepository extends JpaRepository<Victima,Long> {


}