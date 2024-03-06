package dev.patika.restApiVeterinarySystem.service.concretes;
import dev.patika.restApiVeterinarySystem.dto.request.VaccineRequest;
import dev.patika.restApiVeterinarySystem.dto.response.VaccineResponse;
import dev.patika.restApiVeterinarySystem.entity.Vaccine;
import dev.patika.restApiVeterinarySystem.exception.IdNotFoundException;
import dev.patika.restApiVeterinarySystem.exception.VaccineAlreadyExistsException;
import dev.patika.restApiVeterinarySystem.mapper.VaccineMapper;
import dev.patika.restApiVeterinarySystem.repository.VaccineRepository;
import dev.patika.restApiVeterinarySystem.service.abstracts.IVaccineService;

import org.springframework.stereotype.Service;
import java.util.Optional;

import java.time.LocalDate;
import java.util.List;
@Service
public class VaccineService implements IVaccineService {
    private final VaccineRepository vaccineRepository;
    private final VaccineMapper vaccineMapper;

    public VaccineService(VaccineRepository vaccineRepository, VaccineMapper vaccineMapper) {
        this.vaccineRepository = vaccineRepository;
        this.vaccineMapper = vaccineMapper;
    }
    public List<VaccineResponse> findAll() {
        return vaccineMapper.toResponse((vaccineRepository.findAll()));
    }

    public VaccineResponse getById(Long id) {
        return vaccineMapper.toResponse(vaccineRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Vaccine with ID " + id + " not found")));
    }

    public VaccineResponse create(VaccineRequest request) {
        List<Vaccine> isVaccineExist = vaccineRepository
                .findByAnimalIdAndCodeAndProtectionFinishDateAfter(
                        request.getAnimal().getId(),
                        request.getCode(),
                        request.getProtectionStartDate());
        if (!isVaccineExist.isEmpty()) {
            throw new VaccineAlreadyExistsException(request);
        } else {
            Vaccine vaccineSaved = vaccineRepository.save(vaccineMapper.toEntity(request));
            return vaccineMapper.toResponse(vaccineSaved);
        }
    }

    public VaccineResponse update(Long id, VaccineRequest request) {
        Optional<Vaccine> vaccineFromDb = vaccineRepository.findById(id);
        Optional<Vaccine> isVaccineExist = vaccineRepository.findByAnimalIdAndNameAndCode(request.getAnimal().getId(), request.getName(), request.getCode());

        if (vaccineFromDb.isEmpty()) {
            throw new IdNotFoundException(id, request);
        }

        if (isVaccineExist.isPresent() && !isVaccineExist.get().getId().equals(id)) {
            throw new VaccineAlreadyExistsException(id, request);
        }

        Vaccine vaccine = vaccineFromDb.get();
        vaccineMapper.update(vaccine, request);
        return vaccineMapper.toResponse((vaccineRepository.save(vaccine)));
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    public void delete(Long id) {
        Optional<Vaccine> vaccineFromDb = vaccineRepository.findById(id);
        if (vaccineFromDb.isPresent()) {
            vaccineRepository.delete(vaccineFromDb.get());
        } else {
            throw new IdNotFoundException(id);
        }
    }

    public List<VaccineResponse> findByAnimalId(Long animalId) {
        return vaccineMapper.toResponse(vaccineRepository.findByAnimalId(animalId));
    }

    public List<VaccineResponse> findByProtectionFinishDateBetween(LocalDate protectionStartDate, LocalDate protectionFinishDate){
        return vaccineMapper.toResponse(vaccineRepository.findByProtectionFinishDateBetween(protectionStartDate, protectionFinishDate));
    }
}























































