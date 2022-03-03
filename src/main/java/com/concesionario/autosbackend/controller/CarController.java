package com.concesionario.autosbackend.controller;

import com.concesionario.autosbackend.criteria.CarCriteria;
import com.concesionario.autosbackend.dto.SerchDto;
import com.concesionario.autosbackend.enums.Color;
import com.concesionario.autosbackend.model.Car;
import com.concesionario.autosbackend.service.CarService;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/car")
@CrossOrigin("http://localhost:4200")
public class CarController {
    @Autowired
    CarService carService;

    @PostMapping("/list")
    public ResponseEntity<List<Car>> listCars(@RequestBody SerchDto serchDto){
        CarCriteria carCriteria = createCriteria(serchDto);
        List<Car> listCars = carService.findByCriteria(carCriteria);
        return new ResponseEntity<List<Car>>(listCars, HttpStatus.OK);
    }

    private CarCriteria createCriteria(SerchDto serchDto) {
        CarCriteria carCriteria = new CarCriteria();
        if (serchDto != null) {
            if (!StringUtils.isBlank(serchDto.getBrand())) {
                StringFilter filter = new StringFilter();
                filter.setEquals(serchDto.getBrand());
                carCriteria.setBrand(filter);
            }
            if (!StringUtils.isBlank(serchDto.getModel())) {
                StringFilter filter = new StringFilter();
                filter.setEquals(serchDto.getModel());
                carCriteria.setModel(filter);
            }
            if (!StringUtils.isBlank(serchDto.getVersion())) {
                StringFilter filter = new StringFilter();
                filter.setEquals(serchDto.getVersion());
                carCriteria.setVersion(filter);
            }
            if (!StringUtils.isBlank(serchDto.getIsAutomatic())) {
                BooleanFilter filter = new BooleanFilter();
                switch (serchDto.getIsAutomatic()) {
                    case "true":
                        filter.setEquals(true);
                        break;
                    default:
                        filter.setEquals(false);
                        break;
                }
                carCriteria.setIsAutomatic(filter);
            }
            if (!StringUtils.isBlank(serchDto.getColor())) {
                CarCriteria.ColorFilter filter = new CarCriteria.ColorFilter();
                String color = serchDto.getColor().toUpperCase();
                filter.setEquals(Color.valueOf(color));
                carCriteria.setColor(filter);
            }
            if (serchDto.getFromKm() != null || serchDto.getToKm() != null) {
                IntegerFilter filter = new IntegerFilter();
                if (serchDto.getFromKm() != null) {
                    filter.setGreaterThanOrEqual(serchDto.getFromKm());
                    carCriteria.setKm(filter);
                }
                if (serchDto.getToKm() != null) {
                    filter.setLessThanOrEqual(serchDto.getToKm());
                    carCriteria.setKm(filter);
                }
            }
        }
        return carCriteria;
    }
}
