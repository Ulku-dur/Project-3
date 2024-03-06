package dev.patika.restApiVeterinarySystem.service.concretes;
import dev.patika.restApiVeterinarySystem.dto.request.DoctorRequest;
import dev.patika.restApiVeterinarySystem.dto.response.DoctorResponse;
import dev.patika.restApiVeterinarySystem.entity.Doctor;
import dev.patika.restApiVeterinarySystem.exception.DoctorAlreadyExistsException;
import dev.patika.restApiVeterinarySystem.exception.IdNotFoundException;
import dev.patika.restApiVeterinarySystem.mapper.DoctorMapper;
import dev.patika.restApiVeterinarySystem.repository.DoctorRepository;
import dev.patika.restApiVeterinarySystem.service.abstracts.IDoctorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService implements IDoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public DoctorService(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    public List<DoctorResponse> findAll() {
        return doctorMapper.toResponse(doctorRepository.findAll());
    }

    public DoctorResponse getById(Long id) {
        return doctorMapper.toResponse(doctorRepository.findById(id).orElseThrow(() ->
        new RuntimeException("Doctor with id " + id + " not found!")));
    }

    public DoctorResponse create (DoctorRequest request) {
        Optional<Doctor> doctorFromDb = doctorRepository.findByMail(request.getMail());
        if (doctorFromDb.isPresent()) {
            throw new DoctorAlreadyExistsException(doctorFromDb.get().getMail());
        }
        Doctor doctorSaved = doctorRepository.save(doctorMapper.toEntity(request));
        return doctorMapper.toResponse(doctorSaved);

    }

    public DoctorResponse update(Long id, DoctorRequest request) {
        Optional<Doctor> doctorFromDb = doctorRepository.findById(id);
        Optional<Doctor> isDoctorExist =doctorRepository.findByMail(request.getMail());
        if (doctorFromDb.isEmpty()) {
            throw new IdNotFoundException(id, request);
        }

        Doctor doctor = doctorFromDb.get();
        doctorMapper.update(doctor,request);
        return doctorMapper.toResponse((doctorRepository.save(doctor)));
    }

    public boolean deleteById(Long id) {
        if(doctorRepository.existsById(id)){
            doctorRepository.deleteById(id);
            return true;
        }
        return false;
    }
    }



