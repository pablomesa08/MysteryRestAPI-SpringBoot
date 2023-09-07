package com.restapi.trabajo1.repository;

import com.restapi.trabajo1.models.Caso;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface ICasoRepository extends JpaRepository<Caso,Long> {

}
