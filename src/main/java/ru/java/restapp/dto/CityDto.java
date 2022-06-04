package ru.java.restapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityDto {

    private Long id;
    private String cityName;
    private Integer population;
    private Boolean metroAvailability;
    private String country;

}
