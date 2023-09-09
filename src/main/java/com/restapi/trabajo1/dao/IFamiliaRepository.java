package com.restapi.trabajo1.dao;

import com.restapi.trabajo1.models.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFamiliaRepository extends JpaRepository<Familia, Long>{
}
