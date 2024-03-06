package dev.patika.restApiVeterinarySystem.dto.request;

import dev.patika.restApiVeterinarySystem.entity.Animal;
import dev.patika.restApiVeterinarySystem.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequest {
    private LocalDateTime appointmentDate;
    private Doctor doctor;
    private Animal animal;
}
