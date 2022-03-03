package com.concesionario.autosbackend.dto;

import lombok.Data;

@Data
public class SerchDto {
    private String brand;
    private String model;
    private String version;
    private String isAutomatic;
    private Integer fromKm;
    private Integer toKm;
    private String color;
}
