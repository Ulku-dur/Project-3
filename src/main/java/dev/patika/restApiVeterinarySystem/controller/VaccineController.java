package dev.patika.restApiVeterinarySystem.controller;

import dev.patika.restApiVeterinarySystem.dto.request.VaccineRequest;
import dev.patika.restApiVeterinarySystem.dto.response.VaccineResponse;
import dev.patika.restApiVeterinarySystem.service.concretes.VaccineService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vaccines")

public class VaccineController {
    private final VaccineService vaccineService;

    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<VaccineResponse> findAll() {
        return vaccineService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VaccineResponse getById(@PathVariable("id") Long id) {
        return vaccineService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public VaccineResponse save(@RequestBody VaccineRequest vaccine) {
        return vaccineService.create(vaccine);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VaccineResponse update(@PathVariable("id") Long id, @RequestBody VaccineRequest request) {
        return vaccineService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long id) {
        vaccineService.deleteById(id);
    }

    @GetMapping("/findByAnimalId/{animalId}")
    @ResponseStatus(HttpStatus.OK)
    public List<VaccineResponse> findByAnimalId(@PathVariable("animalId") Long animalId) {
        return vaccineService.findByAnimalId(animalId);
    }


    @GetMapping("/finishDate")
    @ResponseStatus(HttpStatus.OK)
    public List<VaccineResponse> findByProtectionFinishDateBetween(
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate) {
        return this.vaccineService.findByProtectionFinishDateBetween(startDate, endDate);
    }

}