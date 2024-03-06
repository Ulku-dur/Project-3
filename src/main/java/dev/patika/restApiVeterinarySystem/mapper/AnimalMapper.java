package dev.patika.restApiVeterinarySystem.mapper;

import dev.patika.restApiVeterinarySystem.dto.request.AnimalRequest;
import dev.patika.restApiVeterinarySystem.dto.response.AnimalResponse;
import dev.patika.restApiVeterinarySystem.entity.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface AnimalMapper {

    Animal toEntity(AnimalRequest animalRequest);
    AnimalResponse toResponse(Animal animal);
    List<AnimalResponse> toResponse(List<Animal> animalList);
    void update(@MappingTarget Animal entity, AnimalRequest animalRequest);

}
