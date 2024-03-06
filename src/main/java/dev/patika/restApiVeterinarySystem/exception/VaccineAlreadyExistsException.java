package dev.patika.restApiVeterinarySystem.exception;

import dev.patika.restApiVeterinarySystem.dto.request.VaccineRequest;

public class VaccineAlreadyExistsException extends RuntimeException{
    public VaccineAlreadyExistsException(Long id) {
        super("The vaccine protection with the ID " + id + "is still active, you cannot add a new vaccine");
    }
public VaccineAlreadyExistsException(VaccineRequest request) {
        super("The vaccine protection is still active, you cannot add a new vaccine.");
}
public VaccineAlreadyExistsException(Long id, VaccineRequest request) {
        super("Another vaccine with the same name and code already exists in the system!");
}
}
