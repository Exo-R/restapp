package ru.java.restapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.java.restapp.dto.CityDto;
import ru.java.restapp.entity.City;
import ru.java.restapp.mapper.Mapper;
import ru.java.restapp.repository.CityRepository;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final Mapper mapper;

    public void saveCity(CityDto cityDto){
        if(validateCityDto(cityDto)) {
            cityRepository.save(mapper.cityDtoToCity(cityDto));
        }
    }

    private boolean validateCityDto(CityDto cityDto){
        try {
            if (
                    cityDto.getCityName().isEmpty() ||
                            cityDto.getCountry().isEmpty() ||
                            cityDto.getMetroAvailability() == null ||
                            cityDto.getPopulation() == null
            )
                return false;
        }catch (Exception ex){
            System.out.println("cityDto is invalid");
            return false;
        }
        return true;
    }

    public Optional<CityDto> findById(Long id){

        Optional<City> foundCity = cityRepository.findById(id);
        return foundCity.map(mapper::cityToCityDto);
    }

    public void updateCity(CityDto cityDto, Long cityId) {

        City updatedCity = null;
        try {
            updatedCity = cityRepository.findById(cityId).get();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        Boolean updatedMetroAvailability = null;
        Integer updatedPopulation = null;
        try {
            updatedMetroAvailability = cityDto.getMetroAvailability();
            updatedPopulation = cityDto.getPopulation();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        if(updatedCity!= null) {
            if (updatedMetroAvailability != null) {
                Objects.requireNonNull(updatedCity).setMetroAvailability(updatedMetroAvailability);
            }
            if (updatedPopulation != null) {
                Objects.requireNonNull(updatedCity).setPopulation(updatedPopulation);
            }
            cityRepository.save(Objects.requireNonNull(updatedCity));
        }
    }


}
