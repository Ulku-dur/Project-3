package dev.patika.restApiVeterinarySystem.exception;

import dev.patika.restApiVeterinarySystem.dto.request.AppointmentRequest;

import java.time.LocalDateTime;

public class AppointmentAlreadyExistsException extends RuntimeException{
    public AppointmentAlreadyExistsException(Long id, LocalDateTime dateTime) {super("At the entered time, there's already another appointment scheduled");}
    public AppointmentAlreadyExistsException(Long id, AppointmentRequest request) {super("An appointment has already been scheduled for this date!");}
    public AppointmentAlreadyExistsException(AppointmentRequest request) {super("Today, the doctor isn't available. Please select an alternative date.");}
}
