package ru.java.restapp.mapstruct;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import ru.java.restapp.dto.CityDto;
import ru.java.restapp.dto.SightDto;
import ru.java.restapp.entity.City;
import ru.java.restapp.entity.Sight;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    CityDto cityToCityDto(City city);

    @InheritInverseConfiguration
    City cityDtoToCity(CityDto cityDto);

    SightDto sightToSightDto(Sight sight);

    @InheritInverseConfiguration
    Sight sightDtoToSight(SightDto sightDto);

}
