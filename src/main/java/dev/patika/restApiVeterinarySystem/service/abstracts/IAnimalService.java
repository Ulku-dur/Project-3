package dev.patika.restApiVeterinarySystem.service.abstracts;

import dev.patika.restApiVeterinarySystem.dto.request.AnimalRequest;
import dev.patika.restApiVeterinarySystem.dto.response.AnimalResponse;

import java.util.List;

public interface IAnimalService {
    List<AnimalResponse> findAll();
    AnimalResponse getById(Long id);
    AnimalResponse create (AnimalRequest request);
    AnimalResponse update(Long id, AnimalRequest request);
    void deleteById(Long id);
    List<AnimalResponse> findByName(String name);
    List<AnimalResponse> findByCustomerName(String customerName);
    List<AnimalResponse> findByCustomerId(Long customerId);
}
