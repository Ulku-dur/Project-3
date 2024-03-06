package dev.patika.restApiVeterinarySystem.mapper;

import dev.patika.restApiVeterinarySystem.dto.request.DoctorRequest;
import dev.patika.restApiVeterinarySystem.dto.response.DoctorResponse;
import dev.patika.restApiVeterinarySystem.entity.Doctor;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface DoctorMapper {

    Doctor toEntity(DoctorRequest doctorRequest);
    DoctorResponse toResponse(Doctor doctor);
    List<DoctorResponse> toResponse(List<Doctor> doctorList);
    void update(@MappingTarget Doctor entity, DoctorRequest request);
}
