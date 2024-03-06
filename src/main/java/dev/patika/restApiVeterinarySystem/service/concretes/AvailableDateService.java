package dev.patika.restApiVeterinarySystem.service.concretes;

import dev.patika.restApiVeterinarySystem.dto.request.AvailableDateRequest;
import dev.patika.restApiVeterinarySystem.dto.response.AvailableDateResponse;
import dev.patika.restApiVeterinarySystem.entity.AvailableDate;
import dev.patika.restApiVeterinarySystem.exception.IdNotFoundException;
import dev.patika.restApiVeterinarySystem.mapper.AvailableDateMapper;
import dev.patika.restApiVeterinarySystem.repository.AvailableDateRepository;
import dev.patika.restApiVeterinarySystem.service.abstracts.IAvailableDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service

public class AvailableDateService implements IAvailableDateService {
    private final AvailableDateRepository availableDateRepository;
    private final AvailableDateMapper availableDateMapper;

    public AvailableDateService(AvailableDateRepository availableDateRepository, AvailableDateMapper availableDateMapper) {
        this.availableDateRepository = availableDateRepository;
        this.availableDateMapper = availableDateMapper;
    }


    public List<AvailableDateResponse> findAll() {
        return availableDateMapper.toResponse((availableDateRepository.findAll()));
    }

    public AvailableDateResponse getById(Long id) {
        return availableDateMapper.toResponse(availableDateRepository.findById(id).orElseThrow(() ->
                new RuntimeException("The available date with ID " + id + " could not be found!")));
    }

    public AvailableDateResponse create (AvailableDateRequest request) {
        Optional<AvailableDate> isAvailableDateExist = availableDateRepository.findByAvailableDate(request.getAvailableDate());
        if (isAvailableDateExist.isEmpty()) {
            AvailableDate availableDateSaved = availableDateRepository.save(availableDateMapper.toEntity(request));
            return availableDateMapper.toResponse(availableDateSaved);
        }
        throw new IdNotFoundException(request);
    }

    public AvailableDateResponse update(Long id, AvailableDateRequest request) {
        Optional<AvailableDate> availableDateFromDb = availableDateRepository.findById(id);
        Optional<AvailableDate> isAvailableDateExist = availableDateRepository.findByAvailableDate(request.getAvailableDate());

        if (availableDateFromDb.isEmpty()) {
            throw new IdNotFoundException(id);
        }

        AvailableDate availableDate = availableDateFromDb.get();
        availableDateMapper.update(availableDate, request);
        return availableDateMapper.toResponse((availableDateRepository.save(availableDate)));
    }

    public boolean deleteById(Long id) {
        if(availableDateRepository.existsById(id)){
            availableDateRepository.deleteById(id);
            return true;
        }
        return false;
    }


    // belirli bir doktorun belirtilen gün ve saat için uygun olup olmadığının kontrolleri yapılır.
    public boolean isDoctorAvailable(Long doctorId, LocalDateTime dateTime) {
        List<AvailableDate> availableDateList = availableDateRepository
        .findByDoctorIdAndAvailableDate(doctorId, dateTime.toLocalDate());
        return !availableDateRepository.existsByDoctorIdAndAvailableDate(doctorId,
                dateTime.toLocalDate());
    }

    public List<AvailableDateResponse> findByDoctorId(Long doctorId) {
        return availableDateMapper.toResponse(availableDateRepository.findByDoctorId(doctorId));
    }
}




