package dev.patika.restApiVeterinarySystem.service.abstracts;

import dev.patika.restApiVeterinarySystem.dto.request.AppointmentRequest;
import dev.patika.restApiVeterinarySystem.dto.response.AppointmentResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IAppointmentService {
    List<AppointmentResponse> findAll();
    AppointmentResponse getById(Long id);
    AppointmentResponse create(AppointmentRequest request);
    boolean isAppointmentDateExistOnDate (Long doctorId, LocalDateTime appointmentDate);
    AppointmentResponse update(Long id, AppointmentRequest request);
    void deleteById(Long id);
    List<AppointmentResponse> findByAppointmentDateBetweenAndAnimalId(LocalDateTime startDate, LocalDateTime endDate, Long animalId);
    List<AppointmentResponse> findByAppointmentDateBetweenAndDoctorId(LocalDateTime startDate, LocalDateTime endDate, Long doctorId);

}
