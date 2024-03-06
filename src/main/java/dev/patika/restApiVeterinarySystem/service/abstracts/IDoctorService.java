package dev.patika.restApiVeterinarySystem.service.abstracts;

import dev.patika.restApiVeterinarySystem.dto.request.DoctorRequest;
import dev.patika.restApiVeterinarySystem.dto.response.DoctorResponse;

import java.util.List;

public interface IDoctorService {
    List<DoctorResponse> findAll();
    DoctorResponse getById(Long id);
    DoctorResponse create (DoctorRequest request);
    DoctorResponse update(Long id, DoctorRequest request);
    boolean deleteById(Long id);

}
