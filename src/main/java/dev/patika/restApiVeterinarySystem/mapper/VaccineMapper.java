package dev.patika.restApiVeterinarySystem.mapper;

import dev.patika.restApiVeterinarySystem.dto.request.VaccineRequest;
import dev.patika.restApiVeterinarySystem.dto.response.VaccineResponse;
import dev.patika.restApiVeterinarySystem.entity.Vaccine;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface VaccineMapper {

    Vaccine toEntity(VaccineRequest vaccineRequest);
    VaccineResponse toResponse(Vaccine vaccine);
    List<VaccineResponse> toResponse(List<Vaccine> vaccineList);
    void update(@MappingTarget Vaccine entity, VaccineRequest request);
}
