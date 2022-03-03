package com.concesionario.autosbackend.service;

import com.concesionario.autosbackend.criteria.CarCriteria;
import com.concesionario.autosbackend.model.Brand_;
import com.concesionario.autosbackend.model.Car;
import com.concesionario.autosbackend.model.Car_;
import com.concesionario.autosbackend.model.Model_;
import com.concesionario.autosbackend.repository.CarRepository;
import io.github.jhipster.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.JoinType;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CarService extends QueryService<Car> {

    @Autowired
    CarRepository carRepository;

    public List<Car> findByCriteria(CarCriteria carCriteria){
        final Specification<Car> specification = createSpecification(carCriteria);
        List<Car> cars = carRepository.findAll(specification);
        return cars;
    }

    private Specification<Car> createSpecification(CarCriteria carCriteria){
        Specification<Car> specification = Specification.where(null);
        if(carCriteria != null){
            if (carCriteria.getVersion() != null){
                specification = specification.and(buildStringSpecification(carCriteria.getVersion(), Car_.version));
            }
            if (carCriteria.getColor() != null){
                specification = specification.and(buildSpecification(carCriteria.getColor(), Car_.color));
            }
            if (carCriteria.getKm() != null){
                specification = specification.and(buildSpecification(carCriteria.getKm(), Car_.km));
            }
            if (carCriteria.getIsAutomatic() != null){
                specification = specification.and(buildSpecification(carCriteria.getIsAutomatic(), Car_.isAutomatic));
            }
            if (carCriteria.getModel() != null){
                specification =
                        specification
                                .and(buildReferringEntitySpecification(carCriteria.getModel(), Car_.model, Model_.name));
            }
            if(carCriteria.getBrand()!=null){
                specification =
                        specification.and(buildSpecification(carCriteria.getBrand(),
                                root->root.join(Car_.model, JoinType.LEFT)
                                        .join(Model_.brand, JoinType.LEFT).get(Brand_.name)));
            }

        }
        return specification;
    }

}
