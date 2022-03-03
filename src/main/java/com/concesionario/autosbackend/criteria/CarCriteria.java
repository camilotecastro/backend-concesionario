package com.concesionario.autosbackend.criteria;

import com.concesionario.autosbackend.enums.Color;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarCriteria {

    public static class ColorFilter extends Filter<Color>{}
    private StringFilter brand;
    private StringFilter model;
    private StringFilter version;
    private BooleanFilter isAutomatic;
    private ColorFilter color;
    private IntegerFilter km;

}
