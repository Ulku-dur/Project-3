package dev.patika.restApiVeterinarySystem.dto.request;

import dev.patika.restApiVeterinarySystem.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateRequest {
    private LocalDate availableDate;
    private Doctor doctor;

}
