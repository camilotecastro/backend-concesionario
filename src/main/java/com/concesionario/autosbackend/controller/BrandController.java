package com.concesionario.autosbackend.controller;

import com.concesionario.autosbackend.model.Brand;
import com.concesionario.autosbackend.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
@CrossOrigin(origins = "http://localhost:4200")
public class BrandController {
    @Autowired
    BrandService brandService;

    @GetMapping("/list")
    public ResponseEntity<List<Brand>> list(){
        List<Brand> brands = brandService.findAll();
        return new ResponseEntity<List<Brand>>(brands, HttpStatus.OK);
    }

}
