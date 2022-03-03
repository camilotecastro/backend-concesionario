package com.concesionario.autosbackend.service;

import com.concesionario.autosbackend.model.Brand;
import com.concesionario.autosbackend.repository.BranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BrandService {
    @Autowired
    BranRepository branRepository;

    public List<Brand> findAll(){
        return branRepository.findAll();
    }

}
