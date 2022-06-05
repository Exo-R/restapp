package ru.java.restapp.mapper;

import ru.java.restapp.dto.CityDto;
import ru.java.restapp.dto.SightDto;
import ru.java.restapp.entity.City;
import ru.java.restapp.entity.Sight;

public interface Mapper {

    CityDto cityToCityDto(City city);

    City cityDtoToCity(CityDto cityDto);

    SightDto sightToSightDto(Sight sight);

    Sight sightDtoToSight(SightDto sightDto);

}
