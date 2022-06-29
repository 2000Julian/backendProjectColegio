package com.colegio.demo.repositories;

import com.colegio.demo.entities.Colegio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColegioRepository extends JpaRepository<Colegio, Long> {
}
