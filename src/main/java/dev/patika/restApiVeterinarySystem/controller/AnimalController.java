package dev.patika.restApiVeterinarySystem.controller;
import dev.patika.restApiVeterinarySystem.dto.request.AnimalRequest;
import dev.patika.restApiVeterinarySystem.dto.response.AnimalResponse;
import dev.patika.restApiVeterinarySystem.service.concretes.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/animals")

public class AnimalController {
    private final AnimalService animalService;
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalResponse> findAll() {
        return animalService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalResponse getById(@PathVariable("id") Long id) {
        return animalService.getById(id);
    }

    // create

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalResponse save(@RequestBody AnimalRequest animal) {
        return animalService.create(animal);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalResponse update(@PathVariable Long id, @RequestBody AnimalRequest request) {
        return animalService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        animalService.deleteById(id);
    }

    // update

    @GetMapping("/byName")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalResponse> findByName(@RequestParam String name) {
        return animalService.findByName(name);
    }

    // get by name
    @GetMapping("/byCustomerName")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalResponse> findByCustomerName(@RequestParam String customerName) {
        return animalService.findByCustomerName(customerName);
    }

}
