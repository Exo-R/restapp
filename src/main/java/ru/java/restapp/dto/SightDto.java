package ru.java.restapp.dto;

import lombok.Builder;
import lombok.Data;
import ru.java.restapp.entity.City;
import ru.java.restapp.entity.TypeSight;
import java.time.LocalDate;

@Data
@Builder
public class SightDto {

    private Long id;
    private String sightName;
    private LocalDate dateConstruction;
    private String shortDescription;
    private TypeSight typeSight;
    private City city;

}
