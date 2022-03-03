package com.concesionario.autosbackend.repository;

import com.concesionario.autosbackend.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranRepository extends JpaRepository<Brand, Long> {
}
