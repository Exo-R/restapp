package ru.java.restapp.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import ru.java.restapp.dto.SightDto;
import ru.java.restapp.service.SightService;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("/sight")
@AllArgsConstructor
@Log
public class SightController {

    private final SightService sightService;

    @GetMapping("/findall/sort={par1}&filter={par2}")
    public List<SightDto> findAllSightsFilter(
            @PathVariable(name = "par1", required = false) Boolean needSort,
            @PathVariable(name = "par2", required = false) String sightName){
        return sightService.findAllByTypeSightAndSortBySightName(sightName, needSort);
    }

    @GetMapping("/{cityId}/findall")
    public List<SightDto> findAllSightsByCity(@PathVariable(name = "cityId") Long cityId){
        return sightService.findAllByCityId(cityId);
    }

    @PostMapping("/save")
    public Response addSight(@RequestBody SightDto sightDto){
        sightService.saveSight(sightDto);
        return Response.ok().build();
    }

    @DeleteMapping("/{sightId}")
    public Response deleteSight(@PathVariable(value = "sightId") Long sightId){
        sightService.deleteSight(sightId);
        return Response.ok().build();
    }

    @PutMapping("/{sightId}")
    public Response updateSight(
            @RequestBody SightDto sightDto,
            @PathVariable(value = "sightId") Long sightId) {
        sightService.updateSight(sightDto, sightId);
        return Response.ok().build();
    }

}
