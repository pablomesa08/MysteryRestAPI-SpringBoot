package com.restapi.trabajo1.dao;

import com.restapi.trabajo1.models.Caso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ICasoRepository extends JpaRepository<Caso, Long> {
}
