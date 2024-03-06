package dev.patika.restApiVeterinarySystem.service.abstracts;

import dev.patika.restApiVeterinarySystem.dto.request.AvailableDateRequest;
import dev.patika.restApiVeterinarySystem.dto.response.AvailableDateResponse;

import java.util.List;

public interface IAvailableDateService {
    List<AvailableDateResponse> findAll();
    AvailableDateResponse getById(Long id);
    AvailableDateResponse create (AvailableDateRequest request);
    AvailableDateResponse update(Long id, AvailableDateRequest request);
    boolean deleteById(Long id);
}
