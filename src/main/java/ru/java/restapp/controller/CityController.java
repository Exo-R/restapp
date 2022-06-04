package ru.java.restapp.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import ru.java.restapp.dto.CityDto;
import ru.java.restapp.service.CityService;
import javax.ws.rs.core.Response;

@RestController("city")
@Log
@RequestMapping("/city")
@AllArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping("/save")
    public Response addCity(@RequestBody CityDto cityDto){
        cityService.saveCity(cityDto);
        return Response.ok().build();
    }

    @PutMapping("/{cityId}")
    public Response updateCity(
            @RequestBody CityDto cityDto,
            @PathVariable(value = "cityId") Long cityId){

        cityService.updateCity(cityDto, cityId);

        return Response.ok().build();
    }

}
