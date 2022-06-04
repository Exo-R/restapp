package ru.java.restapp.mapstruct;

import org.springframework.stereotype.Component;
import ru.java.restapp.dto.CityDto;
import ru.java.restapp.dto.SightDto;
import ru.java.restapp.entity.City;
import ru.java.restapp.entity.Sight;

@Component
public class MapStructMapperImpl implements MapStructMapper{

    @Override
    public CityDto cityToCityDto(City city) {

        if(city == null){
            return null;
        }

        return CityDto.builder()
                .id(city.getId())
                .cityName(city.getCityName())
                .population(city.getPopulation())
                .metroAvailability(city.getMetroAvailability())
                .country(city.getCountry())
                .build();
    }

    @Override
    public City cityDtoToCity(CityDto cityDto) {

        if(cityDto == null){
            return null;
        }

        City city = new City();
        city.setId(cityDto.getId());
        city.setCityName(cityDto.getCityName());
        city.setPopulation(cityDto.getPopulation());
        city.setMetroAvailability(cityDto.getMetroAvailability());
        city.setCountry(cityDto.getCountry());
        return city;
    }

    @Override
    public SightDto sightToSightDto(Sight sight) {

        if(sight == null){
            return null;
        }

        return SightDto.builder()
                .id(sight.getId())
                .sightName(sight.getSightName())
                .dateConstruction(sight.getDateConstruction())
                .shortDescription(sight.getShortDescription())
                .typeSight(sight.getTypeSight())
                .city(sight.getCity())
                .build();
    }

    @Override
    public Sight sightDtoToSight(SightDto sightDto) {

        if(sightDto == null){
            return null;
        }

        Sight sight = new Sight();
        sight.setId(sightDto.getId());
        sight.setSightName(sightDto.getSightName());
        sight.setDateConstruction(sightDto.getDateConstruction());
        sight.setShortDescription(sightDto.getShortDescription());
        sight.setTypeSight(sightDto.getTypeSight());
        sight.setCity(sightDto.getCity());
        return sight;
    }
}
