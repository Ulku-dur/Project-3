package dev.patika.restApiVeterinarySystem.service.abstracts;

import dev.patika.restApiVeterinarySystem.dto.request.VaccineRequest;
import dev.patika.restApiVeterinarySystem.dto.response.VaccineResponse;
import dev.patika.restApiVeterinarySystem.entity.Vaccine;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IVaccineService {
    List<VaccineResponse> findAll();
    VaccineResponse getById(Long id);
    VaccineResponse create(VaccineRequest request);
    VaccineResponse update(Long id, VaccineRequest request);
    boolean deleteById(Long id);
    List<VaccineResponse> findByAnimalId(Long animalId);
    List<VaccineResponse> findByProtectionFinishDateBetween(LocalDate protectionStartDate, LocalDate protectionFinishDate);
}
