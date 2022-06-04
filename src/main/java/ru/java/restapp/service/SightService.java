package ru.java.restapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.java.restapp.dto.CityDto;
import ru.java.restapp.dto.SightDto;
import ru.java.restapp.entity.City;
import ru.java.restapp.entity.Sight;
import ru.java.restapp.entity.TypeSight;
import ru.java.restapp.mapstruct.MapStructMapperImpl;
import ru.java.restapp.repository.SightRepository;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class SightService {

    private final SightRepository sightRepository;
    private final MapStructMapperImpl mapStructMapper;
    private final CityService cityService;

    public List<SightDto> findAllByCityId(Long cityId) {// +
        return sightRepository.findAllByCity_Id(cityId)
                .stream()
                .map(mapStructMapper::sightToSightDto)
                .collect(Collectors.toList());
    }

    public List<SightDto> findAllByTypeSightAndSortBySightName(String typeSight, Boolean needSort){

        List<Sight> listSights;
        try {
            if (typeSight.isEmpty()) {
                listSights = sightRepository.findAll();
            } else {
                listSights = sightRepository.findAllByTypeSight(TypeSight.fromValue(typeSight.toUpperCase()));
            }

            Stream<SightDto> sightDto = listSights.stream().map(mapStructMapper::sightToSightDto);

            if (needSort) {
                sightDto = sightDto.sorted(Comparator.comparing(SightDto::getSightName));
            }
            return sightDto.collect(Collectors.toList());

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return Collections.emptyList();
    }

    public void saveSight(SightDto sightDto) {

        CityDto foundCityDto = null;
        try{
            foundCityDto = cityService.findById(sightDto.getCity().getId()).get();
        }catch (Exception ex){
            System.out.println("City is " + ex.getMessage());
        }

        if (foundCityDto != null && validateSightDto(sightDto)) {
            City foundCity = mapStructMapper.cityDtoToCity(foundCityDto);
            sightDto.setCity(foundCity);
            sightRepository.save(mapStructMapper.sightDtoToSight(sightDto));
        }
    }

    private boolean validateSightDto(SightDto sightDto){
        try {
            if (
                    sightDto.getSightName().isEmpty() ||
                            sightDto.getTypeSight() == null ||
                            sightDto.getDateConstruction() == null ||
                            sightDto.getShortDescription().isEmpty() ||
                            sightDto.getCity().getId() == null
            )
                return false;
        }catch (Exception ex){
            System.out.println("sightDto is invalid");
            return false;
        }
        return true;
    }


    public void deleteSight(Long sightId) {
        if (sightRepository.findById(sightId).isPresent()) {
            sightRepository.deleteById(sightId);
        }
    }

    public void updateSight(SightDto sightDto, Long sightId) {

        Sight updatedSight = null;
        try {
            updatedSight = sightRepository.findById(sightId).get();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        String updatedShortDescr = null;
        try {
            updatedShortDescr = sightDto.getShortDescription();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        if (updatedShortDescr != null && !updatedShortDescr.isEmpty() && updatedSight != null) {
            updatedSight.setShortDescription(updatedShortDescr);
            sightRepository.save(updatedSight);
        }
    }

}
