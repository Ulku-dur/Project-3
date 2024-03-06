package dev.patika.restApiVeterinarySystem.controller;

import dev.patika.restApiVeterinarySystem.dto.request.DoctorRequest;
import dev.patika.restApiVeterinarySystem.dto.response.DoctorResponse;
import dev.patika.restApiVeterinarySystem.service.concretes.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<DoctorResponse> findAll() {
        return doctorService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DoctorResponse getById(@PathVariable("id") Long id) {
        return doctorService.getById(id);
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorResponse save (@RequestBody DoctorRequest doctor) {
        return doctorService.create(doctor);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DoctorResponse update(@PathVariable Long id, @RequestBody DoctorRequest request) {
        return doctorService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        doctorService.deleteById(id);
    }
}
