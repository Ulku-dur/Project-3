package dev.patika.restApiVeterinarySystem.repository;

import dev.patika.restApiVeterinarySystem.dto.response.AppointmentResponse;
import dev.patika.restApiVeterinarySystem.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findByAppointmentDate (LocalDateTime appointmentDate);
    boolean existsByDoctorIdAndAppointmentDate(Long doctorId, LocalDateTime appointmentDate);
    List<Appointment> findByAppointmentDateBetweenAndAnimalId
    (LocalDateTime startDate, LocalDateTime endDate, Long animalId);
    List<Appointment> findByAppointmentDateBetweenAndDoctorId
    (LocalDateTime startDate, LocalDateTime endDate, Long doctorId);
}

