package dev.patika.restApiVeterinarySystem.mapper;

import dev.patika.restApiVeterinarySystem.dto.request.AvailableDateRequest;
import dev.patika.restApiVeterinarySystem.dto.response.AvailableDateResponse;
import dev.patika.restApiVeterinarySystem.entity.AvailableDate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface AvailableDateMapper {

    AvailableDate toEntity(AvailableDateRequest availableDateRequest);
    AvailableDateResponse toResponse(AvailableDate availableDate);
    List<AvailableDateResponse> toResponse(List<AvailableDate> availableDateList);
    void update(@MappingTarget AvailableDate entity, AvailableDateRequest request);



}
